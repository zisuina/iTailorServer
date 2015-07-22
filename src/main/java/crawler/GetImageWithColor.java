package crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;

/**
 * Created by liker on 19/07/2015 0019.
 * Group iTailor.hunters.neu.edu.cn
 */
public class GetImageWithColor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
//        System.out.println(page.getHtml().regex("<li class=\"\"> <a href=\""));
        page.putField("content",page.getHtml().xpath("//*[@id='J_DetailMeta']/div[1]/div[1]/div/div[1]/h1"));
        System.out.println("--------------------------------------");
        page.setSkip(true);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider spider = Spider.create(new MyPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://detail.tmall.com/item.htm?id=45655603350&sku_properties=-1:-1")
                        //开启5个线程抓取
                .thread(1);
        ArrayList<Pipeline> pipelines = new ArrayList<>();
        pipelines.add(new ConsolePipeline());
        spider.setPipelines(pipelines);
        //启动爬虫
        spider.run();
    }

}
