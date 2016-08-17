package lv.ctco.ts.smoke.SvetaPages;

import lv.ctco.ts.smoke.SvetaCommands.SeleniumWrapper;
import org.openqa.selenium.By;

public class RegisterPage extends Page {

        public RegisterPage(SeleniumWrapper browser) {
            super(browser);
        }

        public void register(String userFirstName, String userLastName, String userEmail, String userPassword) {
//            public HomePage register(String userFirstName, String userLastName, String userEmail, String userPassword) {
            //Find input field First name
            browser.type(By.id("FirstName"), userFirstName);
            //Find input field Last name
            browser.type(By.id("LastName"), userLastName);
            //Find input field Email
            browser.type(By.id("Email"), userEmail);
            //Find input field Password
            browser.type(By.id("Password"), userPassword);
            //Find input field ConfirmPassword
            browser.type(By.id("ConfirmPassword"), userPassword);
            //Find button Register
            browser.click(By.xpath("//div[@class='buttons']/input[@id='register-button']"));
            //Find button Continue
            browser.click(By.xpath("//div[@class='page registration-result-page']//input[@value='Continue']"));
        }
}