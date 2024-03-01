package com.zoho.reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	static ExtentReports report;
	public static String screenshotFolderPath;
	
	public static ExtentReports getReport(String basePath) {
		if(report==null) {
			// report folder generation
			Date d = new Date();
			System.out.println(d.toString().replaceAll(":","-"));
			String reportFolder=d.toString().replaceAll(":","-");
			String path = basePath+reportFolder+"\\screenshots";
			screenshotFolderPath=basePath+reportFolder+"\\screenshots\\";
			File file  = new File(path);
			file.mkdirs();
			System.out.println(path);
			 // finalize the report config
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(basePath+reportFolder);
			sparkReporter.config().setReportName("Production Regression Testing");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("utf-8");
			// init the report
			report = new ExtentReports();
			report.attachReporter(sparkReporter);
		}
		
		return report;
		
	}
	
	
}
