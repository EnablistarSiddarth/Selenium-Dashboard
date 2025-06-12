package com.enablistar.tests;

import com.enablistar.pages.HomePage;
import com.enablistar.pages.LoginPage;
import com.enablistar.pages.WorkflowPage;
import com.enablistar.pages.pagecomponent.leftMenuComponents;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Workflow extends BaseTest {
    static Faker faker = new Faker();

    @DataProvider
    public static Object[][] getData() {
        String NameWorkflow = faker.name().username();
        return new Object[][]{
                {"Enablistar_Admin", "Enablistar_Admin@2024", NameWorkflow}
        };
    }


    @Test(description = "This is the test for Workflow", dataProvider = "getData")
    public void Homepage(String username, String password, String NameWorkflow) throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.LoginApp(username, password);
        WorkflowPage workflowPage = new WorkflowPage();
        workflowPage.CreateWorkflow(NameWorkflow);

        

    }
}
