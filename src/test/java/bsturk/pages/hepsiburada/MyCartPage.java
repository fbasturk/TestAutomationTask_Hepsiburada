package bsturk.pages.hepsiburada;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static bsturk.tests.BaseTest.setTestErrorMessage;
import static bsturk.utils.AutomationProcess.*;
import static org.junit.Assert.assertEquals;

public class MyCartPage extends DriverFuncUtils {

    private int stepCount;

    String myCartLink = "https://www.hepsiburada.com/ayagina-gelsin/sepetim";

    // Son gezdiğiniz ürünler vb. listelerin element adresi
    By productContainer = By.cssSelector("div[class='product-container']");

    By productTitle = By.cssSelector("div[class='recommended-products-title']");
    By productListElement = By.cssSelector("li[class*='owl-item']");

    By productInfo = By.tagName("a");


    public MyCartPage(WebDriver driver, int stepStartCount) {
        super(driver);
        this.stepCount = stepStartCount;
    }

    public int getStepCount() {
        return this.stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public void checkOpenPage() {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking 'My Cart Page' visit");

        waitForPageLoad();

        setTestErrorMessage("Visited page is not 'My Cart Page'");
        assertEquals("Visited page is not 'My Cart Page'", myCartLink, getPageLink());
        stepCount++;
    }

    public void scrollProductArea() {
        WebTest_Automation_Task_Page_Func(stepCount, "Scrolling down to product area");

        try {
            ScrollJSElement(productContainer);
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"crolling down to product area", e.getMessage());

        }
        stepCount++;
    }


    public void checkItemsInMyCart(ArrayList<String> reviewedProduct, int productCount) {
        WebTest_Automation_Task_Page_Func(stepCount, "Checking is there a result for the product review");
        int reviewProductCount = 0;
        try {
            List<WebElement> productAreaList = waitForElementsBy(productContainer);

            for (WebElement productArea : productAreaList) {
                if (productArea.findElement(productTitle).getText().equals("Son gezdiğiniz ürünler")) {

                    List<WebElement> productList = productArea.findElements(productListElement);
                    for (WebElement product : productList) {
                        String productSku = getSkuInElement(product.findElement(productInfo));
                        for (String reviewedProductSku : reviewedProduct) {
                            if (reviewedProductSku.equals(productSku)) {
                                reviewProductCount++;
                            }
                        }
                    }
                    break;
                }
            }

        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Checking is there a result for the product review", e.getMessage());
        }

        setTestErrorMessage("The products examined does not match");
        assertEquals("The products examined does not match", productCount, reviewProductCount);
        stepCount++;
    }

    private String getSkuInElement(WebElement product) {
        String productInfo = product.getAttribute("data-hbus");
        JSONObject jsonBody = new JSONObject(productInfo);
        JSONObject data = jsonBody.getJSONObject("data");
        JSONObject properties = data.getJSONObject("properties");

        return properties.getString("productSku");
    }

}
