package com.dss.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.dss.qa.Base.Basepage;

public class LaunchingBrowserTest extends Basepage {
	public WebDriver driver;

	public LaunchingBrowserTest() throws IOException {
		super();

	}

	@Test
	public void validateOpenApplication() {

		driver = initializationAndOpenApplication(prop.getProperty("browser"));

	}

}
