package com.enablistar.tests;

import com.beust.jcommander.Parameters;
import com.enablistar.Reports.ExtendReports;
import com.enablistar.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void startReport() {
        ExtendReports.initReports();  // ✅ MUST initialize the ExtentReports instance
    }


    @BeforeMethod
    public void setup(Method method) throws IOException {
        ExtendReports.createTest(method.getName());
        Driver.initDriver();

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.quit();
    }

    @AfterSuite
    public void endReport() {
        ExtendReports.flushReports();  // ✅ Write all logs to the report file
    }

}
