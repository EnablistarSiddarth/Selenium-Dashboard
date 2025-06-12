package com.enablistar.utils;

import com.enablistar.Reports.ExtendLogger;
import com.enablistar.config.ConfigFactory;
import com.enablistar.driver.Drivermanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    public static void click(By by,String elementName) throws InterruptedException {
        WebElement element= waitUntilYourElementPresent(by);
        element.click();
        ExtendLogger.pass(elementName+ " is clicked");
    }

    public static void sendkeys(By by, String value,String elementName){
        WebElement element= waitUntilYourElementPresent(by);
        element.sendKeys(value);
        ExtendLogger.pass(value +" is successfully entered in " + elementName);

    }

    public static WebElement waitUntilYourElementPresent(By by) {
        WebDriverWait wait =new WebDriverWait(Drivermanager.getDriver(), Duration.ofSeconds(ConfigFactory.getconfig().timeout()));
        WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }
}
