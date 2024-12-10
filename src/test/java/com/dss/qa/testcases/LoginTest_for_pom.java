package com.dss.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dss.qa.Base.Basepage;
import com.dss.qa.pages.Landingpage_Using_pom;

public class LoginTest_for_pom extends Basepage {

	public WebDriver driver;
	public Landingpage_Using_pom lp;

	public LoginTest_for_pom() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		// initializesd the browser and open the application
		driver = initializationAndOpenApplication(prop.getProperty("browser"));
		// work on the login functionality
		lp = new Landingpage_Using_pom(driver);

	}

	@Test(priority = 1)
	public void validateLoginWith_ValidCredentials() throws IOException, InterruptedException {

		// to read the logic inside the Landing page
		lp.loginwithValidCredentials();

	}

	@Test(priority = 2)
	public void validateLoginWith_InValidCredentials() throws IOException, InterruptedException {

		// to read the logic inside the Landing page
		lp.loginwithInValidCredentials();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
