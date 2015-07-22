//package MyWebMagic;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.json.JSONException;
//import org.json.JSONObject;
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.processor.PageProcessor;
//import us.codecraft.webmagic.selector.Html;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Created by liker on 22/07/2015 0022.
// * Group iTailor.hunters.neu.edu.cn
// */
//public class ItemUpdate implements PageProcessor {
//
//    String shopName;
//    String itemName;
//    String keyName;
//
//
//    @Override
//    public void process(Page page) {
//
//        //*[@id="J_PromoPrice"]/dd/div
//        //*[@id="J_PromoPrice"]/dd/div/span
//
////            System.out.println("price:"+html.xpath("//*[@id=\"J_PromoPrice\"]/dd/div/span").toString());
//        System.out.println("price:" + html.css("#J_PromoPrice > dd > div > span").toString());
//
//
////            currentPrice = Float.parseFloat(html.xpath("//*[@id=\"J_PromoPrice\"]/dd/div/span/text()").toString());
////            brand = html.xpath("//*[@id=\"J_BrandAttr\"]/div/a/text()").toString();
////            itemDescription = new ItemDescription(this.getDescriptionMap(page));
////            saleQuantity = Integer.parseInt(html.xpath(" //*[@id=\"J_TabBar\"]/li[3]/a/span/em/text()").toString());
//////            colorSizeQuantityMap = this.getSizeQuantityMap(html);
//        System.out.println(shopName);
//        System.out.println(itemName);
//        System.out.println(keyName);
////            System.out.println(currentPrice);
////            System.out.println(brand);
////            System.out.println(itemDescription);
////            System.out.println(saleQuantity);
//
////            HttpClient client = new HttpClient();
////            HttpMethod method = new PostMethod(indexUrl);
////            client.executeMethod(method);
////            method = new PostMethod("http://要抓取的地址");
////            client.executeMethod(method);
////            // 返回的信息
////            // 程序运行到这里时，就读取了索引页的源代码，然后去除空白的换行
////            String letterContent = method.getResponseBodyAsString().replaceAll("\r\n", "");
////            // 这个方法是去解析这一页内容的
////            // 这里是默认执行的第一页.
////            handleFirstIndex(client, method, letterContent,indexUrl);
////            // 释放连接
////            method.releaseConnection();
//    }
//
////        Map<String, Map<String, Integer>> getSizeQuantityMap(Html html) {
////            int colorLimit = html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[4]/div/div/dl[3]/dd/ul/li").nodes().size();
////            for (int i = 0; i < colorLimit; i++) {
////                int j = i + 1;
////                int sizeLimit = html.xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[4]/div/div/dl[2]/dd/ul/li").nodes().size();
////                for (int k = 0; k < sizeLimit; k++) {
////                    int l = k + 1;
////                    int m = Integer.parseInt(html.xpath("//*[@id=\"J_EmStock\"]/text()").toString());
////                }
////            }
////        }
//
//
//
//
//
//    @Override
//    public Site getSite() {
//        return site;
//    }
//
//    public void update(Item item) {
//        Spider spider = Spider.create(this);
//        String regex = "id=[0-9]{1,}";
//        Pattern pat = Pattern.compile(regex);
//        Matcher matcher = pat.matcher(item.getTmLink());
//        if (matcher.find()) {
//            String id = matcher.group(0);
//            spider.addUrl("https://detail.tmall.com/item.htm?" + id);
//            spider.thread(1);
//            spider.start();
//        } else {
//            System.out.println("Bad Link:" + item.getTmLink());
//            item.setTmLink(null);
//        }
//    }
//}