package bsturk.tests;

import bsturk.Models.TestParameter;
import bsturk.utils.CreateDriverUtil;
import org.junit.*;
import bsturk.utils.AutomationProcess;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import java.util.Date;

import static bsturk.utils.AutomationProcess.*;
import static bsturk.utils.DriverFuncUtils.getScreenshot;

public class BaseTest {
    public enum WebTest {

        HEPSIBURADA("Hepsiburada");

        private String testName;

        WebTest(String testName) {
            this.testName = testName;
        }

        public String getTestName() {
            return testName;
        }
    }

    private static WebDriver driver;
    private static long startTime;
    private static String webDriverTypeName;
    private static WebTest webTest;
    private static String TestErrorMessage;
    private static Date date;

    @Before
    public void baseTest() {
        AutomationProcess.WebTest_Automation_Task_Start();
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            getScreenshot(driver, webTest, TestErrorMessage);
        }
    };

    public static void setTestErrorMessage(String message) {
        TestErrorMessage = message;
    }

    public static Date getTime(){
        return date;
    }

    @Test
    public void webTest() {
        TestParameter testParameter = new TestParameter();
        testParameter.setBrowser(CreateDriverUtil.WebDriverType.CHROME);
        testParameter.setEmail("furkan.testautomation@gmail.com");
        testParameter.setPassword("12345678f");
        testParameter.setProductCount(3);

        date = new Date(System.currentTimeMillis());

        WebTest_Automation_Task_Start_Browser(testParameter.getBrowser().getDriverName());
        driver = CreateDriverUtil.CreateDriver(testParameter.getBrowser());
        driver.manage().window().maximize();
        webDriverTypeName = testParameter.getBrowser().getDriverName();
        startTime = System.currentTimeMillis();
        hepsiburadaTestFunc(driver, testParameter);
    }

    private void hepsiburadaTestFunc(WebDriver driver, TestParameter testParameter) {
        webTest = WebTest.HEPSIBURADA;

        WebTest_Automation_Task_Start_Test(webDriverTypeName, WebTest.HEPSIBURADA);

        HepsiburadaTest hepsiburadaTest = new HepsiburadaTest(driver, testParameter);

        WebTest_Automation_Task_TestStart(WebTest.HEPSIBURADA);

        WebTest_Automation_Task_Test(1, "HomePage", WebTest.HEPSIBURADA);
        hepsiburadaTest.homePageTest();

        WebTest_Automation_Task_Test(2, "Login Operations", WebTest.HEPSIBURADA);
        hepsiburadaTest.loginOperationsTest();

        WebTest_Automation_Task_Test(3, "Product Review", WebTest.HEPSIBURADA);
        hepsiburadaTest.productReviewTest(testParameter.getProductCount());

        WebTest_Automation_Task_Test(4, "Check Product In My Cart", WebTest.HEPSIBURADA);
        hepsiburadaTest.checkProductInMyCart();
    }

    @AfterClass()
    public static void tearDown() {
        if (driver != null)
            driver.quit();

        long testTime = System.currentTimeMillis() - startTime;
        WebTest_Automation_Task_Finish_Browser(testTime, webDriverTypeName);
    }

}
