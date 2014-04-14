package com.futura.webdriver.nopcommerce.pageobjects.register;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Register extends SlowLoadableComponent<Register>{

    private final WebDriver driver;

    // Object locators
    By GENDER_MALE_FIELD = By.id("gender-male");
    By GENDER_FEMALE_FIELD = By.id("gender-female");
    By FIRSTNAME_FIELD = By.id("FirstName") ;
    By LASTNAME_FIELD = By.id("LastName");
    By DATEOFBIRTH_DAY_FIELD = By.name("DateOfBirthDay");
    By DATEOFBIRTH_MONTH_FIELD = By.name("DateOfBirthMonth");
    By DATEOFBIRTH_YEAR_FIELD = By.name("DateOfBirthYear");
    By EMAIL_FIELD = By.id("Email");

    By COMPANYNAME_FIELD = By.id("Company");

    By NEWSLETTER_FIELD = By.id("Newsletter");

    By PASSWORD_FIELD = By.id("Password");
    By CONFIRMPASSWORD_FIELD = By.id("ConfirmPassword");
    By REGISTER_BUTTON = By.id("register-button");

    By REGISTER_CONTINUE_BUTTON = By.cssSelector(".button-1.register-continue-button");
    By VALIDATION_ERROR_MESSAGES = By.cssSelector(".field-validation-error>span");

    // List of Field Validation messages
    public List<String> ErrorText = new ArrayList<String>();

    public Register(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
        driver.get("http://localhost/nopCommerce/register");
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
                whenElementIsVisible(FIRSTNAME_FIELD,"First name field" ).
                whenElementIsVisible(EMAIL_FIELD,"Email field" ).
                whenElementIsVisible(PASSWORD_FIELD,"Password field" ).
                whenElementIsVisible(REGISTER_BUTTON,"Register field" );
    }

    public Register setGender(String gender){
        if (gender == "Male")
           driver.findElement(GENDER_MALE_FIELD).click();
        else
            driver.findElement(GENDER_FEMALE_FIELD).click();
        return this;
    }

    public Register setFirstName(String firstName){
        driver.findElement(FIRSTNAME_FIELD).sendKeys(firstName);
        return this;
    }

    public Register setLastName(String lastName){
        driver.findElement(LASTNAME_FIELD).sendKeys(lastName);
        return this;
    }

    public Register setDateOfBirth(String day, String month, String year){
        driver.findElement(DATEOFBIRTH_DAY_FIELD).sendKeys(day);
        driver.findElement(DATEOFBIRTH_MONTH_FIELD).sendKeys(month);
        driver.findElement(DATEOFBIRTH_YEAR_FIELD).sendKeys(year);
        return this;
    }

    public Register setEmail(String email){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    public Register setCompanyName(String companyName){
        driver.findElement(COMPANYNAME_FIELD).sendKeys(companyName);
        return this;
    }

    public Register selectNewsletter(String opt){
        if (opt=="Yes")
            driver.findElement(COMPANYNAME_FIELD).click();
        return this;
    }

    public Register setPassword(String password){
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    public Register setConfirmPassword(String confirmPassword){
        driver.findElement(CONFIRMPASSWORD_FIELD).sendKeys(confirmPassword);
        return this;
    }

    public Register submitRegistration(){
        driver.findElement(REGISTER_BUTTON).click();
        return this;
    }

    public Register submitSuccessfulRegistrationContinue(){
        driver.findElement(REGISTER_CONTINUE_BUTTON).click();
        return this;
    }

    public Register getFieldValidationErrors()
    {
        List<WebElement> ErrorWebElements = new ArrayList<WebElement>();

        ErrorWebElements = driver.findElements(VALIDATION_ERROR_MESSAGES);

        for( WebElement ErrorObject : ErrorWebElements) {
            ErrorText.add(ErrorObject.getText());
        }
        return this;
    }
}
