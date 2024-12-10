package com.dss.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dss.qa.Base.Basepage;

public class Landingpage_using_pagefactory extends Basepage {

	// pagefactory: object repository

	@FindBy(xpath = "//a[@class ='nav-link dropdown-toggle'  and contains(text(),'Login')]")
	WebElement LoginMenu;

	@FindBy(id = "EmailId")
	WebElement email_id;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement submit_btn;

	public Landingpage_using_pagefactory(WebDriver driver, ExtentTest test) throws IOException {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public HomePage loginwithValidCredentials() throws InterruptedException, IOException {

		test.log(Status.INFO, "Clicking on the login menu");
		captureScreenshots(driver, test);
		LoginMenu.click();
		test.log(Status.INFO, "Entering the email id");
		email_id.sendKeys(prop.getProperty("email"));
		test.log(Status.INFO, "providing the valid password");
		password.sendKeys(prop.getProperty("password"));
		Thread.sleep(1000);
		captureScreenshots(driver, test);
		test.log(Status.INFO, "Clicking the submit button");

		submit_btn.click();
		return new HomePage(driver,test);
	}

	public void loginwithInValidCredentials() throws InterruptedException {

		LoginMenu.click();
		email_id.sendKeys("tst123@gmail.com");
		password.sendKeys("Test@123");
		Thread.sleep(1000);
		submit_btn.click();
	}

}
