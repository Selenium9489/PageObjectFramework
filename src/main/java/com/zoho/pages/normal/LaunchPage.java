package com.zoho.pages.normal;

import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public class LaunchPage extends ZohoBasePage{
	
	

    public ZohoPage openBrowser(String browser) {
    	//ZohoTestSession session = getSession();
    	//session.getCon().openBrowser("browser");
    	getDriver().openBrowser(browser);
    	return this;
    }
    
	public ZohoPage gotoHomePage() {
		log("Navigaing to https://zoho.com");
		getDriver().navigate("https://zoho.com");
		return new HomePage();
	}



}
