package lv.ctco.ts.smoke.lesson1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddToShoppingCardTest {

    private WebDriver driver;

    @Test
    public void verifyThatProductAppearsInShoppingCart(){
        //Open firefox
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find and Create web element Apparel And Shoes
        WebElement lnkApparelAndShoesTopMenu = driver.findElement(By.xpath(""));

        //Click at Apparel And Shoes element
        lnkApparelAndShoesTopMenu.click();

        //Add to chart Blue Jeans
        WebElement btnAddChartBlueJeans = driver.findElement(By.xpath(""));
        btnAddChartBlueJeans.click();

        //Wait for Ajax element invisibility
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Go to Shopping chart
        WebElement lnkShoppingCart=driver.findElement(By.cssSelector(""));
        lnkShoppingCart.click();

        //Verify then product appears in shopping cart
        WebElement lblProduct=driver.findElement(By.xpath(""));
        Assert.assertEquals("Blue Jeans", lblProduct.getText());
    }

    @After
    public void tearDown() throws InterruptedException{
        if (driver!=null)
        driver.quit();
    }
}
