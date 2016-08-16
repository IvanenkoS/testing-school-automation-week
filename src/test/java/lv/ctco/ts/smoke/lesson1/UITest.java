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
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by okunev on 8/3/2016.
 */
public class UITest {

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
        WebElement lblLogo = driver.findElement(By.cssSelector(""));
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
        List<WebElement> lblTopMenuItems = driver.findElements(By.xpath(""));
        Assert.assertTrue(lblTopMenuItems.size() == 7);

        //Save all menuItems values to List
        List<String> menuItems = new ArrayList<String>();
        for (WebElement element : lblTopMenuItems) {
            menuItems.add(element.getText());
        }

        //Verify List contains all values
        Assert.assertTrue(menuItems.containsAll(Arrays.asList("BOOKS", "COMPUTERS", "ELECTRONICS", "APPAREL & SHOES", "DIGITAL DOWNLOADS", "JEWELRY", "GIFT CARDS")));
    }

    @Test
    public void verifyCategoriesIsCorrect() {
        //Open firefox
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Create list of WebElements
        List<WebElement> lblSideMenuItems = driver.findElements(By.cssSelector(""));
        Assert.assertTrue(lblSideMenuItems.size() == 7);

        WebElement lblCategory = driver.findElement(By.cssSelector(""));
        Assert.assertEquals("CATEGORIES", lblCategory.getText());

        //Save all menuItems values to List
        List<String> menuItems = new ArrayList<String>();
        for (WebElement element : lblSideMenuItems) {
            menuItems.add(element.getText());
        }

        //Verify List contains all values
        Assert.assertTrue(menuItems.containsAll(Arrays.asList("Books", "Computers", "Electronics", "Apparel & Shoes", "Digital downloads", "Jewelry", "Gift Cards")));
    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null)
            driver.quit();
    }
}