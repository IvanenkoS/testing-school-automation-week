package lv.ctco.ts.smoke.magentic_games;

import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by semova on 8/17/2016.
 */
public class IrinaPuzzleTest {

    private WebDriver driver;

    @Test

    public void verifyAddressesPage(){

        driver = new FirefoxDriver();

        driver.get("http://demowebshop.tricentis.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        WebElement address = driver.findElement (By.xpath("//h3[.='My account']/following-sibling::ul/li[last()-2]/a"));
        address.click();

        WebElement welcomeText = driver.findElement (By.xpath("//div[@class='page-body']/preceding-sibling::div/h1"));

        Assert.assertTrue(welcomeText.getText().contains("Welcome, Please Sign In!"));

        driver.quit();


    }
}

