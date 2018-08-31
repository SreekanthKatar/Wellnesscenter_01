package com.Tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.util.DriverInitializer;



public class CustomListener extends TestListenerAdapter {
	
	public static WebDriver driver = DriverInitializer.getDriver();
	
	@Override
	public void onTestSuccess(ITestResult tr) {
	
		Reporter.log("Test Case Pass ::::::: "+ tr.getName(),true);
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		Reporter.log("ERROR:::: "+tr.getTestName()+" TEST CASE FAILED",true);
		File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sc, new File("C:/Temp/" + tr.getName()+".png"));
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	

}