package com.enablistar.pages;

import com.enablistar.driver.Drivermanager;
import com.enablistar.pages.pagecomponent.leftMenuComponents;

public class HomePage {

    private leftMenuComponents leftMenuComponents;

    public HomePage() {
        leftMenuComponents = new leftMenuComponents();
    }

    public String getTitle() {
        return Drivermanager.getDriver().getTitle();
    }

    public void clikOnOperations() throws InterruptedException {
        leftMenuComponents.operationsComponentM();
    }

}
