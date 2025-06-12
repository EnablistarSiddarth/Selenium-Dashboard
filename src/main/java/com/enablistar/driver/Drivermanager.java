package com.enablistar.driver;

import org.openqa.selenium.WebDriver;

public class Drivermanager {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadLocal.get();
    }
    public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }
}
