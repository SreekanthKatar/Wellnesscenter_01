package com.PageLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.PageLocators.Appointment_List_Locators;
import com.util.DriverInitializer;


public class Appointment_List extends Appointment_List_Locators
{
	public WebDriver driver = DriverInitializer.getDriver();
	public void Click_on_Client_Module()
	{
		driver.findElement(By.xpath(Client_Module_dropdown_xpath)).click();
		Reporter.log("Clicked on Client Module Dropdown", true);
	}
	public void Click_on_New_Client_Registration()
	{
		driver.findElement(By.xpath(New_Client_Reg_button_xpath)).click();
		Reporter.log("Clicked on New Client Registration", true);
		
	}
	
	public void Click_on_Existing_Clients()
	{
		driver.findElement(By.xpath(Existing_Clients_button)).click();
		Reporter.log("Clicked on Existing Clients", true);
	
	}
	
	public void Client_Menu_ALlOptions(){
		WebElement Menu = driver.findElement(By.xpath(MenuOptions_xpath));
		List<WebElement> alloptions = Menu.findElements(By.tagName("li"));
		for (WebElement EachOption : alloptions) {
			String option_name = EachOption.getText();
			Reporter.log(option_name,true);
			
		}
	}
		public void webtable()
		{
		  WebElement table = driver.findElement(By.xpath(WebTable_xpath));
		 WebElement table_header = table.findElement(By.tagName("thead"));
		 List<WebElement> allrows = table_header.findElements(By.tagName("tr"));
		  for (WebElement row : allrows) {
			  String row_text = row.getText();
			  Reporter.log(row_text,true);
			
		}
		  Reporter.log("------------------------------------------------------------------",true);
		  WebElement table_body = table.findElement(By.tagName("tbody"));
		  List<WebElement> rows = table_body.findElements(By.tagName("tr"));
		  for (WebElement eachrow : rows) {
			  String rowdata = eachrow.getText();
			  Reporter.log(rowdata,true);
			
		}
		}  
		//AL_01
		public void al_01_verify_appointment_list_page()
		{
			String act_url = driver.getCurrentUrl();
			Assert.assertEquals(act_url, Page_URL);
			Reporter.log("AL_01: PASS",true);
			Reporter.log("Appointment Page displayed and this page url is "+act_url,true);
			
			
		}
		  
			
		
	
}
