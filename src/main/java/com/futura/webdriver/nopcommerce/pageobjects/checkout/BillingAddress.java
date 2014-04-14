package com.futura.webdriver.nopcommerce.pageobjects.checkout;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

public class BillingAddress extends SlowLoadableComponent<BillingAddress> {

    private final WebDriver driver;

    // Objects
    By FIRSTNAME_FIELD = By.id("BillingNewAddress_FirstName");
    By LASTNAME_FIELD = By.id("BillingNewAddress_LastName");
    By EMAIL_FIELD = By.id("BillingNewAddress_Email");
    By COMPANY_FIELD = By.id("BillingNewAddress_Company");

    By BILLINGCOUNTRY_DROPDOWN = By.id("BillingNewAddress_CountryId");
    By BILLINGCOUNTRYSTATE_DROPDOWN = By.id("BillingNewAddress_StateProvinceId");

    By BILLINGCITY_FIELD = By.id("BillingNewAddress_City");
    By BILLINGADDRESS1_FIELD = By.id("BillingNewAddress_Address1");
    By BILLINGADDRESS2_FIELD = By.id("BillingNewAddress_Address2");
    By BILLINGPOSTALCODE_FIELD = By.id("BillingNewAddress_ZipPostalCode");
    By BILLINGPHONE_FIELD = By.id("BillingNewAddress_PhoneNumber");
    By BILLINGFAX_FIELD = By.id("BillingNewAddress_FaxNumber");

    By CONTINUE_BUTTON = By.cssSelector("input[type='button'][value='Continue'][onclick='Billing.save()']");


    public BillingAddress(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
                whenElementIsVisible(FIRSTNAME_FIELD,"First Name field" ).
                whenElementIsVisible(LASTNAME_FIELD,"Last Name field" ).
                whenElementIsVisible(BILLINGPOSTALCODE_FIELD,"Billing PostCode field" ).
                whenElementIsVisible(CONTINUE_BUTTON,"Billing Address Continue button" );
    }


    public BillingAddress setFirstName(String firstName){
        driver.findElement(FIRSTNAME_FIELD).sendKeys(firstName);
        return this;
    }

    public BillingAddress setLastName(String lastName){
        driver.findElement(LASTNAME_FIELD).sendKeys(lastName);
        return this;
    }

    public BillingAddress setEmail(String email){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    public BillingAddress clickContinue(){
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public BillingAddress setCountry(String country){
        Select countryDropdown = new Select(driver.findElement(BILLINGCOUNTRY_DROPDOWN));
        countryDropdown.selectByVisibleText(country);
        return this;
    }

    public BillingAddress setState(String state){
        Select stateDropdown = new Select(driver.findElement(BILLINGCOUNTRYSTATE_DROPDOWN));
        stateDropdown.selectByVisibleText(state);
        return this;
    }

    public BillingAddress setCity(String city){
        driver.findElement(BILLINGCITY_FIELD).sendKeys(city);
        return this;
    }

    public BillingAddress setAddress1(String address1){
        driver.findElement(BILLINGADDRESS1_FIELD).sendKeys(address1);
        return this;
    }

    public BillingAddress setAddress2(String address2){
        driver.findElement(BILLINGADDRESS2_FIELD).sendKeys(address2);
        return this;
    }

    public BillingAddress setPostcode(String postcode){
        driver.findElement(BILLINGPOSTALCODE_FIELD).sendKeys(postcode);
        return this;
    }

    public BillingAddress setPhone(String phone){
        driver.findElement(BILLINGPHONE_FIELD).sendKeys(phone);
        return this;
    }
}
