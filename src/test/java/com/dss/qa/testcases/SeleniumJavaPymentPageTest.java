package com.dss.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dss.qa.Base.Basepage;
import com.dss.qa.pages.HomePage;
import com.dss.qa.pages.Landingpage_using_pagefactory;
import com.dss.qa.pages.Paymentpage;
import com.dss.qa.pages.SeleniumJavapage;

public class SeleniumJavaPymentPageTest extends Basepage {
	public WebDriver driver;

	public Landingpage_using_pagefactory lp;

	public HomePage hp;

	public SeleniumJavapage sjp;

	public SeleniumJavaPymentPageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		test = reports.createTest("Validating the Paymnet page");
		// base page
		driver = initializationAndOpenApplication(prop.getProperty("browser"));
		Thread.sleep(2000);
		lp = new Landingpage_using_pagefactory(driver,test);
		Thread.sleep(2000);
		// log in functionality
		hp = lp.loginwithValidCredentials();

	}

	@Test
	public void validate_seleniumJava_paymentpage() throws IOException, InterruptedException {
		// selected the required course
		sjp = hp.clickCourseMenu();
		Thread.sleep(2000);
		// click on the enrollnow button
		Paymentpage pp = sjp.clickEnrollnowBtn();

		// method -1 : we are capturing pagetitle

		/*
		 * String actualTitle =driver.getTitle(); String expectedTitle ="Payments";
		 * Assert.assertEquals(actualTitle, expectedTitle);
		 */

		// Method -2: here we are using page factory to fetch the course name, the logic
		// is inside payment page
		String Actualcoursevalue = pp.checkCoursename();
		String expectedCoursevalue = "Manual + Selenium Testing Package";

		Assert.assertEquals(Actualcoursevalue, expectedCoursevalue);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
