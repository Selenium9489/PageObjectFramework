package com.zoho.pages.session.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.pages.session.ZohoBaseSessionPage;

public class NewLeadPage extends ZohoBaseSessionPage{
	
	@FindBy(id=Constants.LEAD_COMPANY)
	public WebElement company;
	@FindBy(id=Constants.LEAD_LAST_NAME)
	public WebElement lastName;
	@FindBy(id=Constants.LEAD_SAVE)
	public WebElement saveLeadButton;
	
	public LeadDetailsPage submitLeadDetails(String leadCompany, String leadLastName) {
		company.sendKeys(leadCompany);
		lastName.sendKeys(leadLastName);
		saveLeadButton.click();
		//validator(true).isElementPresent(locator)
		return new LeadDetailsPage();
	}

}
