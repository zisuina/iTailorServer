package MyWebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by liker on 20/07/2015 0020.
 * Group iTailor.hunters.neu.edu.cn
 */
public class SearchOnTmall implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private String searchKey;

    @Override
    public void process(Page page) {
        String[] links = this.getLinks(page);
        for (String link : links) {
            new ItemAnalyzer().run(link);
        }
    }

    public String[] getLinks(Page page) {
        int limit = page.getHtml().xpath("//*[@id=\"J_ItemList\"]/div").nodes().size();
        String[] links = new String[limit];
        for (int i = 0; i < limit; i++) {
            int j = i + 1;
            links[i] = page.getHtml()
                    .xpath("//*[@id=\"J_ItemList\"]/div[" + j + "]/div/div[1]/a[1]/@href")
                    .toString()
                    .split("&", 2)[0];
            System.out.println(links[i]);
        }
        return links;
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        String searchkey = "连衣裙";
        Spider spider = Spider.create(new SearchOnTmall());
        spider.addUrl("https://list.tmall.com/search_product.htm?q=" + searchkey);
        spider.thread(1);
        spider.start();
    }
}
