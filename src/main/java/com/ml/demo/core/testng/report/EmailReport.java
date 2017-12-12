package com.ml.demo.core.testng.report;

import com.ml.demo.core.utils.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

public class EmailReport implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        Logger.log("Test execution is done.");
    }
}
