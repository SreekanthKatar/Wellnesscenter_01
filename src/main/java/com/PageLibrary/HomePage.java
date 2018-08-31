package com.PageLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;


import com.PageLocators.HomePage_Locators;
import com.util.DriverInitializer;

public class HomePage extends HomePage_Locators
{

	public  WebDriver driver = DriverInitializer.getDriver();
	
	
	
	public void hp_01_HomePage() throws InterruptedException
	{
	 driver.navigate().to(appurl);
	 Thread.sleep(1000);
	 String url = driver.getCurrentUrl();
	 Assert.assertEquals(url, appurl);
	 Reporter.log("HP_01: PASS",true);
	 Reporter.log("HP_01: As expected "+url+ " displayed" ,true);
	}	
	
	public void hp_02_UI(){
		List<WebElement> allimages = driver.findElements(By.tagName("img"));
		int img_count = allimages.size();
		Reporter.log("Total images in Home page "+img_count,true);
		for (WebElement eachimage : allimages) {
		Assert.assertTrue(eachimage.isDisplayed());	
		}
		Reporter.log(img_count+" images displayed",true);
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		int links_count = alllinks.size();
		Reporter.log("Total Links in Home page "+links_count,true);
		for (WebElement eachlink : alllinks) {
		Assert.assertTrue(eachlink.isDisplayed() && eachlink.isEnabled());	
		String linkname = eachlink.getText();
		Reporter.log(linkname+" link is displayed and enabled ",true);
		}
		
	
		Reporter.log("PASS",true);
	}
	
	public void hp_03_ClickHereToLoginButton() throws InterruptedException
	{
		boolean flag = driver.findElement(By.xpath(Click_here_to_Login_xpath)).isEnabled();
		Assert.assertTrue(flag);
		Reporter.log("HP_03: PASS",true);
		Reporter.log("HP_03: Click Here To Login button is enabled ", true);
		
		
	
		
		/*if(flag==true)
		{
			Reporter.log("HP_03: PASS",true);
			Reporter.log("HP_03: Click Here To Login button is enabled ", true);
		}
		else
		{
			Reporter.log("HP_03: FAIL",true);
			Reporter.log("HP_03: Click Here To Login button is not enabled ", true);
		}*/
	}
	
	public void hp_04_ClickHereToLogin() throws InterruptedException
	{
		driver.findElement(By.xpath(Click_here_to_Login_xpath)).click();
		Thread.sleep(2000);
		 String Actual_URL = driver.getCurrentUrl();
		 Assert.assertEquals(Actual_URL, Staff_Login_Page_URL);
		 Reporter.log("HP_04: PASS",true);
		 Reporter.log("HP_04: As expected "+Actual_URL+ " displayed" ,true);
		 /*boolean flag = Staff_Login_Page_URL.contains(Actual_URL);
		 if(flag==true)
		 	{
			 Reporter.log("HP_04: PASS",true);
			 Reporter.log("HP_04: Staff Login Page displayed Successfully", true);
		 	}
		 else
		 	{
			 Reporter.log("HP_04: FAIL",true);
			 Reporter.log("HP_04: Staff Login Page not displayed", true);
		 	}*/
		 DriverInitializer.screenshot();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
