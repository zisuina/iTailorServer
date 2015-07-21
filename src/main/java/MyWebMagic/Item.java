package MyWebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liker on 21/07/2015 0021.
 * Group iTailor.hunters.neu.edu.cn
 */
public class Item {
    private String shopName;
    private String itemName;
    private String keyName;
    private float currentPrice;
    private String brand;
    private ItemDescription itemDescription;
    private int saleQuantity;
    private String tmLink;
    private Map<String, Map<String, Integer>> colorSizeQuantityMap;

    public static void main(String[] args) {
        new Item("https://detail.tmall.com/item.htm?id=45785571808").itemUpdate();
    }

    public Item(String tmLink) {
        this.tmLink = tmLink;
    }

    public void itemUpdate() {
        new ItemUpdate().update();
    }

    class ItemUpdate implements PageProcessor {
        private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

        @Override
        public void process(Page page) {
            Html html = page.getHtml();
            shopName = html.xpath("//*[@id=\"shopExtra\"]/div[1]/a/strong/text()").toString();
            itemName = html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[1]/h1/text()").toString();
            keyName = html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[1]/p/text()").toString();
            //*[@id="J_PromoPrice"]/dd/div
            //*[@id="J_PromoPrice"]/dd/div/span

//            System.out.println("price:"+html.xpath("//*[@id=\"J_PromoPrice\"]/dd/div/span").toString());
            System.out.println("price:" + html.css("#J_PromoPrice > dd > div > span").toString());


//            currentPrice = Float.parseFloat(html.xpath("//*[@id=\"J_PromoPrice\"]/dd/div/span/text()").toString());
//            brand = html.xpath("//*[@id=\"J_BrandAttr\"]/div/a/text()").toString();
//            itemDescription = new ItemDescription(this.getDescriptionMap(page));
//            saleQuantity = Integer.parseInt(html.xpath(" //*[@id=\"J_TabBar\"]/li[3]/a/span/em/text()").toString());
////            colorSizeQuantityMap = this.getSizeQuantityMap(html);
            System.out.println(shopName);
            System.out.println(itemName);
            System.out.println(keyName);
//            System.out.println(currentPrice);
//            System.out.println(brand);
//            System.out.println(itemDescription);
//            System.out.println(saleQuantity);

//            HttpClient client = new HttpClient();
//            HttpMethod method = new PostMethod(indexUrl);
//            client.executeMethod(method);
//            method = new PostMethod("http://要抓取的地址");
//            client.executeMethod(method);
//            // 返回的信息
//            // 程序运行到这里时，就读取了索引页的源代码，然后去除空白的换行
//            String letterContent = method.getResponseBodyAsString().replaceAll("\r\n", "");
//            // 这个方法是去解析这一页内容的
//            // 这里是默认执行的第一页.
//            handleFirstIndex(client, method, letterContent,indexUrl);
//            // 释放连接
//            method.releaseConnection();
        }

//        Map<String, Map<String, Integer>> getSizeQuantityMap(Html html) {
//            int colorLimit = html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[4]/div/div/dl[3]/dd/ul/li").nodes().size();
//            for (int i = 0; i < colorLimit; i++) {
//                int j = i + 1;
//                int sizeLimit = html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[4]/div/div/dl[2]/dd/ul/li").nodes().size();
//                for (int k = 0; k < sizeLimit; k++) {
//                    int l = k + 1;
//                    int m = Integer.parseInt(html.xpath("//*[@id=\"J_EmStock\"]/text()").toString());
//                }
//            }
//        }

        Map<String, String> getDescriptionMap(Page page) {
            int limit = page.getHtml().xpath("///*[@id=\"J_AttrUL\"]/li").nodes().size();
            String[] keys;
            Map<String, String> result = new HashMap<>();
//        <li title="&nbsp;A型">廓形:&nbsp;A型</li>
            for (int i = 0; i < limit; i++) {
                int j = i + 1;
                page.putField(String.valueOf(j), page.getHtml().xpath("///*[@id=\"J_AttrUL\"]/li[" + j + "]/text()").toString().replaceAll("\u00A0", ""));
                String[] key = page.getResultItems().get(String.valueOf(j)).toString().split(":", 2);
                result.put(key[0], key[1]);
            }
            return result;
        }

        @Override
        public Site getSite() {
            return site;
        }

        public void update() {
            Spider spider = Spider.create(this);
            String regex = "id=[0-9]{1,}";
            Pattern pat = Pattern.compile(regex);
            Matcher matcher = pat.matcher(tmLink);
            if (matcher.find()) {
                String id = matcher.group(0);
                spider.addUrl("https://detail.tmall.com/item.htm?" + id);
                spider.thread(1);
                spider.start();
            } else {
                System.out.println("Bad Link:" + tmLink);
                tmLink = null;
            }
        }
    }
}
