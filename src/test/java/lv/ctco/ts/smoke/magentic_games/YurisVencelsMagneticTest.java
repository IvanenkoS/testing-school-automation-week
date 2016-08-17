package lv.ctco.ts.smoke.lesson1;

import lv.ctco.ts.base.TestStarter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuris.vencels on 8/17/2016.
 */
public class YurisVencelsMagneticTest  extends TestStarter {

    @Test
    public void checkNumberOfSiteMapCategory() {
        WebElement siteMapLink = getDriver().findElement(By.xpath("//div[@class='column information']/ul/li[1]/a"));
        siteMapLink.click();

        List<WebElement> listOfCategories = getDriver().findElements(By.xpath("//div[@class='page sitemap-page']/div/div"));

        Assert.assertEquals(3,getCategorySize(listOfCategories));
    }

    private int getCategorySize(List<WebElement> categories) {
        System.out.print("Getting number of categories");
        return categories.size();
    }
}
