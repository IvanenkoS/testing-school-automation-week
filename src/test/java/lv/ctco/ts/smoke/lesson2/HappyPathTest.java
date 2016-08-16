package lv.ctco.ts.smoke.lesson2;

import lv.ctco.ts.base.TestStarter;
import lv.ctco.ts.ui.model.RegularPageModel;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HappyPathTest extends TestStarter{

    @Test
    public void verifyUserCanBySomeProduct() {
        RegularPageModel regularPageModel = new RegularPageModel(getDriver());

        //Find input field Search
        regularPageModel.getTxtSearch().sendKeys("blue and green");

        //Find button Search
        regularPageModel.getBtnSearch().click();

        //Click on product
        regularPageModel.getLnkProduct().click();

        //Add to cart
        WebElement btnAddToCart = getDriver().findElement(By.cssSelector(""));
        btnAddToCart.click();

        //Wait for Ajax element invisibility
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Go to Shopping cart
        WebElement lnkShoppingCart = getDriver().findElement(By.xpath(""));
        lnkShoppingCart.click();

        //Checkout
        WebElement cbxIAgree = getDriver().findElement(By.cssSelector(""));
        WebElement btnCheckout = getDriver().findElement(By.cssSelector(""));
        cbxIAgree.click();
        btnCheckout.click();

        WebElement btnCheckoutAsGuest = getDriver().findElement(By.cssSelector(""));
        btnCheckoutAsGuest.click();

        //Provide billing information
        getDriver().findElement(By.id("")).sendKeys("FirstNameT");
        getDriver().findElement(By.id("")).sendKeys("LastNameT");
        getDriver().findElement(By.id("")).sendKeys("email@Test.lv");
        new Select(getDriver().findElement(By.id(""))).selectByVisibleText("Latvia");
        getDriver().findElement(By.id("")).sendKeys("Riga");
        getDriver().findElement(By.id("")).sendKeys("Test Street");
        getDriver().findElement(By.id("")).sendKeys("LV-6789");
        getDriver().findElement(By.id("")).sendKeys("23456789");
        getDriver().findElement(By.cssSelector("")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        getDriver().findElement(By.cssSelector("")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        getDriver().findElement(By.cssSelector("")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        getDriver().findElement(By.cssSelector("")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        getDriver().findElement(By.cssSelector("")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        getDriver().findElement(By.cssSelector("")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        //Verify order is completed
        WebElement lblMessage = getDriver().findElement(By.cssSelector(""));
        Assert.assertEquals("Your order has been successfully processed!", lblMessage.getText());
        getDriver().findElement(By.cssSelector("")).click();
        Assert.assertTrue(getDriver().findElement(By.cssSelector("")).isDisplayed());
    }
}
