package com.walletHub.Pages.Assignment2;

import com.walletHub.driverFactory.Web.DriverFactory;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class DashboardPage extends DriverFactory {

    @FindAll({@FindBy(css = "div.review-stat-box>div>review-star>div>svg>g>path[fill='#4ae0e1']")})
    List<WebElement> reviewStarListEle;

    @FindAll({@FindBy(css = "div.review-stat-box>div>review-star>div>svg>g>path+path")})
    List<WebElement> reviewStarHoverListEle;

    @FindAll({@FindBy(css = "write-review>review-star>div>svg>g>path+path")})
    List<WebElement> afterReviewStarListEle;

    @FindBy(xpath = "//span[text()='Select...']")
    WebElement dropDownEle;

    @FindAll({@FindBy(xpath = "//span[text()='Select...']/following-sibling::ul/li")})
    List<WebElement> dropDownOptionListEle;

    @FindBy(xpath = "//textarea[@placeholder='Write your review...']")
    WebElement writeReviewEle;

    @FindBy(xpath = "//div[text()='Submit']")
    WebElement submit;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void selectOnReviewStar(int val,boolean requiredHover){
        WebElement ele = reviewStarListEle.get(val-1);
        if(isElementAvailable(ele,10)) {
            if (requiredHover) {
                hoverOnStar(val - 1);
            }
            ele.click();
        }else {
            throw new ElementNotVisibleException("element for review star is not visisble");
        }
    }

    public void hoverOnStar(int val){
        WebElement ele =reviewStarListEle.get(val-1);
        if(isElementAvailable(ele,10)){
            hoverOnElement(ele);
        }
    }

    public int getLitUpStarCountWhenHover(){
      return reviewStarHoverListEle.size();
    }

    public int getLitUpStarCountOnReviewForm(){
        return afterReviewStarListEle.size();
    }

    public void selectValueInDropDown(String value){
        if(isElementAvailable(dropDownEle,10)){
            dropDownEle.click();
            if(isElementAvailableInList(dropDownOptionListEle,2)){
                for (WebElement ele:dropDownOptionListEle){
                    if(ele.getText().equals(value)){
                        ele.click();
                        return;
                    }
                }throw new NotFoundException("Element which have text as "+ value +" is not available in drop down");
            }else {
                throw new ElementNotVisibleException(dropDownOptionListEle+" is not visible");
            }
        }else {
            throw new ElementNotVisibleException(dropDownEle+" is not visible");
        }
    }

    public void writeReview(String review){
        writeReviewEle.sendKeys(review);
    }

    public void submitForm(){
        submit.click();
    }





}
