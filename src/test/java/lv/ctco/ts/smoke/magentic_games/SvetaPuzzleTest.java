package lv.ctco.ts.smoke.magentic_games;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SvetaPuzzleTest {

    private WebDriver driver;

    @Test
    public void verifyNewsPage() {

        driver = new FirefoxDriver();
        driver.get("http://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        List<WebElement>menuList=driver.findElements(By.xpath("//h3[.='Customer service']/following-sibling::ul/li/a"));
        menuList.get(1).click();
        List<WebElement> newsHeaders=driver.findElements(By.xpath("//div[@class='news-items']/div/div[1]/a"));

        Assert.assertEquals(2, newsHeaders.size());
        Assert.assertEquals("New online store is open!", newsHeaders.get(0).getText());

        driver.close();
    }
}
