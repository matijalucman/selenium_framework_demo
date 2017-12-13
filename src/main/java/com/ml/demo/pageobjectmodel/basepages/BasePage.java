package com.ml.demo.pageobjectmodel.basepages;

import com.ml.demo.core.driver.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    // Get new instance of WebDriverWait class
    protected WebDriverWait getWebDriverWaitInstance(int numberOfSeconds) {
        return new WebDriverWait(Driver.getInstance(), numberOfSeconds);
    }
}
