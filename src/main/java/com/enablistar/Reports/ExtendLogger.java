package com.enablistar.Reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.enablistar.utils.ScreenshotUtils;

public final class ExtendLogger {

    private ExtendLogger() {
    }

    public static void pass(String message) {
        ExtendManager.getExtentTest().pass(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }

    public static void fail(String message) {
        ExtendManager.getExtentTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }

    public static void info(String message) {
        ExtendManager.getExtentTest().info(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }

}
