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
 * Created by Olgert
 */
public class OKRegisterTest {

    private WebDriver driver;

    @Test
    public void verifyRegisterWorkingProperly() {
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        double random=Math.random();

        //Find button Register
        WebElement btnReg = driver.findElement(By.cssSelector(".ico-register"));
        btnReg.click();

        //Click button Male
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("gender-male")));
        WebElement btnGender = driver.findElement(By.id("gender-male"));
        btnGender.click();

        //Find input field FirstName
        WebElement txtFirstN = driver.findElement(By.id("FirstName"));
        txtFirstN.sendKeys("Test");

        //Find input field LastName
        WebElement txLastN = driver.findElement(By.id("LastName"));
        txLastN.sendKeys("Tester");

        //Find input field Email
        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.sendKeys(random+"Test@test.com");

        //Find input field Password
        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.sendKeys("Test123");

        //Find input field ConfirmPassword
        WebElement txtConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        txtConfirmPassword.sendKeys("Test123");

        //Find button Register
        WebElement btnReg1 = driver.findElement(By.cssSelector("#register-button"));
        btnReg1.click();

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
