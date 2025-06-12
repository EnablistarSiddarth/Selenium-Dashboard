package com.enablistar.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.enablistar.constants.FrameworkConstants;

public class ExtendReports {

    private ExtendReports() {
    }

    public static ExtentReports extent;
    public static ExtentTest extentTest;


    public static void initReports() {
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.ReportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }


    public static void createTest(String testCaseName) {
        extentTest = extent.createTest(testCaseName);
        ExtendManager.setExtentTest(extentTest);
    }


    public static void flushReports() {
        extent.flush();
    }
}