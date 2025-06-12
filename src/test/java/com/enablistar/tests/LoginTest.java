package com.enablistar.tests;


import com.enablistar.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider
    public static Object[][] getdata() {
        return new Object[][]{
                {"Enablistar_Admin", "Enablistar_Admin@2024", "Dashboard"}

        };

    }

    @Test(description = "To check weather the team can login in the Enablistar Dashboard", dataProvider = "getdata")
    public void login(String username, String password, String expectedTitle) throws Exception {

        LoginPage loginPage = new LoginPage();
        String actualTitle = loginPage
                .LoginApp(username, password)
                .getTitle();
        Thread.sleep(1000);
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
