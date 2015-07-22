package crawler;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by liker on 19/07/2015 0019.
 * Group iTailor.hunters.neu.edu.cn
 */
//@TargetUrl("http://blog.csdn.net/likerxu/article/details/\\w+")
@TargetUrl("https://detail.tmall.com/item.htm?id=45655603350")
@HelpUrl("https://detail.tmall.com/item.htm?id=45655603350")
public class CsdnBlogPageProcessor {

    @ExtractBy("//*[@id='OSC_Content']/div[1]/div[1]/div[1]/div[2]/div[1]/p")
    private String name;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), CsdnBlogPageProcessor.class)
                .addUrl("http://www.oschina.net/question/1258281_130084?sort=time").thread(5).run();

    }
}
