package com.futura.webdriver.nopcommerce.pageobjects.register;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmation extends SlowLoadableComponent<com.futura.webdriver.nopcommerce.pageobjects.register.Register> {

    private final WebDriver driver;

    // Objects

    By REGISTER_CONTINUE_BUTTON = By.cssSelector(".button-1.register-continue-button");
    By STATUS = By.cssSelector(".result");

    public RegistrationConfirmation(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
                whenElementIsVisible(STATUS,"Status Message").
                whenElementIsVisible(REGISTER_CONTINUE_BUTTON, "Confirmation Button");
    }

    public RegistrationConfirmation submitRegistrationContinue(){
            driver.findElement(REGISTER_CONTINUE_BUTTON).click();
        return this;
    }
}

