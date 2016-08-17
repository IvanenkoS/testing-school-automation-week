package lv.ctco.ts.smoke.SvetaPages;


import lv.ctco.ts.smoke.SvetaCommands.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends Page {

     public SearchPage(SeleniumWrapper browser) {
            super(browser);
        }

    public SearchPage search(String textSearch) {
        browser.type(By.xpath("//input[@id='small-searchterms']"), textSearch);
        browser.click(By.cssSelector(".search-box input[value='Search']"));
        return new SearchPage(browser);
    }

    public SearchPage addToCartFirstItem() {
        browser.click(By.xpath("//div[@class='search-results']//input[@value='Add to cart']"));
        browser.waitForElementInvisibility(By.cssSelector(".ajax-loading-block-window"));
       return this;
    }

}
