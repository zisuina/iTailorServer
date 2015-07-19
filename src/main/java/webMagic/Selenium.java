package webMagic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by liker on 19/07/2015 0019.
 * Group iTailor.hunters.neu.edu.cn
 */
public class Selenium {
    public static void main(String[] args) {
        System.getProperties().setProperty("webdriver.chrome.driver", "G:\\Desktop\\JavaCrawler\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("http://huaban.com/");
        webDriver.get("https://s.taobao.com/search?q=youku");
        WebElement webElement = webDriver.findElement(By.xpath("/html"));
        System.out.println(webElement.getAttribute("outerHTML"));


        webDriver.close();
    }
}
