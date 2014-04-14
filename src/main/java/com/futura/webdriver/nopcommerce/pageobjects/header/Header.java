package com.futura.webdriver.nopcommerce.pageobjects.header;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

import java.util.ArrayList;
import java.util.List;

public class Header extends SlowLoadableComponent<Header>{

    private final WebDriver driver;

    // Objects
    By REGISTER_FIELD = By.className("ico-register");
    By LOGIN_FIELD = By.className("ico-login");
    By SHOPPINGCART_FIELD = By.className("ico-cart");
    By WISHLIST_FIELD = By.className("ico-wishlist");

    public Header(WebDriver driver){
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
                whenElementIsVisible(REGISTER_FIELD,"Register link" ).
                whenElementIsVisible(LOGIN_FIELD,"Login link" ).
                whenElementIsVisible(SHOPPINGCART_FIELD,"ShoppingCart link" ).
                whenElementIsVisible(WISHLIST_FIELD, "Wishlist link");
    }

    public Header clickRegister(){
        driver.findElement(REGISTER_FIELD).click();
        return this;
    }

    public Header clickLogin(){
        driver.findElement(LOGIN_FIELD).click();
        return this;
    }

    public Header clickShoppingCart(){
        driver.findElement(SHOPPINGCART_FIELD).click();
        return this;
    }

    public Header clickWishList(){
        driver.findElement(WISHLIST_FIELD).click();
        return this;
    }
}
