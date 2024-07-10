package com.saucedemo.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.saucedemo.TestBase.TestBase;
import com.saucedemo.Utils.Utils;

public class CustomListener extends TestBase implements ITestListener {
	
	     public void onTestStart(ITestResult result) {
		   logger.info("Test started: "+result.getMethod().getMethodName());
		  }

		
		  public void onTestSuccess(ITestResult result) {
			  logger.info("Test success: "+result.getMethod().getMethodName());
		  }

		 
		  public void onTestFailure(ITestResult result) {
			  logger.info("Test failed: "+result.getMethod().getMethodName());
			  logger.info("Test Failed, taking screenshot!!!!");
			  Utils.takeFailedTestScreenShot(result.getMethod().getMethodName());
		  }

		
		  public void onTestSkipped(ITestResult result) {
			  logger.info("Test skipped: "+result.getMethod().getMethodName());
		  }

		
	

}
