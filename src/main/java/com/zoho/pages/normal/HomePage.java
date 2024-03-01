package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;



public class HomePage extends ZohoBasePage{

	//@FindBy(css =Constants.LOGIN_LINK)
	@FindBy(css=Constants.LOGIN_LINK)
	WebElement loginLink;
	
	
	
	public ZohoPage gotoEnterUsernamePage() {// 20 elements
		log("Going to username page");
		loginLink.click();
		return new EnterUsernamePage();
	}
	
}
