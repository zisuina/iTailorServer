package MyWebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by liker on 19/07/2015 0019.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ItemAnalyzer implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        System.out.println("====================");
        System.out.println(page.getHtml());
        System.out.println("====================");
        System.out.println(page.toString());
        System.out.println("====================");
        System.out.println(page.getRawText());
        System.out.println("====================");
        System.out.println(page.getRequest());
        System.out.println("====================");
        System.out.println(page.getStatusCode());
        page.putField("name",page.getHtml().xpath("//*[@id=\"J_DetailMeta\"]/div[1]/div[1]/div/div[1]/h1/text()").replace(" ",""));
        for (int i = 0; i < 22; i++) {
//            http://www.tuicool.com/articles/iqQFBn
//            page.putField(String.valueOf(i), page.getHtml().css("#J_AttrUL > li:nth-child(" + i + ")"));
            page.putField(String.valueOf(i), page.getHtml().xpath("//*[@id='J_AttrUL']/li[" + i + "]/text()"));
//            System.out.println(page.getResultItems().get(String.valueOf(i)).toString());
        }
//        page.getHtml();
    }

    @Override
    public Site getSite() {
        return site;
    }

    //    //*[@id="J_AttrUL"]
    public static void main(String[] args) {
        Spider spider = Spider.create(new ItemAnalyzer());
        spider.addUrl("https://detail.tmall.com/item.htm?id=520452595021");
        spider.thread(1);
        spider.start();
    }
}
