import com.futura.webdriver.nopcommerce.pageobjects.checkout.*;
import com.futura.webdriver.nopcommerce.pageobjects.header.Header;
import com.futura.webdriver.nopcommerce.pageobjects.login.Login;
import com.futura.webdriver.nopcommerce.pageobjects.search.Search;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutTest {

    private static WebDriver driver;

    @BeforeClass
    public static void startSelenium() throws IOException {

        String s = File.separator;
        String extensionFireBugPath = System.getProperty("user.dir") +
                String.format("%ssrc%smain%sresources%s%s",s,s,s,s,"firebug-1.12.7-fx.xpi");

        String extensionFirePathPath = System.getProperty("user.dir") +
                String.format("%ssrc%smain%sresources%s%s",s,s,s,s,"firepath-0.9.7-fx.xpi");

        System.out.println(extensionFireBugPath);
        System.out.println(extensionFirePathPath);

        FirefoxProfile FFProfile = new FirefoxProfile();

        FFProfile.setPreference("extensions.firebug.currentVersion","1.12.7");

        FFProfile.addExtension(new File(extensionFireBugPath));

        FFProfile.addExtension(new File(extensionFirePathPath));

        driver = new FirefoxDriver(FFProfile);
    }

    @SuppressWarnings("Uncheched")
    @Test
    public void guestCheckoutTest(){

        // Search and add item to cart
        Search searchForItem = new Search(driver);
        searchForItem.get();

        searchForItem
                .performSearch("Recipes")
                .getSearchResults();
        assertThat("All Search Results Product titles should contain Recipes", searchForItem.SearchResultProductNames, everyItem(containsString("Recipes")));

        searchForItem.addToCart("Best Grilling Recipes");

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(searchForItem.ADDTOCARTSUCCESS_MESSAGE));

        assertThat("Product has been added to cart Confirmation", searchForItem.getAddToCartResultMessage(), containsString("The product has been added to your shopping cart"));

        // Navigate to shopping cart and checkout
        Header header = new Header(driver);
        header.clickShoppingCart();
        ShoppingCart cart = new ShoppingCart(driver);
        cart.tickTermsOfService();
        cart.clickCheckout();

        // Initiate Guest Checkout
        Login checkout = new Login(driver);
        checkout.get();
        checkout.clickCheckOutAsGuest();

        // Enter Billing Address

        BillingAddress billing = new BillingAddress(driver);
        billing.get();
        billing
                .setFirstName("John")
                .setLastName("Smith")
                .setEmail("test@tester.com")
                .setCountry("United Kingdom")
                .setState("Other (Non US)")
                .setCity("London")
                .setAddress1("12 Pine road")
                .setAddress2("Wimbledon")
                .setPostcode("SW19 7AS")
                .setPhone("34242424242422")
                .clickContinue();

        // Enter Shipping Address

        ShippingAddress shipping = new ShippingAddress(driver);
        shipping.get();
        shipping.clickContinueButton();

        // Enter Shipping Method

        ShippingMethod shipMethod = new ShippingMethod(driver);
        shipMethod.get();
        // OPTIONS - In-Store (shippingoption_0), By Ground shippingoption_1), By Air or In-Store shippingoption_2)
        shipMethod.selectShippingMethod("shippingoption_1");
        shipMethod.clickContinue();

        // Enter Payment Details
        PaymentInformation payment = new PaymentInformation(driver);
        payment.get();

        payment
                .setCreditCardType("Master card")
                .setCreditCardHolderName("John Smith")
                .setCreditCardNumber("5555555555555557")
                .setCreditCardExpirationonMonth("07")
                .setCreditCardExpirationonYear("2020")
                .setCreditCardCode("123")
                .clickContinue();

        // Confirm Order
        ConfirmOrder orderConfirmation = new ConfirmOrder(driver);
        orderConfirmation.get();
        orderConfirmation.clickContinue();

        // Order Completed
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(orderConfirmation.COMPLETED_MESSAGE));
        assertThat("Order has been successfully processed", orderConfirmation.getCompletedMessageText(), containsString("Your order has been successfully processed!"));
    }
    @AfterClass
    public static void closeSelenium(){
        driver.quit();
    }
}
