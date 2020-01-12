package com.actitime.features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageObjects.EnterTimeTrackPage;
import com.actitime.pageObjects.LoginPage;

public class LoginFeature {
	WebDriver driver;
	LoginPage lp;
	EnterTimeTrackPage ettp;
	
	public LoginFeature(WebDriver driver) {
		this.driver=driver;
		lp=new LoginPage(driver);
		ettp=new EnterTimeTrackPage(driver);
	}
	
	public void login(String userName, String password) {
		lp.getUnTxtBx().sendKeys(userName);
		lp.getPwdTxtBx().sendKeys(password);
		lp.getLgnBtn().click();
	}
	
	public void verfiyLoginScript() {
		String expected="Enter Time-Track";
		String actual=ettp.getPgTitle().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Home Page title is verified", true);
	}
}
