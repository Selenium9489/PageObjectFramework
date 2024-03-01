package com.zoho.suite.testcases.creation;

import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoho.base.TestBase;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.dataprovider.TestDataProvider;
import com.zoho.pages.normal.EnterUsernamePage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.session.ZohoTestSession;
import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;

public class CreateLeadTest extends TestBase {
	
	
	

	
	@Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
	public void createLeadTest(Hashtable<String,String> data) {
		session.log(data.toString());
		
		if(!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
				// skip in extent rep
				session.skipTest("Skipping the test as Runmode was NO");
				//skip - testng
				throw new SkipException("Skipping the test as Runmode was NO");
	   }
			
			             new LaunchPage()
					    .openBrowser("chrome")
					    .gotoHomePage()
					    .validator(false).validateTitle(Constants.HOME_PAGE_TITLE)// returns home page object , dont have to stop 		   
					    .gotoEnterUsernamePage()
					    .submitUsername(Constants.DEFAULT_USERNAME)
					    .validator(true).validateElementPresence(Constants.PASSWORD_LOCATOR)
			 			.submitPassword(Constants.DEFAULT_PASWD)
			 			.validateIntermediatePageOptions()
			 			.goToDefaultLandingPage()
			 			.getHeader().create("lead")
			 			.submitLeadDetails(data.get("LeadCompany"),data.get("LeadName"))
			 			//.validateleadDeails();
			 			.validator(true).validateText(Constants.LEAD_NAME_DISPLAYED_LOCATOR, data.get("LeadName"))
			 			.validator(true).validateText(Constants.LEAD_COMPANY_DISPLAYED_LOCATOR, data.get("LeadCompany"))
			 			.gotoLeadsPage();
			 			//.validateLeadPresenceInList();
			             
			             session.end();
			 			
			
	}
	

}
