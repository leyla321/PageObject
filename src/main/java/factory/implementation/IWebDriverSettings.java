package factory.implementation;

import org.openqa.selenium.remote.AbstractDriverOptions;

public interface IWebDriverSettings {

    String isBrowserMode = System.getProperty("mode", "fullscreen");

    AbstractDriverOptions settings();
}
