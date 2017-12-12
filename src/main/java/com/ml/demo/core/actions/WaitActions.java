package com.ml.demo.core.actions;

import com.ml.demo.core.driver.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions {

    // Get new instance of WebDriverWait class
    public static WebDriverWait getWebDriverWaitInstance(int numberOfSeconds) {
        return new WebDriverWait(Driver.getInstance(), numberOfSeconds);
    }
}
