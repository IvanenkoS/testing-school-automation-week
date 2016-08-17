package lv.ctco.ts.smoke.magentic_games;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by roman.pipchenko on 8/17/2016.
 */

public class RomanPuzzleTest {
    private WebDriver driver = new FirefoxDriver();

    @Test
    public void verifyDropdownValue() {

        //maximizes driver window
        driver.manage().window().maximize();
        //follows url
        driver.get("http://demowebshop.tricentis.com");
        //set wait time
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        List<WebElement> menuList= driver.findElements(By.xpath("//*[@class='master-wrapper-content']/div[last()-2]/ul[position()<2]/li/a"));
        menuList.get(6).click();
        Select display = new Select(driver.findElement(By.id("products-pagesize")));

              //Asserting
        Assert.assertEquals("8", display.getFirstSelectedOption().getText());

        driver.close();
    }
}
