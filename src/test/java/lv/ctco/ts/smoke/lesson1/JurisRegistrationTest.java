package lv.ctco.ts.smoke.lesson1;

import lv.ctco.ts.ui.model.JurisRegisterPageModel;
import lv.ctco.ts.ui.model.JurisRegisterPageModel;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Random;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuris.vencels on 8/16/2016.
 */
public class JurisRegistrationTest {


    private WebDriver driver;

    Random r = new Random();
    int Low = 10000;
    int High = 99999;
    int randomNumber = r.nextInt(High-Low) + Low;

    @Test
    public void verifyRegistrationWorkingProperly() {
        driver = new FirefoxDriver();
        JurisRegisterPageModel registerPageModel = new JurisRegisterPageModel(driver);

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Click Register button

        registerPageModel.getBtnRegister().click();

        //Find input field for First name
        registerPageModel.getInpFieldByID("FirstName").sendKeys("Mr");

        //Find input field for Last name
        registerPageModel.getInpFieldByID("LastName").sendKeys("Bean");

        //Find input field for Email
        registerPageModel.getInpFieldByID("Email").sendKeys("mr.bean" + randomNumber + "@gmail.com");

        //Find input field for Password
        registerPageModel.getInpFieldByID("Password").sendKeys("12345678");

        //Find input field for Confirm password
        registerPageModel.getInpFieldByID("ConfirmPassword").sendKeys("12345678");

        //Click Register button
        registerPageModel.getInpFieldByID("register-button").click();

        //Verify registration is successful
        Assert.assertTrue(registerPageModel.getTxtSuccessResult().isDisplayed());
        Assert.assertEquals("Your registration completed", registerPageModel.getTxtSuccessResult().getText());

        driver.quit();
    }
}
