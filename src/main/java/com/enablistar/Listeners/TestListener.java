package com.enablistar.Listeners;

import com.enablistar.Reports.ExtendLogger;
import com.enablistar.Reports.ExtendReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtendReports.createTest(result.getMethod().getDescription());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendLogger.pass(result.getName()+"is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtendLogger.fail(result.getName()+" is failed");
        ExtendLogger.fail(result.getThrowable().getMessage());
        ExtendLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }
    @Override
    public void onStart(ITestContext context) {
        ExtendReports.initReports();
    }
    @Override
    public void onFinish(ITestContext context) {
        ExtendReports.flushReports();
    }
}
