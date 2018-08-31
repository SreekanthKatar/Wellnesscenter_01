package com.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class DriverInitializer 
{
	public static WebDriver driver;
	
	static int i = 0;
	
	public static void launch()
	{
	  System.setProperty("webdriver.chrome.driver", "D:/Workspace_Sree/Wellnesscenter/src/main/java/com/Browser/chromedriver.exe"); 
	  Reporter.log("Launch_Browser: Chrome Browser Launched Successfully", true);
	  Reporter.log("Launch_Application: Application Launched Successfully", true);
	}
	
	public static WebDriver getDriver()
	{
		
		if(i==0)
		{
			launch();
			driver = new ChromeDriver();
			i++;
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void close()
	{
		driver.close();
		Reporter.log("Close_Browser: Chrome Browser Closed Successfully", true);
	}
	public static void Refresh() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		Thread.sleep(1000);
	}
	
	public static void screenshot() throws InterruptedException
	{
		Thread.sleep(2000);
		try 
		{
		Date d= new Date();
		DateFormat dformat= new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss ");
		File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sc, new File("D://"+dformat.format(d)+".png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public static void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	public static void fileSeperator()
	{
		  String path = "D:";
		  String pathSep = path + File.separator + "Hello" + File.separator;
		  System.out.println(pathSep);
	 }

		
}
