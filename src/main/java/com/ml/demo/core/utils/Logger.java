package com.ml.demo.core.utils;

import com.cucumber.listener.Reporter;

public class Logger {

    public static void log(String logText) {
        System.out.println(logText);
        Reporter.addStepLog(logText);
    }
}
