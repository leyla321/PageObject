package factory;

import data.BrowserData;
import exceptions.DriverNotFoundException;
import factory.implementation.ChromeSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;
import java.util.Locale;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class WebDriverFactory implements IDriverFactory {

    private static String browserName = System.getProperty("browser.name", "chrome");
    private final static Logger logger = LogManager.getLogManager().getLogger(String.valueOf(WebDriverFactory.class));
    private final String remoteGridURL = System.getProperty("gridUrl", "http://193.104.57.173/wd/hub");

    public static WebDriver create() throws DriverNotFoundException, MalformedURLException {
        BrowserData browserData = BrowserData.valueOf(browserName.toUpperCase(Locale.ROOT));
        switch (browserData) {
            case CHROME: {
                return new ChromeDriver((ChromeOptions) new ChromeSettings().settings());
            }
            case FIREFOX: {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            }
            case REMOTE: {
                RemoteSetting remoteSetting = new RemoteSetting();
                return remoteSetting.configurationRemoteWebDriver();
            }
            default:
                throw new DriverNotFoundException(browserName);
        }
    }

    public WebDriver getDriver() throws DriverNotFoundException {
        return null;
    }
}
