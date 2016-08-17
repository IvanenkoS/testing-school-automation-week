package lv.ctco.ts.smoke.SvetaPages;

import lv.ctco.ts.smoke.SvetaCommands.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends Page {

    public ShoppingCartPage(SeleniumWrapper browser) {
        super(browser);
    }

    public void checkout() {
        browser.click(By.cssSelector("#termsofservice"));
        browser.click(By.cssSelector("#checkout"));
    }

    public void checkoutPage(String userCountry, String userCity, String userAddress1, String  userZipPostalCode, String userPhoneNumber) {
        new Select(browser.select(By.id("BillingNewAddress_CountryId"))).selectByVisibleText(userCountry);
        browser.type(By.id("BillingNewAddress_City"), userCity);
        browser.type(By.id("BillingNewAddress_Address1"), userAddress1);
        browser.type(By.id("BillingNewAddress_ZipPostalCode"), userZipPostalCode);
        browser.type(By.id("BillingNewAddress_PhoneNumber"), userPhoneNumber);

        browser.click(By.cssSelector("#opc-billing [title='Continue']"));
        browser.waitForElementInvisibility(By.cssSelector("#billing-please-wait"));

        browser.click(By.cssSelector("#opc-shipping [title='Continue']"));
        browser.waitForElementInvisibility(By.cssSelector("#shipping-please-wait"));

        browser.click(By.cssSelector("#opc-shipping_method [value='Continue']"));
        browser.waitForElementInvisibility(By.cssSelector("#shipping-method-please-wait"));

        browser.click(By.cssSelector("#payment-method-buttons-container [value='Continue']"));
        browser.waitForElementInvisibility(By.cssSelector("#payment-method-please-wait"));

        browser.click(By.cssSelector("#opc-payment_info [value='Continue']"));
        browser.waitForElementInvisibility(By.cssSelector("#payment-info-please-wait"));

        browser.click(By.cssSelector("#opc-confirm_order [value='Confirm']"));
        browser.waitForElementInvisibility(By.cssSelector("#confirm-order-please-wait"));
    }

    public String getTitle(){
        return browser.getText(By.cssSelector(".title"));
    }

    public void checkoutPage1() {
        browser.click(By.cssSelector("[value='Continue']"));
    }
}
