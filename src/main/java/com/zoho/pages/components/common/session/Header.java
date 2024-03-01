package com.zoho.pages.components.common.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.session.contacts.ContactsPage;
import com.zoho.pages.session.contacts.NewContactPage;
import com.zoho.pages.session.lead.LeadsPage;
import com.zoho.pages.session.lead.NewLeadPage;

public class Header {
	
	@FindBy(css=Constants.ADD_ICON)
	public WebElement addIcon;
	@FindBy(xpath=Constants.LEAD_HEADER)
	public WebElement leads;
	@FindBy(xpath=Constants.CONTACTS_HEADER)
	public WebElement contacts;
	@FindBy(id=Constants.SUBMENU_LEADS)
	public WebElement submenuLead;
	@FindBy(id=Constants.SUBMENU_CONTACTS)
	public WebElement submenuContact;
	@FindBy(id=Constants.SUBMENU_TASKS)
	public WebElement submenuTasks;
	
	public Header(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		
	}
	
	public ZohoPage create(String elementText) {
		
		addIcon.click();
		if(elementText.equals("lead")) {
			submenuLead.click();
			return new NewLeadPage();
		}else if(elementText.equals("contacts")) {
			submenuContact.click();
			return new NewContactPage();
		}else if(elementText.equals("task")) {
			submenuTasks.click();
			return new NewContactPage();
		}
		// report a failure and stop
		return new ZohoBasePage();
		
	}
	
	public ZohoPage goToLeads() {
		leads.click();
		return new LeadsPage();
		
	}

	public ZohoPage goToContacts() {
		contacts.click();
		return new ContactsPage();
		
	}
}
