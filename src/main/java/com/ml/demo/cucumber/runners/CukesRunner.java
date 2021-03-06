package com.ml.demo.cucumber.runners;

import com.ml.demo.core.driver.Browser;
import com.ml.demo.core.driver.Driver;
import com.ml.demo.core.driver.DriverFactory;
import com.ml.demo.core.utils.Logger;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/main/resources",
        glue = "com.ml.demo.cucumber",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:build/reports/tests/runTests/detailedReport.html"}
)
public class CukesRunner extends AbstractTestNGCucumberTests {
    @BeforeMethod(alwaysRun = true)
    public void setUpWebDriver(ITestContext context) throws Exception {
        Logger.setCucumberActive(true);
        String browser = context.getCurrentXmlTest().getParameter("browser");
        WebDriver driver = DriverFactory.createInstance(Browser.valueOf(browser));
        Driver.setInstance(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebDriver() {
        DriverFactory.closeInstance();
    }
}
