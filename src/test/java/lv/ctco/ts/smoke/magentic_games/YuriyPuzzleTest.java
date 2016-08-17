package lv.ctco.ts.smoke.magentic_games;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuris.panfilo on 8/17/2016.
 */
public class YuriyPuzzleTest {

    private WebDriver driver;

    @Test
    public void verifyVoteCanBeDone(){
        driver = new FirefoxDriver();

        //navigate to aplication url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find excelent radio button
        WebElement excelentRBtn = driver.findElement(By.cssSelector("[type='radio'][value='1']"));
        excelentRBtn.click();

        //Find vote button
        WebElement voteBtn = driver.findElement(By.xpath("//*[@id='block-poll-vote-error-1']/preceding-sibling::div/input"));
        voteBtn.click();


        //Verify  error message
        WebElement errorMessage = driver.findElement(By.id("block-poll-vote-error-1"));
        Assert.assertTrue(errorMessage.isDisplayed());
        driver.close();

    }





}
