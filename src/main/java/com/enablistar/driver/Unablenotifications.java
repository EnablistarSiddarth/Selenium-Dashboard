package com.enablistar.driver;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Arrays;

public class Unablenotifications {

    public static ChromeOptions UnableBrowserNameChrome(){
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // Important
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
       // options.addArguments("--no-sandbox");
       // options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-web-security"); // Use cautiously
        options.addArguments("--disable-site-isolation-trials");
        options.addArguments("--start-maximized");
        return options;
    }


    public static void UnableBrowserNameSafari() throws IOException {
        Runtime.getRuntime().exec("osascript -e 'tell application \"System Events\" to click button \"Don’t Allow\" of window 1 of application process \"Safari\"'");
    }



}
