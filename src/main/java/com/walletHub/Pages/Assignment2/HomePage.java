package com.walletHub.Pages.Assignment2;

import com.walletHub.driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement login;

    public boolean isHomePageOpen(){
       return isElementAvailable(login,10);
    }

    public void clickOnLogin(){
        login.click();
    }


}

