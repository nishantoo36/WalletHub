package com.walletHub.driverFactory.Web;



import com.walletHub.driverFactory.CommonDriverFactoryMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DriverFactory extends CommonDriverFactoryMethod {
    protected WebDriver driver;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }

    protected boolean isElementAvailable(WebElement element, int timeoutVal) {
        return super.isElementAvailable(element,timeoutVal,driver);
    }

    protected boolean isElementAvailableInList(List<WebElement> element, int timeoutVal) {
        return super.isElementAvailableList(element,timeoutVal,driver);
    }

    protected String getTitle(){
        return driver.getTitle();
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    public void hoverOnElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        action.release();
    }


}


