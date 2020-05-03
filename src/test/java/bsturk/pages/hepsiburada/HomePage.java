package bsturk.pages.hepsiburada;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static bsturk.tests.BaseTest.setTestErrorMessage;
import static bsturk.utils.AutomationProcess.*;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class HomePage extends DriverFuncUtils {
    private int stepCount;
    private String homePageLink = "https://www.hepsiburada.com/";

    // Login butonu element adresini tanımlama
    By myAccountButton = By.id("myAccount");
    By loginButton = By.id("login");

    // Hesabım yazısı elementin adresini tanımlama
    By myAccountTitle = By.cssSelector("span[class='OldMyAccount-PhY-T']");

    // Ürün listeleri yer alan bölüm
    By productArea = By.cssSelector("div[class='Explore-2rsL9']");
    By product = By.tagName("a");

    // Sepetim butonu elemenet adresini tanımlama
    By myCartButton = By.cssSelector("a[class='OldMyAccount-2OvEz OldMyAccount-3TYPj']");


    public HomePage(WebDriver driver, int stepStartCount) {
        super(driver);
        this.stepCount = stepStartCount;
    }

    public int getStepCount() {
        return this.stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public void goToPage() {
        WebTest_Automation_Task_Page_Func(stepCount, "Visiting 'Homepage'");
        try {
            GoPage(homePageLink);
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"'Homepage' visiting", e.getMessage());
        }
        stepCount++;
    }

    public void checkOpenPage() {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking 'Homepage' visit");

        waitForPageLoad();

        setTestErrorMessage("Visited page is not 'Homepage'");
        assertEquals("Visited page is not 'Homepage'", homePageLink, getPageLink());
        stepCount++;
    }

    public void clickLogin() {
        WebTest_Automation_Task_Page_Func(stepCount, "Clicking the 'Login' button");

        try {
            hoverToElement(myAccountButton);
            waitForElementBy(loginButton).click();
            //   hoverToClickElement(myAccountButton, loginButton);
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Clicking the 'Login' button", e.getMessage());

        }
        stepCount++;
    }

    public void checkLogin() {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking Login");
        boolean isLogin = false;
        try {
            sleep(1000);
            String accountInfo = waitForElementBy(myAccountButton).findElement(myAccountTitle).getText();
            if (!accountInfo.equals("Hesabım")) {
                refreshPage();
                sleep(1000);
                if (waitForElementBy(myAccountButton).findElement(myAccountTitle).getText().equals("Hesabım"))
                    isLogin = true;
            } else {
                isLogin = true;
            }
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Checking Login", e.getMessage());
        }


        setTestErrorMessage("No login");
        assertTrue("No login", isLogin);
        stepCount++;
    }


    public String selectItem(int categoryIndex) {
        WebTest_Automation_Task_Page_Func(stepCount, "The given item is selecting");

        String productLink = null;
        try {

            List<WebElement> productAreaList = waitForElementsBy(productArea);
            List<WebElement> productList = productAreaList.get(categoryIndex).findElements(product);

            productLink = productList.get(0).getAttribute("href");
            productList.get(0).click();

        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"The given item is selecting", e.getMessage());

        }
        setTestErrorMessage("Item could not be selected");
        assertNotEquals("Item could not be selected", null, productLink);
        stepCount++;
        return productLink;
    }


    public void clickMyCart() {
        WebTest_Automation_Task_Page_Func(stepCount, "Clicking the 'MyCart' button");

        try {
            waitForElementBy(myCartButton).click();
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Clicking the 'MyCart' button", e.getMessage());

        }
        stepCount++;
    }


}
