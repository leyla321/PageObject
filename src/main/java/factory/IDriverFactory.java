package factory;

import exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
    WebDriver getDriver() throws DriverNotFoundException;
}
