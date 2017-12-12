package com.ml.demo.core.driver;

import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    // Create new WebDriver instance
    public static WebDriver createInstance(Browser browser) throws Exception {
        MutableCapabilities browserOptions;

        switch (browser) {
            case Chrome:
                browserOptions = new ChromeOptions();
                break;
            case Firefox:
                browserOptions = new FirefoxOptions();
                break;
            case InternetExplorer:
                browserOptions = new InternetExplorerOptions();
                break;
            default:
                throw new Exception("Invalid browser option.");
        }

        ImmutableCapabilities capabilities = new ImmutableCapabilities(browserOptions);
        return new RemoteWebDriver(capabilities);
    }

    // Close WebDriver instance
    public static void closeInstance() {
        Driver.getInstance().quit();
    }
}
