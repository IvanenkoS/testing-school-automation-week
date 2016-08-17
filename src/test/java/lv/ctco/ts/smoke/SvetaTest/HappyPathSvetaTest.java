package lv.ctco.ts.smoke.SvetaTest;

import lv.ctco.ts.smoke.SvetaCommands.SeleniumWrapper;
import lv.ctco.ts.smoke.SvetaPages.ShoppingCartPage;
import lv.ctco.ts.smoke.SvetaPages.HomePage;
import lv.ctco.ts.smoke.SvetaPages.RegisterPage;
import lv.ctco.ts.smoke.SvetaPages.SearchPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

public class HappyPathSvetaTest {

        public HomePage homePage;
        public RegisterPage registerPage;
        public SearchPage searchPage;
//        public ShoppingCartPage shoppingCartPage;

    @Before
        public void setUp() {
            System.out.println("HappyPathTest");
            SeleniumWrapper browser = new SeleniumWrapper();
            homePage = new HomePage(browser);
        }

    @Test
        public void registerTest() {

            Random rn = new Random();
            int i = rn.nextInt(9999);

            registerPage = homePage.openRegisterPage();
            registerPage.register("Angelina"+i, "Jolie"+i, "Jolie"+i+"@gmail.com", "jolie123");

            String actualResultUserEmail = homePage.getUserEmail();
            String expectResultUserEmail = ("Jolie"+i+"@gmail.com");
            Assert.assertEquals(actualResultUserEmail, expectResultUserEmail);
        }
    @Test
    public void searchTest() {

        searchPage = homePage.search("blue and green");
        searchPage.addToCartFirstItem();
        ShoppingCartPage shoppingCartPage=searchPage.openShoppingCartPage();

//        registerPage.register("Angelina"+i, "Jolie"+i, "Jolie"+i+"@gmail.com", "jolie123");
//
//        String actualResultUserEmail = homePage.getUserEmail();
//        String expectResultUserEmail = ("Jolie"+i+"@gmail.com");
//        Assert.assertEquals(actualResultUserEmail, expectResultUserEmail);
    }

    @After
        public void turnDown() {
            homePage.closeBrowser();
        }
}


