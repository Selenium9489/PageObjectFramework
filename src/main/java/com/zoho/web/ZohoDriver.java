package com.zoho.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.zoho.base.pages.Constants;
import com.zoho.listener.ZohoEventListener;

public class ZohoDriver extends ZohoValidationDriver{
	public void logout() {
		
		
	}

	public void openBrowser(String bName) {
		log("Opening the browser "+bName );
		
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.setBinary("C:\\Users\\lramk\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		listener = new ZohoEventListener();
      
	
	//	System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	//	System.setProperty("webdriver.chrome.driver", "D:\\Ashish\\softwares\\drivers\\chromedriver.exe");
	
		
		if(Constants.GRIDRUN.equals("Y")) 
		{
			// desired capabilities
			DesiredCapabilities cap = new DesiredCapabilities();
			if(bName.equalsIgnoreCase("chrome")) {
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
			}else if(bName.equalsIgnoreCase("mozilla")) {
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
			}
			
			try {
				driver = new EventFiringDecorator(listener).decorate(new RemoteWebDriver(new URL("http://localhost:4444"),cap));
			//	driver = new EventFiringWebDriver(new RemoteWebDriver(new URL("http://localhost:4444"),cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				setStopExecution(true);
				fail("Unable to launch test on hub "+ e.getMessage());
			}
			
			
			
			
			
			
		}else {// normal run
			driver = new EventFiringDecorator(listener).decorate(webdriver);
			
			
		 
			if(bName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setBinary("C:\\Users\\lramk\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
				listener = new ZohoEventListener();
		        webdriver = new ChromeDriver(options);
		        driver = new EventFiringDecorator(listener).decorate(webdriver);
			}else if(bName.equalsIgnoreCase("mozilla")) {
				driver = new EventFiringDecorator(listener).decorate(webdriver);// Launching the LaunchPage

			}
		
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	}

	public void navigate(String url) {
		log("URL"+url );
		driver.get(url);
		
	}

	public void quit() {
		if(driver!=null)
		   driver.quit();
		
	}
	
	public WebDriver getCurrentDriver() {
		return driver;
	}

	public void waitForElementLoad() {
		
		
	}

}
