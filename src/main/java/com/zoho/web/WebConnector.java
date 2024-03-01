package com.zoho.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public interface WebConnector extends ZohoWebConnector {

	void openBrowser(String bName);
	void navigate(String url);
	void quit();
	void waitForElementLoad();
	WebDriver getCurrentDriver();
	ZohoTestSession getSession();
	boolean isStopExecution();
    void setStopExecution(boolean stopExecution);
    void assertAll();
    SoftAssert getSoftAssert();
	void setSoftAssert(SoftAssert softAssert);
	void log(String message);
	void fail(String message);
	
	
	
}
