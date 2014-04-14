package com.futura.webdriver.nopcommerce.pageobjects;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;


public class PageObjectTemplate extends SlowLoadableComponent<PageObjectTemplate> {

    private final WebDriver driver;

    // Objects

    By CONTINUE_BUTTON = By.cssSelector("input[type='button'][value='Continue']");


    public PageObjectTemplate(WebDriver driver){
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
                whenElementIsVisible(CONTINUE_BUTTON,"Billing Address Continue button" );
    }


    public PageObjectTemplate clickContinue(String firstName){
        driver.findElement(CONTINUE_BUTTON).sendKeys(firstName);
        return this;
    }
}
