package lv.ctco.ts.smoke.magentic_games;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by diana.potapenkova on 8/17/2016.
 */
public class DianaMagneticTest {
    public WebDriver driver;
@Test
    public void checkSiteMapInformation(){
    driver = new FirefoxDriver();
    driver.get("http://demowebshop.tricentis.com");
    driver.manage().window().maximize();
    WebElement siteMapLink = driver.findElement(By.xpath("//div[@class='column information']/ul/li[1]/a"));
    siteMapLink.click();
    WebElement lastCategoryElement = driver.findElement(By.xpath("//div[./h2[text()='Categories']]/following-sibling::div[@class='entity-body']/ul/li[last()]/a"));
    Assert.assertEquals("Gift Cards",lastCategoryElement.getText());





}


}
