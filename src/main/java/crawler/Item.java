package crawler;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liker on 21/07/2015 0021.
 * Group iTailor.hunters.neu.edu.cn
 */
public class Item {
    private String itemId;
    private String itemName;
    private String keyName;
    private String shopName;
    private int saleQuantityInAMonth = -1; //Ajax
    private String[] skuIds = null;
    private ItemDescription itemDescription;
    private Map<String, Float> currentPrice = new HashMap<>();
    private ArrayList<SkuItem> skuItems = new ArrayList<>();

    public Item(String itemId) {
        this.itemId = itemId;
    }

    public void maintain() {
        new ItemMaintainer().maintain();
    }

    class ItemMaintainer implements PageProcessor {
        private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

        @Override
        public void process(Page page) {
            Html html = page.getHtml();
            itemName = html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[1]/h1/text()").toString();
            keyName = html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[1]/p/text()").toString();
            shopName = html.xpath("//*[@id=\"shopExtra\"]/div[1]/a/strong/text()").toString();
//            saleQuantityInAMonth = Integer.parseInt(html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/ul/li[1]/div/span[2]/text()").toString());
            skuIds = getSkuIds(html);
            System.out.println("OK");
            itemDescription = new ItemDescription(getDescriptionMap(html));
            System.out.println(itemDescription.toString());
//            currentPrice = getPriceMap();
//            System.out.println(currentPrice.toString());
            try {
                getAllSkuItems(html);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public Site getSite() {
            return site;
        }

        void maintain() {
            System.out.println("OK~~~~");
            Spider.create(new ItemMaintainer()).addUrl("https://detail.tmall.com/item.htm?id=" + itemId).thread(1).start();
            System.out.println("OK2~~~~");
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

        String[] getSkuIds(Html html) {
            String[] result = null;
            String script = html.css("#J_DetailMeta > div.tm-clear > script").toString().replace(" ", "");
            Pattern p = Pattern.compile("\\{\"api\":(.*)\\}");
            Matcher m = p.matcher(script);
            if (m.find()) {
                try {
                    JSONObject jsonObject = new JSONObject(m.group());
                    JSONArray jsonArray = jsonObject.getJSONObject("valItemInfo").getJSONArray("skuList");
                    System.out.println(jsonArray.length());
                    result = new String[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        result[i] = jsonArray.getJSONObject(i).getString("skuId");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        float getTmallRealPrice(String itemId, String skuId) throws IOException, JSONException {
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
            return Float.parseFloat(realPrice);
        }

        Map<String, Float> getPriceMap() {
            Map<String, Float> priceMap = new HashMap<>();
            for (String skuid : skuIds) {
                try {
                    priceMap.put(skuid, getTmallRealPrice(itemId, skuid));
//                    System.out.println(skuid+":"+getTmallRealPrice(itemId,skuid));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return priceMap;
        }


        int getSellCount(String itemId) throws IOException, JSONException {
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
            int sellCount = Integer.parseInt(new JSONObject(context)
                    .getJSONObject("defaultModel")
                    .getJSONObject("sellCountDO")
                    .getString("sellCount"));

            response.close();
            httpClient.close();
            return sellCount;
        }

        //        ArrayList<SkuItem> getAllSkuItems(Html html) throws Exception {
        void getAllSkuItems(Html html) throws Exception {
            String script = html.css("#J_DetailMeta > div.tm-clear > script").toString();//.replace(" ", "");
            Pattern p = Pattern.compile("\\{\"api\":(.*)\\}");
            Matcher m = p.matcher(script);
            if (m.find()) {
                try {
                    JSONObject one = new JSONObject(m.group()).getJSONObject("valItemInfo");
                    JSONArray two = one.getJSONArray("skuList");
                    JSONObject three = one.getJSONObject("skuMap");
                    for (int i = 0; i < two.length(); i++) {
                        String sku = two.getJSONObject(i).getString("skuId");
                        String[] temp = two.getJSONObject(i).getString("names").split(" ", 2);
                        String size = temp[0];
                        String color = temp[1];
                        String pvs = two.getJSONObject(i).getString("pvs");
                        float price = Float.parseFloat(three.getJSONObject(";" + pvs + ";").getString("price"));
                        int stock = Integer.parseInt(three.getJSONObject(";" + pvs + ";").getString("stock"));
                        int sell = getSellCount(itemId);
                        skuItems.add(new SkuItem(sku, size, color, stock, sell, price));
                        System.out.println(sku + " : " + size + " : " + color + ":" + price + " : " + stock + " : " + sell);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
//        Item item = new Item("43663164301");
//        Item item = new Item("37521992837");
//        Item item = new Item("43873949784");
        Item item = new Item("43671643681");
        item.maintain();
    }

}
