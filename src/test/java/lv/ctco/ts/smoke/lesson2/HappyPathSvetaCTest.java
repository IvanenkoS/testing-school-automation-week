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

public class HappyPathSvetaCTest extends TestStarter{

    @Test
    public void verifyUserCanBySomeProduct() {
        RegularPageModel regularPageModel = new RegularPageModel(getDriver());

        //Find input field Search
        regularPageModel.getTxtSearch().sendKeys("blue and green");

        //Find button Search
        regularPageModel.getBtnSearch().click();

        //Click on product
        regularPageModel.getLnkProduct().click();

        //Wait for Ajax element invisibility
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Add to cart
        regularPageModel.getBtnnAddToCart().click();

        //Wait for Ajax element invisibility
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Go to Shopping cart
        regularPageModel.getLnkShoppingCart().click();

        //Checkout
        regularPageModel.getCbxIAgree().click();
        regularPageModel.getBtnCheckout().click();

        regularPageModel.getBtnCheckoutAsGuest().click();

        //Provide billing information
        regularPageModel.getFirstName().sendKeys("FirstNameT");
        regularPageModel.getLastName().sendKeys("LastNameT");
        regularPageModel.getEmail().sendKeys("email@Test.lv");
        new Select(regularPageModel.getCountry()).selectByVisibleText("Latvia");
        regularPageModel.getCity().sendKeys("Riga");
        regularPageModel.getStreet().sendKeys("Test Street");
        regularPageModel.getZip().sendKeys("LV-6789");
        regularPageModel.getTel().sendKeys("23456789");
        regularPageModel.getBtnContinue1().click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        regularPageModel.getBtnContinue2().click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));

        regularPageModel.getBtnContinue3().click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));
        regularPageModel.getBtnContinue4().click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));
        regularPageModel.getBtnContinue5().click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));
        regularPageModel.getBtnContinue6().click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#billing-please-wait")));
        //Verify order is completed
        regularPageModel.getBtnConfirm().click();
        WebElement lblMessage = regularPageModel.getTitle();
        Assert.assertEquals("Your order has been successfully processed!", lblMessage.getText());
        regularPageModel.getBtnContinue7().click();
        Assert.assertTrue(getDriver().findElement(By.cssSelector(".topic-html-content-header")).isDisplayed());
    }
}
