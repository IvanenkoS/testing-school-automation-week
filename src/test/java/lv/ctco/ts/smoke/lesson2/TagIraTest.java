package lv.ctco.ts.smoke.lesson2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by semova on 8/16/2016.
 */
public class TagIraTest {

    private WebDriver driver;

    @Test
    public void verifyProduct() {
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find web element View all
        WebElement lnkViewAll = driver.findElement(By.xpath("//a[contains(text(),'View all')]"));

        //Click at View all element
        lnkViewAll.click();

        //Find tag willshouldwearit
        WebElement lnkWillshouldwearit = driver.findElement(By.xpath("//a[contains(text(),'willshouldwearit')]"));

        //Click at willshouldwearit tag
        lnkWillshouldwearit.click();

        //Verify correct product is found under that tag
        WebElement lblProduct = driver.findElement(By.xpath("//a[contains(text(),'Rockabilly')]"));
        Assert.assertTrue(lblProduct.isDisplayed());
        Assert.assertEquals("50's Rockabilly Polka Dot Top JR Plus Size", lblProduct.getText());

        //Close browser
        driver.quit();


    }
}

