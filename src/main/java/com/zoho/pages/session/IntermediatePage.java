package com.zoho.pages.session;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

public class IntermediatePage extends ZohoBaseSessionPage{
	
	// @FindAll -  satisfys each one
	// @FindBys -  box -element inside element
	
	/*
	@FindBys({
		   @FindBy(id = "zl-myapps"),
		   @FindBy(tagName = "a")
		})
	public List<WebElement> pageOptions;
	*/
	
	@FindAll({
		 @FindBy(css = Constants.DIV_FIRST_COL), //4
		 @FindBy(css = Constants.DIV_SECOND_COL),//4
		 @FindBy(css = Constants.DIV_THIRD_COL),//3
		 @FindBy(css = Constants.DIV_FOURTH_COL),//3
	})
	public List<WebElement> pageOptions;
	
	
	@FindBy(xpath = Constants.CRM_LINK)
	public WebElement crmLink;
	
	public ZohoPage validateIntermediatePageOptions() {
		System.out.println(pageOptions.size());
		
		List<String> intermediatePageOptions = Arrays.asList(Constants.intermediatePageOptions);
		for(WebElement e: pageOptions) {
			System.out.println(e.getText()+" -- "+intermediatePageOptions.contains(e.getText()));
			if(!intermediatePageOptions.contains(e.getText()))
			   validator(false).fail("Option not found "+ e.getText());
		}
	
		return this;
	}
	
	public ZohoPage goToDefaultLandingPage() {
		crmLink.click();
		waitForPageToLoad();
		return new DefaultLandingPage();
	}
	

}
