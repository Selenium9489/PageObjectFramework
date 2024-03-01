package com.zoho.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;


public abstract class ZohoValidationDriver implements WebConnector{
	WebDriverListener listener;
    WebDriver webdriver;
    WebDriver driver;
	boolean stopExecution;
	SoftAssert softAssert = new SoftAssert();


	public void validateLogin() {
		System.out.println("ZohoValidationDriver validateLogin");
		
	}

	public ZohoPage validateTitle(String expTitle) {
		log("Expedted Title "+ expTitle);
		log("Actual Title "+ driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), expTitle);
      //  System.out.println(" validateTitle Status is "+ isStopExecution());
		if(!expTitle.equals(driver.getTitle())) {
			fail("Titles do not match. Got title as "+driver.getTitle());
			
		}
		return getSession().getCurrentPage();
		
	}
	
	public ZohoPage validateText(By locator, String expectedText) {
		log("validateText");
		//Assert.assertEquals(actual, expected);
		String actualText = driver.findElement(locator).getText();
		log("Actual Text {"+actualText+"}. Expected Text {"+expectedText+"}");
		if(!expectedText.equals(actualText)) {
			fail("Text not Matching. Got text as "+actualText);
		}
		return getSession().getCurrentPage();
	}
	
	public ZohoPage validateElementPresence(By locator) {
		log("Validating element presence "+ locator);
		if(!isElementPresent(locator))
			fail("Element not found - "+locator);
		
		return getSession().getCurrentPage();
	}
	

	
	public ZohoPage validateElementNotPresence(By locator) {
		
		if(isElementPresent(locator))
			fail("Element not found - "+locator);
		
		return getSession().getCurrentPage();
	}
	
	//true - present
	//false - not present
	public boolean isElementPresent(By locator) {
		getSession().setExecuteListener(false);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}catch(TimeoutException e) {
			getSession().setExecuteListener(true);
			log("Element not found "+locator);
			return false;
		}
		getSession().setExecuteListener(true);
		log("Element found success fully "+locator);
		return true;
		
	}
	
	
	
	public void assertAll() {// control will come to stop the test.. some critical err
		// take screenshot
		softAssert.assertAll();
	}
	
	
	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
		
		
	}

	public ZohoTestSession getSession() {
		return (ZohoTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public SoftAssert getSoftAssert() {
		return softAssert;
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}
	
	public void log(String message) {
		getSession().log(message);
	}
	
	public void fail(String message) {
		// fail in extent reports
		getSession().failTest(message);
		
		// fail in testng
		softAssert.fail(message);
		
		// decide - if exec has to be stopped
		if(isStopExecution())
			assertAll();
	}
	
}
