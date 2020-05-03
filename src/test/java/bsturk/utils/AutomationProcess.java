package bsturk.utils;

import bsturk.tests.BaseTest;

public class AutomationProcess {

    //// 1. Adım
    public static void WebTest_Automation_Task_Start() {
        LogUtil.info("1- Hepisburada's web test scenario begins.");
    }

    ///// 2. Adım
    public static void WebTest_Automation_Task_Start_Browser(String driverName) {
        LogUtil.info("2- Browser Name: " + driverName + " is getting ready to run.");
    }

    //// 3. Adım
    public static void WebTest_Automation_Task_Start_Test(String driverName, BaseTest.WebTest webSite) {
        LogUtil.info("3- Browser Name: " + driverName + ": " + webSite.getTestName() + " tests started.");
    }

    //// 4. Adım
    public static void WebTest_Automation_Task_Create_WebDriver(BaseTest.WebTest webSite) {
        LogUtil.info("4- WebDriver created for " + webSite.getTestName() + " Tests\n");
    }

    //// 5. Adım
    public static void WebTest_Automation_Task_TestStart(BaseTest.WebTest webSite) {
        LogUtil.info("5- Starting test scenarios in " + webSite.getTestName() + " Tests");
    }

    //// 5. Adım
    public static void WebTest_Automation_Task_Test(int index, String testPage, BaseTest.WebTest webSite) {
        LogUtil.info(" \t5." + index + "- " + testPage + " test scenario in " + webSite.getTestName() + " Tests");
    }

    //// Sayfaları oluşturma adımları
    public static void WebTest_Automation_Task_Create_Page(String testPage, BaseTest.WebTest webSite) {
        LogUtil.info(" \t\t" + testPage + " test created for " + webSite.getTestName() + " Tests");
    }

    public static void WebTest_Automation_Task_Finish_Page(String testPage, BaseTest.WebTest webSite) {
        LogUtil.info(" \t\t" + testPage + " test completed for " + webSite.getTestName() + " Tests\n");
    }

    //// Sayfalarda yapılan işlemlerin adımları
    public static void WebTest_Automation_Task_Page_Func(int stepCount, String funcMessage) {
        LogUtil.info(" \t\t\t " + stepCount + ". Step: " + funcMessage);
    }

    //// 6. Adım
    public static void WebTest_Automation_Task_Finish_Browser(long testTime, String driverName) {
        LogUtil.info("6- Test Complete Time:" + testTime + ", Browser Name: " + driverName + " is closed\n\n");
    }

}
