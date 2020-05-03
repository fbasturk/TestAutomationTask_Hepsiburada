package bsturk.tests;

import bsturk.Models.TestParameter;
import bsturk.pages.hepsiburada.HomePage;
import bsturk.pages.hepsiburada.LoginPage;
import bsturk.pages.hepsiburada.MyCartPage;
import bsturk.pages.hepsiburada.ProductPage;
import org.openqa.selenium.WebDriver;

import static bsturk.utils.AutomationProcess.*;
import static java.lang.Thread.sleep;

public class HepsiburadaTest {


    private WebDriver driver;
    private TestParameter testParameter;

    HepsiburadaTest(WebDriver driver, TestParameter testParameter) {
        WebTest_Automation_Task_Create_WebDriver(BaseTest.WebTest.HEPSIBURADA);
        this.driver = driver;
        this.testParameter = testParameter;
    }

    public void homePageTest() {
        WebTest_Automation_Task_Create_Page("HomePage", BaseTest.WebTest.HEPSIBURADA);
        HomePage homePage = new HomePage(driver, 1);

        homePage.goToPage();
        homePage.checkOpenPage();
        homePage.clickLogin();

        WebTest_Automation_Task_Finish_Page("HomePage", BaseTest.WebTest.HEPSIBURADA);
    }

    public void loginOperationsTest() {
        WebTest_Automation_Task_Create_Page("Login Operations", BaseTest.WebTest.HEPSIBURADA);
        LoginPage loginPage = new LoginPage(driver, 1);

        loginPage.checkOpenPage();
        loginPage.clickLoginRadioButton();
        loginPage.setUserEmail(testParameter.getEmail());
        loginPage.setUserPassword(testParameter.getPassword());
        loginPage.clickLogin();


        WebTest_Automation_Task_Finish_Page("Login Operations", BaseTest.WebTest.HEPSIBURADA);
    }

    public void productReviewTest(int productReviewCount) {
        WebTest_Automation_Task_Create_Page("Product Review", BaseTest.WebTest.HEPSIBURADA);
        HomePage homePage = new HomePage(driver, 1);

        homePage.checkOpenPage();
        homePage.checkLogin();


        for (int i = 0; i < productReviewCount; i++) {
            homePage.checkOpenPage();

            String productLink = homePage.selectItem(i);

            ProductPage productPage = new ProductPage(driver, homePage.getStepCount());
            productPage.checkOpenPage(productLink);
            String productID = productPage.getProductInfo();
            testParameter.addSearchItem(productID);
            productPage.clickHomePage();
            homePage.setStepCount(productPage.getStepCount());
        }


        WebTest_Automation_Task_Finish_Page("Product Review", BaseTest.WebTest.HEPSIBURADA);
    }

    public void checkProductInMyCart() {
        WebTest_Automation_Task_Create_Page("Check Product In My Cart", BaseTest.WebTest.HEPSIBURADA);
        HomePage homePage = new HomePage(driver, 1);

        homePage.checkOpenPage();
        homePage.clickMyCart();

        MyCartPage myCartPage = new MyCartPage(driver, homePage.getStepCount());
        myCartPage.checkOpenPage();
        myCartPage.scrollProductArea();
        myCartPage.checkItemsInMyCart(testParameter.getProductList(), testParameter.getProductCount());


        WebTest_Automation_Task_Finish_Page("Check Product In My Cart", BaseTest.WebTest.HEPSIBURADA);
    }

}
