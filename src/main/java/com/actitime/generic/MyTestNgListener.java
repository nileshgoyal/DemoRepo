package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestNgListener implements ITestListener {
	int executionCount, passCount, failCount, skipCount=0;
	
	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+" Suite execution is start "+ new Date(), true);
	}
	
	public void OnTestStart(ITestResult result) {
		executionCount++;
		Reporter.log(result.getName()+" Script execution is start "+ new Date(), true);
	}
	
	public void onTestSuccess(ITestResult result) {
		passCount++;
		Reporter.log(result.getName()+" Script is passed ", true);
	}
	
	public void onTestSkip(ITestResult result) {
		skipCount++;
		Reporter.log(result.getName()+" Script is skipped ", true);
	}
	
	public void onTestFail(ITestResult result) {
		failCount++;
		Reporter.log(result.getName()+" Script is Failed ", true);
		TakesScreenshot ts=(TakesScreenshot)BaseLib.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot"+result.getName()+ ".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot has been taken");
	}
	
	public void onFinish(ITestContext context) {
		Reporter.log("Total Script is execuited "+ executionCount);
		Reporter.log("Total Script is passed "+ passCount);
		Reporter.log("Total Script is skipped "+ skipCount);
		Reporter.log("Total Script is skipCount "+ failCount);
	}
}
