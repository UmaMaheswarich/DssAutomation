package com.dss.qa.testcases;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dss.qa.Base.Basepage;
import com.dss.qa.pages.HomePage;
import com.dss.qa.pages.Landingpage_using_pagefactory;
import com.dss.qa.pages.RequiredCoursePage;
import com.dss.qa.utils.TestUtility;
public class CoursesusingDataproviders extends Basepage {
	public Landingpage_using_pagefactory lp;
	public HomePage hp;
	String sheetname = "Sheet1";
	
	public CoursesusingDataproviders() {
		super();
	}

	@DataProvider(name = "CourseNameDetails")
	public Object[][] getdata() throws InvalidFormatException {
		// reading the data from the TestUtility class
		Object[][] data = TestUtility.getTestData(sheetname);
		return data;
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {

		// initializesd the browser and open the application
		driver = initializationAndOpenApplication(prop.getProperty("browser"));
		// work on the login functionality
		lp = new Landingpage_using_pagefactory(driver,test);
		// login
		hp = lp.loginwithValidCredentials();
	}

	@Test(dataProvider = "CourseNameDetails")
	public void validatecourses(String Course) {
		// cliking the course menu and clicking the courses which are mentioned inthe xl;

		RequiredCoursePage rp = hp.clickrequiredCourses(Course);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
