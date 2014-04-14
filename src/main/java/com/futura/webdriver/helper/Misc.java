package com.futura.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Misc {
    public final WebDriver driver;

    By LOGOUT_LINK = By.className("ico-logout");
    By LOGIN_LINK = By.className("ico-login");
    public Misc(WebDriver driver)
    {
        this.driver = driver;
    }

    public Misc checkLogOut()
    {
        boolean found;

        try
        {
            if (driver.findElement(LOGIN_LINK).isDisplayed())
            {
                return this;
            }
        }
        catch(NoSuchElementException e)
        {
            driver.findElement(LOGOUT_LINK).click();
        }
        return this;
    }

   public Misc clearAllCookies()
   {
       driver.manage().deleteAllCookies();
       return this;
   }
}
