package lv.ctco.ts.smoke.SvetaTest;

import lv.ctco.ts.smoke.SvetaCommands.SeleniumWrapper;
import lv.ctco.ts.smoke.SvetaPages.ShoppingCartPage;
import lv.ctco.ts.smoke.SvetaPages.HomePage;
import lv.ctco.ts.smoke.SvetaPages.RegisterPage;
import lv.ctco.ts.smoke.SvetaPages.SearchPage;
import org.junit.*;
import java.util.Random;

public class HappyPathSvetaTest {

        public HomePage homePage;
        public RegisterPage registerPage;
        public SearchPage searchPage;
        public ShoppingCartPage shoppingCartPage;

    @Before
        public void setUp() {
            System.out.println("HappyPathTest");
            SeleniumWrapper browser = new SeleniumWrapper();
            homePage = new HomePage(browser);
        }

    @Test
        public void shoppingTest() {
            Random rn = new Random();
            int i = rn.nextInt(9999);

            registerPage = homePage.openRegisterPage();
            registerPage.register("Angelina"+i, "Jolie"+i, "Jolie"+i+"@gmail.com", "jolie123");

            String actualResultUserEmail = homePage.getUserEmail();
            String expectResultUserEmail = ("Jolie"+i+"@gmail.com");
            Assert.assertEquals(actualResultUserEmail, expectResultUserEmail);

            searchPage = homePage.search("Casual Golf Belt");
            searchPage.addToCartFirstItem();
            shoppingCartPage = searchPage.openShoppingCartPage();

            shoppingCartPage.checkout();

            shoppingCartPage.checkoutPage("Latvia", "Riga", "Test Street","LV-6789","23456789");

            Assert.assertEquals("Your order has been successfully processed!", shoppingCartPage.getTitle());
            shoppingCartPage.checkoutPage1();
        }

    @After
        public void turnDown() {
            homePage.closeBrowser();
    }
}


