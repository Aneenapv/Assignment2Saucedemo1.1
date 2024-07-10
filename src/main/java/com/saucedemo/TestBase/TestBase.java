package com.saucedemo.TestBase;

import java.time.Duration;


import org.apache.log4j.BasicConfigurator;
	import org.apache.log4j.Level;
	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.saucedemo.Browsers.Browsers;
import com.saucedemo.listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase {
		
		public static WebDriver driver;
		//private final String browser = "chrome";
		
		// introduced enum.. browsers is class name for enums. 
		//enums are constant so that we can call by classnamme.enumvalue
		
		private final Browsers browser = Browsers.CHROME;
		private final String URL="https://www.saucedemo.com/";
		
		public static Logger logger;
		public WebdriverEvents events;
		@SuppressWarnings("deprecation")
		public EventFiringWebDriver  eDriver;
		
		
		public void initialise()
		{
			initialiseWebdriver();
			driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 driver.get(URL);
			
		}
		
		@BeforeClass
		public void setUpLogger()
		{
			logger = Logger.getLogger(TestBase.class);
			PropertyConfigurator.configure("log4j.properties");
			BasicConfigurator.configure();
			logger.setLevel(Level.ALL);
		}


		
		private void initialiseWebdriver() {
			
			String browser = System.getProperty("browser", Browsers.CHROME.toString().toUpperCase());
			
			
			switch(Browsers.valueOf(browser))
			
			//switch(browser)
			//switch(browser.getBrowserNameWithCompanies())
			{
			//case "chrome" : 
			case CHROME:
			//case "Google Chrome":
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			//case "firefox" : 
			case FIREFOX:
			//case "Mozilla Firefox":
				WebDriverManager.firefoxdriver().setup();
				driver =  new FirefoxDriver();
				break;
				
			//case "edge" : 
			case EDGE:
			//case "Microsoft Edge":
				WebDriverManager.edgedriver().setup();
				driver =  new EdgeDriver();
				break;
				
				default: 
					throw new InvalidArgumentException("enter correct browser name");
			}
			
			// initializing event firing web driver and web driver event
			eDriver = new EventFiringWebDriver(driver);
			
			events = new WebdriverEvents();
			
			//register the event
			eDriver.register(events);
			driver = eDriver;
			
		}
		
		public void selectDropdown(WebElement element,String value,String text)
		{
		Select select = new Select(element);
		try
		{
			select.selectByValue(value);
		}
		catch(Exception e)
		{
			select.selectByVisibleText(text);
		}
		
		}
		
		
		
		public void tearDown()
		{
			driver.quit();
		}
		
		
		

	}



