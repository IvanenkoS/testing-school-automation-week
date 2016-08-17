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
        regularPageModel.getBtnnAddToCart().click();

        //Wait for Ajax element invisibility
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Go to Shopping cart
        regularPageModel.getLnkShoppingCart().click();

        //Checkout
        WebElement cbxIAgree = getDriver().findElement(By.cssSelector("#termsofservice"));
        cbxIAgree.click();
        WebElement btnCheckout = getDriver().findElement(By.cssSelector("#checkout"));
        btnCheckout.click();

        WebElement btnCheckoutAsGuest = getDriver().findElement(By.xpath("//input[@value='Checkout as Guest']"));
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

        getDriver().findElement(By.cssSelector("#opc-billing [title='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        getDriver().findElement(By.cssSelector("#opc-shipping [title='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#shipping-please-wait")));

        getDriver().findElement(By.cssSelector("#opc-shipping_method [value='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#shipping-method-please-wait")));

        getDriver().findElement(By.cssSelector("#payment-method-buttons-container [value='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#payment-method-please-wait")));

        getDriver().findElement(By.cssSelector("#opc-payment_info [value='Continue']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#payment-info-please-wait")));

        getDriver().findElement(By.cssSelector("#opc-confirm_order [value='Confirm']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#confirm-order-please-wait")));

        //Verify order is completed
        WebElement lblMessage = getDriver().findElement(By.cssSelector(".title"));
        Assert.assertEquals("Your order has been successfully processed!", lblMessage.getText());
        getDriver().findElement(By.cssSelector("[value='Continue']")).click();
        Assert.assertTrue(getDriver().findElement(By.cssSelector(".topic-html-content-header")).isDisplayed());
        Assert.assertEquals("http://demowebshop.tricentis.com/", getDriver().getCurrentUrl());
        //Olgert
    }
}
