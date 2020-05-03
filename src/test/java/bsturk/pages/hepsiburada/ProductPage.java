package bsturk.pages.hepsiburada;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static bsturk.tests.BaseTest.setTestErrorMessage;
import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Create_Page;
import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Page_Func;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductPage extends DriverFuncUtils {

    private int stepCount;

    // Sepete ekle butonunun elemet adresini tanımlama
    By addToCardButton = By.cssSelector("button[id='addToCart']");

    // HomePage link element adresini tanımlama
    By homePageButton = By.cssSelector("a[title='Hepsiburada']");


    public ProductPage(WebDriver driver, int stepStartCount) {
        super(driver);
        this.stepCount = stepStartCount;
    }

    public int getStepCount() {
        return this.stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public void checkOpenPage(String productLink) {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking 'Product Page' visit");

        waitForPageLoad();

        setTestErrorMessage("Visited page is not 'Product Page'");
        assertEquals("Visited page is not 'Product Page'", productLink, getPageLink());
        stepCount++;
    }


    public String getProductInfo() {
        WebTest_Automation_Task_Page_Func(stepCount, "Getting product information");

        String result= null;
        try {

            result=  waitForElementBy(addToCardButton).getAttribute("data-sku");
            System.out.println("DATA-SKU:"+result);
            //   hoverToClickElement(myAccountButton, loginButton);
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Getting product information", e.getMessage());

        }

        setTestErrorMessage("Product information could not be retrieved");
        assertNotEquals("Product information could not be retrieved", null, result);
        stepCount++;
        return result;
    }

    public void clickHomePage() {
        WebTest_Automation_Task_Page_Func(stepCount, "Clicking the 'HomePage' button");

        try {
            waitForElementBy(homePageButton).click();
            //   hoverToClickElement(myAccountButton, loginButton);
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Clicking the 'HomePage' button", e.getMessage());

        }
        stepCount++;
    }
}
