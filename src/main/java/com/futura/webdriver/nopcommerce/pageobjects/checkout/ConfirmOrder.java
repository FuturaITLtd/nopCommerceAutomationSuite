package com.futura.webdriver.nopcommerce.pageobjects.checkout;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;


public class ConfirmOrder extends SlowLoadableComponent<ConfirmOrder> {

    private final WebDriver driver;

    // Objects

    By CONTINUE_BUTTON = By.cssSelector("input[type='button'][value='Confirm'][onclick='ConfirmOrder.save()']");

    public By COMPLETED_MESSAGE = By.cssSelector("div[class='section order-completed']");
    public String COMPLETEDMESSAGE_TEXT;


    public ConfirmOrder(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
                whenElementIsVisible(CONTINUE_BUTTON,"Order Confirmation Continue button" );
    }

    public ConfirmOrder clickViewOrderDetails(){
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public ConfirmOrder clickContinue(){
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public String getCompletedMessageText()
    {
        COMPLETEDMESSAGE_TEXT = driver.findElement(COMPLETED_MESSAGE).getText();
        return COMPLETEDMESSAGE_TEXT;
    }
}
