package com.ml.demo.core.utils;

import com.cucumber.listener.Reporter;

public class Logger {

    private static ThreadLocal<Boolean> cucumberActive = new ThreadLocal<>();

    public static void setCucumberActive(Boolean isActive) {
        cucumberActive.set(isActive);
    }

    public static void log(String logText) {
        System.out.println(logText);

        if (cucumberActive.get()) {
            Reporter.addStepLog(logText);
        }
        else {
            org.testng.Reporter.log(logText);
        }
    }
}
