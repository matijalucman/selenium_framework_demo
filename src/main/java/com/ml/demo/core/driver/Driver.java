package com.ml.demo.core.driver;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    public static WebDriver getInstance() {
        return driverInstance.get();
    }

    public static void setInstance(WebDriver driver) {
        driverInstance.set(driver);
    }
}
