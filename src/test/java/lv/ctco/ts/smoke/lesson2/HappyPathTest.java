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
        WebElement btnAddToCart = getDriver().findElement(By.cssSelector(".add-to-cart [value='Add to cart']"));
        btnAddToCart.click();

        //Wait for Ajax element invisibility
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Go to Shopping cart
        WebElement lnkShoppingCart = getDriver().findElement(By.xpath("//li[@id='topcartlink']/a"));
        lnkShoppingCart.click();

        //Checkout
        WebElement cbxIAgree = getDriver().findElement(By.cssSelector("#termsofservice"));
        WebElement btnCheckout = getDriver().findElement(By.cssSelector("#checkout"));
        cbxIAgree.click();
        btnCheckout.click();

        WebElement btnCheckoutAsGuest = getDriver().findElement(By.cssSelector("[value='Checkout as Guest']"));
        btnCheckoutAsGuest.click();

        //Provide billing information
        getDriver().findElement(By.id("BillingNewAddress_FirstName")).sendKeys("FirstNameT");
        getDriver().findElement(By.id("BillingNewAddress_LastName")).sendKeys("LastNameT");
        getDriver().findElement(By.id("BillingNewAddress_Email")).sendKeys("email@Test.lv");
        new Select(getDriver().findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText("Latvia");
        getDriver().findElement(By.id("BillingNewAddress_City")).sendKeys("Riga");
        getDriver().findElement(By.id("BillingNewAddress_Address1")).sendKeys("Test Street");
        getDriver().findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("LV-6789");
        getDriver().findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("23456789");
        getDriver().findElement(By.cssSelector("#opc-billing input[value='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        getDriver().findElement(By.cssSelector("#opc-shipping input[value='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        getDriver().findElement(By.cssSelector("#opc-shipping_method input[value='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        getDriver().findElement(By.cssSelector("#opc-payment_method input[value='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        getDriver().findElement(By.cssSelector("#opc-payment_info input[value='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        getDriver().findElement(By.cssSelector("#confirm-order-buttons-container [value='Confirm']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        //Verify order is completed
        WebElement lblMessage = getDriver().findElement(By.cssSelector(".order-completed .title strong"));
        Assert.assertEquals("Your order has been successfully processed!", lblMessage.getText());
        getDriver().findElement(By.cssSelector("input[value='Continue']")).click();
        Assert.assertTrue(getDriver().findElement(By.cssSelector("#nivo-slider")).isDisplayed());
    }
}
