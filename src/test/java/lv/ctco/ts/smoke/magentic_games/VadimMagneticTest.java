package lv.ctco.ts.smoke.magentic_games;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class VadimMagneticTest {

    private WebDriver driver;

    @Test
    public void checkSiteMapInformation() {
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Find and click SiteMap link
        driver.manage().window().maximize();
        WebElement siteMapLink = driver.findElement(By.xpath("//div[@class='column information']/ul/li[1]/a"));
        siteMapLink.click();

        //compare number of elements
        List<WebElement> categories = driver.findElements(By.xpath("//div[./h2[text()='Categories']]/following-sibling::div[@class='entity-body']/ul/*"));
        Assert.assertEquals(12, categories.size());

    }
}
