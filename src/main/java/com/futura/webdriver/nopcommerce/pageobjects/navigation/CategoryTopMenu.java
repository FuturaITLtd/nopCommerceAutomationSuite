package com.futura.webdriver.nopcommerce.pageobjects.navigation;


import com.futura.webdriver.helper.isLoaded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

public class CategoryTopMenu extends SlowLoadableComponent<CategoryTopMenu>{

    private final WebDriver driver;

    //Top Header menu items
    By BOOKS_TOP_HEADER = By.linkText("Books");
    By COMPUTERS_TOP_HEADER = By.linkText("Computers");
    By ELECTRONICS_TOP_HEADER= By.linkText("Electronics");
    By APPARELSHOES_TOP_HEADER = By.linkText("Apparel & Shoes");
    By DIGITALDOWNLOADS_TOP_HEADER = By.linkText("Digital downloads");
    By JEWELRY_TOP_HEADER = By.linkText("Jewelry");
    By GIFTCARDS_TOP_HEADER = By.linkText("Gift Cards");

    public CategoryTopMenu(WebDriver driver){
        super(new SystemClock(),10);
        this.driver = driver;
    }

    public enum TopLink{BOOKS,COMPUTERS,ELECTRONICS,APPARELSHOES,DIGITALDOWNLOADS,JEWELRY,GIFTCARDS}

    @Override
    protected void load(){
        driver.get("http://localhost/nopCommerce");
    }

    @Override
    protected void isLoaded() throws Error{
        isLoaded.forThis(driver).
                 whenElementIsVisible(BOOKS_TOP_HEADER, "Books Top menu header")
                .whenElementIsVisible(COMPUTERS_TOP_HEADER, "Computers Top menu header")
                .whenElementIsVisible(ELECTRONICS_TOP_HEADER, "Electronics Top menu header")
                .whenElementIsVisible(APPARELSHOES_TOP_HEADER, "Apparel shoes Top menu header")
                .whenElementIsVisible(DIGITALDOWNLOADS_TOP_HEADER, "Digital downloads Top menu header")
                .whenElementIsVisible(JEWELRY_TOP_HEADER, "Jewelry Top menu header")
                .whenElementIsVisible(GIFTCARDS_TOP_HEADER, "Gift card Top menu header");
    }

    public CategoryTopMenu clickOnTopMenuLink(TopLink linkToClick)
    {
        //driver.findElement(BOOKS_TOP_HEADER).click();
       // return this;

        switch (linkToClick) {
            case BOOKS: driver.findElement(BOOKS_TOP_HEADER).click();
                break;
            case COMPUTERS:driver.findElement(COMPUTERS_TOP_HEADER).click();
                break;
            case ELECTRONICS:driver.findElement(ELECTRONICS_TOP_HEADER).click();
                break;
            case APPARELSHOES:driver.findElement(APPARELSHOES_TOP_HEADER).click();
                break;
            case DIGITALDOWNLOADS:driver.findElement(DIGITALDOWNLOADS_TOP_HEADER).click();
                break;
            case JEWELRY:driver.findElement(JEWELRY_TOP_HEADER).click();
                break;
            case GIFTCARDS:driver.findElement(GIFTCARDS_TOP_HEADER).click();
                break;
            default: driver.findElement(BOOKS_TOP_HEADER).click();
                break;
        }
        return this;
    }
}
