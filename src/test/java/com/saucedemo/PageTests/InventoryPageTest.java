package com.saucedemo.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.Pages.AccountLoginPage;
import com.saucedemo.Pages.CartPage;
import com.saucedemo.Pages.CheckoutPage;
import com.saucedemo.Pages.InventoryPage;
import com.saucedemo.TestBase.TestBase;

public class InventoryPageTest extends TestBase {
	
	AccountLoginPage loginPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;

	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage =new AccountLoginPage();
		
	}
	
	
	
	@Test
	public void validateLoginAndAddToCartRemoveProduct()
	{
		inventoryPage = loginPage.loginToMyAccount("standard_user","secret_sauce");
		String getInventoryText = inventoryPage.getInventoryText();
		Assert.assertEquals("Swag Labs",getInventoryText,"Not showing Swag Labs");
		
		cartPage = inventoryPage.addToCart();
		checkoutPage = cartPage.removeProduct();
		checkoutPage.clickOnCheckout();
		String getCheckoutHeadingText = checkoutPage.getCheckoutPageHeading();
		Assert.assertEquals(getCheckoutHeadingText,"Checkout: Your Information","Not matching heading");
		checkoutPage.checkoutMethods();
		
		inventoryPage.addOnesieAndBikeLightSteps();
		checkoutPage.clickOnCheckout();
		inventoryPage.logout();
		 
	}
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	

}
