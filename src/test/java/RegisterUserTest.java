import com.futura.webdriver.helper.Misc;
import com.futura.webdriver.nopcommerce.pageobjects.register.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterUserTest {
    private static WebDriver driver;
    private int randomInt = (int)(1000.0 * Math.random());

    @BeforeClass
    public static void startSelenium(){
        driver = new FirefoxDriver();
    }

    @SuppressWarnings("unchecked") //hasItems causing Java unchecked or unsafe operation warning
    @Test
    public void checkRegistrationMandatoryFields()
    {
        Register valRegMandatoryFields = new Register(driver);

        valRegMandatoryFields.get();

        valRegMandatoryFields.submitRegistration();

       valRegMandatoryFields.getFieldValidationErrors();

       assertThat("Mandatory Registration fields are flagged", valRegMandatoryFields.ErrorText, hasItems(
               containsString("First name is required"),
               containsString("Last name is required"),
               containsString("Email is required"),
               containsString("Password is required")));

       assertThat("The number of Registration mandatory fields", valRegMandatoryFields.ErrorText, hasSize(5));
    }

    @Test
    public void registerUser(){
        Register registerNewUser = new Register(driver);
        RegistrationConfirmation regConfirmation = new RegistrationConfirmation(driver);
        Misc cleanUp = new Misc(driver);

        registerNewUser.get();

        cleanUp.checkLogOut();

        registerNewUser.setGender("Female")
                .setFirstName("Andy2")
                .setLastName("Smith1")
                .setDateOfBirth("12","10","1965")
                .setEmail(randomInt+"@adada.com")
                .setCompanyName("Horseferry Ltd")
                .selectNewsletter("Yes")
                .setPassword("password")
                .setConfirmPassword("password")
                .submitRegistration();

        regConfirmation.get();

        assertThat("Registration Success message displayed",driver.findElement(By.cssSelector(".result")).getText(), containsString("Your registration completed"));

        regConfirmation.submitRegistrationContinue();

        assertThat("On Continue taken back to Home page",driver.getTitle(), containsString("Your store"));

        cleanUp.checkLogOut();
    }



    @AfterClass
    public static void closeSelenium(){
        driver.quit();
    }


}
