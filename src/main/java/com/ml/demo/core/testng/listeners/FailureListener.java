package com.ml.demo.core.testng.listeners;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.ml.demo.core.driver.DriverUtils;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;

public class FailureListener extends TestListenerAdapter {

    private static Table<String, String, Boolean> failedTests = HashBasedTable.create();

    @Override
    public void onTestFailure(ITestResult testResult) {

        // Get failed test data
        String testName = testResult.getTestClass().getRealClass().getSimpleName();
        String browser =  testResult.getTestContext().getCurrentXmlTest().getParameter("browser");

        // Save data about failed test to data table
        failedTests.put(testName, "CH", browser.equals("CH"));
        failedTests.put(testName, "FF", browser.equals("FF"));
        failedTests.put(testName, "IE", browser.equals("IE"));

        // Get screenshot when test fails
        DriverUtils.screenShot(testName);
    }

    // Skip current test if its condition test failed
    public static void skipTestIfIsFailed(String testName, String browser) throws SkipException {

        if(failedTests.containsRow(testName) && failedTests.get(testName, browser)) {
            throw new SkipException("Test is skipped because '" + testName + "' failed.");
        }
    }
}
