package factory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver getDriver(String driverName, boolean maximize, boolean implicitWait, boolean incognito, boolean headless) {
        driverName = driverName.toUpperCase();
        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        switch (driverName) {
            case "FIREFOX":
                firefoxOptions.setCapability("marionette", true);
                if(incognito){
                    firefoxOptions.addArguments("-private");
                }
                if(headless){
                    firefoxOptions.setHeadless(true);
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "CHROME":
                if (headless){
                    chromeOptions.setHeadless(true);
                }
                if(incognito){
                    chromeOptions.addArguments("--incognito");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                driver = new ChromeDriver();
                break;
        }

        if(maximize) {
            driver.manage().window().maximize();
        }

        if(implicitWait) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}