package lv.ctco.ts.smoke.magentic_games;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by vustinovicha on 8/17/2016.
 */
public class VikaPuzzleTest {
    private WebDriver driver;

    @Test
    public void verifyWelcomeTextCorrect() {
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find button Address
        WebElement address = driver.findElement(By.xpath("//h3[.='My account']/following-sibling::ul/li[last()-2]/a"));
        address.click();

        //Verify welcome Text is correct
        WebElement welcomeText = driver.findElement(By.xpath("//div[@class='page-body']/preceding-sibling::div/h1"));
        System.out.println(welcomeText.getText());
        Assert.assertEquals("Welcome, Please Sign In!", welcomeText.getText());


    }
}
