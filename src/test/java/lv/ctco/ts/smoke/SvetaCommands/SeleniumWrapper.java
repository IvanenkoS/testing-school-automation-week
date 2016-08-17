package lv.ctco.ts.smoke.SvetaCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SeleniumWrapper {

    private WebDriver driver;

    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public void openURL(String URL) {
        driver.get(URL);
    }

    public void click(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void waitForElementInvisibility(By locator){
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void type(By locator, String whatToType){
        WebElement element = driver.findElement(locator);
        element.clear();
        element.findElement(locator).sendKeys(whatToType);
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public WebElement select(By locator) {
        return driver.findElement(locator);
    }
//    public void acceptAllert(String YesOrNo){
//        driver.switchTo().alert().accept();
//    }

    public void closeBrowser(){
        driver.quit();
    }

}
