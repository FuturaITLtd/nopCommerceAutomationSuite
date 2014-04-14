package com.futura.webdriver.nopcommerce.pageobjects.checkout;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

/**
 * Created by Andy on 4/11/14.
 */
public class PaymentInformation extends SlowLoadableComponent<PaymentInformation> {

    private final WebDriver driver;

    // Objects

    By CARDTYPE_DROPDOWN = By.id("CreditCardType"); // = By.className("button-1 new-address-next-step-button");
    By CARDHOLDERNAME_FIELD = By.id("CardholderName");
    By CARDNUMBER_FIELD = By.id("CardNumber");
    By EXPIRATIONMONTH_FIELD = By.id("ExpireMonth");
    By EXPIRATIONYEAR_FIELD = By.id("ExpireYear");
    By CARDCODE_FIELD = By.id("CardCode");

    By CONTINUE_BUTTON = By.cssSelector("input[type='button'][value='Continue'][onclick='PaymentInfo.save()']");

    public PaymentInformation(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    @Override
    protected void load(){
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
                whenElementIsVisible(CARDTYPE_DROPDOWN,"Billing Address Continue button" ).
                whenElementIsVisible(EXPIRATIONMONTH_FIELD,"Credit Card Expiration Month").
                whenElementIsVisible(EXPIRATIONYEAR_FIELD,"Credit Card Expiration Year").
                whenElementIsVisible(CONTINUE_BUTTON, "Payment Information Continue Button");
    }


    public PaymentInformation setCreditCardType(String creditCardType){
        Select creditCardTypeDrowpdown = new Select(driver.findElement(CARDTYPE_DROPDOWN));
        creditCardTypeDrowpdown.selectByVisibleText(creditCardType);
        return this;
    }

    public PaymentInformation setCreditCardHolderName(String creditCardHolderName)
    {
        driver.findElement(CARDHOLDERNAME_FIELD).sendKeys(creditCardHolderName);
        return this;
    }

    public PaymentInformation setCreditCardNumber(String creditCardNumber)
    {
        driver.findElement(CARDNUMBER_FIELD).sendKeys(creditCardNumber);
        return this;
    }

    public PaymentInformation setCreditCardExpirationonMonth(String creditCardExpirationMonth)
    {
        Select creditCardExiryMonthDrowpdown = new Select(driver.findElement(EXPIRATIONMONTH_FIELD));
        creditCardExiryMonthDrowpdown.selectByVisibleText(creditCardExpirationMonth);
        return this;
    }

    public PaymentInformation setCreditCardExpirationonYear(String creditCardExpirationYear)
    {
        Select creditCardExpiryYearDrowpdown = new Select(driver.findElement(EXPIRATIONYEAR_FIELD));
        creditCardExpiryYearDrowpdown.selectByVisibleText(creditCardExpirationYear);
        return this;
    }

    public PaymentInformation setCreditCardCode(String creditCardCode)
    {
        driver.findElement(CARDCODE_FIELD).sendKeys(creditCardCode);
        return this;
    }

    public PaymentInformation clickContinue()
    {
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }
}
