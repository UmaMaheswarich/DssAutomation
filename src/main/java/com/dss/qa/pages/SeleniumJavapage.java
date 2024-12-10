package com.dss.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dss.qa.Base.Basepage;

public class SeleniumJavapage extends Basepage {
	
	@FindBy(xpath = "//button[contains(text(),'Enroll Now')]")
	WebElement EnrollBtn;

	public SeleniumJavapage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	public void  clickNewWebinarsBtn() {
		
		
	}
	
	public Paymentpage clickEnrollnowBtn() throws  InterruptedException {
		
		Thread.sleep(2000);
		EnrollBtn.click();
		return new Paymentpage(driver);
		
		
	}
	
	public void clickDownloadcurriculum() {
		
		
	}
}
