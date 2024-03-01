package com.zoho.listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoEventListener extends AbstractWebDriverEventListener implements WebDriverListener{
	
	public void beforeFindBy(By locator, WebElement element, WebDriver driver) {
		
		// validate the presence and visiblity
		// certainly fail
		//System.out.println("--->"+getSession().isExecuteListener());
		if(getSession().isExecuteListener()) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
			}catch(TimeoutException e) {
				getDriver().fail("Element not found - "+locator);
				//getDriver().assertAll();
			}
		}
	}
	
	public WebConnector getDriver() {
		return getSession().getCon();
	}
	
	public ZohoTestSession getSession() {
		return (ZohoTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public void log(String message) {
			getSession().log(message);
	}
	

}
