package com.saucedemo.PageTests;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.saucedemo.Pages.AccountLoginPage;
import com.saucedemo.Pages.InventoryPage;
import com.saucedemo.TestBase.TestBase;
import com.saucedemo.Utils.ExcelUtils;

public class AccountLoginPageTest extends TestBase {
	
	AccountLoginPage loginPage;
	InventoryPage inventoryPage;
	
	
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage =new AccountLoginPage();
		
	}
	
	
	@Test(dataProvider = "Book2")
	public void validateLoginWithValidCredentials(String user,String pwd) {
		inventoryPage = loginPage.loginToMyAccount(user,pwd);
		String getInventoryText = inventoryPage.getInventoryText();
		Assert.assertEquals("Swag Labs",getInventoryText,"Not showing Swag Labs");
		inventoryPage.logout();
	}
	
	
	@DataProvider(name ="Book2")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "C:\\Users\\johng\\OneDrive\\Desktop\\Book2.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
	
	@Test
	public void validateLoginWithValidCredentials()
	{
		inventoryPage = loginPage.loginToMyAccount("standard_user","secret_sauce");
		String getInventoryText = inventoryPage.getInventoryText();
		Assert.assertEquals("Swag Labs",getInventoryText,"Not showing Swag Labs");
		inventoryPage.logout();
	}
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}

}
