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
        WebElement txtSearch = driver.findElement(By.id(""));
        txtSearch.sendKeys("blue and green");

        //Find button Search
        WebElement btnSearch = driver.findElement(By.cssSelector(""));
        btnSearch.click();

        //Click on product
        WebElement lnkProduct = driver.findElement(By.cssSelector(""));
        lnkProduct.click();

        //Add to cart
        WebElement btnAddToCart = driver.findElement(By.cssSelector(""));
        btnAddToCart.click();

        //Wait for Ajax element invisibility
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        //Go to Shopping cart
        WebElement lnkShoppingCart = driver.findElement(By.xpath(""));
        lnkShoppingCart.click();

        //Checkout
        WebElement cbxIAgree = driver.findElement(By.cssSelector(""));
        WebElement btnCheckout = driver.findElement(By.cssSelector(""));
        cbxIAgree.click();
        btnCheckout.click();

        WebElement btnCheckoutAsGuest = driver.findElement(By.cssSelector(""));
        btnCheckoutAsGuest.click();

        //Provide billing information
        driver.findElement(By.id("")).sendKeys("FirstNameT");
        driver.findElement(By.id("")).sendKeys("LastNameT");
        driver.findElement(By.id("")).sendKeys("email@Test.lv");
        new Select(driver.findElement(By.id(""))).selectByVisibleText("Latvia");
        driver.findElement(By.id("")).sendKeys("Riga");
        driver.findElement(By.id("")).sendKeys("Test Street");
        driver.findElement(By.id("")).sendKeys("LV-6789");
        driver.findElement(By.id("")).sendKeys("23456789");
        driver.findElement(By.cssSelector("")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        driver.findElement(By.cssSelector("")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        driver.findElement(By.cssSelector("")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        driver.findElement(By.cssSelector("")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        driver.findElement(By.cssSelector("")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        driver.findElement(By.cssSelector("")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        //Verify order is completed
        WebElement lblMessage = driver.findElement(By.cssSelector(""));
        Assert.assertEquals("Your order has been successfully processed!", lblMessage.getText());
        driver.findElement(By.cssSelector("")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());

        //Close browser
        driver.quit();
    }
}
