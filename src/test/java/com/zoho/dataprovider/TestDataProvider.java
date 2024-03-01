package com.zoho.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;

public class TestDataProvider {

	
	
	@DataProvider
	public static Object[][] getData(Method m){		
		System.out.println("Getting data for "+ m.getName());
		Object[][] data= new DataUtil().getData(m.getName(), new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx"));
		System.out.println("Got data for "+ m.getName());
		return data;
	}
	

	
	
}
