package crawler;

import hibernate.recommendation.ClothingImage;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.parseFloat;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ItemMaintainer implements PageProcessor {
    private static Logger logger = Logger.getLogger(ItemMaintainer.class);
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private Item item;

    public ItemMaintainer(Item item) {
        this.item = item;
    }

    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        try {
            item.setItemName(html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[1]/h1/text()").toString());
            item.setKeyName(html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[1]/p/text()").toString());
            if (html.xpath("//*[@id=\"shopExtra\"]/div[1]/a/strong/text()").toString().isEmpty()) {
                item.setShopName(html.xpath("//*[@id=\"side-shop-info\"]/div/h3/div/a/text()").toString());
            }
            item.setSaleQuantityInAMonth(getSellCount());
            item.setItemDescription(new ItemDescription(getDescriptionMap(html)));
            getAllSkuItems(html);
            getItemImagesFromTamll(page);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    void maintain() {
        logger.debug("ITEM :" + item.getItemId() + " BEGIN to maintain.");
        Spider.create(this).addUrl("https://detail.tmall.com/item.htm?id=" + item.getItemId()).thread(1).run();
        logger.debug("ITEM :" + item.getItemId() + " END to maintain.");
    }

    Map<String, String> getDescriptionMap(Html html) {
        int limit = html.xpath("///*[@id=\"J_AttrUL\"]/li").nodes().size();
        String[] keys;
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < limit; i++) {
            int j = i + 1;
            String one = html.xpath("///*[@id=\"J_AttrUL\"]/li[" + j + "]/text()").toString().replaceAll("\u00A0", "");
            String[] key = one.split(":", 2);
            result.put(key[0], key[1]);
        }
        return result;
    }

    void getAllSkuItems(Html html) throws Exception {
        Matcher m = Pattern.compile("\\{\"api\":(.*)\\}")
                .matcher(html.css("#J_DetailMeta > div.tm-clear > script").toString());
        if (m.find()) {
            try {
                JSONObject one = new JSONObject(m.group()).getJSONObject("valItemInfo");
                JSONArray two = one.getJSONArray("skuList");
                JSONObject three = one.getJSONObject("skuMap");

                for (int i = 0; i < two.length(); i++) {
                    String sku = String.valueOf(two.getJSONObject(i).getLong("skuId"));
                    String[] temp = two.getJSONObject(i).getString("names").split(" ", 2);
                    String size = temp[0];
                    String color = temp[1].replace(" ", "");
                    String pvs = two.getJSONObject(i).getString("pvs");
                    float price = getTmallRealPrice(sku);
                    int stock = three.getJSONObject(";" + pvs + ";").getInt("stock");
                    int sell = getSellCount();
                    item.getSkuItems().add(new SkuItem(sku, size, color, stock, sell, price));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Item item = new Item("44787408094");
        ItemMaintainer itemMaintainer = new ItemMaintainer(item);
        itemMaintainer.maintain();
        System.out.println(item.getItemId());
        System.out.println(item.getSkuItems().size());
        item.getSkuItems().forEach((SkuItem skuItem) -> {
            System.out.print(skuItem.getSkuid() + "!");
            System.out.print(skuItem.getSize() + "!");
            System.out.print(skuItem.getColor() + "!");
            System.out.print(skuItem.getPrice() + "!");
            System.out.println(skuItem.getStock() + ";");
        });
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getTmallRealPrice(String skuId) throws IOException, JSONException {
        String itemId = item.getItemId();
        HttpClientBuilder builder = HttpClients.custom();
        builder.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36");
        CloseableHttpClient httpClient = builder.build();
        HttpGet httpGet = new HttpGet("https://mdskip.taobao.com/core/initItemDetail.htm?itemId=" + itemId);
        httpGet.addHeader("scheme", "https");
        httpGet.addHeader("version", "HTTP/1.1");
        httpGet.addHeader("accept", "*/*");
        httpGet.addHeader("accept-encoding", "gzip, deflate, sdch");
        httpGet.addHeader("accept-language", "en,zh-CN;q=0.8,zh;q=0.6");
        httpGet.addHeader("cache-control", "no-cache");
        httpGet.addHeader("Referer", "https://detail.tmall.com/item.htm?id=" + itemId);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        OutputStream out = new ByteArrayOutputStream();
        if (entity != null) {
            InputStream instream = entity.getContent();
            int len;
            byte[] tmp = new byte[2048];
            while ((len = instream.read(tmp)) != -1) {
                out.write(tmp, 0, len);
            }
            instream.close();
        } else {
            out.write(new byte[]{'{', '}'});
        }
        out.close();
        String context = out.toString();
        String realPrice = new JSONObject(context)
                .getJSONObject("defaultModel")
                .getJSONObject("itemPriceResultDO")
                .getJSONObject("priceInfo")
                .getJSONObject(skuId)
                .getJSONArray("promotionList")
                .getJSONObject(0)
                .getString("price");
        response.close();
        httpClient.close();
        return parseFloat(realPrice);
    }

    public int getSellCount() throws IOException, JSONException {
        String itemId = item.getItemId();
        HttpClientBuilder builder = HttpClients.custom();
        builder.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36");
        CloseableHttpClient httpClient = builder.build();
        HttpGet httpGet = new HttpGet("https://mdskip.taobao.com/core/initItemDetail.htm?itemId=" + itemId);
        httpGet.addHeader("scheme", "https");
        httpGet.addHeader("version", "HTTP/1.1");
        httpGet.addHeader("accept", "*/*");
        httpGet.addHeader("accept-encoding", "gzip, deflate, sdch");
        httpGet.addHeader("accept-language", "en,zh-CN;q=0.8,zh;q=0.6");
        httpGet.addHeader("cache-control", "no-cache");
        httpGet.addHeader("Referer", "https://detail.tmall.com/item.htm?id=" + itemId);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        OutputStream out = new ByteArrayOutputStream();
        if (entity != null) {
            InputStream instream = entity.getContent();
            int len;
            byte[] tmp = new byte[2048];
            while ((len = instream.read(tmp)) != -1) {
                out.write(tmp, 0, len);
            }
            instream.close();
        } else {
            out.write(new byte[]{'{', '}'});
        }
        int sellCount = new JSONObject(out.toString())
                .getJSONObject("defaultModel")
                .getJSONObject("sellCountDO")
                .getInt("sellCount");
        out.close();
        response.close();
        httpClient.close();
        return sellCount;
    }

    public void getItemImagesFromTamll(Page page) {
        int limit = page.getHtml().xpath("//*[@id=\"J_UlThumb\"]/li").nodes().size();
        ClothingImage[] clothingImages = null;
        for (int i = 0; i < limit; i++) {
            int j = i + 1;
            clothingImages = new ClothingImage[limit];
            clothingImages[i] = new ClothingImage();
            clothingImages[i].setSource(page.getHtml()
                    .xpath("//*[@id=\"J_UlThumb\"]/li[" + j + "]/a/img/@src")
                    .toString()
                    .replace("//", "")
                    .replace("_60x60q90.jpg", ""));
            item.getClothingImages().add(clothingImages[i]);
            new GetImage().getImage(item.getItemId() + "@" + i, clothingImages[i]);
        }
    }

}