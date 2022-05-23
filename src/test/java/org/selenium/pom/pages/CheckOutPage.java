package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

      private final By firstNameFld = By.id("billing_first_name");
      private final By lastNameFld = By.id("billing_last_name");
      private final By addressFld = By.id("billing_address_1");
      private final By cityNameFld= By.id("billing_city");
      private final By postalCodeFld= By.id("billing_postcode");
      private final By emailFld =  By.id("billing_email");
      private final By placeOrderBtn= By.id("place_order");
      private final By welcomeMessage= By.cssSelector(".woocommerce-notice");

      public CheckOutPage enterFirstName(String firstName){
          driver.findElement(firstNameFld).sendKeys(firstName);
          return this;
      }

    public CheckOutPage enterLastName(String lastName){
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckOutPage enterAddressFld(String address){
        driver.findElement(addressFld).sendKeys(address);
        return this;
    }

    public CheckOutPage enterCityName(String cityName){
        driver.findElement(cityNameFld).sendKeys(cityName);
        return this;
    }

    public CheckOutPage enterPostalCode(String postalCode){
        driver.findElement(postalCodeFld).sendKeys(postalCode);
        return this;
    }

    public CheckOutPage enterEmail(String email){
        driver.findElement(emailFld).sendKeys(email);
        return this;
    }

    public CheckOutPage clickPlaceOrder(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String  getMessage(){
        return driver.findElement(welcomeMessage).getText();
    }

    public CheckOutPage setBillingAddress(BillingAddress bilinAddress){
          return enterFirstName(bilinAddress.getFirstName()).
                  enterLastName(bilinAddress.getLastName()).
                  enterAddressFld(bilinAddress.getAddress()).
                  enterCityName(bilinAddress.getCityName()).
                  enterPostalCode(bilinAddress.getPostalCode()).
                  enterEmail(bilinAddress.getEmail());

    }
}
