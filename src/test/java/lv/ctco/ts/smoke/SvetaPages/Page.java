package lv.ctco.ts.smoke.SvetaPages;

import lv.ctco.ts.smoke.SvetaCommands.SeleniumWrapper;
import org.openqa.selenium.By;


public class Page {
        protected SeleniumWrapper browser;

        public Page(SeleniumWrapper browser){
            this. browser=browser;
        }

    public SearchPage search(String textSearch) {
        browser.type(By.xpath("//input[@id='small-searchterms']"), textSearch);
        browser.click(By.cssSelector(".search-box input[value='Search']"));
        return new SearchPage(browser);
    }

        public void closeBrowser(){
            browser.closeBrowser();
        }

    public ShoppingCartPage openShoppingCartPage() {
        browser.click(By.xpath("//li[@id='topcartlink']//span[@class='cart-label']"));
        return new ShoppingCartPage(browser);
    }

//        public String getUserEmail() {
//            String currentUserEmail = browser.getText(By.xpath("//div[@class='header-links']//a[@class='account']"));
//            return currentUserEmail;
//        }

    }

