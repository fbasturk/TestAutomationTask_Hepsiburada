package bsturk.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class CreateDriverUtil {

    public enum WebDriverType {

        CHROME("CHROME", "webdriver.chrome.driver", "src/test/resources/chromedriver.exe"),
        FIREFOX("FIREFOX", "webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        private String driverName, systemKey, systemValue;

        private WebDriverType(String driverName, String systemKey, String systemValue) {
            this.driverName = driverName;
            this.systemKey = systemKey;
            this.systemValue = systemValue;
        }

        public String getDriverName() {
            return driverName;
        }

        public String getSystemKey() {
            return systemKey;
        }

        public String getSystemValue() {
            return systemValue;
        }
    }


    public static WebDriver CreateDriver(WebDriverType webDriverType) {
        System.setProperty(webDriverType.getSystemKey(), webDriverType.getSystemValue());

        WebDriver driver;
        switch (webDriverType.getDriverName()) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--user-agent=Mozilla/5.0 (WghrXkuMnF) AppleWebKit/5.0 Chrome/8.0 Safari/5.0");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                FirefoxProfile profile = new FirefoxProfile();
                profile.setAcceptUntrustedCertificates(true);
                profile.setAssumeUntrustedCertificateIssuer(false);
                profile.setPreference("network.proxy.type", 0);
                profile.setPreference("general.useragent.override", "Mozilla/5.0 (WghrXkuMnF) AppleWebKit/5.0 Chrome/8.0 Safari/5.0");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);

                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverType.getDriverName());
        }

        return driver;
    }
}
