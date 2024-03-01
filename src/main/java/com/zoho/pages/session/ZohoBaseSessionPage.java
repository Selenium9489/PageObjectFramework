package com.zoho.pages.session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.pages.components.common.session.Header;

public class ZohoBaseSessionPage extends ZohoBasePage{

	Header header;
	
	@FindBy(css=Constants.DATE_MONTH_YEAR)
	public WebElement dateMonth;
	@FindBy(css=Constants.DATE_MONTH_FORWARD)
	public WebElement forward;
	@FindBy(css=Constants.DATE_MONTH_BACKWARD)
	public WebElement backward;
	
	public ZohoBaseSessionPage() {
		header = new Header(getCurrentDriver());
	}
	
	public Header getHeader() {
		return header;
	}
	
	public void selectDateFromCalendar(String date) {
    	try {
        	Date currentDate = new Date();
			Date dateToBeSelected = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			String day = new SimpleDateFormat("dd").format(dateToBeSelected);
			String month = new SimpleDateFormat("MMMM").format(dateToBeSelected);
			String year = new SimpleDateFormat("yyyy").format(dateToBeSelected);
			String monthYear=month+" "+year;
			while(!dateMonth.getText().equals(monthYear)){
				System.out.println(dateMonth.getText()+" --- "+monthYear);
				
				if(currentDate.compareTo(dateToBeSelected) > 0)
					backward.click();
				else if(currentDate.compareTo(dateToBeSelected) < 0)
					forward.click();
					
			}
			
			getCurrentDriver().findElement(By.xpath("//td[text()='"+day+"'")).click();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
	public void getRowWithCellData(String data) {
		
	}
}
