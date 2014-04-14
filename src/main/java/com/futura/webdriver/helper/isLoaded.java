package com.futura.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class isLoaded {
    private final WebDriver driver;

    public isLoaded(WebDriver driver) {
        this.driver = driver;
    }

    public static isLoaded forThis(WebDriver driver) {
        isLoaded isLoaded = new com.futura.webdriver.helper.isLoaded(driver);
        return isLoaded;
    }

    public isLoaded whenElementIsVisible(By usingBy, String description) {
        try{
            if(driver.findElement(usingBy).isDisplayed()){
                return this;
            }else{
                throw new Error(description + " is not visible");
            }
        }catch(WebDriverException e){
            throw new Error(description + " is not visible", e);
        }
    }

    public isLoaded whenElementIsEnabled(By usingBy, String description) {
        try{
            if(driver.findElement(usingBy).isEnabled()){
                return this;
            }else{
                throw new Error(description + " is not enabled");
            }
        }catch(WebDriverException e){
            throw new Error(description + " is not enabled", e);
        }
    }
}