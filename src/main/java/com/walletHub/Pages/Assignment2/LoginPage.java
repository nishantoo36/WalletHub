package com.walletHub.Pages.Assignment2;

import com.walletHub.driverFactory.Web.DriverFactory;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverFactory {

    @FindBy(id = "email")
    private WebElement emailEle;

    @FindBy(id="password")
    private WebElement passwordEle;

    @FindBy(xpath="//span[text()='Login']/parent::button")
    private WebElement loginButtonEle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageOpen(){
        return getTitle().equals("Login");
    }

    public void doLogin(String email, String password){
        if(isElementAvailable(emailEle,20)) {
            emailEle.sendKeys(email);
            passwordEle.sendKeys(password);
            loginButtonEle.click();
        }else {
            throw new ElementNotVisibleException("Unable to find element "+emailEle);
        }
    }


}
