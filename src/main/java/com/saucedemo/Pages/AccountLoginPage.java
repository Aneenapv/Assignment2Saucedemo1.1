package com.saucedemo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestBase.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	
	private void username(String user)
	{
		username.sendKeys(user);
	}
	
	private void password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	private void clickOnLoginButton()
	{
		loginButton.submit();
	}
	
	
	public InventoryPage loginToMyAccount(String user, String pwd)
	{
		username(user);
		password(pwd);
		clickOnLoginButton();
		return new InventoryPage();
		
		
	}

	
	
}
