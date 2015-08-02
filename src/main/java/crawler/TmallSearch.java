package crawler;

import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liker on 20/07/2015 0020.
 * Group iTailor.hunters.neu.edu.cn
 */
public class TmallSearch implements PageProcessor {
    private static Logger logger = Logger.getLogger(TmallSearch.class);
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private ArrayList<Item> items = new ArrayList<>();
    private int count = 0;

    @Override
    public void process(Page page) {
        String[] links = this.getLinks(page);
        for (String link : links) {
            Matcher matcher = Pattern.compile("id=[0-9]+").matcher(link);
            if (matcher.find()) {
                Item item = new Item(matcher.group(0).replace("id=", ""));
                if (count < 3) {
                    item.maintain();
                    count++;
                }
                items.add(item);
                logger.debug("Add ITEM:" + item.getItemId());
            } else {
                logger.debug("Bad Link:" + link);
            }
        }
        logger.debug(">> FIND " + items.size() + " ITEMS");
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
        }
        return links;
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        new TmallSearch().search("公主裙");
    }

    public void search(String searchWord) {
        try {
            Spider spider = Spider.create(this);
            logger.debug("SEARCH SHOP NAME:" + searchWord + "BEGIN");
            spider.addUrl("https://list.tmall.com/search_product.htm?q="
                    + java.net.URLEncoder.encode(searchWord, "utf-8"));
            spider.thread(5);
            spider.run();
            logger.debug("SEARCH SHOP NAME:" + searchWord + " END");
        } catch (UnsupportedEncodingException e) {
            logger.debug("UnsupportedEncodingException:" + e.getLocalizedMessage());
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
