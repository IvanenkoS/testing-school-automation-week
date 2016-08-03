package lv.ctco.ts.smoke.lesson1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by okunev on 8/3/2016.
 */
public class SmokeTest {

    private WebDriver driver;

    @Test
    public void verifyApplicationIsUp() {
        //Open firefox
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Verify Logo is displayed
        WebElement lblLogo = driver.findElement(By.cssSelector(".header-logo"));
        Assert.assertTrue(lblLogo.isDisplayed());
    }

    @Test
    public void verifyTopMenuIsCorrect() {
        //Open firefox
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Create list of WebElements
        List<WebElement> lblTomMenuItems = driver.findElements(By.xpath("//ul[@class='top-menu']/li/a"));
        Assert.assertTrue(lblTomMenuItems.size() == 7);

        //Save all menuItems values to List
        List<String> menuItems = new ArrayList<>();
        for (WebElement element : lblTomMenuItems) {
            menuItems.add(element.getText());
        }

        //Verify List contains all values
        Assert.assertTrue(menuItems.containsAll(Arrays.asList("BOOKS", "COMPUTERS", "ELECTRONICS", "APPAREL & SHOES", "DIGITAL DOWNLOADS", "JEWELRY", "GIFT CARDS")));
    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null)
            driver.quit();
    }
}
