package webMagic;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.util.List;

/**
 * Created by liker on 18/07/2015 0018.
 * Group iTailor.hunters.neu.edu.cn
 */

//将URL中常用的字符.默认做了转义，变成了\.
// 将"*"替换成了".*"，直接使用可表示通配符。
@TargetUrl("https://github.com/\\w+/\\w+")//TargetUrl是我们最终要抓取的URL，最终想要的数据都来自这里[最终的项目页]
//TargetUrl还支持定义sourceRegion，这个参数是一个XPath表达式，指定了这个URL从哪里得到——不在sourceRegion的URL不会被抽取。
@HelpUrl("https://github.com/\\w+")//HelpUrl则是为了发现这个最终URL，我们需要访问的页面[项目搜索页，它会展示所有项目的链接]
//      对于博客页，HelpUrl是列表页，TargetUrl是文章页。
//      对于论坛，HelpUrl是帖子列表，TargetUrl是帖子详情。
//      对于电商网站，HelpUrl是分类列表，TargetUrl是商品详情。
public class GithubRepo {

    @ExtractBy(value = "//h1[@class='entry-title public']/strong/a/text()", notNull = true)
    //notNull = true 此字段不允许为空。如果为空，这条抽取到的结果会被丢弃 notNull默认为false
    //使用这个抽取规则，将抽取到的结果保存到这个字段中
    private String name;

    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
    private String author;

    @ExtractBy("//div[@id='readme']/tidyText()")
    private String readme;

    @ExtractBy(value = "div.BlogContent", type = ExtractBy.Type.Css)
    private String content;

    @ExtractBy("//div[@class='BlogTags']/a/text()")
    private List<String> tags;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), GithubRepo.class)
                .addUrl("https://github.com/code4craft").thread(5).run();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }
}