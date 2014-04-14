package com.futura.webdriver.nopcommerce.pageobjects.search;

import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

import java.util.ArrayList;
import java.util.List;

public class Search extends SlowLoadableComponent<Search>{

    private final WebDriver driver;

    //Objects

    By SEARCH_FIELD = By.id("small-searchterms");
    By SEARCH_BUTTON = By.cssSelector(".button-1.search-box-button");

    By SEARCH_RESULT_ITEMS = By.cssSelector("h2.product-title a");
    ByChained adadada = new ByChained(By.cssSelector("asdasd"), By.id("1231231"));

    // List of Field Validation messages
    public List<String> SearchResultProductNames = new ArrayList<String>();

    public Search(WebDriver driver)
    {
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
                whenElementIsVisible(SEARCH_FIELD,"Search field" ).
                whenElementIsVisible(SEARCH_BUTTON,"Search Button" );
    }

    public Search performSearch(String searchCriteria){
        driver.findElement(SEARCH_FIELD).sendKeys(searchCriteria);
        driver.findElement(SEARCH_BUTTON).click();
        return this;
    }

    public Search getSearchResults()
    {
        List<WebElement> searchResultsWebElements = new ArrayList<WebElement>();

        searchResultsWebElements = driver.findElements(SEARCH_RESULT_ITEMS);

        for( WebElement searchResultsWebElement : searchResultsWebElements) {
            SearchResultProductNames.add(searchResultsWebElement.getText());
        }
        return this;
    }

    public Search addToCart(String ProductTitle)
    {
        //CSS h2[class="product-title"] a[href='/nopCommerce/best-grilling-recipes']
        //CSS Exampple h2 a[href*='grilling']
        driver.findElement(By.xpath("//h2/a[contains(.,'"+ProductTitle+"')]/../../div[@class='add-info']/div[@class='buttons']/input[@type='button']")).click();
        return this;
    }

    public Search addAllItemsToCart()
    {
        return this;
    }
}
