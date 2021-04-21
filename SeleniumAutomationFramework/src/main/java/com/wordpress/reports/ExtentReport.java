package com.wordpress.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.wordpress.constants.FilePathConstants;
import com.wordpress.enums.ExtentReportEnums;

public final class ExtentReport {

	private ExtentReport() {
		
	}
	
	private static ExtentReports extent;
	
	public static void initializeReport() {
	    if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FilePathConstants.getExtentreportFilepath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("WordPress Automation Report");
	  }
	}
	
	public static void flushReport() {
		if(Objects.nonNull(extent)) {
		extent.flush();	
	  }
		
	}
	
	public static void createTest(String testcasename) {
		ExtentTest test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
	
	public static void addCategories(ExtentReportEnums[] categories) {
		for(ExtentReportEnums temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
	
	
}
