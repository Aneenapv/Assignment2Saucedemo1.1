package com.saucedemo.Pages;

import java.time.Duration;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.TestBase.TestBase;

public class InventoryPage extends TestBase{
	
	WebDriverWait wait;

	public InventoryPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="div.header_label div")
	WebElement inventoryTitle;
	
	public String getInventoryText()
	{
		return inventoryTitle.getText().trim();
	}
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement hamburgerMenuButton;
	
	public void hamburgerMenuButton()
	{
		hamburgerMenuButton.click();
	}
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement clickOnLogout;
	
	public void clickOnLogout()
	{
		clickOnLogout.click();
	}
	
	public void logout()
	{
		hamburgerMenuButton();
		wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ById.id("logout_sidebar_link")));
		clickOnLogout();
	}
	
	
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement backpackToCart;
	public void backpackToCart()
	{
		backpackToCart.click();
		
	}
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement clickOnShoppingCart;
	public void clickOnShoppingCart()
	{
		clickOnShoppingCart.click();
	}
	
	public CartPage addToCart()
	{
		 backpackToCart();
		 clickOnShoppingCart();
		 return new CartPage();
	}
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	WebElement onesieToCart;
	public void onesieToCart()
	{
		onesieToCart.click();
	}
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement clickOnFilter;
	
	public void  clickOnFilter()
	{
		//Select select = new Select(clickOnFilter);
		//select.selectByVisibleText("Price (low to high)");
		selectDropdown(clickOnFilter,"lohi","Price (low to high)");
	}
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement addBikeLight;
	public void addBikeLight()
	{
		addBikeLight.click();
	}

	public void addOnesieAndBikeLightSteps()
	{
		onesieToCart();
		clickOnFilter();
		addBikeLight();
		clickOnShoppingCart();
	}
}
