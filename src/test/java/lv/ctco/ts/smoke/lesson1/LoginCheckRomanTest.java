package lv.ctco.ts.smoke.lesson1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class LoginCheckRomanTest {
    private WebDriver driver;

    @Test
    public void verifySearchWorkingProperly() {
        driver = new FirefoxDriver();

        //Navigate to application url login page
        driver.get("http://demowebshop.tricentis.com/login");

        //Make a string for User
        String email = "Romans.Pipcenko@gmail.com";

        //Find input field Email
        WebElement txtEmail = driver.findElement(By.xpath("//input[@autofocus='autofocus']"));
        txtEmail.sendKeys(email);

        //Find input field Password
        WebElement txtPass = driver.findElement(By.xpath("//input[@class='password']"));
        txtPass.sendKeys("DemoPass");

        //Click on a Login button
        WebElement btnLogin = driver.findElement(By.cssSelector(".button-1[value='Log in']"));
        btnLogin.click();

        //Verify correct user login
        WebElement lblUserz = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[1]"));
        Assert.assertTrue(lblUserz.isDisplayed());
        Assert.assertEquals(true, lblUserz.getText().contains(email));

        //Close browser
        driver.quit();
    }
}