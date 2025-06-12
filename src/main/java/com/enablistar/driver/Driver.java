package com.enablistar.driver;

import com.enablistar.config.ConfigFactory;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.time.Duration;

public class Driver {

    private Driver(){}

    public static void initDriver() throws IOException {
        String browser= ConfigFactory.getconfig().browser();
        WebDriver driver= DriverFactory.getDriver(browser);
        Drivermanager.setDriver(driver);
        Drivermanager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigFactory.getconfig().timeout()));
        Drivermanager.getDriver().manage().window().maximize();
        Drivermanager.getDriver().get(ConfigFactory.getconfig().url());
    }
    public static void quit(){

        Drivermanager.getDriver().quit();
    }



}

