package com.dss.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
public  static String captureScreenshots(WebDriver driver, String testname) {
		

		File scrennshotpath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destinationpath = System.getProperty("user.dir") + "\\Screenshots\\" + testname + ".png";

		try {
			FileUtils.copyFile(scrennshotpath, new File(destinationpath));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return destinationpath;
	}

}
