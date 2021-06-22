package com.walletHub.driverFactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class CommonDriverFactoryMethod {

    protected Wait fluentWait(int timeoutVal,Object driver) {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeoutVal))
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait;
    }

    protected boolean isElementAvailable(WebElement element, int timeoutVal,Object driver) {
        boolean ret = false;
        try {
            fluentWait(timeoutVal,driver).until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                ret = true;
                return ret;
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
        return ret;
    }

    protected boolean isElementAvailableList(List<WebElement> element, int timeoutVal, Object driver) {
        try {
            fluentWait(timeoutVal,driver).until(ExpectedConditions.visibilityOf(element.get(0)));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }




}
