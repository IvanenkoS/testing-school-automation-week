package lv.ctco.ts.smoke.lesson1;

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
 * Created by okunev on 8/4/2016.
 */
public class RegisterVikaTest {

    private WebDriver driver;

    @Test
    public void verifySearchWorkingProperly() {
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find button Register
        WebElement btnRegister = driver.findElement(By.xpath("//a[@class='ico-register'][text()='Register']"));
        btnRegister.click();

        //Click button Female
        WebElement btnFemale = driver.findElement(By.id("gender-female"));
        btnFemale.click();

        Random random = new Random();
        String firstName = new String();
        for (int i = 1; i < 15; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            firstName = firstName + c;
        }

        //Find input field First name
        WebElement txtFirstname = driver.findElement(By.id("FirstName"));
        txtFirstname.sendKeys(firstName);

        //Find input field Last name
        WebElement txtLastname = driver.findElement(By.id("LastName"));
        txtLastname.sendKeys("Test");

        //Find input field Email
        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.sendKeys(firstName + ".Test@gmail.com");

        //Find input field Password
        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.sendKeys("Marineee.Test");

        //Find input field ConfirmPassword
        WebElement txtConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
        txtConfirmPassword.sendKeys("Marineee.Test");

        //Find button Register
        WebElement btnRegister1 = driver.findElement(By.xpath("//div[@class='buttons']/input[@id='register-button']"));
        btnRegister1.click();

        //Verify Register is successful
        WebElement btnAccount = driver.findElement(By.xpath("//a[@class='account']"));
        Assert.assertEquals("Marineee.Test@gmail.com", btnAccount.getText());
        WebElement btnLogout = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        Assert.assertEquals("Log out", btnLogout.getText());


    }
}