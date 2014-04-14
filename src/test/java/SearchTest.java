import com.futura.webdriver.nopcommerce.pageobjects.search.Search;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
    private static WebDriver driver;

    @BeforeClass
    public static void startSelenium(){
        driver = new FirefoxDriver();
    }

    @SuppressWarnings("Uncheched")
    @Test
    public void keywordSearchForItem(){
        Search searchForItem = new Search(driver);
        searchForItem.get();
        searchForItem.performSearch("Recipes");
        searchForItem.getSearchResults();
        assertThat("All Search Results Product titles should contain Recipes", searchForItem.SearchResultProductNames, everyItem(containsString("Recipes")));
    }

    @SuppressWarnings("Uncheched")
    @Test
    public void keywordSearchAndAddItemToCart(){
        Search searchForItem = new Search(driver);
        searchForItem.get();

        searchForItem
                .performSearch("Recipes")
                .getSearchResults();
        assertThat("All Search Results Product titles should contain Recipes", searchForItem.SearchResultProductNames, everyItem(containsString("Recipes")));

        searchForItem.addToCart("Best Grilling Recipes");

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.bar-notification.success p")));

        assertThat("Product has been added to cart Confirmation", driver.findElement(By.cssSelector("div.bar-notification.success p")).getText(), containsString("The product has been added to your shopping cart"));
    }
    @AfterClass
    public static void closeSelenium(){
        driver.quit();
    }
}
