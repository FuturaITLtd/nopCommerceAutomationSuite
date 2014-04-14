import com.futura.webdriver.nopcommerce.pageobjects.header.*;

import com.futura.webdriver.nopcommerce.pageobjects.navigation.CategoryTopMenu;
import com.futura.webdriver.nopcommerce.pageobjects.search.Search;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HeaderTest {
    private static WebDriver driver;

    @BeforeClass
    public static void startSelenium(){
        driver = new FirefoxDriver();
    }

    @Test
    public void navigateLinks(){
        Header testHeaderLinks = new Header(driver);
        testHeaderLinks.get();

        testHeaderLinks.clickRegister().
                        clickLogin().
                        clickRegister().
                        clickWishList();
    }

    @Test
    public void topMenuTest(){
        CategoryTopMenu catTopMenu = new CategoryTopMenu(driver);
        catTopMenu.get();
        catTopMenu.clickOnTopMenuLink(CategoryTopMenu.TopLink.COMPUTERS);
    }

    @AfterClass
    public static void closeSelenium(){
          driver.quit();
    }
}
