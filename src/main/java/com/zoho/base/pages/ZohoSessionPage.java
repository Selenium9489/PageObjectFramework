package com.zoho.base.pages;

import java.util.Hashtable;

import com.zoho.pages.components.common.session.Header;
import com.zoho.pages.session.lead.LeadDetailsPage;
import com.zoho.pages.session.lead.LeadsPage;
import com.zoho.pages.session.task.TaskPage;

public interface ZohoSessionPage {
	 // Zoho - session
    void createDeal();
    void logout();
    ZohoPage validateIntermediatePageOptions();
    ZohoPage goToDefaultLandingPage();
    Header getHeader();
    LeadDetailsPage submitLeadDetails(String leadCompany, String leadLastName);
    LeadsPage gotoLeadsPage();
    TaskPage createTask(Hashtable<String,String> data);
    void selectDateFromCalendar(String date);
}
