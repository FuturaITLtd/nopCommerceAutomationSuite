package com.futura.webdriver.nopcommerce.pageobjects.login;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

public class Login extends SlowLoadableComponent<Login>{

    private final WebDriver driver;

    // Objects
    By REGISTER_BUTTON = By.cssSelector("input[type='Button'][value='Register']");
    By GUESTCHECKOUT_BUTTON = By.cssSelector("input[type='Button'][value='Checkout as Guest']");

    By EMAIL_FIELD = By.id("Email");
    By PASSWORD_FIELD = By.id("Password");
    By REMEMBERME_CHECKBOX = By.id("RememberMe");
    By LOGIN_BUTTON = By.className("button-1 login-button");

    public Login(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
        driver.get("http://localhost/nopCommerce");
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
            whenElementIsVisible(REGISTER_BUTTON,"Register button" ).
            whenElementIsVisible(EMAIL_FIELD,"Registered Email" ).
            whenElementIsVisible(PASSWORD_FIELD, "Registered Password");
    }

    public Login clickRegister(){
        driver.findElement(REGISTER_BUTTON).click();
        return this;
    }

    public Login clickCheckOutAsGuest(){
        driver.findElement(GUESTCHECKOUT_BUTTON).click();
        return this;
    }

}
