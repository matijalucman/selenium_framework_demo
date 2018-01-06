package com.ml.demo.core.driver;

import com.ml.demo.core.utils.DateHelper;
import com.ml.demo.core.utils.Logger;
import com.vimalselvam.testng.listener.ExtentTestNgFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class DriverUtils {

    /* resolve browser name from driver instance */
    public static String resolveDriverName() {

        try {
            String driverName = Driver.getInstance().toString();

            if (driverName.contains("chrome")) {
                return Browser.CH.name();
            }

            else if (driverName.contains("firefox")) {
                return Browser.CH.name();
            }

            else if (driverName.contains("internet explorer")) {
                return Browser.CH.name();
            }

            else return "unknownBrowser";
        }
        catch (Exception e) {
            Logger.log("Exception caught while resolving driver name. " + e);
            return "unknownBrowser";
        }
    }

    public static void screenShot(String testName) {
        try {
            String browserName = resolveDriverName();
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            String timeStamp = DateHelper.getCurrentDateTime("dd_MM_yyyy__hh_mm_ssaa").asString();
            String screenshotFilePath = "C:\\AutoTests\\portal_autotests\\build\\" +
                    "reports\\tests\\runTests\\screenshots\\" + testName + "_" + browserName + "_" + timeStamp + ".png";

            // Take screenshot and save it to .png file
            File screenshotFile = new File(screenshotFilePath);
            File tempScreenshotFile = ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(tempScreenshotFile, screenshotFile);

            // Add screenshot to report
            ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(screenshotFilePath);
        }
        catch (IOException e) {
            Logger.log(e.toString());
        }
    }
}
