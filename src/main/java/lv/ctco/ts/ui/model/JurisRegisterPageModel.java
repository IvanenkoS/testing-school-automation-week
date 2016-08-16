package lv.ctco.ts.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by yuris.vencels on 8/16/2016.
 */
public class JurisRegisterPageModel {

    private WebDriver driver;

    public JurisRegisterPageModel(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getBtnRegister() {
        return driver.findElement(By.xpath("//a[@class='ico-register']"));
    }

    public WebElement getInpFieldByID(String nameID) {
        return driver.findElement(By.id(nameID));
    }

    public WebElement getTxtSuccessResult() {
        return driver.findElement(By.xpath("//div[@class='result']"));
    }

}
