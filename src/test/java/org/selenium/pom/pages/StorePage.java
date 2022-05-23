package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        super(driver);

    }
    private final By searchFld= By.id("woocommerce-product-search-field-0");
    private final By searchBtn= By.cssSelector("button[value='Search']");
    private final By title= By.cssSelector(".woocommerce-products-header__title.page-title");
   // private final WebElement addToCartBtn= driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']"));

    private final By viewCart =By.cssSelector("a[title='View cart']");
    private StorePage enterTxtInSearchFld(String txt){
        driver.findElement(searchFld).clear();
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }

    private StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }

    public StorePage search(String txt){
        enterTxtInSearchFld(txt).clickSearchBtn();
        return this;
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }

    private By getAddToCartBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }
    public void clickAddToCartBtn(String productName){
        By addToCartBtn= getAddToCartBtnElement(productName);
        driver.findElement(addToCartBtn).click();
    }

    public CartPage clickViewCart(){
        driver.findElement(viewCart).click();
        return new CartPage(driver);
    }

}
