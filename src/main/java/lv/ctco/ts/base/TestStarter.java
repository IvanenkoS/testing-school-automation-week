package lv.ctco.ts.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestStarter {

    public WebDriver driver;

    @Before
    public void setUp(){
        driver=new FirefoxDriver();
        driver.get("http://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
