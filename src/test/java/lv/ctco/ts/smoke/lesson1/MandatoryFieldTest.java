package lv.ctco.ts.smoke.lesson1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by svetlana.cipisheva on 8/16/2016.
 */
public class MandatoryFieldTest {

    private WebDriver driver;

    @Test
    public void verifyThatProductAppearsInShoppingCart() {
        //Open firefox
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find button Register
        WebElement btnRegister = driver.findElement(By.cssSelector(".ico-register"));
        btnRegister.click();

        //new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".button-1[value='Register']")));

        //Find button Register
        WebElement btnRegister2 = driver.findElement(By.cssSelector(".button-1[value='Register']"));
        btnRegister2.click();


        WebElement elementFirstName = driver.findElement(By.xpath("//input[@ id='FirstName']/following-sibling::span[2]"));
        Assert.assertEquals("First name is required.", elementFirstName.getText());

        WebElement elementLastName = driver.findElement(By.xpath("//input[@ id='LastName']/following-sibling::span[2]"));
        Assert.assertEquals("Last name is required.", elementLastName.getText());

        WebElement elementEmail = driver.findElement(By.xpath("//input[@ id='Email']/following-sibling::span[2]"));
        Assert.assertEquals("Email is required.", elementEmail.getText());

        WebElement elementPassword = driver.findElement(By.xpath("//input[@ id='Password']/following-sibling::span[2]"));
        Assert.assertEquals("Password is required.", elementPassword.getText());

        WebElement elementConfirmPassword = driver.findElement(By.xpath("//input[@ id='ConfirmPassword']/following-sibling::span[2]"));
        Assert.assertEquals("Password is required.", elementConfirmPassword.getText());

        driver.quit();
    }
}
