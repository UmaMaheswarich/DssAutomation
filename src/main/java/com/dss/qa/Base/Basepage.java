package com.dss.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.dss.qa.utils.ExtentManager;
import com.dss.qa.utils.Screenshots;
import com.dss.qa.utils.TestUtility;

public class Basepage {

	public static WebDriver driver;

	public static Properties prop;

	public static ExtentTest test;

	public ExtentReports reports = ExtentManager.getExtentReports();
	public String path = ExtentManager.getreportpath();

	public Basepage() {
		// to use properties file which we have created
		prop = new Properties();

		File f = new File("D:\\Javaworks\\DssAutomation\\src\\main\\java\\com\\dss\\qa\\config\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public WebDriver initializationAndOpenApplication(String browsername) {

		if (browsername.equals("chrome")) {
			// logs which we can see the extent reports ( new steps for extent reports)

			test.log(Status.INFO, "Chrome browser should open");
			driver = new ChromeDriver();
			test.log(Status.INFO, "Chrome browser is opened successfully");

		} else if (browsername.equals("edge")) {
			driver = new EdgeDriver();
		}

		else if (browsername.equals("firefox")) {

			driver = new FirefoxDriver();
		}

		else if (browsername.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtility.PAGELOAD_OUT_TIME));
		// logs (new)
		test.log(Status.INFO, "Opening the website");

		driver.get(prop.getProperty("url"));

		// logs (new)
		test.log(Status.INFO, "Website opened succesfuuly");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtility.IMPLICIT_TIMEOUT));
		return driver;
	}

	public void captureScreenshots(WebDriver driver, ExtentTest test) throws IOException {
		Date d = new Date();
		String filename = d.toString().replace(" ", "_").replace(":", "_");

		String capturedpath = System.getProperty("user.dir") + "//screenshots//img" + filename + ".png";
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(capturedpath));

		test.log(Status.INFO, "Screenshot captured Successfully");
		// log screenshots to the extent report
		test.addScreenCaptureFromPath(capturedpath);

	}

}
