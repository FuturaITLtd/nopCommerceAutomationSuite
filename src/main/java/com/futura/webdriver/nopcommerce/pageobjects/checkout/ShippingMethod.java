package com.futura.webdriver.nopcommerce.pageobjects.checkout;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShippingMethod extends SlowLoadableComponent<ShippingMethod> {

    private final WebDriver driver;

    // Objects

    By CONTINUE_BUTTON = By.cssSelector("input[type='button'][value='Continue'][onclick='ShippingMethod.save()']");

    public ShippingMethod(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
                whenElementIsVisible(CONTINUE_BUTTON,"Shipping Method Continue button" );
    }

    public ShippingMethod selectShippingMethod(String shippingOption){
        WebElement selectedShippingMethod = driver.findElement(By.cssSelector("input[id='"+shippingOption+"']"));
        if(!selectedShippingMethod.isSelected()){
            selectedShippingMethod.click();
        }
        return this;
    }

    public ShippingMethod clickContinue(){
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }


}
