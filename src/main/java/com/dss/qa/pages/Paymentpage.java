package com.dss.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dss.qa.Base.Basepage;

public class Paymentpage extends Basepage{
	
	@FindBy(xpath  = "//input[@title='Manual + Selenium Testing Package']")
	WebElement coursename;

	public Paymentpage(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkCoursename() {
		
		String actualCoursename =coursename.getAttribute("value");
		 return actualCoursename;
		
		
	}

}
