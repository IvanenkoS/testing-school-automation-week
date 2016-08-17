package lv.ctco.ts.smoke.SvetaPages;

import lv.ctco.ts.smoke.SvetaCommands.SeleniumWrapper;
import lv.ctco.ts.smoke.SvetaPages.Page;
import org.openqa.selenium.By;

public class HomePage extends Page {

    public HomePage(SeleniumWrapper browser) {
        super(browser);
        browser.openBrowser();
        browser.openURL("http://demowebshop.tricentis.com/");
    }

    public RegisterPage openRegisterPage() {
        browser.click(By.xpath("//a[@class='ico-register']"));
        return new RegisterPage(browser);
    }
//
//    public LogInPage openLogInPage() {
//        browser.click(By.xpath("//a[@class='ico-login'"));
//        return new LogInPage(browser);
//    }



//    public MyAccauntPage openMyAccauntPage() {
//        browser.click(By.xpath("//div[@class='header-links']//a[@class='account']"));
//        return new MyAccauntPage(browser);
//    }
//    public String getUserEmail() {
//        return browser.getText(By.xpath(""));
//    }
//    public String getUserEmail() {
//        return browser.getText(By.xpath("//div[@class='header-links']//a[@class='account']"));
//    }

//    public String getUserEmail() {
//        return browser.select(By.xpath("//div[@class='header-links']//a[@class='account']")).getText();
//    }

//    public HomePage logOut() {
//        browser.click(By.xpath("//a[@class='ico-logout']"));
//        return new HomePage(browser);
//    }

}