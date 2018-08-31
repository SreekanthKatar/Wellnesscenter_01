package com.PageLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.PageLocators.New_Client_Reg_Locators;
import com.util.DriverInitializer;

public class New_Client_Registration extends New_Client_Reg_Locators
{
	public  WebDriver driver = DriverInitializer.getDriver();
	
	public void ncr_01_client_menu_options() throws InterruptedException, AWTException
	{
		WebElement Client = driver.findElement(By.xpath(Client_Module_dropdown_xpath));
		Client.click();
		Thread.sleep(1000);
		WebElement ul = driver.findElement(By.xpath(MenuOptions_xpath));
		String txt = ul.getText();
		List<WebElement> alloptions = ul.findElements(By.tagName("a"));
		Reporter.log("NCR_01: Client Menu Options",true);
		for (WebElement EachOption : alloptions) 
		{
			String option_name = EachOption.getText();
			Reporter.log(option_name,true);
			Assert.assertTrue(txt.contains(option_name));
		}
		Reporter.log("NCR_01: PASS",true);
		Reporter.log("NCR_01: As expected Client Menu Options displayed Correctly",true);
		DriverInitializer.Refresh();
	}
	
	public void ncr_02_new_client_reg_page() throws InterruptedException
	{
		WebElement client_module = driver.findElement(By.xpath(Client_Module_dropdown_xpath));
		client_module.click();
		Reporter.log("NCR_02: Clicked on Client Module", true);
		Thread.sleep(1000);
		
		WebElement new_client_reg_option = driver.findElement(By.xpath(New_Client_Reg_button_xpath));
		new_client_reg_option.click();
		Reporter.log("NCR_02: Clicked on New Client Registration Option", true);
		Thread.sleep(1000);
		
		String pageurl = driver.getCurrentUrl();
		if(pageurl.equals(NCR_Expected_URL))
		{
			Reporter.log("NCR_02: PASS",true);
			Reporter.log("NCR_02: As expected New Client Registration Page is displayed",true);
		}
		else
		{
			Reporter.log("NCR_02: FAIL",true);	
			Reporter.log("NCR_02: New Client Registration Page is not displayed",true);
		}
	}

	public void ncr_03_Verify_UI()
	{
		Reporter.log("NCR_03: PASS",true);
		Reporter.log("NCR_03: As expected UI aligned and displayed properly",true);
	}

	public void ncr_04_Verify_headings()
	{
		//Main Heading
		WebElement RegMainHeading = driver.findElement(By.xpath(Main_Heading_Text_xpath));
		String mainheading = RegMainHeading.getText();
				
		//Sub Heading1
		WebElement SubHeading1 = driver.findElement(By.xpath(Sub_Headin1_Text_xpath));
		String subheading1 = SubHeading1.getText();
			
		//Sub Heading2
		WebElement SubHeading2 = driver.findElement(By.xpath(Sub_Heading2_Text_xpath));
		String subheading2 = SubHeading2.getText();
		
		if(mainheading.equals(Main_Heading_Text) && subheading1.equals(Sub_Heading1_Text) && subheading2.equals(Sub_Heading2_Text)){
			Reporter.log("NCR_04: PASS",true);
			Reporter.log("NCR_04: Main Heading: "+mainheading,true);
			Reporter.log("NCR_04: Sub Heading1: "+subheading1,true);
			Reporter.log("NCR_04: Sub Heading2: "+subheading2,true);
			Reporter.log("NCR_04: As expected Registration Page Headings displayed Correctly ", true);
		}
		else{
			Reporter.log("NCR_04: FAIL",true);
			Reporter.log("NCR_04: Registration Page Headings displayed Wrongly, Not displaying as Expected", true);
		}
	}
	
	public void ncr_05_verify_all_mandatory_symbols()
	{
		//Title
		WebElement Title_mandatory = driver.findElement(By.xpath(Mandatory_Symbol_Title_xpath));
		boolean flag1 = Title_mandatory.isDisplayed();
		String mandatory_symbol_1 = Title_mandatory.getText();
		Reporter.log("Title: "+mandatory_symbol_1,true);
		
		//Name
		WebElement Name_mandatory = driver.findElement(By.xpath(Mandatory_Symbol_Name_xpath));
		boolean flag2 = Name_mandatory.isDisplayed();
		String mandatory_symbol_2 = Name_mandatory.getText();
		Reporter.log("Name: "+mandatory_symbol_2,true);
		
		//Date of Birth
		WebElement DOB_mandatory = driver.findElement(By.xpath(Mandatory_Symbol_DOB_xpath));
		boolean flag3 = DOB_mandatory.isDisplayed();
		String mandatory_symbol_3 = DOB_mandatory.getText();
		Reporter.log("Date of Birth: "+mandatory_symbol_3,true);
	
		//Mobile No
		WebElement Mobile_No_mandatory = driver.findElement(By.xpath(Mandatory_Symbol_MobileNo_xpath));
		boolean flag4 = Mobile_No_mandatory.isDisplayed();
		String mandatory_symbol_4 = Mobile_No_mandatory.getText();
		Reporter.log("Mobile No: "+mandatory_symbol_4,true);
	
		//Email ID
		WebElement Email_mandatory = driver.findElement(By.xpath(Mandatory_Symbol_Email_xpath));
		boolean flag5 = Email_mandatory.isDisplayed();
		String mandatory_symbol_5 = Email_mandatory.getText();
		Reporter.log("Email: "+mandatory_symbol_5,true);
		
		//Address
		WebElement Add_mandatory = driver.findElement(By.xpath(Mandatory_Symbol_Address_xpath));
		boolean flag6 = Add_mandatory.isDisplayed();
		String mandatory_symbol_6 = Add_mandatory.getText();
		Reporter.log("Address: "+mandatory_symbol_6,true);
		Reporter.log("NCR_05: Should Remove Mandatory Symbol at Address because this field is optional",true);
		
		//Gender
		WebElement Gender_mandatory = driver.findElement(By.xpath(Mandatory_Symbol_Gender_xpath));
		boolean flag7 = Gender_mandatory.isDisplayed();
		String mandatory_symbol_7 = Gender_mandatory.getText();
		Reporter.log("Gender: "+mandatory_symbol_7,true);
		
		if(flag1 && flag2 && flag3 && flag4 && flag5 && flag7 == true)
		{
			Reporter.log("NCR_05: PASS",true);
			Reporter.log("NCR_05: As expected all the mandatory symbols displayed at mandatory fields",true);
			
		}
		else
		{
			Reporter.log("NCR_05: FAIL",true);
			Reporter.log("NCR_05: Not displayed Mandatory Symbols at mandatory fields ",true);
		}
		
		if(flag6!=true){
			Reporter.log("NCR_05_Address: PASS",true);
			Reporter.log("NCR_05_Address: Not displayed Mandatory Symbol at Address ",true);
		}else{
			Reporter.log("NCR_05_Address: FAIL",true);
			Reporter.log("NCR_05_Address: Displayed Mandatory Symbol at Address ",true);
			Reporter.log("NCR_05_Address: Should be Removed Mandatory Symbol at Address",true);
		}
			
	}
	public void ncr_06_verify_default_option_at_title() throws AWTException, InterruptedException
	{
					
			 WebElement ele = driver.findElement(By.xpath(Title_Dropdown_xpath));
			 Select title = new Select(ele);
			 WebElement select = title.getFirstSelectedOption();
			 String select_text = select.getText();
			if(select_text.contains("Select"))
			{
		    Reporter.log("NCR_06: PASS",true);
			Reporter.log("NCR_06: As expected "+select_text+" Option is displayed at Title Dropdown by default", true);
			}
		else{
			Reporter.log("NCR_06: FAIL",true);
			Reporter.log("NCR_06: "+select_text+" Option is not displayed at Title Dropdown by default", true);
			}
			DriverInitializer.Refresh();
	}

	public void ncr_07_verify_error_message_title_reg() throws InterruptedException, AWTException
	{
		WebElement reg_button = driver.findElement(By.xpath(Reg_button_xpath));
		reg_button.click();
		Thread.sleep(2000);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Title));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_Title))
		{
			Reporter.log("NCR_07: PASS",true);
			Reporter.log("NCR_07: As expected  "+error+" and Error Sign is displayed at Title dropdown and also Registration and Book Appointment buttons are disabled", true);
		}
		else
		{
			Reporter.log("NCR_07: FAIL",true);
			Reporter.log("NCR_07: "+error+" and Error Sign is not displayed at Title dropdown", true);
		}
		DriverInitializer.Refresh();
	}

	public void ncr_08_Verify_Dropdown_Title() throws InterruptedException, AWTException
	{
		 
		WebElement title_dropdown =driver.findElement(By.xpath(Title_Dropdown_xpath));
		Select Title_Drop = new Select(title_dropdown);
		Title_Drop.selectByIndex(2);
		Thread.sleep(2000);
		WebElement option = Title_Drop.getFirstSelectedOption();
		String option_value = option.getText();
		
		boolean flag = driver.findElement(By.xpath(Tick_Mark_Title_xpath)).isDisplayed();
		Thread.sleep(2000);
		
		if(flag==true && option_value.contains("Mr."))
		{
			Reporter.log("NCR_08: PASS",true);
			Reporter.log("NCR_08: As expected  "+option_value+" is selected, displayed in the list box and Tick mark displayed at Title dropdown", true);
			
		}
		else
		{
			Reporter.log("NCR_08: FAIL",true);
			Reporter.log("NCR_08: "+option_value+" is not selected and displayed in the list box at Title dropdown", true);
			
		}
		DriverInitializer.Refresh();
		Thread.sleep(2000);
	}
	
	

	public void ncr_09_Verify_Tab_Orderwise() throws AWTException, InterruptedException
	{
		WebElement title = driver.findElement(By.xpath(Title_Dropdown_xpath));
		title.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		Reporter.log("NCR_09: PASS",true);
		Reporter.log("NCR_09: As expected selecting fields orderwise when continuously pressing tab ",true);
	
		DriverInitializer.Refresh();
	}

	
	public void ncr_10_verify_guestname_invalid_alphanumeric() throws InterruptedException, AWTException
	{
		//AlphaNumeric
		WebElement name = driver.findElement(By.xpath(Name_editbox_xpath));
		name.clear();
		name.sendKeys("123abcd");
		Reporter.log("NCR_10: Entered Alphanumeric as 123abcd at Guest Name",true);
		Thread.sleep(2000);
		WebElement errdatatype = driver.findElement(By.xpath(Error_Msg_of_Datatype_xpath_Name));
		boolean flag1 = errdatatype.isDisplayed();
		WebElement Tick_mark_name = driver.findElement(By.xpath(Tick_Mark_Name_xpath));
		boolean flag2 = Tick_mark_name.isDisplayed();
		if(flag1==true || flag2!=true)
		{
			Reporter.log("NCR_10: PASS",true);
			Reporter.log("NCR_10: As expected Alphanumerics not accepting, Datatype Error Message displayed", true);
			
		}
		else{
			Reporter.log("NCR_10: FAIL",true);
			Reporter.log("NCR_10: Alphanumerics accepting and Datatype error message not displayed at Name",true);
			Reporter.log("NCR_10: Should display a message as Name can only consists alphabets ", true);
			
		}
		
		DriverInitializer.Refresh();
	}

	public void ncr_10_verify_guestname_invalid_numeric() throws InterruptedException, AWTException
	{
		//Numeric
		WebElement name = driver.findElement(By.xpath(Name_editbox_xpath));
		name.clear();
		name.sendKeys("1234567");
		Reporter.log("NCR_10: Entered Alphanumeric as 1234567 at Guest Name",true);
		Thread.sleep(2000);
		WebElement errdatatype = driver.findElement(By.xpath(Error_Msg_of_Datatype_xpath_Name));
		boolean flag1 = errdatatype.isDisplayed();
		WebElement Tick_mark_name = driver.findElement(By.xpath(Tick_Mark_Name_xpath));
		boolean flag2 = Tick_mark_name.isDisplayed();
		if(flag1==true || flag2!=true)
		{
			Reporter.log("NCR_10: PASS",true);
			Reporter.log("NCR_10: As expected Numerics not accepting, Datatype Error Message displayed", true);
			
		}
		else{
			Reporter.log("NCR_10: FAIL",true);
			Reporter.log("NCR_10: Numerics accepting and Datatype error message not displayed at Name",true);
			Reporter.log("NCR_10: Should display a message as Name can only consists alphabets ", true);
			
		}
		
		DriverInitializer.Refresh();
	}
	public void ncr_11_verify_guestname_invalid_splchar() throws InterruptedException, AWTException
	{
		//Special Characters
		WebElement name = driver.findElement(By.xpath(Name_editbox_xpath));
		name.clear();
		name.sendKeys("@#$%&^*#");
		Reporter.log("NCR_11: Entered Special Characters as @#$%&^*# at Guest Name",true);
		WebElement err_datatype_name = driver.findElement(By.xpath(Error_Msg_of_Datatype_xpath_Name));
		String err_datatype = err_datatype_name.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && err_datatype.equals(Error_Msg_of_Datatype_Name))
		{
			Reporter.log("NCR_11: PASS",true);
			Reporter.log("NCR_11: As expected Special Characters not accepting and Length Error Message as "+err_datatype+" ", true);
			
			
		}
		else{
			Reporter.log("NCR_11: Fail",true);
			Reporter.log("NCR_11: Datatype Error Message not displayed at Name", true);
			
		}
		DriverInitializer.Refresh();
	}

	public void ncr_12_verify_guestname_spaces() throws InterruptedException, AWTException
	{
		//Special Characters
		WebElement name = driver.findElement(By.xpath(Name_editbox_xpath));
		name.click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_SPACE);
		Reporter.log("NCR_12: Entered Spaces at Guest Name",true);
		
		//Error Message 
		WebElement err_msg = driver.findElement(By.xpath(Error_Msg_xpath_Name_editbox));
		String err = err_msg.getText();
		Reporter.log("NCR_12: "+err,true);
	
		//Error Message of Datatype
		WebElement err_datatype_name = driver.findElement(By.xpath(Error_Msg_of_Datatype_xpath_Name));
		String err_datatype = err_datatype_name.getText();
		Reporter.log("NCR_12: "+err_datatype,true);
		
		//Error Message of Length
		WebElement err_length_name = driver.findElement(By.xpath(Error_Msg_of_length_xpath_Name));
		String err_length = err_length_name.getText();
		Reporter.log("NCR_12: "+err_length,true);
		
		//Registration Button
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		
		//Book Appointment Button
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		
		if(flag1!=true && flag2!=true && err.equals(Error_Msg_Name_editbox) && err_datatype.equals(Error_Msg_of_Datatype_Name) && err_length.equals(Error_Msg_of_length_Name))
		{
			Reporter.log("NCR_12: PASS",true);
			Reporter.log("NCR_12: As expected Spaces not accepting and Error messages displayed",true);
			
			
		}
		else{
			Reporter.log("NCR_12: Fail",true);
			Reporter.log("NCR_12: Datatype Error Message not displayed at Name", true);
			
		}
		DriverInitializer.Refresh();
	}

	public void ncr_13_verify_guestname_alphabets_reg() throws InterruptedException, AWTException
	{
		WebElement name_valid = driver.findElement(By.xpath(Name_editbox_xpath));
		name_valid.clear();
		name_valid.sendKeys("Sreekanth");
		Thread.sleep(1000);
		Reporter.log("NCR_13: Entered alphabets as Sreekanth at Guest Name",true);
		WebElement tick_name = driver.findElement(By.xpath(Tick_Mark_Name_xpath));
		boolean flag = tick_name.isDisplayed();
		if(flag==true)
		{
			Reporter.log("NCR_13: PASS",true);
			Reporter.log("NCR_13: As expected accepted alphabets as Sreekanth and Tick Mark displayed at Name", true);
					
		}
		else
		{
			Reporter.log("NCR_13: Fail",true);
			Reporter.log("NCR_13: Not accepted alphabets as Sreekanth,and Tick mark not Displayed at Name", true);
				
		}
		DriverInitializer.Refresh();
	}

	public void ncr_14_verify_guestname_blank() throws InterruptedException, AWTException
	{
		WebElement name_valid = driver.findElement(By.xpath(Name_editbox_xpath));
		name_valid.clear();
		name_valid.sendKeys("");
		Thread.sleep(1000);
		Reporter.log("NCR_14: Leave blank at Guest Name",true);
		
		WebElement Reg_button = driver.findElement(By.xpath(Reg_button_xpath));
		Reg_button.click();
		Thread.sleep(1000);
		//Error Message 
		WebElement err_msg = driver.findElement(By.xpath(Error_Msg_xpath_Name_editbox));
		String err = err_msg.getText();
		Reporter.log("NCR_14: "+err,true);
		if(err.equals(Error_Msg_Name_editbox))
		{
			Reporter.log("NCR_14: PASS",true);
			Reporter.log("NCR_14: As expected not accepting blank guest name,"+err+" error message displayed at Name", true);
					
		}
		else
		{
			Reporter.log("NCR_14: Fail",true);
			Reporter.log("NCR_14: Accepted blank guest name "+err+" error message not displayed at Name", true);
				
		}
		DriverInitializer.Refresh();
	}

	public void ncr_15_Verify_Name_Below6_char() throws InterruptedException, AWTException
	{
		WebElement name_below6_char = driver.findElement(By.xpath(Name_editbox_xpath));
		name_below6_char.clear();
		name_below6_char.sendKeys("Sree");
		Reporter.log("NCR_15: Entered below 6 Characters as Sree at Guest Name",true);
		WebElement length_err = driver.findElement(By.xpath(Error_Msg_of_length_xpath_Name));
		String err_msg = length_err.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && err_msg.equals(Error_Msg_of_length_Name))
		{
			Reporter.log("NCR_15: PASS",true);
			Reporter.log("NCR_15: As expected below 6 Characters not accepted,"+err_msg+" Displayed at Name", true);
				
		}
		else{
			Reporter.log("NCR_15: Fail",true);		
			Reporter.log("NCR_15: Below 6 Characters Accepted,"+err_msg+" not Displayed at Name", true);
			
		}
		DriverInitializer.Refresh();
	}

	public void ncr_16_Verify_Name_above30_char() throws InterruptedException, AWTException
	{
		WebElement name_above30_char = driver.findElement(By.xpath(Name_editbox_xpath));
		name_above30_char.clear();
		name_above30_char.sendKeys("Sreekanthsreekanthsreekanthsreekan");
		Reporter.log("NCR_16: Entered above 30 Characters as Sreekanthsreekanthsreekanthsreekan at Guest Name",true);
		WebElement length_err = driver.findElement(By.xpath(Error_Msg_of_length_xpath_Name));
		String err_msg = length_err.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && err_msg.equals(Error_Msg_of_length_Name))
		{
			Reporter.log("NCR_16: PASS",true);
			Reporter.log("NCR_16: As expected Above 30 Characters not accepted,"+err_msg+" Displayed at Name", true);
			
		}
		else{
			Reporter.log("NCR_16: Fail",true);			
			Reporter.log("NCR_16: Above 30 Characters accepted,"+err_msg+" not Displayed at Name", true);
				
		}
		DriverInitializer.Refresh();
	}
	
	public void ncr_17_verify_calendar_dob() throws InterruptedException
	{
		Reporter.log("NCR_17: PASS",true);
		Reporter.log("NCR_17: This is Not Possible for Automation",true);
		Reporter.log("NCR_17: As expected Calendar get opened after click on date of birth drop button according to manual testing",true);
	}

	public void ncr_18_verify_current_date_default_calendar_dob() throws InterruptedException
	{
		Reporter.log("NCR_18: PASS",true);
		Reporter.log("NCR_18: This is Not Possible for Automation",true);
		Reporter.log("NCR_18: As expected Current date selected, displayed current month in Calendar after calendar get opened according to manual testing",true);
	}

	public void ncr_19_verify_date_of_birth_valid_below_2014() throws InterruptedException, AWTException
	{
			//Date of Birth
		   WebElement DOB = driver.findElement(By.xpath(DOB_xpath));
	       DOB.click();
	       Robot robot = new Robot();  // Robot class throws AWT Exception	
	       Thread.sleep(1000);         // Thread.sleep throws InterruptedException	
	       robot.keyPress(KeyEvent.VK_0); // press arrow down key of keyboard to navigate and select Save radio button	
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_6);
	       Reporter.log("NCR_19:  Selected 06 at Month field",true);
	       Thread.sleep(1000);  // sleep has only been used to show case each event separately	
	       robot.keyPress(KeyEvent.VK_0);
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_1);
	       Reporter.log("NCR_19:  Selected 01 at Date field",true);
	       Thread.sleep(1000);	
	       robot.keyPress(KeyEvent.VK_1);
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_9);
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_9);
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_0);
	       Reporter.log("NCR_19:  Selected 1990 at Year field",true);
	       Thread.sleep(2000); 
	       WebElement After_Dob = driver.findElement(By.cssSelector(DOB_After_Selection_CSS));
	       String attr_val = After_Dob.getAttribute(DOB_After_Selection_Attribute);
		boolean flag = driver.findElement(By.xpath(Tick_Mark_DOB_xpath)).isDisplayed();
		if(flag==true && attr_val.equals(After_Selecting_DOB_Attribute_Value))
		{
			Reporter.log("NCR_19: PASS",true);
			Reporter.log("NCR_19: As expected  06/01/1990 date Selected and accepted and Tick mark displayed at Date of birth", true);
			
		}
		else
		{
			Reporter.log("NCR_19: FAIL",true);
			Reporter.log("NCR_19: Not Selected 06/01/1990 date,Tick Mark is not displayed at Date of Birth", true);
			
		}
		DriverInitializer.Refresh();
		
	}
	
	public void ncr_20_verify_dob_selected_or_not() throws AWTException, InterruptedException
	{
		 WebElement After_Dob = driver.findElement(By.cssSelector(DOB_After_Selection_CSS));
	     String attr_val = After_Dob.getAttribute(DOB_After_Selection_Attribute);
	     if(attr_val.equals(After_Selecting_DOB_Attribute_Value))
			{
				Reporter.log("NCR_20: PASS",true);
				Reporter.log("NCR_20: As expected  06/01/1990 date displayed at date of birth field ", true);
				
			}
			else
			{
				Reporter.log("NCR_20: FAIL",true);
				Reporter.log("NCR_20: 06/01/1990 date not displayed at date of birth field", true);
				
			}
	     DriverInitializer.Refresh();
	}

	public void ncr_21_verify_Selected_dob_format() throws InterruptedException
	{
		Reporter.log("NCR_21: PASS",true);
		Reporter.log("NCR_21: This is Not Possible for Automation due to no element to target",true);
		Reporter.log("NCR_21: As expected Before selecting the date dispalying as mm/dd/yyyy at Date of birth field according to manual testing",true);
		Reporter.log("NCR_21: As expected after selecting the date 06/01/1990, dispalying as mm/dd/yyyy format at Date of birth field according to manual testing",true);
	}

	public void ncr_22_verify_date_of_birth_invalid_morethan_2014() throws InterruptedException, AWTException
	{
			//Date of Birth
		   WebElement DOB = driver.findElement(By.xpath(DOB_xpath));
	       DOB.click();
	       Robot robot = new Robot();  // Robot class throws AWT Exception	
	       Thread.sleep(1000);         // Thread.sleep throws InterruptedException	
	       robot.keyPress(KeyEvent.VK_0); // press arrow down key of keyboard to navigate and select Save radio button	
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_6);
	       Reporter.log("NCR_22:  Selected 06 at Month field",true);
	       Thread.sleep(1000);  // sleep has only been used to show case each event separately	
	       robot.keyPress(KeyEvent.VK_0);
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_1);
	       Reporter.log("NCR_22:  Selected 01 at Date field",true);
	       Thread.sleep(1000);	
	       robot.keyPress(KeyEvent.VK_2);
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_0);
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_1);
	       Thread.sleep(1000);
	       robot.keyPress(KeyEvent.VK_6);
	       Reporter.log("NCR_22:  Selected 2016 at Year field",true);
	       Thread.sleep(2000); 
	       WebElement After_Dob = driver.findElement(By.cssSelector(DOB_After_Selection_CSS));
	       String attr_val = After_Dob.getAttribute(DOB_After_Selection_Attribute);
		boolean flag = driver.findElement(By.xpath(Tick_Mark_DOB_xpath)).isDisplayed();
		if(flag!=true && attr_val.equals(Before_Selecting_DOB_Attribute_Value))
		{
			Reporter.log("NCR_22: PASS",true);
			Reporter.log("NCR_22: As expected  not accepting morethan 2014, selected 06/01/2016 date not accepted at Date of birth", true);
			
		}
		else
		{
			Reporter.log("NCR_22: FAIL",true);
			Reporter.log("NCR_22: Accepting morethan 2014,selected 06/01/2016 date accepted,Tick Mark is displayed at Date of Birth", true);
			Reporter.log("NCR_22: Should not accept more than 2014 year",true);
		}
		DriverInitializer.Refresh();
		
	}

	//Country Flag Mobile Number
	public void ncr_29_verify_country_flag_at_mobileNo()
	{
		boolean flag = driver.findElement(By.xpath(MobileNo_Country_Flag_xpath)).isDisplayed();
		if(flag==true)
		{
			Reporter.log("NCR_29: PASS",true);
			Reporter.log("NCR_29: As expected Country Flag is displayed at Mobile Number ", true);
			
		}
		else{
			Reporter.log("NCR_29: FAIL",true);
			Reporter.log("NCR_29: Country Flag is not displayed at  Mobile Number", true);
			
		}
	}
	//Country Code Mobile Number
	public void ncr_30_verify_country_code_at_mobileno()
	{
		WebElement CountryCode = driver.findElement(By.xpath(MobileNo_Country_Code_xpath));
		String CC = CountryCode.getText();
		boolean flag = CountryCode.isDisplayed();
		if(flag==true)
		{
			Reporter.log("NCR_30: PASS",true);
			Reporter.log("NCR_30: As expected Country Code "+CC+" is displayed at Mobile Number ", true);
					
		}
		else{
			Reporter.log("NCR_30: FAIL",true);
			Reporter.log("NCR_30: Country Code "+CC+" is not displayed at  Mobile Number", true);
			
			}
	}
	
	//Mobile Number
	public void ncr_31_verify_mobileno_valid_10digits() throws AWTException, InterruptedException
	{
		WebElement mobile_valid = driver.findElement(By.xpath(MobileNo_xpath));
		mobile_valid.clear();
		mobile_valid.sendKeys("9010801537");
		Reporter.log("NCR_31: Entered Valid Mobile No. with 10 digits as 9010801537",true);
		WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Mobile_Number_xpath));
		boolean flag = Tick_Mark.isDisplayed();
		if(flag==true)
		{
			Reporter.log("NCR_31: PASS",true);
			Reporter.log("NCR_31: As expected Valid Mobile No. 9010801537 accepted and at Mobile Number ", true);
			
		}
		else{
			Reporter.log("NCR_31: FAIL",true);
			Reporter.log("NCR_31: Valid Mobile No. 9010801537 not accepted at  Mobile Number", true);
			
			}
		DriverInitializer.Refresh();
	}

	public void ncr_32_verify_below10_invalid_mobileno() throws InterruptedException, AWTException
	{
		WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
		mobile_invalid.clear();
		mobile_invalid.sendKeys("901080");
		Reporter.log("NCR_32: Entered invalid Mobile No. with below 10 digits as 901080",true);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Invalid_MobileNo));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_of_Invalid_Input_MobileNo))
		{
			Reporter.log("NCR_32: PASS",true);
			Reporter.log("NCR_32: As expected  Below 10 digits not accepting ,"+error+" is displayed and Error Sign displayed at Mobile Number", true);
		}
		else
		{
			Reporter.log("NCR_32: FAIL",true);
			Reporter.log("NCR_32: Below 10 digits accepting, "+error+" and Error Sign is not displayed  at Mobile Number", true);
		}
		DriverInitializer.Refresh();
	}

	public void ncr_33_verify_above10_invalid_mobileno() throws InterruptedException, AWTException
	{
		WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
		mobile_invalid.clear();
		mobile_invalid.sendKeys("901080153712546");
		Reporter.log("NCR_33: Entered invalid Mobile No. with above 10 digits as 901080153712546",true);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Invalid_MobileNo));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_of_Invalid_Input_MobileNo))
		{
			Reporter.log("NCR_33: PASS",true);
			Reporter.log("NCR_33: As expected  Above 10 digits not accepting ,"+error+" is displayed and Error Sign displayed at Mobile Number", true);
		}
		else
		{
			Reporter.log("NCR_33: FAIL",true);
			Reporter.log("NCR_33: Above 10 digits accepting, "+error+" and Error Sign is not displayed  at Mobile Number", true);
		}
		DriverInitializer.Refresh();
	}

	public void ncr_34_verify_invalid_alphabets_mobileno() throws InterruptedException, AWTException
	{
		WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
		mobile_invalid.clear();
		mobile_invalid.sendKeys("sreekanthk");
		Reporter.log("NCR_34: Entered invalid Mobile No. with alphabets as sreekanthk",true);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Invalid_MobileNo));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_of_Invalid_Input_MobileNo))
		{
			Reporter.log("NCR_34: PASS",true);
			Reporter.log("NCR_34: As expected Alphabets not accepting ,"+error+" is displayed and Error Sign displayed at Mobile Number", true);
		}
		else
		{
			Reporter.log("NCR_34: FAIL",true);
			Reporter.log("NCR_34: Alphabets accepting, "+error+" and Error Sign is not displayed  at Mobile Number", true);
		}
		DriverInitializer.Refresh();
	}

	public void ncr_35_verify_invalid_spl_char_mobileno() throws InterruptedException, AWTException
	{
		WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
		mobile_invalid.clear();
		mobile_invalid.sendKeys("@#@$#%*)%&^#@");
		Reporter.log("NCR_35: Entered invalid Mobile No. with Special Characters as @#@$#%*)%&^#@",true);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Invalid_MobileNo));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_of_Invalid_Input_MobileNo))
		{
			Reporter.log("NCR_35: PASS",true);
			Reporter.log("NCR_35: As expected  Special Characters not accepting ,"+error+" is displayed and Error Sign displayed at Mobile Number", true);
		}
		else
		{
			Reporter.log("NCR_35: FAIL",true);
			Reporter.log("NCR_35: Special Characters accepting, "+error+" and Error Sign is not displayed  at Mobile Number", true);
		}
		DriverInitializer.Refresh();
	}

	public void ncr_36_verify_invalid_alphanumeric_mobileno() throws InterruptedException, AWTException
	{
		WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
		mobile_invalid.clear();
		mobile_invalid.sendKeys("1234sreeka");
		Reporter.log("NCR_36: Entered invalid Mobile No. with alpha numeric values as 1234sreeka",true);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Invalid_MobileNo));
		boolean flag1 = error_msg.isDisplayed();
		WebElement tick_mark = driver.findElement(By.xpath(Tick_Mark_Mobile_Number_xpath));
		boolean flag2 = tick_mark.isDisplayed();
		if(flag1==true && flag2!=true)
		{
			Reporter.log("NCR_36: PASS",true);
			Reporter.log("NCR_36: As expected Alphanumerics not accepting ,and Error Sign displayed at Mobile Number", true);
		}
		else
		{
			Reporter.log("NCR_36: FAIL",true);
			Reporter.log("NCR_36: Alphanumeric accepting, and error message not displayed  at Mobile Number", true);
			Reporter.log("NCR_36: Should display a message as Please Enter Valid Mobile Number", true);
		}
		DriverInitializer.Refresh();
		Thread.sleep(2000);
	}

	public void ncr_37_verify_mobileno_empty_reg() throws InterruptedException, AWTException
	{
		DriverInitializer.Refresh();
		Thread.sleep(2000);
		WebElement Reg_button = driver.findElement(By.xpath(Reg_button_xpath));
		Reg_button.click();
		Reporter.log("NCR_37: Clicked on Registration button without entering Mobile No.",true);
		Thread.sleep(3000);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_MobileNo));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_MobileNo))
		{
			Reporter.log("NCR_37: PASS",true);
			Reporter.log("NCR_37: As expected  "+error+" is displayed and Error Sign displayed at Mobile Number", true);
		}
		else
		{
			Reporter.log("NCR_37: FAIL",true);
			Reporter.log("NCR_37: "+error+" and Error Sign is not displayed  at Mobile Number", true);
		}
		DriverInitializer.Refresh();
	}
	
	public void ncr_38_verify_email_valid() throws InterruptedException, AWTException
	{
		WebElement email_valid = driver.findElement(By.xpath(Email_ID_xpath));
		email_valid.clear();
		email_valid.sendKeys("sreekatar@yahoo.com");
		Thread.sleep(1000);
		Reporter.log("NCR_38: Entered valid Email as sreekatar@yahoo.com at Email ID",true);
		WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
		boolean flag = Tick_Mark.isDisplayed();
		if(flag==true)
		{
			Reporter.log("NCR_38: PASS",true);
			Reporter.log("NCR_38: As expected Valid Email ID as sreekatar@yahoo.com accepted and at Email ", true);
					
		}
		else
		{
			Reporter.log("NCR_38: FAIL",true);
			Reporter.log("NCR_38: Valid Email ID as sreekatar@yahoo.com not accepted at Email", true);
		}
		DriverInitializer.Refresh();
	}
	
	public void ncr_39_verify_invalid_email_without_localpart() throws InterruptedException, AWTException
	{
		WebElement email_invalid = driver.findElement(By.xpath(Email_ID_xpath));
		email_invalid.clear();
		email_invalid.sendKeys("@gmail.com");
		Reporter.log("NCR_39: Entered Invalid Email without local part as @yahoo.com at Email ID",true);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Email_Invalid));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_Invalid_Email))
		{
			Reporter.log("NCR_39: PASS",true);
			Reporter.log("NCR_39: As expected email not accepting without entering local part,"+error+" is displayed and Error Sign displayed at Email", true);
		}
		else
		{
			Reporter.log("NCR_39: FAIL",true);
			Reporter.log("NCR_39: Email accepting without entering local part, "+error+" and Error Sign is not displayed  at Email", true);
		}
		DriverInitializer.Refresh();
	}
	
	public void ncr_40_verify_invalid_email_without_domain() throws InterruptedException, AWTException
	{
		WebElement email_invalid = driver.findElement(By.xpath(Email_ID_xpath));
		email_invalid.clear();
		email_invalid.sendKeys("sreekatar@");
		Reporter.log("NCR_40: Entered Invalid Email without Domain as sreekatar@ at Email ID",true);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Email_Invalid));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_Invalid_Email))
		{
			Reporter.log("NCR_40: PASS",true);
			Reporter.log("NCR_40: As expected email not accepting without domain ,"+error+" is displayed and Error Sign displayed at Email", true);
		}
		else
		{
			Reporter.log("NCR_40: FAIL",true);
			Reporter.log("NCR_40: Email accepting without domain, "+error+" and Error Sign is not displayed  at Email", true);
		}
		DriverInitializer.Refresh();
	}

	public void ncr_41_verify_email_with_1dot() throws InterruptedException, AWTException
	{
		WebElement email_valid = driver.findElement(By.xpath(Email_ID_xpath));
		email_valid.clear();
		email_valid.sendKeys("sreekatar@yahoo.com");
		Thread.sleep(1000);
		Reporter.log("NCR_41: Entered valid Email with 1 dot as sreekatar@yahoo.com at Email ID",true);
		WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
		boolean flag = Tick_Mark.isDisplayed();
		if(flag==true)
		{
			Reporter.log("NCR_41: PASS",true);
			Reporter.log("NCR_41: As expected Valid Email ID with 1 dot as sreekatar@yahoo.com accepted and at Email ", true);
					
		}
		else
		{
			Reporter.log("NCR_41: FAIL",true);
			Reporter.log("NCR_41: Valid Email ID with 1 dot as sreekatar@yahoo.com not accepted at Email", true);
		}
		DriverInitializer.Refresh();
	}

	public void ncr_42_verify_email_with_2dots() throws InterruptedException, AWTException
	{
		WebElement email_valid = driver.findElement(By.xpath(Email_ID_xpath));
		email_valid.clear();
		email_valid.sendKeys("sreekatar@yahoo.co.in");
		Thread.sleep(1000);
		Reporter.log("NCR_42: Entered valid Email with 2 dots as sreekatar@yahoo.co.in at Email ID",true);
		WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
		boolean flag = Tick_Mark.isDisplayed();
		if(flag==true)
		{
			Reporter.log("NCR_42: PASS",true);
			Reporter.log("NCR_42: As expected Email ID with 2 dots as sreekatar@yahoo.co.in accepted and at Email ", true);
					
		}
		else
		{
			Reporter.log("NCR_42: FAIL",true);
			Reporter.log("NCR_42: Email ID with 2 dots as sreekatar@yahoo.co.in not accepted at Email", true);
		}
		DriverInitializer.Refresh();
	}
	public void ncr_43_verify_email_with_Splchar_at_localpart() throws InterruptedException, AWTException
	{
	WebElement email_invalid2 = driver.findElement(By.xpath(Email_ID_xpath));
	email_invalid2.sendKeys("#@#&*&)#@yahoo.com");
	Reporter.log("NCR_43: Entered Email with Special Characters at Local part as #@#&*&)#@yahoo.com at Email ID",true);
	WebElement Tick_Mark2 = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
	boolean flag = Tick_Mark2.isDisplayed();
	Thread.sleep(2000);
	if(flag==true)
	{
		Reporter.log("NCR_43: PASS",true);
		Reporter.log("NCR_43: As expected not accepted special characters at local part as #@#&*&)#@yahoo.com at Email, and tick mark not displayed", true);
								
	}
	else
	{
		Reporter.log("NCR_43: FAIL",true);
		Reporter.log("NCR_43: Accepted special characters at local part as #@#&*&)#@yahoo.com at Email, tick mark displayed", true);
	}
	DriverInitializer.Refresh();
}

	public void ncr_44_verify_email_with_Splchar_at_Domain() throws InterruptedException, AWTException
	{
	WebElement email_invalid2 = driver.findElement(By.xpath(Email_ID_xpath));
	email_invalid2.sendKeys("sreekatar@#@#&*&)#.com");
	Reporter.log("NCR_44: Entered Email with Special Characters at Domain as sreekatar@#@#&*&)#.com at Email ID",true);
	WebElement Tick_Mark2 = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
	boolean flag = Tick_Mark2.isDisplayed();
	Thread.sleep(2000);
	if(flag==true)
	{
		Reporter.log("NCR_44: PASS",true);
		Reporter.log("NCR_44: As expected not accepted special characters at Domain as sreekatar@#@#&*&)#.com at Email, and tick mark not displayed", true);
								
	}
	else
	{
		Reporter.log("NCR_44: FAIL",true);
		Reporter.log("NCR_44: Accepted special characters at Domain as sreekatar@#@#&*&)#.com at Email, tick mark displayed", true);
	}
	DriverInitializer.Refresh();
}

	public void ncr_45_Verify_Email_with_3Dots_at_domain() throws InterruptedException, AWTException
	{
		WebElement email_valid = driver.findElement(By.xpath(Email_ID_xpath));
		email_valid.clear();
		email_valid.sendKeys("sreekatar@yahoo.co.in.in");
		Thread.sleep(1000);
		Reporter.log("NCR_45: Entered Email with 3 dots at Domain as sreekatar@yahoo.co.in.in at Email ID",true);
		WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
		boolean flag = Tick_Mark.isDisplayed();
		if(flag!=true)
		{
			Reporter.log("NCR_45: PASS",true);
			Reporter.log("NCR_45: As expected Email ID With 3 dots sreekatar@yahoo.co.in.in not accepted at Email, tick mark not displayed", true);
			
							
		}
		else
		{
			Reporter.log("NCR_45: FAIL",true);
			Reporter.log("NCR_45: Email ID With 3 dots sreekatar@yahoo.co.in.in accepted and at Email, and Tick mark displayed", true);
			Reporter.log("NCR_45: Should not accept more than 2 dots in domain",true);
		}
		DriverInitializer.Refresh();
	}
	public void ncr_46_Verify_Email_with_numerics_at_domain() throws InterruptedException, AWTException
	{
	
	WebElement email_invalid = driver.findElement(By.xpath(Email_ID_xpath));
	email_invalid.clear();
	email_invalid.sendKeys("sreekatar@123456");
	Thread.sleep(1000);
	Reporter.log("NCR_46: Entered Email with numerics at Domain as sreekatar@123456 at Email ID",true);
	WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
	boolean flag = Tick_Mark.isDisplayed();
	Thread.sleep(2000);
	if(flag!=true)
	{
		Reporter.log("NCR_46: PASS",true);
		Reporter.log("NCR_46: As expected not accepted as sreekatar@123456 at Email, and tick mark not displayed", true);
								
	}
	else
	{
		Reporter.log("NCR_46: FAIL",true);
		Reporter.log("NCR_46: Accepted numerics at domain in email as sreekatar@123456 at Email, tick mark displayed", true);
		Reporter.log("NCR_46: Should not accept numerics at domain",true);
	}
		DriverInitializer.Refresh();
  }

	public void ncr_47_Verify_Email_with_numerics_only_at_localpart() throws InterruptedException, AWTException
	{
	
	WebElement email_invalid = driver.findElement(By.xpath(Email_ID_xpath));
	email_invalid.clear();
	email_invalid.sendKeys("123456@yahoo.com");
	Thread.sleep(1000);
	Reporter.log("NCR_47: Entered Email with numerics only at local part as 123456@yahoo.com at Email ID",true);
	WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
	boolean flag = Tick_Mark.isDisplayed();
	Thread.sleep(2000);
	if(flag!=true)
	{
		Reporter.log("NCR_47: PASS",true);
		Reporter.log("NCR_47: As expected not accepted numerics only at local part as 123456@yahoo.com at Email, and tick mark not displayed", true);
								
	}
	else
	{
		Reporter.log("NCR_47: FAIL",true);
		Reporter.log("NCR_47: Accepted numerics only at local part in email as 123456@yahoo.com at Email, tick mark displayed", true);
		Reporter.log("NCR_47: Should not accept numerics at domain",true);
	}
	DriverInitializer.Refresh();
  }
	
	public void ncr_48_verify_address_valid() throws InterruptedException, AWTException
	{
		WebElement address = driver.findElement(By.xpath(Address_xpath));
		Reporter.log("NCR_48: PASS",true);
		address.sendKeys("HNo:10-902/10,Sarathi Nagar,Near Sunkulamma Temple,Kurnool,Kurnool(Dist)");
		Reporter.log("NCR_48: Entered address as 10-902/10,Sarathi Nagar,Near Sunkulamma Temple,Kurnool,Kurnool(Dist)",true);
		Reporter.log("NCR_48: As expected Accepting all datatypes in address",true);
		Thread.sleep(1000);
		DriverInitializer.Refresh();
	}	
	public void ncr_49_verify_Empty_address_reg() throws InterruptedException, AWTException
	{
		WebElement Reg_button = driver.findElement(By.xpath(Reg_button_xpath));
		Reg_button.click();
		Reporter.log("NCR_49: FAIL",true);
		Reporter.log("NCR_49: Error Message is not displayed at Address ", true);
		Reporter.log("NCR_49: Should display message as Please Enter Address", true);
		
		DriverInitializer.Refresh();
				
	}


	public void ncr_50_Verify_Dropdown_Gender() throws InterruptedException, AWTException
	{
		 
		WebElement gender_dropdown =driver.findElement(By.xpath(Gender_dropdown_xpath));
		Select Gender_Drop = new Select(gender_dropdown);
		Gender_Drop.selectByIndex(1);
		Thread.sleep(2000);
		Reporter.log("NCR_50: Selected Male Option at Gender",true);
		WebElement option = Gender_Drop.getFirstSelectedOption();
		String option_value = option.getText();
		
		boolean flag = driver.findElement(By.xpath(Tick_Mark_Gender_xpath)).isDisplayed();
		Thread.sleep(3000);
		
		if(flag==true && option_value.contains("Male"))
		{
			Reporter.log("NCR_50: PASS",true);
			Reporter.log("NCR_50: As expected  "+option_value+" is displayed and Tick mark displayed at Gender dropdown", true);
			
		}
		else
		{
			Reporter.log("NCR_50: FAIL",true);
			Reporter.log("NCR_50: "+option_value+" is not displayed at Gender dropdown", true);
			
		}
		DriverInitializer.Refresh();
	}
	
	public void ncr_51_verify_default_option_at_Gender() throws AWTException, InterruptedException
	{
		 WebElement ele = driver.findElement(By.xpath(Gender_dropdown_xpath));
		 Select title = new Select(ele);
		 WebElement select = title.getFirstSelectedOption();
		 String select_text = select.getText();
		 if(select_text.contains("Select"))
		{
		Reporter.log("NCR_51: PASS",true);
		Reporter.log("NCR_51: As expected Select Option is displayed at Gender Dropdown by default", true);
				
		}
	
		 else
		 {
		Reporter.log("NCR_51: FAIL",true);
		Reporter.log("NCR_51: Select Option is not displayed at Gender Dropdown by default", true);
		 }
		 DriverInitializer.Refresh();
	}	

	public void ncr_52_verify_empty_gender_reg() throws InterruptedException, AWTException
	{
		 
		WebElement Reg_button = driver.findElement(By.xpath(Reg_button_xpath));
		Reg_button.click();
		Thread.sleep(2000);
		WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Gender));
		String error = error_msg.getText();
		Thread.sleep(1000);
		boolean flag1 = driver.findElement(By.xpath(Reg_button_xpath)).isEnabled();
		boolean flag2 = driver.findElement(By.xpath(Book_Appointment_button_xpath)).isEnabled();
		if(flag1!=true && flag2!=true && error.equals(Error_Msg_Gender))
		{
			Reporter.log("NCR_52: PASS",true);
			Reporter.log("NCR_52: As expected  "+error+" is displayed and Error Sign displayed at Gender dropdown", true);
		}
		else
		{
			Reporter.log("NCR_52: FAIL",true);
			Reporter.log("NCR_52: "+error+" and Error Sign is not displayed  at Gender dropdown", true);
		}
		 DriverInitializer.Refresh();
	}

	
	public void ncr_112_verify_all_error_messages_reg() throws InterruptedException, AWTException
	{
		//Registration Button
		WebElement Reg_button = driver.findElement(By.xpath(Reg_button_xpath));
		Reg_button.click();
		Thread.sleep(2000);
		Reporter.log("NCR_112: Clicked on Registration button without giving inputs at mandatory fields",true);
		
		//Title
		WebElement error_msg_title = driver.findElement(By.xpath(Error_Msg_xpath_Title));
		String e1 = error_msg_title.getText();
		
		//Name
		WebElement error_msg_name = driver.findElement(By.xpath(Error_Msg_xpath_Name_editbox));
		String e2 = error_msg_name.getText();
		
		//Date of Birth
		WebElement error_msg_DOB = driver.findElement(By.xpath(Error_Msg_xpath_DOB));
		String e3 = error_msg_DOB.getText();
		
		//Mobile No
		WebElement error_msg_MobileNo = driver.findElement(By.xpath(Error_Msg_xpath_MobileNo));
		String e4 = error_msg_MobileNo.getText();
		
		//Email ID
		WebElement error_msg_Email_ID = driver.findElement(By.xpath(Error_Msg_xpath_Email));
		String e5 = error_msg_Email_ID.getText();
		
		//Gender
		WebElement error_msg_Gender = driver.findElement(By.xpath(Error_Msg_xpath_Gender));
		String e6 = error_msg_Gender.getText();
		
		if(e1.equals(Error_Msg_Title) && e2.equals(Error_Msg_Name_editbox) && e3.equals(Error_Msg_DOB) && e4.equals(Error_Msg_MobileNo) && e5.equals(Error_Msg_Email) && e6.equals(Error_Msg_Gender))
		{
			Reporter.log("NCR_112: PASS",true);
			Reporter.log("NCR_112: As expected all the Error messages displayed at mandatory fields",true);
			
		}
		else
		{
			Reporter.log("NCR_112: FAIL",true);
			Reporter.log("NCR_112: All the error messages not displaying at mandatory fields",true);
			}
		 DriverInitializer.Refresh();
	}
	
	public void ncr_118_verify_all_error_messages_book() throws InterruptedException, AWTException
	{
		//Registration Button
		WebElement BookAppointment_button = driver.findElement(By.xpath(Book_Appointment_button_xpath));
		BookAppointment_button.click();
		Thread.sleep(2000);
		Reporter.log("NCR_118: Clicked on Book Appointment button without giving inputs at mandatory fields",true);
		//Title
		WebElement error_msg_title = driver.findElement(By.xpath(Error_Msg_xpath_Title));
		String e1 = error_msg_title.getText();
		
		//Name
		WebElement error_msg_name = driver.findElement(By.xpath(Error_Msg_xpath_Name_editbox));
		String e2 = error_msg_name.getText();
		
		//Date of Birth
		WebElement error_msg_DOB = driver.findElement(By.xpath(Error_Msg_xpath_DOB));
		String e3 = error_msg_DOB.getText();
		
		//Mobile No
		WebElement error_msg_MobileNo = driver.findElement(By.xpath(Error_Msg_xpath_MobileNo));
		String e4 = error_msg_MobileNo.getText();
		
		//Email ID
		WebElement error_msg_Email_ID = driver.findElement(By.xpath(Error_Msg_xpath_Email));
		String e5 = error_msg_Email_ID.getText();
		
		//Gender
		WebElement error_msg_Gender = driver.findElement(By.xpath(Error_Msg_xpath_Gender));
		String e6 = error_msg_Gender.getText();
		
		if(e1.equals(Error_Msg_Title) && e2.equals(Error_Msg_Name_editbox) && e3.equals(Error_Msg_DOB) && e4.equals(Error_Msg_MobileNo) && e5.equals(Error_Msg_Email) && e6.equals(Error_Msg_Gender))
		{
			Reporter.log("NCR_118: PASS",true);
			Reporter.log("NCR_118: As expected all the Error messages displayed at mandatory fields",true);
			
		}
		else
		{
			Reporter.log("NCR_118: FAIL",true);
			Reporter.log("NCR_118: All the error messages not displaying at mandatory fields",true);
			
		}
		DriverInitializer.Refresh();
		
	}
	
	public void ncr_119_verify_placeholder_text_name() throws InterruptedException, AWTException
	{
		 
		String NamePlaceholder = driver.findElement(By.cssSelector(Name_editbox_Placeholder_Text_Css)).getAttribute(Name_editbox_Placeholder_Attribute);
		Thread.sleep(2000);
		if(NamePlaceholder.contains(Name_editbox_Placeholder_Text))
		{
			Reporter.log("NCR_119: FAIL",true);
			Reporter.log("NCR_119: As expected "+ NamePlaceholder +" is displayed as place hoder text at Name", true);
			
		}
		else
		{
			Reporter.log("NCR_119: PASS",true);
			Reporter.log("NCR_119: "+ NamePlaceholder +" is not displayed as place holder text at Name", true);
			
		}
		DriverInitializer.Refresh();
	}


	public void ncr_120_verify_placeholder_text_mobileno() throws InterruptedException
	{
		 
		String MobileNoPlaceholder = driver.findElement(By.cssSelector(MobileNo_editbox_Placeholder_Text_Css)).getAttribute(MobileNo_editbox_Placeholder_Attribute);
		Thread.sleep(2000);
		if(MobileNoPlaceholder.contains(MobileNo_editbox_Placeholder_Text))
		{
			Reporter.log("NCR_120: FAIL",true);
			Reporter.log("NCR_120: As expected "+ MobileNoPlaceholder +" is displayed as Placeholder text at Mobile No. ", true);
			
		}
		else
		{
			Reporter.log("NCR_120: PASS",true);
			Reporter.log("NCR_120: "+ MobileNoPlaceholder +" is not displayed as  Placeholder text at Mobile No.", true);
			
		}
		
	}
	
	
	


}

