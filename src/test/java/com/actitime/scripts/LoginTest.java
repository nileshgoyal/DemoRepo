package com.actitime.scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.actitime.features.LoginFeature;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class LoginTest extends BaseLib{
	
	@Test
	public void login() {
		ExcelUtilities eu=new ExcelUtilities("./testData/testdata.xlsx");
		String userName=eu.readData("sheet1", 1, 1);
		String password=eu.readData("sheet1", 1, 2);
		LoginFeature lf=new LoginFeature(driver);
		lf.login(userName, password);
		lf.verfiyLoginScript();
		
	}
}
