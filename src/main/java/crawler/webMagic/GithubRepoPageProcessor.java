package crawler.webMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.management.JMException;

/**
 * Created by liker on 18/07/2015 0018.
 * Group iTailor.hunters.neu.edu.cn
 */

public class GithubRepoPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    // 也包括一些模拟的参数，例如User Agent、cookie，以及代理的设置，
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    //setCharset(String) 	    设置编码 	               site.setCharset("utf-8")
    //setUserAgent(String) 	    设置UserAgent 	           site.setUserAgent("Spider")
    //setTimeOut(int) 	        设置超时时间，单位是毫秒 	   site.setTimeOut(3000)
    //setRetryTimes(int) 	    设置重试次数 	           site.setRetryTimes(3)
    //setCycleRetryTimes(int) 	设置循环重试次数 	       site.setCycleRetryTimes(3)
    //addCookie(String,String) 	添加一条cookie 	           site.addCookie("dotcomt_user","code4craft")
    //setDomain(String) 	    设置域名，需设置域名后，addCookie才可生效 	site.setDomain("github.com")
    //addHeader(String,String) 	添加一条addHeader 	       site.addHeader("Referer","https://github.com")
    //setHttpProxy(HttpHost) 	设置Http代理 	           site.setHttpProxy(new HttpHost("127.0.0.1",8080))

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws JMException {


        Spider githubSpider = Spider.create(new GithubRepoPageProcessor())
                .addUrl("https://github.com/code4craft")
//                .addRequest()
//                .addPipeline(new JsonFilePipeline(".\\webmagic\\"))//可以添加多个
                        //开启5个线程抓取
                .thread(5);
                        //启动爬虫
                        //start()/runAsync() 当前线程继续执行
//                .run();//会阻塞当前线程
        //.stop()
        //test("https://github.com/code4craft")
        //spider .setDownloader(new SeleniumDownloader())  只能有一个downloader
        //get(String)  List<ResultItems> results = spider .getAll("http://webmagic.io/docs/", "http://webmagic.io/xxx")

        SpiderMonitor.instance().register(githubSpider);//可以注册多个Spiders
        githubSpider.start();



    }
}