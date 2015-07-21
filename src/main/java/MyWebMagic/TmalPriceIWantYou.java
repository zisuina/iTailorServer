package MyWebMagic;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by liker on 21/07/2015 0021.
 * Group iTailor.hunters.neu.edu.cn
 */
public class TmalPriceIWantYou {
    public static void main(String[] args) throws Exception {
        String url = "https://mdskip.taobao.com/core/initItemDetail.htm?showShopProm=false&queryMemberRight=true&isSecKill=false&itemTags=775,907,1163,1478,1483,1675,1803,1991,2049,2059,2443,2507,2635,3019,3851,3915,3974,4107,4166,4171,4363,4491,4555,4614,4678,4811,5835,5954,6411,6603,9153,15554,17665,17793,17921,19841,20289,21505,22081,25282,25922,26433,28353,28802,44930,57026,59010,60418,62082,63746,69250,72386,79106&service3C=false&tryBeforeBuy=false&notAllowOriginPrice=false&isUseInventoryCenter=false&itemId=45785571808&sellerUserTag3=144185556820066432&sellerUserTag4=1729382398679860611&tmallBuySupport=true&isRegionLevel=false&sellerPreview=false&addressLevel=2&progressiveSupport=true&isForbidBuyItem=false&household=false&isAreaSell=false&sellerUserTag=38899744&offlineShop=false&tgTag=false&cartEnable=true&isApparel=true&sellerUserTag2=18015688073412616&isIFC=false&callback=setMdskip";
        HttpClientBuilder builder = HttpClients.custom();
        builder.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36");
        CloseableHttpClient httpClient = builder.build();
        HttpGet httpGet = new HttpGet(url);

        httpGet.addHeader("scheme", "https");
        httpGet.addHeader("version", "HTTP/1.1");
        httpGet.addHeader("accept", "*/*");
        httpGet.addHeader("accept-encoding", "gzip, deflate, sdch");
        httpGet.addHeader("accept-language", "en,zh-CN;q=0.8,zh;q=0.6");
        httpGet.addHeader("cache-control", "no-cache");
        httpGet.addHeader("Referer", "https://detail.tmall.com/item.htm?id=45785571808&sku_properties=-1:-1");

        CloseableHttpResponse response = null;
        response = httpClient.execute(httpGet);
//        System.out.println(response.getProtocolVersion());
//        System.out.println(response.containsHeader("host-name"));
//        System.out.println(response.containsHeader("m"));
//        System.out.println(response.containsHeader("p3p"));
//        System.out.println(response.containsHeader("s"));
//        System.out.println(response.containsHeader("via"));

//
//        System.out.println(html.getDocument().toString());


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
//        Html html = new Html(out.toString());
        out.close();
//        System.out.println(html.toString());
        String context = out.toString();
        context = context.substring(12,context.length()-1);
        System.out.println(context);
        JSONObject myjObject = new JSONObject(context);
        System.out.println(myjObject.getJSONArray("defaultModel"));
        System.out.println(myjObject.getJSONObject("defaultModel"));

//        JSONArray jsonArray = new JSONArray(context);
//        System.out.println(jsonArray.length());
//        JSONObject myjObject = jsonArray.getJSONObject();


//
//        System.out.println(entity.getContentLength());
//        String result = null;
//        if (entity != null) {
//            result = EntityUtils.toString(entity);
//            EntityUtils.consume(entity);
//        }
//
//        //商品价格的返回值，需要解析出来价格
//
//        result = result.substring(10, result.length()-1);
//
//        JSONObject object = new JSONObject(result);
//        JSONObject object2 = (JSONObject)object.get("defaultModel");
//        JSONObject object3 = (JSONObject)object2.get("itemPriceResultDO");
//        JSONObject object4 = (JSONObject)object3.get("priceInfo");
//        JSONObject object5 = (JSONObject)object4.get("68347779144");
//        JSONArray jsonArray = new JSONArray(object5.get("promotionList").toString());
//        if(jsonArray.length()==1){
//            JSONObject object6 = (JSONObject)jsonArray.get(0);
//            System.out.println(object6.get("price"));
//        }

        response.close();
        httpClient.close();
    }
}
