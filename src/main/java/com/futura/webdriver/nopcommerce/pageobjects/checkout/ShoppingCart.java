package com.futura.webdriver.nopcommerce.pageobjects.checkout;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

public class ShoppingCart extends SlowLoadableComponent<ShoppingCart> {

    //

    private final WebDriver driver;

    // Objects
    By REGISTER_FIELD = By.className("ico-register");

    By TERMSOFSERVICE_CHECKBOX = By.id("termsofservice");
    By CHECKOUT_BUTTON = By.id("checkout");

    public ShoppingCart(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
        driver.get("http://localhost/nopCommerce/cart");
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver)
                .whenElementIsVisible(TERMSOFSERVICE_CHECKBOX, "Terms and Conditions Checkbox")
                .whenElementIsVisible(CHECKOUT_BUTTON,"Checkout Button");
    }

    public ShoppingCart tickTermsOfService()
    {
        driver.findElement(TERMSOFSERVICE_CHECKBOX).click();
        return this;
    }

    public ShoppingCart clickCheckout()
    {
        driver.findElement(CHECKOUT_BUTTON).click();
        return this;
    }
}
