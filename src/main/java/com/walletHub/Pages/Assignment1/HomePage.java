package com.walletHub.Pages.Assignment1;

import com.walletHub.driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement userNameEle;

    @FindBy(id = "pass")
    private WebElement passwordEle;

    @FindBy(name = "login")
    private WebElement loginEle;

    public boolean isHomePageOpen(){
       return getTitle().equals("Facebook-login or sign up");
    }

    public void enterUsername(String username){
        userNameEle.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordEle.sendKeys(password);
    }

    public void clickOnFbLogin(){
        loginEle.click();
    }



}

