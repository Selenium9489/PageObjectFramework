package com.zoho.base.pages;

import java.util.Hashtable;

import com.zoho.pages.components.common.session.Header;
import com.zoho.pages.session.lead.LeadDetailsPage;
import com.zoho.pages.session.lead.LeadsPage;
import com.zoho.pages.session.task.TaskPage;
import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public interface ZohoPage extends ZohoNormalPage,ZohoSessionPage{
	// normal browser operations
	ZohoPage openBrowser(String browser);
    void quit();
    void getTotalWindows();
    ZohoTestSession getSession();
    

    // ZOHO based normal
    ZohoPage gotoHomePage();
    void goToRegisterPage();
    ZohoPage submitUsername(String userid);
    ZohoPage submitPassword(String userid);
    WebConnector validator(boolean flagAssertionType);
    ZohoPage gotoEnterUsernamePage();
    
    // Zoho - session
    void createDeal();
    void logout();
    void log(String message);
    ZohoPage validateIntermediatePageOptions();
    Header getHeader();
    LeadDetailsPage submitLeadDetails(String leadCompany, String leadLastName);
    LeadsPage gotoLeadsPage();
    TaskPage createTask(Hashtable<String,String> data);
    void selectDateFromCalendar(String date); 

    
}
