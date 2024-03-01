package com.zoho.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zoho.base.pages.ZohoPage;

public interface ZohoWebConnector {
	
	
	void logout();
	ZohoPage validateTitle(String expectedTitle);
	ZohoPage validateText(By locator,String expectedText);
	boolean isElementPresent(By locator);
	void validateLogin();
	ZohoPage validateElementPresence(By locator);
    WebDriver getCurrentDriver();
	


}
