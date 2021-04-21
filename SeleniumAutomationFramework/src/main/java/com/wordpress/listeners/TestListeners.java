package com.wordpress.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.wordpress.reports.ExtentLogger;
import com.wordpress.reports.ExtentReport;

public class TestListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addCategories(result.getTestClass().getRealClass().getAnnotation(com.wordpress.annotations.ExtentReport.class).category());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName());
		ExtentLogger.info(result.getThrowable().toString());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// This method is not yet implemented
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentReport.initializeReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.flushReport();
		
	}

}
