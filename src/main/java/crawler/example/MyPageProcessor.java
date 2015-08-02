package crawler.example;

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
public class MyPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);


    @Override
    public void process(Page page) {

//        site.addCookie("thw","cn");
//        site.addCookie("cookie2","1cc0c056c6d30cf4fbe7aff6ded7e810");
//        site.addCookie("isg","3A8417BF0506D0EE6D25027B9A87A2CC");
//        site.addCookie("t","7aa2108c1ecd67fd47ac735cd8876ef4");
//        site.addCookie("cna","vB0yDh5FeAYCAdvYZ81VzIxc");
//        site.addCookie("v","0");
//        site.addCookie("lastalitrackid","taobao");
//        site.addCookie("l","AiQkkfPkXS8oRwzb7jW19BGsdDwWvUgn");
//        site.addCookie("alitrackid","www.taobao.com");
//        site.addCookie("JSESSIONID","31B6DB5B4A7D7A6E63E08B014CF5BC00");
//        site.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36");
        System.out.println(page.getHtml().toString());

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

//        System.getProperties().setProperty("webdriver.chrome.driver", "G:\\Desktop\\JavaCrawler\\chromedriver_win32\\chromedriver.exe");
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("http://blog.csdn.net/likerxu/article/details/46763409");
//        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"article_content\"]/div[1]/div/div/ul[6]/li[2]/ul/li[13]/ul/li/div/text()"));
//        System.out.println(webElement.getAttribute("outerHTML"));
//        webDriver.close();
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
