package com.PageLibrary;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import com.PageLocators.Staff_Login_Locators;
import com.util.DriverInitializer;

public class Staff_Login extends Staff_Login_Locators
{
	boolean IsAlertPresent;
	public  WebDriver driver = DriverInitializer.getDriver();
	
	public void sl_01_loginpage()
	{
		String acturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, Page_URL);
		Reporter.log("SL_01: PASS",true);
		Reporter.log("SL_01: As expected "+acturl+ " displayed" ,true);
		
	}
		
	//Main Heading Text at Login 
	public void sl_02_Verify_MainHeading() throws InterruptedException
	{ 
		WebElement text = driver.findElement(By.xpath(Main_Heading_Text_xpath));
		String mainheading = text.getText();
		Assert.assertEquals(mainheading, Main_Heading_Text);
		Reporter.log("SL_02: PASS",true);
		Reporter.log("SL_02: As expected displayed "+ mainheading +" in Page as Main Heading: " , true);
		/*if(flag==true)
		{
			Reporter.log("SL_02: PASS",true);
			Reporter.log("SL_02: As expected displayed "+ mainheading +" in Page as Main Heading: " , true);
				
		}
		else
		{
			Reporter.log("SL_02: FAIL",true);
			Reporter.log("SL_02: "+ mainheading +" not displayed in the Page ", true);
		 	
		}*/
		Thread.sleep(1000);
	}
	
	public void sl_03_verifyLoginbutton() throws InterruptedException
	{
		boolean flag = driver.findElement(By.xpath(Login_button_xpath)).isEnabled();
		Assert.assertTrue(flag);
		Reporter.log("SL_03: PASS",true);
		Reporter.log("SL_03: As expected Login button is enabled ", true);
		/*if(flag==true)
		{
			Reporter.log("SL_03: PASS",true);
			Reporter.log("SL_03: As expected Login button is enabled ", true);
		}
		else
		{
			Reporter.log("SL_03: FAIL",true);
			Reporter.log("SL_03: Login button is not enabled ", true);
		}*/
	}
	

	//Staff Login with both Username and Password Invalid Inputs
	public void sl_04_Verify_Staff_Login_InValid_Username_InValid_Password() throws InterruptedException, AWTException
	{
	 	//InValid Username
		 Thread.sleep(1000);
		WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
		username.clear();
		username.sendKeys("tes");
		 Reporter.log("Entered Invalid Username", true);
		 Thread.sleep(1000);
		//InValid Password
		WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
		password.clear();
		password.sendKeys("123");
		 Reporter.log("Entered Invalid Password", true);
		 Thread.sleep(1000);
		//Click on Login button
		WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
		Login_button.click();
		Thread.sleep(2000);
		//String Actual_URL = driver.getCurrentUrl();
		//boolean flag = Actual_URL.equals(Appointment_List_Page_URL);
		Assert.assertTrue(IsAlertPresent);
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		Alert a = wait.until(ExpectedConditions.alertIsPresent());
		a.accept();
		String alert_msg = a.getText();*/
		Reporter.log("SL_04: Alert is Presented ",true);
	
		
		
		/*if(flag!=true)
		{
			Reporter.log("SL_04: FAIL",true);
			Reporter.log("SL_04: No Error Message displayed", true);
			Reporter.log("SL_04: Should be displayed error message as Please Enter Valid Inputs ",true );
		}
		else
		{
			Reporter.log("SL_04: PASS",true);
			Reporter.log("SL_04: Error Message Displayed as Please Enter Valid Inputs", true);
		}*/
		DriverInitializer.Refresh();
	}
	
	//Staff Login with Valid Username and Invalid Password 
		public void sl_05_Verify_Staff_Login_Valid_Username_InValid_Password() throws InterruptedException, AWTException
		{
		 	//Valid Username
			 Thread.sleep(1000);
			WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
			username.clear();
			username.sendKeys("tester1");
			 Reporter.log("Entered Valid Username", true);
			 Thread.sleep(1000);
			//InValid Password
			WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
			password.clear();
			password.sendKeys("123");
			 Reporter.log("Entered Invalid Password", true);
			 Thread.sleep(1000);
			//Click on Login button
			WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
			Login_button.click();
			Thread.sleep(2000);
			/*String Actual_URL = driver.getCurrentUrl();
			//Assert.assertEquals(Actual_URL, Appointment_List_Page_URL);
			
			boolean flag = Actual_URL.equals(Appointment_List_Page_URL);
			if(flag!=true)
			{
				Reporter.log("SL_05: FAIL",true);
				Reporter.log("SL_05: No Error Message displayed", true);
				Reporter.log("SL_05: Should be displayed error message as Please Enter Valid Password ",true ); 
			}
			else
			{
				Reporter.log("SL_05: PASS",true);
				Reporter.log("SL_05: Error Message displayed as Please Enter Valid Password", true);
			}
			WebDriverWait wait = new WebDriverWait(driver, 15);
			Alert a = wait.until(ExpectedConditions.alertIsPresent());
			a.accept();
			String alert_msg = a.getText();
			Reporter.log("SL_05: PASS",true);*/
			Assert.assertTrue(IsAlertPresent);
			Reporter.log("SL_05: Alert is Presented",true);
			DriverInitializer.Refresh();
		}
		
	
	//Staff Login with InValid Username and Valid Password 
				public void sl_06_Verify_Staff_Login_InValid_Username_Valid_Password() throws InterruptedException, AWTException
				{
				 	//InValid Username
					 Thread.sleep(1000);
					WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
					username.clear();
					username.sendKeys("tes");
					 Reporter.log("Entered Invalid Username", true);
					 Thread.sleep(1000);
					//Valid Password
					WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
					password.clear();
					password.sendKeys("1");
					 Reporter.log("Entered Valid Password", true);
					 Thread.sleep(1000);
					//Click on Login button
					WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
					Login_button.click();
					Thread.sleep(2000);
					/*String Actual_URL = driver.getCurrentUrl();
					boolean flag = Actual_URL.equals(Appointment_List_Page_URL);
					if(flag!=true)
					{
						Reporter.log("SL_06: FAIL",true);
						Reporter.log("SL_06: No Error Message displayed", true);
						Reporter.log("SL_06: Should be displayed error message as Please Enter Valid Username ",true ); 
					}
					else
					{
						Reporter.log("SL_06: PASS",true);
						Reporter.log("SL_06: Error Message displayed as Please Enter Valid Username", true);
					}*/
					//WebDriverWait wait = new WebDriverWait(driver, 15);
					//Alert a = wait.until(ExpectedConditions.alertIsPresent());
					//Assert.assertTrue(IsAlertPresent);
					//a.accept();
					//String alert_msg = a.getText();
					//Reporter.log("SL_06: PASS",true);
					Assert.assertTrue(IsAlertPresent);
					Reporter.log("SL_06: Alert is Presented",true);
					DriverInitializer.Refresh();
				}
				
				//Staff Login with Valid Username and Blank Password 
				public void sl_07_Verify_Staff_Login_Valid_Username_Blank_Password() throws InterruptedException, AWTException
				{
				 	//Valid Username
					 Thread.sleep(1000);
					WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
					username.clear();
					username.sendKeys("tester1");
					 Reporter.log("Entered Valid Username", true);
					 Thread.sleep(1000);
					//Blank Password
					WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
					password.clear();
					password.sendKeys("");
					 Reporter.log("Entered Blank Password", true);
					 Thread.sleep(1000);
					//Click on Login button
					WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
					Login_button.click();
					Thread.sleep(2000);
					/*String Actual_URL = driver.getCurrentUrl();
					boolean flag = Actual_URL.equals(Appointment_List_Page_URL);
					if(flag!=true)
					{
						Reporter.log("SL_07: FAIL",true);
						Reporter.log("SL_07: No Error Message displayed", true);
						Reporter.log("SL_07: Should be displayed error message as Please Enter Password ",true ); 
					}
					else
					{
						Reporter.log("SL_07: PASS",true);
						Reporter.log("SL_07: Error Message displayed as Please Enter Password", true);
					}*/
					//WebDriverWait wait = new WebDriverWait(driver, 15);
					//Alert a = wait.until(ExpectedConditions.alertIsPresent());
					//Assert.assertTrue(IsAlertPresent);
					//a.accept();
					//String alert_msg = a.getText();
					//Reporter.log("SL_07: PASS",true);
					Assert.assertTrue(IsAlertPresent);
					Reporter.log("SL_07: Alert is Presented",true);
					DriverInitializer.Refresh();
				}
				
	
				//Staff Login with Blank Username and Valid Password 
				public void sl_08_Verify_Staff_Login_Blank_Username_Valid_Password() throws InterruptedException, AWTException
				{
				 	//Blank Username
					 Thread.sleep(1000);
					WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
					username.clear();
					username.sendKeys("");
					 Reporter.log("Blank Username", true);
					 Thread.sleep(1000);
					//Valid Password
					WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
					password.clear();
					password.sendKeys("1");
					 Reporter.log("Entered Valid Password", true);
					 Thread.sleep(1000);
					//Click on Login button
					WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
					Login_button.click();
					Thread.sleep(2000);
					/*String Actual_URL = driver.getCurrentUrl();
					boolean flag = Actual_URL.equals(Appointment_List_Page_URL);
					if(flag!=true)
					{
						Reporter.log("SL_08: FAIL",true);
						Reporter.log("SL_08: No Error Message displayed", true);
						Reporter.log("SL_08: Should be displayed error message as Please Enter Username ",true ); 
					}
					else
					{
						Reporter.log("SL_08: PASS",true);
						Reporter.log("SL_08: Error Message displayed as Please Enter Username", true);
					}*/
					//WebDriverWait wait = new WebDriverWait(driver, 15);
					//Alert a = wait.until(ExpectedConditions.alertIsPresent());
					//Assert.assertTrue(IsAlertPresent);
					//a.accept();
					//String alert_msg = a.getText();
					//Reporter.log("SL_08: PASS",true);
					Assert.assertTrue(IsAlertPresent);
					Reporter.log("SL_08: Alert is Presented",true);
					DriverInitializer.Refresh();
				}
				
	
				//Staff Login with Blank Username and Blank Password 
				public void sl_09_Verify_Staff_Login_Blank_Username_Blank_Password() throws InterruptedException, AWTException
				{
				 	//Blank Username
					 Thread.sleep(1000);
					WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
					username.clear();
					username.sendKeys("");
					 Reporter.log("Blank Username", true);
					 Thread.sleep(1000);
					//Blank Password
					WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
					password.clear();
					password.sendKeys("");
					 Reporter.log("Blank Password", true);
					 Thread.sleep(1000);
					//Click on Login button
					WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
					Login_button.click();
					Thread.sleep(2000);
					/*String Actual_URL = driver.getCurrentUrl();
					boolean flag = Actual_URL.equals(Appointment_List_Page_URL);
					if(flag!=true)
					{
						Reporter.log("SL_09: FAIL",true);
						Reporter.log("SL_09: No Error Message displayed", true);
						Reporter.log("SL_09: Should be displayed error message as Please Enter Username and Password",true ); 
					}
					else
					{
						Reporter.log("SL_09: PASS",true);
						Reporter.log("SL_09: Error Message displayed as Please Enter Username and Password", true);
					}*/
				//	WebDriverWait wait = new WebDriverWait(driver, 15);
					//Alert a = wait.until(ExpectedConditions.alertIsPresent());
				//	Assert.assertTrue(IsAlertPresent);
				//	a.accept();
				//	String alert_msg = a.getText();
				//	Reporter.log("SL_09: PASS",true);
					Assert.assertTrue(IsAlertPresent);
					Reporter.log("SL_09: Alert is Presented",true);
					DriverInitializer.Refresh();
				}
				
	
	public void sl_10_Verify_Password_visibility() throws InterruptedException
	{
		String pwd = driver.findElement(By.xpath(Password_editbox_xpath)).getAttribute("type");
		Assert.assertEquals(pwd, Password_Type);
		Reporter.log("SL_10: PASS",true);
		Reporter.log("SL_10: As expected password characters not visible, displaying as ***** ",true);
	
	}
	
	//Staff Login with Blank Username and Blank Password 
	public void sl_11_Verify_Staff_Login_Valid_Username_Valid_Password() throws InterruptedException
	{
	 	//Valid Username
		 Thread.sleep(1000);
		WebElement username = driver.findElement(By.xpath(Username_editbox_xpath));
		username.clear();
		username.sendKeys("tester1");
		 Reporter.log("Entered Valid Username", true);
		 Thread.sleep(1000);
		//Valid Password
		WebElement password = driver.findElement(By.xpath(Password_editbox_xpath));
		password.clear();
		password.sendKeys("1");
		 Reporter.log("Entered Valid Password", true);
		 Thread.sleep(1000);
		//Click on Login button
		WebElement Login_button = driver.findElement(By.xpath(Login_button_xpath));
		Login_button.click();
		Thread.sleep(2000);
		String Actual_URL = driver.getCurrentUrl();
		Assert.assertEquals(Actual_URL, Appointment_List_Page_URL);
		Reporter.log("SL_09: PASS",true);
		Reporter.log("SL_11: Appointment List Page displayed",true ); 
		/*String Actual_URL = driver.getCurrentUrl();
		boolean flag = Actual_URL.equals(Appointment_List_Page_URL);
		if(flag==true)
		{
			Reporter.log("SL_11: PASS",true);
			Reporter.log("SL_11: Staff Login Successfully", true);
			Reporter.log("SL_11: Appointment List Page displayed",true ); 
		}
		else
		{
			Reporter.log("SL_11: FAIL",true);
			Reporter.log("SL_11: Staff Login Failed, Appointment List Page not displayed", true);
		}*/
	}
	

	
	
	
	
	
	
	
	
	
	

}
