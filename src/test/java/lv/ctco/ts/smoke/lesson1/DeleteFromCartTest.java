package lv.ctco.ts.smoke.lesson1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by maxim.fominih on 8/16/2016.
 */
public class DeleteFromCartTest {

    private WebDriver driver;

    @Test
    public void verifyDeleteFromCart() {
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find and Create web element Books
        WebElement lnkBooksTopMenu = driver.findElement(By.xpath("//div[@class='header-menu']//a[contains(text(),'Books')]"));
        lnkBooksTopMenu.click();

        //Add to chart BookFiction
        WebElement lnkBookFiction = driver.findElement(By.xpath("//h2[@class='product-title']//a[.='Fiction']/../..//input[@class='button-2 product-box-add-to-cart-button']"));
        lnkBookFiction.click();

        //Wait for Ajax element invisibility
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Go to Shopping chart
        WebElement lnkShoppingCart=driver.findElement(By.xpath("//div[@class='header-links']//span[.='Shopping cart']"));
        lnkShoppingCart.click();

        //Verify that product appears in shopping cart
        WebElement lblProduct=driver.findElement(By.xpath("//tr[@class='cart-item-row']//a[contains(text(),'Fiction')]"));
        Assert.assertEquals("Fiction", lblProduct.getText());

        //Select 'Remove Product' checkbox
        WebElement ckbProduct=driver.findElement(By.xpath("//tr[@class='cart-item-row']//a[contains(text(),'Fiction')]/../..//td[@class='remove-from-cart']//input"));
        ckbProduct.click();

        //Update Shopping Cart
        WebElement updateCart=driver.findElement(By.xpath("//div[@class='page shopping-cart-page']//div[@class='common-buttons']//input[@class='button-2 update-cart-button']"));
        updateCart.click();

        //Verify that product disappears from shopping cart
        new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(lblProduct));

        //Close browser
        driver.quit();
    }


    public Boolean verifyAlertIsPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}
