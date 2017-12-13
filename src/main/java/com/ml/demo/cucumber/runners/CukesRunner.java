package com.ml.demo.cucumber.runners;

import com.ml.demo.core.driver.Browser;
import com.ml.demo.core.driver.Driver;
import com.ml.demo.core.driver.DriverFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/main/resources",
        glue = "com.ml.demo.cucumber",
        plugin = {"pretty", "html:target/cucumber-html-report"}
)
public class CukesRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod
    public void setUpWebDriver(ITestContext context) throws Exception {
        String browser = context.getCurrentXmlTest().getParameter("browser");
        WebDriver driver = DriverFactory.createInstance(Browser.valueOf(browser));
        Driver.setInstance(driver);
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterMethod
    public void closeWebDriver() {
        DriverFactory.closeInstance();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }
}
