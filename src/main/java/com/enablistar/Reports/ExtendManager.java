package com.enablistar.Reports;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static com.enablistar.Reports.ExtendReports.extent;

public class ExtendManager {
    private ExtendManager() {
    }

    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    static void setExtentTest(ExtentTest test) {
        threadLocal.set(test);
    }

    static ExtentTest getExtentTest() {
        return threadLocal.get();
    }


}
