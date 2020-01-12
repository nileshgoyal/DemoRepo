package com.actitime.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lombok.Getter;

public class LoginPage {
	@FindBy(name="username")
	private @Getter WebElement unTxtBx;
	
	@FindBy(name="pwd")
	private @Getter WebElement pwdTxtBx;
	
	@FindBy(id="loginButton")
	private @Getter WebElement lgnBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
