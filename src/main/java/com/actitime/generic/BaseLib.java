package com.actitime.generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	public static WebDriver driver;
	
	@Parameters({"browserName", "baseUrl"})
	@BeforeMethod
	public void preCond(String browserName, String url) {
		driver=BrowserFactory.launchBrowser(browserName, url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("URL is navigated",true);
	}
	
	@AfterMethod
	public void postCond() {
		driver.quit();
		Reporter.log("Browser closed", true);
	}
}
