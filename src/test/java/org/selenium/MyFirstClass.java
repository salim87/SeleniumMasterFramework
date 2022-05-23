package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstClass extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {
        BillingAddress  billingAddress= JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class);
        /*billingAddress.setAddress("Colorado Springs").
                setFirstName("salim").setLastName("iqbal").
                setCityName("Colorado Springs").
                setPostalCode("80920").
                setEmail("info@gmail.com");*/
        StorePage storePage = new HomePage(driver)
                .load().
                clickStoreMenuLink().
                search("blue");
        /*storePage= home.clickStoreMenuLink();
        storePage.search("blue");*/
        /*storePage.enterTxtInSearchFld("blue").
                 clickSearchBtn();*/
        Thread.sleep(4000);
        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”");
        Thread.sleep(4000);
        storePage.clickAddToCartBtn("Blue Shoes");

        Thread.sleep(5000);
        CartPage cartPage=storePage.clickViewCart();

        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckOutPage checkOutPage= cartPage.
                clickCheckOutBtn().
                setBillingAddress(billingAddress).
                clickPlaceOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getMessage(), "Thank you. Your order has been received.");
    }



}
