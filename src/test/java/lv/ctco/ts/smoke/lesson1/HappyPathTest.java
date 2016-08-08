package lv.ctco.ts.smoke.lesson1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HappyPathTest {

    private WebDriver driver;

    @Test
    public void verifyUserCanBySomeProduct() {
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find input field Search
        WebElement txtSearch = driver.findElement(By.id("small-searchterms"));
        txtSearch.sendKeys("blue and green");

        //Find button Search
        WebElement btnSearch = driver.findElement(By.cssSelector(".search-box input[value='Search']"));
        btnSearch.click();

        //Click on product
        WebElement lnkProduct = driver.findElement(By.cssSelector(".product-item .product-title a"));
        lnkProduct.click();

        //Add to cart
        WebElement btnAddToCart = driver.findElement(By.cssSelector(".add-to-cart [value='Add to cart']"));
        btnAddToCart.click();

        //Wait for Ajax element invisibility
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Go to Shopping cart
        WebElement lnkShoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']/a"));
        lnkShoppingCart.click();

        //Checkout
        WebElement cbxIAgree = driver.findElement(By.cssSelector("#termsofservice"));
        WebElement btnCheckout = driver.findElement(By.cssSelector("#checkout"));
        cbxIAgree.click();
        btnCheckout.click();

        WebElement btnCheckoutAsGuest = driver.findElement(By.cssSelector("[value='Checkout as Guest']"));
        btnCheckoutAsGuest.click();

        //Provide billing information
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("FirstNameT");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("LastNameT");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("email@Test.lv");
        new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText("Latvia");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Riga");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Test Street");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("LV-6789");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("23456789");
        driver.findElement(By.cssSelector("#opc-billing input[value='Continue']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        driver.findElement(By.cssSelector("#opc-shipping input[value='Continue']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        driver.findElement(By.cssSelector("#opc-shipping_method input[value='Continue']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        driver.findElement(By.cssSelector("#opc-payment_method input[value='Continue']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        driver.findElement(By.cssSelector("#opc-payment_info input[value='Continue']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        driver.findElement(By.cssSelector("#confirm-order-buttons-container [value='Confirm']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        //Verify order is completed
        WebElement lblMessage = driver.findElement(By.cssSelector(".order-completed .title strong"));
        Assert.assertEquals("Your order has been successfully processed!", lblMessage.getText());
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#nivo-slider")).isDisplayed());

        //Close browser
        driver.quit();
    }
}
