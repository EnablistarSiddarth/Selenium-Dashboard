package com.enablistar.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;


public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(String browsername) throws IOException {
        WebDriver driver;
        if (browsername.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions op= Unablenotifications.UnableBrowserNameChrome();
            driver = new ChromeDriver(op);

        }
        else if
        (browsername.equalsIgnoreCase("safari"))
        {
            WebDriverManager.safaridriver().setup();
            Unablenotifications.UnableBrowserNameSafari();
            driver = new SafariDriver();
        }else
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        return driver;
    }

}
