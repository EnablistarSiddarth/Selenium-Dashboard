package com.enablistar.pages;

import com.enablistar.driver.Drivermanager;
import com.enablistar.pages.pagecomponent.leftMenuComponents;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.enablistar.utils.SeleniumUtils.click;
import static com.enablistar.utils.SeleniumUtils.sendkeys;


public class WorkflowPage {

    private leftMenuComponents leftMenuComponents;
    private static final By NEWWORKFLOW = By.xpath("(//*[@type='button'])[8]");
    private static final By SELECTPRODUCTOPTIONS = By.xpath("//*[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper css-vkjhqy']");
    private static final By SELECTPRODUCT = By.xpath("//*[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-18bt607']");
    private static final By WORKFLOWNAME = By.xpath("//*[@placeholder='Name']");
    private static final By CLICKCREATEWORKFLOW = By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]");
    private static final By CLICKONSAVE = By.xpath("(//*[@type='button'])[1]");
    private static final By CLICKONCONFIRM = By.xpath("(//*[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-colorPrimary css-1ff5lqt'])[2]");

    @SneakyThrows
    public WorkflowPage() {
        leftMenuComponents = new leftMenuComponents();
    }

    public String getTitle() {
        return Drivermanager.getDriver().getTitle();
    }

    public WorkflowPage clikOnWorkflowButton() throws InterruptedException {
        leftMenuComponents.leftwindowWorkflow();
        return this;
    }

    public WorkflowPage clickNewWorkflow() throws InterruptedException {
        click(NEWWORKFLOW, "Clicked on New Workflow");
        return this;

    }

    public WorkflowPage selectproduct() throws InterruptedException {
        click(SELECTPRODUCT, "Entering the name");

        List<WebElement> options = Drivermanager.getDriver().findElements(By.xpath("//*[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1o1fq3n']"));
        options.get(1).click();
//        for (int i = 0; i < 2 && i < options.size(); i++) {
//            options.get(i).click();
//            Thread.sleep(500); // Small wait between clicks if needed
            return this;
        }
//       return null;
//   }

    public WorkflowPage enterWorkflowName(String NameWorkflow) throws InterruptedException {
        sendkeys(WORKFLOWNAME, NameWorkflow, "enterWorkflowName");
        return this;
    }

    public WorkflowPage clickcreate() throws InterruptedException {
        click(CLICKCREATEWORKFLOW, "clicked on create");
        return this;
    }

    public WorkflowPage clicktoaddelement() throws InterruptedException {
        WebElement element = Drivermanager.getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-1u6s58t']//*[name()='svg'][1]/*[name()='rect'][1]"));
        JavascriptExecutor js = (JavascriptExecutor) Drivermanager.getDriver();
        js.executeScript("var evt = new MouseEvent('click', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);", element);
        return this;
    }

    public WorkflowPage DragForm() {
        WebElement source = Drivermanager.getDriver().findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiAccordion-root MuiAccordion-rounded Mui-expanded MuiAccordion-gutters css-7k7w77']//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']//div[1]//div[1]"));
        Actions actions = new Actions(Drivermanager.getDriver());
        actions.dragAndDropBy(source, 400, 250).perform();
        return this;
    }

    public WorkflowPage ConnectstartForm() {
        WebElement source = Drivermanager.getDriver().findElement(By.xpath("(//*[@class='react-flow__handle react-flow__handle-right nodrag nopan handle-st-dots handle-st-dots-right source connectable connectablestart connectableend connectionindicator'])[1]"));
        WebElement target = Drivermanager.getDriver().findElement(By.xpath("(//*[@class='react-flow__handle react-flow__handle-left nodrag nopan handle-st-dots handle-st-dots-left target connectable connectablestart connectableend connectionindicator'])[2]"));
        Actions actions = new Actions(Drivermanager.getDriver());
        actions.clickAndHold(source)
                .moveToElement(target)
                .pause(java.time.Duration.ofMillis(300)) // optional: pause for realism
                .release()
                .build()
                .perform();
        return this;
    }

    public WorkflowPage ConnectFormtoend() throws InterruptedException {
        WebElement source = Drivermanager.getDriver().findElement(By.xpath("(//*[@class='react-flow__handle react-flow__handle-right nodrag nopan handle-st-dots handle-st-dots-right source connectable connectablestart connectableend connectionindicator'])[2]"));
        WebElement target = Drivermanager.getDriver().findElement(By.xpath("(//*[@class='react-flow__handle react-flow__handle-left nodrag nopan handle-st-dots handle-st-dots-left target connectable connectablestart connectableend connectionindicator'])[1]"));
        Actions actions = new Actions(Drivermanager.getDriver());
        actions.clickAndHold(source)
                .moveToElement(target)
                .pause(java.time.Duration.ofMillis(300)) // optional: pause for realism
                .release()
                .build()
                .perform();
        click(CLICKONSAVE, "click on save button");
        click(CLICKONCONFIRM, "click on confirm button");
        return this;
    }


    public WorkflowPage CreateWorkflow(String NameWorkflow) throws InterruptedException {
        return clikOnWorkflowButton().
                clickNewWorkflow().
                selectproduct().
                enterWorkflowName(NameWorkflow).
                clickcreate().clicktoaddelement().
                DragForm().
                ConnectstartForm().
                ConnectFormtoend();

    }

}
