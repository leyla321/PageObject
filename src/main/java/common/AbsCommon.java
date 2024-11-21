package common;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;


public abstract class AbsCommon {

    protected WebDriver driver;
    protected Faker faker;
    protected Waiters waiters;
    protected Actions actions;

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        this.faker = new Faker();
        this.waiters = new Waiters(driver);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }
}
