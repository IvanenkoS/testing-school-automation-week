package lv.ctco.ts.smoke.magentic_games;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by olgerts.kazarin on 8/17/2016.
 */

public class OlgertsPuzzleTest {

    private WebDriver driver;

    @Test
    public void verifyNewProductPage(){

        driver = new FirefoxDriver();
        driver.get("http://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        List<WebElement> menuList=driver.findElements(By.xpath("//h3[.='Customer service']/following-sibling::ul/li/a"));
        menuList.get(5).click();

        List<WebElement> productList= driver.findElements(By.xpath("//img[./ancestor::div[@class='product-item']]"));
        Assert.assertEquals(8,productList.size());
        String firstelementtext = productList.get(0).findElement(By.xpath("./ancestor::div[@class='item-box']//div[@class='details']/h2/a")).getText();
        Assert.assertEquals("Build your own cheap computer",firstelementtext);
        driver.close();
    }
}
