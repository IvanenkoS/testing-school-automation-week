package lv.ctco.ts.smoke.magentic_games;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by fominih on 8/17/2016.
 */
public class MaximMagneticTest {

    public WebDriver driver;

    @Test
    public void checkSiteMapInformation() {

        driver = new FirefoxDriver();

        driver.get("http://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        WebElement siteMapLink = driver.findElement(By.xpath("//div[@class='column information']/ul/li[1]/a"));
        siteMapLink.click();
        WebElement blogElement = driver.findElement(By.xpath("//div[@class='page-body']//a[text()='Blog']"));
        Assert.assertEquals("Blog", blogElement.getText());

    }


}
