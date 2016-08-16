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
        return driver.findElement(By.cssSelector(".search-box input[value='Search']"));
    }

    public WebElement getLnkProduct() {
        return driver.findElement(By.cssSelector(".product-item .product-title a"));
    }

    public WebElement btnAddToCart() {
        return driver.findElement(By.xpath("//input[@value='Add to cart']"));
    }

    public WebElement getShoppingCart() {
        return driver.findElement(By.cssSelector(".ico-cart .cart-label"));
    }
}
