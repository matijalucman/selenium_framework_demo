package com.ml.demo.core.actions;

import com.ml.demo.core.utils.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

    public static void setText(WebElement element, String text) {
        Logger.log("Writing text '" + text + "' to element '" + element + "'.");

        WebDriverWait wait = WaitActions.getWebDriverWaitInstance(30);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);

        Logger.log("Text '" + text + "' is written to element '" + element + "'.");
    }
}
