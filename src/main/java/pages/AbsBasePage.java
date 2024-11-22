package pages;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class AbsBasePage extends AbsCommon {
    private String BASE_URL = System.getProperty("base.url").endsWith("/") ? System.getProperty("base.url")
            .replaceAll("/$", "") : System.getProperty("base.url");

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public AbsBasePage open() {
        BASE_URL = BASE_URL.endsWith("/") ? BASE_URL.substring(0, BASE_URL.length() - 1) : BASE_URL;
        driver.get(BASE_URL);

        return this;
    }

    protected void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected void waitForElementToBeClickable(By locator) {
        waiters.waitForCondition(ExpectedConditions.elementToBeClickable(locator));
    }
}
