package lv.ctco.ts.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by vadim.krasovskis on 8/16/2016.
 */
public class RegisterPageModel {

    private WebDriver driver;

    public RegisterPageModel(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonRegister() {
        return driver.findElement(By.xpath("//a[@class='ico-register']"));
    }

    public WebElement getRegButton() {

    return driver.findElement(By.xpath("//input[@id='register-button']"));
}

    public WebElement nameError(){
        return driver.findElement(By.xpath("//span[@class='field-validation-error']/span[@for='FirstName']"));
    }
    public WebElement secondNameError(){
        return driver.findElement(By.xpath("//span[@class='field-validation-error']/span[@for='LastName']"));
    }
    public WebElement Email() {
        return driver.findElement(By.xpath("//span[@class='field-validation-error']/span[@for='Email']"));
    }

    public WebElement Password() {
        return driver.findElement(By.xpath("//span[@class='field-validation-error']/span[@for='Password']"));
    }

    public WebElement ConfirmPassword() {
       return driver.findElement(By.xpath("//span[@class='field-validation-error']/span[@for='ConfirmPassword']"));
    }

 //   public WebElement getBtnSearch() {
  //      return driver.findElement(By.id(".search-box input[value='Search']"));
  //  }

 //   public WebElement getLnkProduct() {
 //       return driver.findElement(By.id(".product-item .product-title a"));
 //   }
}
