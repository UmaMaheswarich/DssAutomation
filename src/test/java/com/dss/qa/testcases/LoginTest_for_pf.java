package com.dss.qa.testcases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dss.qa.Base.Basepage;
import com.dss.qa.pages.Landingpage_using_pagefactory;

public class LoginTest_for_pf extends Basepage {

	public LoginTest_for_pf() throws IOException {
		super();
	}

	public WebDriver driver;
	public Landingpage_using_pagefactory lp;

	@BeforeMethod
	public void setup() throws IOException {

		test = reports.createTest("Validating the Login Functionality");
		// initializesd the browser and open the application
		driver = initializationAndOpenApplication(prop.getProperty("browser"));
		// work on the login functionality
		lp = new Landingpage_using_pagefactory(driver, test);
	}

	@Test(priority = 1)
	public void validateLoginWith_ValidCredentials() throws IOException, InterruptedException {

		// to read the logic inside the Landing page
		lp.loginwithValidCredentials();

		test.log(Status.PASS, "The login was succesfull");
	}

	@Test(priority = 2)
	public void validateLoginWith_InValidCredentials() throws IOException, InterruptedException {

		// to read the logic inside the Landing page
		lp.loginwithInValidCredentials();
	}

	@AfterMethod
	public void tearDown() throws IOException {
		// This method will generate the report
		reports.flush();

		Desktop.getDesktop().browse(new File(path).toURI());

		driver.quit();
	}

}
