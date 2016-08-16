package lv.ctco.ts.smoke.lesson1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class UIHeadersRomanTest {

    private WebDriver driver;

    @Test
    public void verifySearchWorkingProperly() {
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);


        //Verify correct element is found - books
        WebElement lblProduct = driver.findElement(By.xpath("//ul[@class='top-menu']/li[1]/a"));
        Assert.assertTrue(lblProduct.isDisplayed());
        Assert.assertEquals("BOOKS", lblProduct.getText());

        //Verify correct element is found - computers
        WebElement lblProduct7 = driver.findElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
        Assert.assertTrue(lblProduct7.isDisplayed());
        Assert.assertEquals("COMPUTERS", lblProduct7.getText());

        //Verify correct element is found - electronics
        WebElement lblProduct2 = driver.findElement(By.xpath("//ul[@class='top-menu']/li[3]/a"));
        Assert.assertTrue(lblProduct2.isDisplayed());
        Assert.assertEquals("ELECTRONICS", lblProduct2.getText());

        //Verify correct element is found
        WebElement lblProduct3 = driver.findElement(By.xpath("//ul[@class='top-menu']/li[4]/a"));
        Assert.assertTrue(lblProduct3.isDisplayed());
        Assert.assertEquals("APPAREL & SHOES", lblProduct3.getText());

        //Verify correct element is found - digital downloads
        WebElement lblProduct4 = driver.findElement(By.xpath("//ul[@class='top-menu']/li[5]/a"));
        Assert.assertTrue(lblProduct4.isDisplayed());
        Assert.assertEquals("DIGITAL DOWNLOADS", lblProduct4.getText());

        //Verify correct element is found - jewelry
        WebElement lblProduct5 = driver.findElement(By.xpath("//ul[@class='top-menu']/li[6]/a"));
        Assert.assertTrue(lblProduct5.isDisplayed());
        Assert.assertEquals("JEWELRY", lblProduct5.getText());

        //Verify correct element is found - Gift cards
        WebElement lblProduct6 = driver.findElement(By.xpath("//ul[@class='top-menu']/li[7]/a"));
        Assert.assertTrue(lblProduct6.isDisplayed());
        Assert.assertEquals("GIFT CARDS", lblProduct6.getText());

        //Verify correct element is found - Register
        WebElement lblRegister = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[1]/a"));
        Assert.assertTrue(lblRegister.isDisplayed());
        Assert.assertEquals("Register", lblRegister.getText());

        //Verify correct element is found - Log in
        WebElement lblLogin = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[2]/a"));
        Assert.assertTrue(lblLogin.isDisplayed());
        Assert.assertEquals("Log in", lblLogin.getText());

        //Verify correct element is found - Shoppin cart
        WebElement lblShoppingcart = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[3]/a"));
        Assert.assertTrue(lblShoppingcart.isDisplayed());
        Assert.assertEquals(true, lblShoppingcart.getText().contains("Shopping cart"));

        //Verify correct element is found - Wishlist
        WebElement lblWishlist = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[4]/a"));
        Assert.assertTrue(lblWishlist.isDisplayed());
        Assert.assertEquals(true, lblWishlist.getText().contains("Wishlist"));
        //Close browser
        driver.quit();
    }
}