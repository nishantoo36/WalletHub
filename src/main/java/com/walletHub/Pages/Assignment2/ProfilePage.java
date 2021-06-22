package com.walletHub.Pages.Assignment2;

import com.walletHub.driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProfilePage extends DriverFactory {


    @FindBy(className = "pr-rec-type")
    public WebElement dropDownSelectedValue;

    @FindAll({@FindBy(css = "review-star>div>svg>g>path+path")})
    List<WebElement> reviewStarListEle;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getSelectedDropDownValue(){
       return dropDownSelectedValue.getText();
    }

    public int getReviewCount(){
        return reviewStarListEle.size();
    }


}
