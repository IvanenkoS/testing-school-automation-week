package lv.ctco.ts.smoke.lesson1;

import lv.ctco.ts.ui.model.RegisterPageModel;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class RegistrationFailVadimTest {

    private WebDriver driver;

    @Test
    public void RegistrationFailTestVadim() {

        driver = new FirefoxDriver();

        RegisterPageModel registerPageModel = new RegisterPageModel(driver);

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find and click Reg link
        registerPageModel.getButtonRegister().click();

        //Press Registration Button
        registerPageModel.getRegButton().click();

        //Verify correct product is found
        Assert.assertTrue(registerPageModel.nameError().isDisplayed());
        Assert.assertEquals("First name is required.", registerPageModel.nameError().getText());

        //Verify correct product is found
        Assert.assertTrue(registerPageModel.secondNameError().isDisplayed());
        Assert.assertEquals("Last name is required.", registerPageModel.secondNameError().getText());

        //Verify correct product is found
        Assert.assertTrue(registerPageModel.Email().isDisplayed());
        Assert.assertEquals("Email is required.", registerPageModel.Email().getText());

        //Verify correct product is found
        Assert.assertTrue(registerPageModel.Password().isDisplayed());
        Assert.assertEquals("Password is required.", registerPageModel.Password().getText());

        //Verify correct product is found
        Assert.assertTrue(registerPageModel.ConfirmPassword().isDisplayed());
        Assert.assertEquals("Password is required.", registerPageModel.ConfirmPassword().getText());

        //Close browser
        driver.quit();

    }
}

