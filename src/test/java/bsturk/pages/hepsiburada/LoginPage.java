package bsturk.pages.hepsiburada;

import bsturk.tests.BaseTest;
import bsturk.utils.DriverFuncUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static bsturk.tests.BaseTest.setTestErrorMessage;
import static bsturk.utils.AutomationProcess.WebTest_Automation_Task_Page_Func;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class LoginPage extends DriverFuncUtils {
    private String loginPageLink = "https://www.hepsiburada.com/uyelik/giris?ReturnUrl=%2F";

    private int stepCount;


    By loginRadioButton = By.cssSelector("label[for='select-login']");

    // Mail ve şifre alanının element adresini tanımlama
    By emailArea = By.id("email");
    By passwordArea = By.id("password");

    // Login butonunun element adresini tanımlama
    By loginButton = By.cssSelector("button[class='btn full btn-login-submit']");

    public LoginPage(WebDriver driver, int stepStartCount) {
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
        WebTest_Automation_Task_Page_Func(stepCount, "Checking 'Login Page' visit");

        waitForPageLoad();

        setTestErrorMessage("Visited page is not 'Login Page'");
        assertEquals("Visited page is not 'Login Page'", loginPageLink, getPageLink());
        stepCount++;
    }


    public void clickLoginRadioButton() {
        WebTest_Automation_Task_Page_Func(stepCount,"Clicking the 'Login' radio button");

        try {
            waitForElementBy(loginRadioButton).click();
            //   hoverToClickElement(myAccountButton, loginButton);
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Clicking the 'Login' radio button", e.getMessage());

        }
        stepCount++;
    }

    public void setUserEmail(String email) {
        WebTest_Automation_Task_Page_Func(stepCount, "Email address is writing to email area");

        try {
            waitForElementBy(emailArea).clear();
            waitForElementBy(emailArea).sendKeys(email);

        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Email address is writing to email area", e.getMessage());

        }
        stepCount++;
    }

    public void setUserPassword(String password) {
        WebTest_Automation_Task_Page_Func(stepCount, "Password is writing to password area");

        try {
            waitForElementBy(passwordArea).clear();
            waitForElementBy(passwordArea).sendKeys(password);

        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Password is writing to password area", e.getMessage());

        }
        stepCount++;
    }

    public void clickLogin() {
        WebTest_Automation_Task_Page_Func(stepCount, "Clicking the 'Login' button");

        try {
            waitForElementBy(loginButton).click();
            sleep(1000);
        } catch (Exception e) {
            errorMessage(BaseTest.WebTest.HEPSIBURADA,"Clicking the 'Login' button", e.getMessage());

        }
        stepCount++;
    }
}
