package lv.ctco.ts.smoke.lesson1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BooksTest {

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

        //Find and Create web element Books
        WebElement linkBooksTopMenu = driver.findElement(By.xpath("//ul[@class='top-menu']/li/a[contains(text(),'Books')]"));

        //Click at Books element
        linkBooksTopMenu.click();

        //Find Sorting products element
        Select select = new Select(driver.findElement(By.xpath("//select[@id='products-orderby']")));

        //Sort products by name
        select.selectByVisibleText("Name: A to Z");

        //Add to cart Computer and Internet book
        WebElement btnAddChartBlueJeans = driver.findElement(By.xpath("//h2[./a[.='Computing and Internet']]/following-sibling::div[@class='add-info']//input[@type='button']"));
        btnAddChartBlueJeans.click();

        //Close cart popup
        WebElement closeButton = driver.findElement(By.xpath("//span[@class='close']"));
        closeButton.click();

        //Wait for Ajax element invisibility
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

        //Go to Shopping chart
        WebElement lnkShoppingCart=driver.findElement(By.cssSelector("#topcartlink"));
        lnkShoppingCart.click();

        //Verify then product appears in shopping cart
        WebElement lblProduct=driver.findElement(By.xpath("//tr[@class='cart-item-row']/td[@class='product']/a"));
        Assert.assertEquals("Computing and Internet", lblProduct.getText());
    }

    @After
    public void tearDown() throws InterruptedException{
        if (driver!=null)
            driver.quit();
    }

}
