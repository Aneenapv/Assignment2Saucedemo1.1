package com.saucedemo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestBase.TestBase;

public class CartPage extends TestBase {
	
	public CartPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")
	WebElement removeProduct;
	public CheckoutPage removeProduct()
	{
		removeProduct.click();
		return new  CheckoutPage();
	}
	

}
