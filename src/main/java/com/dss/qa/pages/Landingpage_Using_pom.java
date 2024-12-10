package com.dss.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dss.qa.Base.Basepage;

public class Landingpage_Using_pom extends Basepage {

	public Landingpage_Using_pom(WebDriver driver)  {
		this.driver = driver;

	}

	// pom:initializing the webelements

	By LoginMenu = By.xpath("//a[@class ='nav-link dropdown-toggle'  and contains(text(),'Login')]");

	By Emailid = By.id("EmailId");
	By password = By.id("Password");
	By submit_btn = By.xpath("//button[contains(text(),'Login')]");

	// pom-- Page Object model, it is design pattern -- ( we will intialize
	// individually)

	// page factory --- it is class which is their in selenium webdriver which is
	// used pom .-- ( only once at the class level)

	public void loginwithValidCredentials() throws InterruptedException {

		driver.findElement(LoginMenu).click();
		driver.findElement(Emailid).sendKeys(prop.getProperty("email"));
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(submit_btn).click();

	}

	public void loginwithInValidCredentials() throws InterruptedException {

		driver.findElement(LoginMenu).click();
		driver.findElement(Emailid).sendKeys("test123@gmail.com");
		driver.findElement(password).sendKeys("test@123");
		Thread.sleep(1000);
		driver.findElement(submit_btn).click();

	}
}
