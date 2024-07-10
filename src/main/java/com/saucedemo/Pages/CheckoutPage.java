package com.saucedemo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestBase.TestBase;

public class CheckoutPage extends TestBase{
	
	
	public CheckoutPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement clickOnCheckout;
	public void clickOnCheckout()
	{
		clickOnCheckout.click();
	}
	
	
	
	@FindBy(xpath="//span[@class='title']")
	WebElement checkoutPageHeading;
	public String getCheckoutPageHeading()
	{
		return checkoutPageHeading.getText().trim();
	}
	
	
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstnameCheckout;
	public void firstnameCheckout()
	{
		firstnameCheckout.sendKeys("Aneena");
	}
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastnameCheckout;
	public void lastnameCheckout()
	{
		lastnameCheckout.sendKeys("Vincent");
	}
	
	@FindBy(id="postal-code")
	WebElement postalCodeCheckout;
	public void  postalCodeCheckout()
	{
      postalCodeCheckout.sendKeys("L6T 1L2");
	}
	
	public void checkoutForm()
	{
		firstnameCheckout();
		lastnameCheckout();
		postalCodeCheckout();
	}
	
	@FindBy(id="continue")
	WebElement clickOnContinue;
	public void clickOnContinue()
	{
		clickOnContinue.submit();
	}
	
	@FindBy(id="cancel")
	WebElement clickOnCancel;
	public void clickOnCancel()
	{
		clickOnCancel.click();
	}
	
	public void checkoutMethods()
	{
		checkoutForm();
		clickOnContinue();
		clickOnCancel();
	}
	
	

}
