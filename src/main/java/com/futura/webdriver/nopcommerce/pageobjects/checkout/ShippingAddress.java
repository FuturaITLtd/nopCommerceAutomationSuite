package com.futura.webdriver.nopcommerce.pageobjects.checkout;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

public class ShippingAddress extends SlowLoadableComponent<ShippingAddress> {

    private final WebDriver driver;

    // Objects

    By SHIPPINGADDRESS_DROPDOWN = By.id("shipping-address-select");
    By CONTINUE_BUTTON = By.cssSelector("input[onclick='Shipping.save()']");

    //By CONTINUE_BUTTON = By.cssSelector("div#shipping-buttons-container.buttons input.button-1");


    public ShippingAddress(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
                whenElementIsVisible(SHIPPINGADDRESS_DROPDOWN, "Shipping Address dropdown")
                .whenElementIsVisible(CONTINUE_BUTTON, "Shipping Address Continue button");
    }

    public ShippingAddress setShippingAddress(String shippingAddress){
        Select shippingAddressDropdown = new Select(driver.findElement(SHIPPINGADDRESS_DROPDOWN));
        shippingAddressDropdown.selectByValue(shippingAddress);
        return this;
    }

    public ShippingAddress clickContinueButton(){
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }
}
