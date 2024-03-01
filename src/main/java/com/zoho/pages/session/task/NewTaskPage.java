package com.zoho.pages.session.task;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.pages.session.ZohoBaseSessionPage;

public class NewTaskPage extends ZohoBaseSessionPage{
	@FindBy(id="Crm_Tasks_SUBJECT")
	public WebElement subject;
	@FindBy(id="Crm_Tasks_DUEDATE")
	public WebElement calendar;
	@FindBy(id="Crm_Tasks_CONTACTID_img")
	public WebElement searchContact;
	
	
	public TaskPage createTask(Hashtable<String,String> data) {
		subject.sendKeys(data.get(Constants.COL_SUBJECT));
		calendar.click();
		selectDateFromCalendar(data.get(Constants.COL_DATE));
		// contact selection from webtable
		// getRowWithCellData
		return new TaskPage();
	}

}
