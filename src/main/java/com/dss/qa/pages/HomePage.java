package com.dss.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dss.qa.Base.Basepage;

public class HomePage extends Basepage {

	@FindBy(linkText = "Courses")
	WebElement course_toggle;

	@FindBy(linkText = "Selenium Testing with Java")
	WebElement selenium_java_course;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public SeleniumJavapage clickCourseMenu() throws IOException {

		course_toggle.click();

		selenium_java_course.click();

		return new SeleniumJavapage(driver);
	}
	
	
	public RequiredCoursePage clickrequiredCourses(String Course) {
		//click the course Menu
		course_toggle.click();
		//click diff. courses by using dynamic xpath
		WebElement courses = driver.findElement(By.xpath("//li/a[contains(text(),'"+Course+"')]"));
		courses.click();
		return new RequiredCoursePage(driver);
		
	}

}
