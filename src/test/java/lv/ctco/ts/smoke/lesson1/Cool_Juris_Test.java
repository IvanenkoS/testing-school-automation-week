package lv.ctco.ts.smoke.lesson1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuris.panfilo on 8/16/2016.
 */
public class Cool_Juris_Test {

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

        //Find element cool
        WebElement coolSearch = driver.findElement(By.xpath("//*[.='cool']/../li[8]/a[1]"));
        coolSearch.click();

        //Verify correct product is found
        WebElement lblProduct = driver.findElement(By.xpath("//a[.='Blue Jeans']"));
        Assert.assertTrue(lblProduct.isDisplayed());
        Assert.assertEquals("Blue Jeans", lblProduct.getText());

        //find page 1
        WebElement txt1pageSearch = driver.findElement(By.xpath("//span[.='1']"));


        //Find and press page button 2
        WebElement btnpage2 = driver.findElement(By.xpath("//a[.='2']"));
        btnpage2.click();

        //Find and press page 3
        WebElement btnpage3 = driver.findElement(By.xpath("//a[.='3']"));
        btnpage3.click();



        //Close browser
        driver.quit();
    }
}
