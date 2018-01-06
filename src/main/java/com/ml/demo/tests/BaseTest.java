package com.ml.demo.tests;

import com.ml.demo.core.driver.Browser;
import com.ml.demo.core.driver.Driver;
import com.ml.demo.core.driver.DriverFactory;
import com.ml.demo.core.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpWebDriver(ITestContext context) throws Exception {
        Logger.setCucumberActive(false);
        String browser = context.getCurrentXmlTest().getParameter("browser");
        WebDriver driver = DriverFactory.createInstance(Browser.valueOf(browser));
        Driver.setInstance(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebDriver() {
        DriverFactory.closeInstance();
    }
}
