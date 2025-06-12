package com.enablistar.pages.pagecomponent;

import org.openqa.selenium.By;

import static com.enablistar.utils.SeleniumUtils.click;

public class leftMenuComponents {

    private By leftwindowHome = By.xpath("//*[@class='MuiListItem-root MuiListItem-gutters MuiListItem-padding css-wbwqq1']");
    private By leftwindowWorkflow = By.xpath("//li[@aria-label='Workflows']");


    public void operationsComponentM() throws InterruptedException {
        click(leftwindowHome, "HomeButton");
    }


    public By leftwindowWorkflow() throws InterruptedException {
        click(leftwindowWorkflow, "WorkflowButton");
        return null;
    }


}
