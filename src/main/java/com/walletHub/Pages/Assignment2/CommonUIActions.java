package com.walletHub.Pages.Assignment2;


import com.walletHub.driverFactory.ConfigFileReader;
import com.walletHub.driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CommonUIActions extends DriverFactory {
    public CommonUIActions(WebDriver driver) {
        super(driver);
    }

    ConfigFileReader configFileReader = new ConfigFileReader();

    @FindBy(css=".brgm-user>span.brgm-list-title")
    private WebElement userNameFromHeaderEle;

    @FindBy(xpath="//a[text()='Profile']")
    private WebElement profile;



    public void openMainURL(String url) {
        openUrl(url);
    }

    public void selectProfile(){
        hoverOnElement(userNameFromHeaderEle);
        profile.click();

    }


}
