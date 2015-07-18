package jsoupDemo;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


/**
 * Created by liker on 17/07/2015 0017.
 * Group iTailor.hunters.neu.edu.cn
 */
public class MyJsoup {
    public String search(String good) throws IOException {
        Document doc = Jsoup.connect("https://s.taobao.com/search?q="+good).get();
        System.out.println(doc);

//        pic_url":"//g-search1.alicdn.com/img/bao/uploaded/i4/i1/TB1qhi4IFXXXXbNXVXXXXXXXXXX_!!0-item_pic.jpg"
        return "yes";
    }

    public static void main(String[] args) throws IOException {
        MyJsoup mj = new MyJsoup();
        mj.search(" yonex");
    }
}
