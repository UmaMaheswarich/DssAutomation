package com.dss.qa.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.dss.qa.Base.Basepage;

public class MyListeners extends Basepage implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started : " + context.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {

		test.log(Status.INFO, "Test Started :" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Passed:" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed:" + result.getMethod().getMethodName());

		test.log(Status.INFO, "Failure Reason: " + result.getThrowable().getMessage());

		try {
			captureScreenshots(driver, test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, "Test Skipped:" + result.getMethod().getMethodName());

		test.log(Status.INFO, "Reason for Skipping: " + result.getThrowable().getMessage());

		try {
			captureScreenshots(driver, test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Test Suite Finished: " + context.getName());

	}

}
