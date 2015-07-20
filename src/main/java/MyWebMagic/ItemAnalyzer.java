package MyWebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liker on 19/07/2015 0019.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ItemAnalyzer implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
//        System.out.println(this.getName(page));
        for (String image : this.getImageAddress(page)) {
            System.out.println(image);
            ImageGet ig = new ImageGet();
            ig.getImage(image);
        }

//        System.out.println(this.getPropertyMap(page));

    }

    public String getName(Page page) {
        return page.getHtml().xpath("//*[@id=\"J_ImgBooth\"]/@alt").toString();
    }

    public String[] getImageAddress(Page page) {
        int limit = page.getHtml().xpath("//*[@id=\"J_UlThumb\"]/li").nodes().size();
        String[] images = new String[limit];
        for (int i = 0; i < limit; i++) {
            int j = i + 1;
            images[i] = page.getHtml()
                    .xpath("//*[@id=\"J_UlThumb\"]/li[" + j + "]/a/img/@src")
                    .toString()
                    .replace("//", "")
                    .replace("_60x60q90.jpg", "");
        }
        return images;
    }

    public Map<String, String> getPropertyMap(Page page) {
        int limit = page.getHtml().xpath("///*[@id=\"J_AttrUL\"]/li").nodes().size();
        String[] keys;
        Map<String, String> result = new HashMap<>();
//        <li title="&nbsp;A型">廓形:&nbsp;A型</li>
        for (int i = 0; i < limit; i++) {
            int j = i + 1;
            page.putField(String.valueOf(j), page.getHtml().xpath("///*[@id=\"J_AttrUL\"]/li[" + j + "]/text()").toString().replaceAll("\u00A0", ""));
            String[] key = page.getResultItems().get(String.valueOf(j)).toString().split(":", 2);
            result.put(key[0], key[1]);
        }
        return result;
    }

    @Override
    public Site getSite() {
        return site;
    }

    //    //*[@id="J_AttrUL"]
    public static void main(String[] args) {
        Spider spider = Spider.create(new ItemAnalyzer());
        spider.addUrl("https://detail.tmall.com/item.htm?id=520452595021");
//        spider.addUrl("https://detail.tmall.com/item.htm?id=45841654739");
//        spider.addUrl("https://detail.tmall.com/item.htm?id=520347727231");
        spider.thread(1);
        spider.start();
    }
}
