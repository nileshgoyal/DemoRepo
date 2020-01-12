package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	static WebDriver driver;
	
	public static WebDriver launchBrowser(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Chrome Launch");
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Firefox Launch");
		}
		
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./exe/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			System.out.println("IE Launch");
		}
		
		return driver;
	}
}
