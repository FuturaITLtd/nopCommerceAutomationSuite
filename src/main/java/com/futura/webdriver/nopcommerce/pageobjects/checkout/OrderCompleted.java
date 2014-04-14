package com.futura.webdriver.nopcommerce.pageobjects.checkout;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;


public class OrderCompleted extends SlowLoadableComponent<OrderCompleted> {

    private final WebDriver driver;

    // Objects

    By VIEWORDERDETAILS_BUTTON = By.cssSelector("a[href*='/nopCommerce/orderdetails/']");
    By CONTINUE_BUTTON = By.cssSelector("input[type='button'][value='Continue']");

    public OrderCompleted(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver)
                .whenElementIsVisible(VIEWORDERDETAILS_BUTTON,"Order Completed Continue button" )
                .whenElementIsVisible(CONTINUE_BUTTON,"Order Completed Continue button" );
    }


    public OrderCompleted clickCompleted(){
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }
}
