package com.ml.demo.core.testng.listeners;

import com.ml.demo.core.utils.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class FailureListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult testResult) {
       String testName = testResult.getTestClass().getRealClass().getName();
        Logger.log("Test '" + testName + "' has failed.");
    }
}
