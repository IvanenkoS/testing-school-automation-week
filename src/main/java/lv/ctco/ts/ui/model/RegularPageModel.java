package lv.ctco.ts.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegularPageModel {

    private WebDriver driver;

    public RegularPageModel(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getTxtSearch() {
        return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement getBtnSearch() {
        return driver.findElement(By.cssSelector(".button-1[value='Search']"));
    }

    public WebElement getLnkProduct() {return driver.findElement(By.cssSelector(".button-2[value='Add to cart']"));}

    public WebElement getBtnnAddToCart(){return driver.findElement(By.cssSelector(".button-1[value='Add to cart']"));}

    public WebElement getLnkShoppingCart() {return driver.findElement(By.xpath("//span[contains(text(), 'Shopping cart')]"));}


    public WebElement getCbxIAgree() {return driver.findElement(By.cssSelector("#termsofservice"));}

    public WebElement getBtnCheckout() {return driver.findElement(By.cssSelector("#checkout"));}

    public WebElement getBtnCheckoutAsGuest() {return driver.findElement(By.cssSelector(".button-1[value='Checkout as Guest']"));}

    public WebElement getFirstName(){return driver.findElement(By.id("BillingNewAddress_FirstName"));}
    public WebElement getLastName(){return driver.findElement(By.id("BillingNewAddress_LastName"));}
    public WebElement getEmail(){return driver.findElement(By.id("BillingNewAddress_Email"));}
    public WebElement getCountry(){return driver.findElement(By.id("BillingNewAddress_CountryId"));}
    public WebElement getCity(){return driver.findElement(By.id("BillingNewAddress_City"));}
    public WebElement getStreet(){return driver.findElement(By.id("BillingNewAddress_Address1"));}
    public WebElement getZip(){return driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));}
    public WebElement getTel(){return driver.findElement(By.id("BillingNewAddress_PhoneNumber"));}
    public WebElement getBtnContinue1(){return driver.findElement(By.cssSelector("#opc-billing [value='Continue']"));}
    public WebElement getBtnContinue2(){return driver.findElement(By.cssSelector("#opc-shipping [value='Continue']"));}
    public WebElement getBtnContinue3(){return driver.findElement(By.cssSelector("#shipping-buttons-container [value='Continue']"));}
    public WebElement getBtnContinue4(){return driver.findElement(By.cssSelector("#shipping-method-buttons-container [value='Continue']"));}
    public WebElement getBtnContinue5(){return driver.findElement(By.cssSelector("#payment-method-buttons-container [value='Continue']"));}
    public WebElement getBtnContinue6(){return driver.findElement(By.xpath("//li[@id='opc-payment_info']//input"));}
    public WebElement getTitle(){return driver.findElement(By.xpath("html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong"));}
    public WebElement getBtnConfirm(){return driver.findElement(By.cssSelector("[value='Confirm']"));}
    ////div[@class='page checkout-page']//div[@class='title']/strong
    public WebElement getBtnContinue7(){return driver.findElement(By.cssSelector("[value='Continue']"));}

}
