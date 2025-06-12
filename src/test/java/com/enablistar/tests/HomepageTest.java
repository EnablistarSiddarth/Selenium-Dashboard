package com.enablistar.tests;

import com.enablistar.pages.HomePage;
import com.enablistar.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {


    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"Enablistar_Admin", "Enablistar_Admin@2024"}
        };
    }


    @Test(description = "This is the test for Homepage", dataProvider = "getData")
    public void Homepage(String username, String password) throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginApp(username, password);
        HomePage homePage = new HomePage();
        homePage.clikOnOperations();

    }
}
