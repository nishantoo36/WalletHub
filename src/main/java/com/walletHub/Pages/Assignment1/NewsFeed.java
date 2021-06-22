package com.walletHub.Pages.Assignment1;

import com.walletHub.driverFactory.Web.DriverFactory;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsFeed extends DriverFactory {

    public NewsFeed(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'on your mind')]")
    private WebElement composerEle;

    @FindBy(xpath = "//div[contains(@aria-label,'on your mind')]")
    private WebElement composerPopupEle;

    @FindBy(xpath = "//span[text()='Post']")
    private WebElement postButtonEle;

    public void doPost(String value){
        if(isElementAvailable(composerEle,10)){
            composerEle.click();
            if(isElementAvailable(composerPopupEle,5)){
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", composerPopupEle);
                composerPopupEle.sendKeys(value);
                postButtonEle.click();
            }else {
                throw new ElementNotVisibleException(composerPopupEle+" is not visible");
            }
        }else {
            throw new ElementNotVisibleException(composerEle+" is not visible");
        }
    }


}
