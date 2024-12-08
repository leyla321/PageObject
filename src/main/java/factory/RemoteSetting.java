package factory;

import factory.implementation.IWebDriverSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;

public class RemoteSetting implements IWebDriverSettings {

    private final static Logger logger = Logger.getLogger(RemoteSetting.class.getName());
    private static String browserName = System.getProperty("browser.name", "chrome");
    private static final String browserVersion = System.getProperty("browser.version", "124.0");
    private String remoteGridURL = System.getProperty("remote.url", "http://193.104.57.173/wd/hub");

    @Override
    public ChromeOptions settings() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setCapability("browserName", browserName);
        chromeOptions.setCapability("browserVersion", browserVersion);

        chromeOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "run remote web driver");
            put("sessionTimeout", "15m");
            put("env", new String[]{"TZ=UTC"});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVideo", false);
        }});

        return chromeOptions;
    }

    public WebDriver configurationRemoteWebDriver() throws MalformedURLException {
        ChromeOptions chromeOptions = settings();

        WebDriver driver = new RemoteWebDriver(new URL(remoteGridURL), chromeOptions);

        logger.info("Initialized RemoteWebDriver with ChromeOptions for browser: " + browserName +
                ", version: " + browserVersion);
        return driver;
    }

}
