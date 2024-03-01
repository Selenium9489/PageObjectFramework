package com.zoho.base.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.How;


public class Constants {
	public static final String GRIDRUN = "N";

	public static final String ID="id";
	public static final String NAME="name";
	public static final String XPATH="XPATH";
	public static final String CSS="CSS";
	
	public static final String DEFAULT_USERNAME="sachintester.1983@gmail.com";
	public static final String DEFAULT_PASWD="Whizdom@2020";
	
	public static final String LOGIN_LINK="a.zh-login";
	public static final By LOGIN_LINK_LOCATOR=By.cssSelector(LOGIN_LINK);
	
	public static final String LOGIN_ID = "login_id";
	public static final By LOGIN_ID_LOCATOR=By.id(LOGIN_ID);
	
	public static final String NEXT_BUTTON = "//button[@id='nextbtn']/span[text()='Next']";
	public static final By NEXT_BUTTON_LOCATOR=By.xpath(NEXT_BUTTON);
	
	public static final String PASSWORD = "password";
	public static final By PASSWORD_LOCATOR=By.id(PASSWORD);
	
	public static final String SIGNIN_BUTTON = "//button[@id='nextbtn']/span[text()='Sign in']";
	public static final By SIGNIN_BUTTON_LOCATOR=By.xpath(SIGNIN_BUTTON);
	
	public static final String HOMEPAGE_TEXT = "//*[@id='block-system-main']/div[1]/div/h1";
	public static final By HOMEPAGE_TEXT_LOCATOR=By.xpath(HOMEPAGE_TEXT);
	
	public static final String DIV_FIRST_COL = "div.zl-nth-child1";
	public static final By DIV_FIRST_COL_LOCATOR=By.cssSelector(DIV_FIRST_COL);
	
	public static final String DIV_SECOND_COL = "div.zl-nth-child2";
	public static final By DIV_SECOND_COL_LOCATOR=By.cssSelector(DIV_SECOND_COL);
	
	public static final String DIV_THIRD_COL = "div.zl-nth-child3";
	public static final By DIV_THIRD_COL_LOCATOR=By.cssSelector(DIV_THIRD_COL);
	
	public static final String DIV_FOURTH_COL = "div.zl-nth-child4";
	public static final By DIV_FOURTH_COL_LOCATOR=By.cssSelector(DIV_FOURTH_COL);
	
	public static final String CRM_LINK = "//div[text()='CRM']";
	public static final By CRM_LINK_LOCATOR=By.xpath(DIV_FOURTH_COL);
	
	public static final String ADD_ICON = "span#createIcon";
	public static final By ADD_ICON_LOCATOR=By.cssSelector(ADD_ICON);
	
	public static final String LEAD_HEADER = "//a[text()='Leads']";
	public static final By LEAD_HEADER_LOCATOR=By.xpath(LEAD_HEADER);
	
	public static final String SUBMENU_LEADS = "submenu_Leads";
	public static final By SUBMENU_LEADS_LOCATOR=By.id(SUBMENU_LEADS);
	
	public static final String SUBMENU_CONTACTS = "submenu_Contacts";
	public static final By SUBMENU_CONTACTS_LOCATOR=By.id(SUBMENU_CONTACTS);
	
	public static final String SUBMENU_TASKS = "submenu_Tasks";
	public static final By SUBMENU_TASKS_LOCATOR = By.id(SUBMENU_TASKS);
	
	public static final String CONTACTS_HEADER = "//a[text()='Contacts']";
	public static final By CONTACTS_HEADER_LOCATOR = By.xpath(CONTACTS_HEADER);
	
	public static final String LEAD_COMPANY = "Crm_Leads_COMPANY";
	public static final By LEAD_COMPANY_LOCATOR = By.id(LEAD_COMPANY);
	
	public static final String LEAD_LAST_NAME = "Crm_Leads_LASTNAME";
	public static final By LEAD_LAST_NAME_LOCATOR = By.id(LEAD_LAST_NAME);
	
	public static final String LEAD_SAVE = "saveLeadsBtn";
	public static final By LEAD_SAVE_LOCATOR = By.id(LEAD_SAVE);
	
	public static final String LEAD_NAME_DISPLAYED ="div#detailViewButtonLayerMainTableContainer span#subvalue_LASTNAME";
	public static final By LEAD_NAME_DISPLAYED_LOCATOR=By.cssSelector(LEAD_NAME_DISPLAYED);
	
	public static final String LEAD_COMPANY_DISPLAYED ="div#detailViewButtonLayerMainTableContainer span#subvalue_COMPANY";
	public static final By LEAD_COMPANY_DISPLAYED_LOCATOR=By.cssSelector(LEAD_COMPANY_DISPLAYED);
	
	public static final String LEAD_BACKBUTTON ="span.backtoIcon.dIB.mT15";
	public static final By LEAD_BACKBUTTON_LOCATOR=By.cssSelector(LEAD_BACKBUTTON);
	
	public static final String DATE_MONTH_YEAR = "span.sCalMon";
	public static final By DATE_MONTH_YEAR_LOCATOR=By.cssSelector(DATE_MONTH_YEAR);
	
	public static final String DATE_MONTH_FORWARD = "span.calNav.dRgt";
	public static final By DATE_MONTH_FORWARD_LOCATOR=By.cssSelector(DATE_MONTH_FORWARD);
	
	public static final String DATE_MONTH_BACKWARD = "span.calNav.dLft";
	public static final By DATE_MONTH_BACKWARD_LOCATOR=By.cssSelector(DATE_MONTH_BACKWARD);
	
	
	// titles
	public static final String HOME_PAGE_TITLE = "Zoho - Cloud Software Suite and SaaS Applications for Businesses";
	
	// report path
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"//reports//";
	public static final How CSS_SEL = How.CSS;
	
	/// data
	public static final String[] intermediatePageOptions= {"Books","Connect","Mail","WorkDrive","Calendar","CRM","Meeting","Writer","Campaigns","Desk","Sheet","Cliq","Invoice","Show"};
	
	// sheet names
	public static final String TEST_STATUS_SHEET = "Test Status";
	
	//col names
	public static final Object COL_SUBJECT = "Subject";
	public static final Object COL_DATE = "Date";
	public static final String TCID = "TCID";
	public static final String RUNMODE = "Runmode";
	
	
	
	
	
	
		
}
