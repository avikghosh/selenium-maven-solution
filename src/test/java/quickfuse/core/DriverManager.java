package quickfuse.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            setDriver();
        }
        return driver;
    }


    private static void setDriver() {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--start-maximized");
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(desiredCapabilities);
    }

    public static String getChromeDriverPath() {
        return TestGlobals.chromedriverPath;
    }

    public static void tearDownDriver() {
        driver.quit();
        driver = null;
    }
}
