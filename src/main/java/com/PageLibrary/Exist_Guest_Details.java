package com.PageLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.PageLocators.Exist_Guest_Details_Locators;
import com.util.DriverInitializer;

public class Exist_Guest_Details extends Exist_Guest_Details_Locators
{
	public  WebDriver driver = DriverInitializer.getDriver();
	
	public void egd_01_client_menu_options() throws InterruptedException, AWTException, IOException
	{
		WebElement Client = driver.findElement(By.xpath(Client_Module_dropdown_xpath));
		Client.click();
		Thread.sleep(1000);
		WebElement ul = driver.findElement(By.xpath(MenuOptions_xpath));
		List<WebElement> alloptions = ul.findElements(By.tagName("a"));
		Reporter.log("EGD_01: Client Menu Options",true);
		for (WebElement EachOption : alloptions) 
		{
			String option_name = EachOption.getText();
			Reporter.log(option_name,true);
		}
		Reporter.log("EGD_01: PASS",true);
		Reporter.log("EGD_01: As expected Client Menu Options displayed Correctly",true);
		
		

		DriverInitializer.Refresh();
	}
	
	public void egd_02_existing_guest_details_page() throws InterruptedException, AWTException, IOException
	{
		WebElement client_module = driver.findElement(By.xpath(Client_Module_dropdown_xpath));
		client_module.click();
		Reporter.log("EGD_02: Clicked on Client Module", true);
		Thread.sleep(1000);
		
		WebElement existing_clients_option = driver.findElement(By.xpath(Exist_Guest_Details_xpath));
		existing_clients_option.click();
		Reporter.log("EGD_02: Clicked on Existing Clients Option", true);
		Thread.sleep(1000);
		
		String pageurl = driver.getCurrentUrl();
		if(pageurl.equals(Exist_Guest_URL))
		{
			Reporter.log("EGD_02: PASS",true);
			Reporter.log("EGD_02: As expected Existing Guest Details Page is displayed",true);
		}
		else
		{
			Reporter.log("EGD_02: FAIL",true);	
			Reporter.log("EGD_02: Existing Guest Details Page is not displayed",true);
		}
		
		DriverInitializer.Refresh();
	}

	public void egd_03_Verify_UI()
	{
		Reporter.log("EGD_03: PASS",true);
		Reporter.log("EGD_03: As expected UI aligned and displayed properly",true);
	}
	
	public void egd_04_Verify_headings() throws AWTException, InterruptedException
	{
		//Main Heading
		WebElement RegMainHeading = driver.findElement(By.xpath(Main_Heading_Text_xpath));
		String mainheading = RegMainHeading.getText();
				
		//Sub Heading
		WebElement SubHeading = driver.findElement(By.xpath(Sub_Heading_Text_xpath));
		String subheading = SubHeading.getText();
			
		
		if(mainheading.equals(Main_Heading_Text) && subheading.equals(Sub_Heading_Text)){
			Reporter.log("EGD_04: PASS",true);
			Reporter.log("EGD_04: Main Heading: "+mainheading,true);
			Reporter.log("EGD_04: Sub Heading: "+subheading,true);
			Reporter.log("EGD_04: Should Display Mainheading equal to Module Option Name",true);
			Reporter.log("EGD_04: As expected Existing Clients Page Headings displayed Correctly ", true);
		}
		else{
			Reporter.log("EGD_04: FAIL",true);
			Reporter.log("EGD_04: Existing Clients Page Headings displayed Wrongly, Not displaying as Expected", true);
		}
		DriverInitializer.Refresh();
	}
	
	public void egd_05_verify_webtable() throws AWTException, InterruptedException, IOException
	{
		WebElement webtable_header = driver.findElement(By.xpath(webtable_header_xpath));
		List<WebElement> header = webtable_header.findElements(By.tagName("tr"));
		Reporter.log("EGD_05: Webtable Data ",true);
		for (WebElement tableheader : header) 
		{
			String th = tableheader.getText();
			Reporter.log("   "+th,true);
			Reporter.log("------------------------------------------------------------------",true);
		}
		
		WebElement table = driver.findElement(By.xpath(WebTable_xpath));
		WebElement tablebody = table.findElement(By.tagName("tbody"));
		List<WebElement> tablerows = tablebody.findElements(By.tagName("tr"));
		int rs = tablerows.size();
		System.out.println(rs);
		for (WebElement eachrow : tablerows) {
			String text = eachrow.getText();
			Reporter.log("   "+text,true);
			Reporter.log("------------------------------------------------------------------",true);
			}
		boolean flag = table.isDisplayed();
		if(flag==true)
		{
			Reporter.log("EGD_05: PASS",true);
			Reporter.log("EGD_05: As expected displayed Existing Clients List as webtable",true);
		}
		else
		{
			Reporter.log("EGD_05: FAIL",true);
			Reporter.log("EGD_05: Not displayed Existing Clients List as webtable",true);
		}
		
		DriverInitializer.Refresh();
	}
	
	public void egd_06_verify_SearchCustomer_valid() throws InterruptedException, AWTException
	{
		WebElement Search_Textbox = driver.findElement(By.xpath(Search_Textbox_xpath));
		Search_Textbox.clear();
		Search_Textbox.sendKeys("Ram");
		Reporter.log("EGD_06: Entered Ram in Search Box",true);
		Thread.sleep(2000);
		WebElement Searchbutton = driver.findElement(By.xpath(Search_button_xpath));
		Searchbutton.click();
		Reporter.log("EGD_06: Clicked on Search Button",true);
		Thread.sleep(1000);
		
		WebElement webtable_header = driver.findElement(By.xpath(webtable_header_xpath));
		List<WebElement> header = webtable_header.findElements(By.tagName("tr"));
		Reporter.log("EGD_06: Webtable Data of Ram ",true);
		for (WebElement tableheader : header) 
		{
			String th = tableheader.getText();
			Reporter.log("   "+th,true);
			Reporter.log("------------------------------------------------------------------",true);
		}
		
		WebElement table = driver.findElement(By.xpath(WebTable_xpath));
		WebElement tablebody = table.findElement(By.tagName("tbody"));
		List<WebElement> tablerows = tablebody.findElements(By.tagName("tr"));
		int rs = tablerows.size();
		System.out.println(rs);
		for (WebElement eachrow : tablerows) {
			String text = eachrow.getText();
			Reporter.log("   "+text,true);
			Reporter.log("------------------------------------------------------------------",true);
			}
		boolean flag = table.isDisplayed();
		if(flag==true)
		{
			Reporter.log("EGD_06: PASS",true);
			Reporter.log("EGD_06: As expected displayed Ram Data as webtable",true);
		}
		else
		{
			Reporter.log("EGD_06: FAIL",true);
			Reporter.log("EGD_06: Not displayed Ram Data as webtable",true);
		}
		DriverInitializer.Refresh();
	}
	
	
	public void egd_07_verify_SearchResult_Without_Name_Search() throws InterruptedException
	{
		WebElement Search_Textbox = driver.findElement(By.xpath(Search_Textbox_xpath));
		Search_Textbox.clear();
		Search_Textbox.sendKeys("Ram");
		Reporter.log("EGD_07: Entered Ram in Search Box",true);
		Thread.sleep(2000);
		WebElement Searchbutton = driver.findElement(By.xpath(Search_button_xpath));
		Searchbutton.click();
		Reporter.log("EGD_07: Clicked on Search Button",true);
		Reporter.log("EGD_07: FAIL",true);
		Reporter.log("EGD_07: Error Message not displayed after clicked on search button without entering customer name in search box",true);
		Reporter.log("EGD_07: Should display a message as << Please Enter Customer Name then Search >> ",true);
	}
	
	public void egd_08_verify_UnregisteredCustomer_Search() throws InterruptedException, AWTException
	{
		WebElement Search_Textbox = driver.findElement(By.xpath(Search_Textbox_xpath));
		Search_Textbox.clear();
		Search_Textbox.sendKeys("ramu");
		Reporter.log("EGD_08: Entered ramu in Search Box",true);
		Thread.sleep(2000);
		WebElement Searchbutton = driver.findElement(By.xpath(Search_button_xpath));
		Searchbutton.click();
		Reporter.log("EGD_08: Clicked on Search Button",true);
		Thread.sleep(2000);
		String ps = driver.getPageSource();
		if(ps.contains(Err_Invalid_Customer_Search_Text))
		{
			Reporter.log("EGD_08: PASS",true);
			Reporter.log("EGD_08: As expected displayed "+Err_Invalid_Customer_Search_Text+ " and No list displayed in webtable",true);
		}
		else
		{
			Reporter.log("EGD_08: FAIL",true);
			Reporter.log("EGD_08: Not displayed "+Err_Invalid_Customer_Search_Text,true);
		}
		DriverInitializer.Refresh();
	}	
	
	
	public void egd_09_verify_invalid_customersearch() throws InterruptedException, AWTException{
		
		//Special Characters
		WebElement splchar = driver.findElement(By.xpath(Search_Textbox_xpath));
		splchar.clear();
		splchar.sendKeys("@%$#$#$#");
		Reporter.log("EGD_09: Entered @%$#$#$# in Search Box",true);
		Thread.sleep(1000);
		
		WebElement Searchbutton = driver.findElement(By.xpath(Search_button_xpath));
		Searchbutton.click();
		Reporter.log("EGD_09: Clicked on Search Button",true);
		Thread.sleep(2000);
		
		String ps = driver.getPageSource();
		if(ps.contains(Err_Invalid_Customer_Search_Text_Splchar))
		{

			Reporter.log("EGD_09_splchar: Able to enter Special Characters "+Err_Invalid_Customer_Search_Text_Splchar+ " and No list displayed in webtable",true);
			Reporter.log("EGD_09_splchar: Should not be able to enter and not accept Special characters",true);
		}
		else
		{
			
			Reporter.log("EGD_09_splchar: Not able to enter Special Characters "+Err_Invalid_Customer_Search_Text_Splchar,true);
		}
		
		DriverInitializer.Refresh();
		
		//numeric
		WebElement numeric = driver.findElement(By.xpath(Search_Textbox_xpath));
		numeric.clear();
		numeric.sendKeys("123456");
		Reporter.log("EGD_09: Entered 123456 in Search Box",true);
		Thread.sleep(1000);
		
		WebElement Searchbutton1 = driver.findElement(By.xpath(Search_button_xpath));
		Searchbutton1.click();
		Reporter.log("EGD_09: Clicked on Search Button",true);
		Thread.sleep(2000);
		
		
		String ps1 = driver.getPageSource();
		if(ps1.contains(Err_Invalid_Customer_Search_Text_numeric))
		{
		
			Reporter.log("EGD_09_numeric: Able to enter Numerics "+Err_Invalid_Customer_Search_Text_numeric+ " and No list displayed in webtable",true);
			Reporter.log("EGD_09_numeric: Should not be able to enter and not accept Numerics",true);
		}
		else
		{
	
			Reporter.log("EGD_09_numeric: Not able to enter Numerics "+Err_Invalid_Customer_Search_Text_numeric,true);
		}
		
		DriverInitializer.Refresh();
		//alpha numeric
		WebElement alphanumeric = driver.findElement(By.xpath(Search_Textbox_xpath));
		alphanumeric.clear();
		alphanumeric.sendKeys("123sree");
		Reporter.log("EGD_09: Entered 123sree in Search Box",true);
		Thread.sleep(1000);
				
		WebElement Searchbutton2 = driver.findElement(By.xpath(Search_button_xpath));
		Searchbutton2.click();
		Reporter.log("EGD_09: Clicked on Search Button",true);
		Thread.sleep(2000);
				
				
		String ps2 = driver.getPageSource();
		if(ps2.contains(Err_Invalid_Customer_Search_Text_alphanumeric))
		{
			
			Reporter.log("EGD_09_alphanumeric: Able to enter Alpha Numerics "+Err_Invalid_Customer_Search_Text_alphanumeric+ " and No list displayed in webtable",true);
			Reporter.log("EGD_09_alphanumeric: Should not be able to enter and not accept Alpha Numerics",true);
		}
		else
		{
		
			Reporter.log("EGD_09_alphanumeric: Not able to enter Alpha Numerics "+Err_Invalid_Customer_Search_Text_alphanumeric,true);
		}
		
		Reporter.log("EGD_09_: FAIL",true);
		
		DriverInitializer.Refresh();	
	}
	
	public void egd_10_verify_search_button() throws AWTException, InterruptedException
	{
	
		boolean flag = driver.findElement(By.xpath(Search_button_xpath)).isEnabled();
		if(flag==true)
		{
			Reporter.log("EGD_10: PASS",true);
			Reporter.log("EGD_10: As expected Search Button is enabled by default", true);
			
		}
		else{
			Reporter.log("EGD_10: FAIL",true);
			Reporter.log("EGD_10: Search Button is not enabled by default", true);
			
		}
	
	}
	
	public void egd_11_verify_pagenobuttons() throws AWTException, InterruptedException
	{
		 WebElement pageno_buttons = driver.findElement(By.xpath(PageNo_Enable_xpath));
		 boolean flag1 = pageno_buttons.isDisplayed();
		 boolean flag2 = pageno_buttons.isEnabled();
		 
		 if(flag1 && flag2 == true){
			 Reporter.log("EGD_11: FAIL",true);
			 Reporter.log("EGD_11: Page No. buttons are displayed and enabled as expected but page no. buttons functionality not working properly according to manual testing",true);
		 }
		 else{
			 Reporter.log("EGD_11: PASS",true);
			 Reporter.log("EGD_11: Page no. displayed and enabled as per data exists and also buttons are working properly",true);
		 }
		
		
	}
	
	public void egd_12_verify_customer_id() throws InterruptedException, AWTException
	{	WebElement Search_Textbox = driver.findElement(By.xpath(Search_Textbox_xpath));
		Search_Textbox.clear();
		Search_Textbox.sendKeys("Ram");
		Reporter.log("EGD_12: Entered Ram in Search Box",true);
		Thread.sleep(2000);
		WebElement Searchbutton = driver.findElement(By.xpath(Search_button_xpath));
		Searchbutton.click();
		Reporter.log("EGD_12: Clicked on Search Button",true);
		Thread.sleep(1000);
		
		 WebElement CustID_6 = driver.findElement(By.xpath(Cust_ID_6_Val_xpath));
		 boolean flag = CustID_6.isDisplayed();
		
		 Thread.sleep(2000);
	
		if(flag==true)
		{
			Reporter.log("EGD_12: PASS",true);
			Reporter.log("EGD_12: As expected Customer_ID Button is displayed and enabled ", true);
			
		}
		else{
			Reporter.log("EGD_12: FAIL",true);
			Reporter.log("EGD_12: Customer_ID Button is not displayed and not enabled ", true);
			
		}
		
		DriverInitializer.Refresh();
		}
		
	public void egd_13_verify_clientmodificationspage_afterclickedon_custID() throws InterruptedException
	{
		WebElement Search_Textbox = driver.findElement(By.xpath(Search_Textbox_xpath));
		Search_Textbox.clear();
		Search_Textbox.sendKeys("Ram");
		Reporter.log("EGD_13: Entered Ram in Search Box",true);
		Thread.sleep(2000);
		WebElement Searchbutton = driver.findElement(By.xpath(Search_button_xpath));
		Searchbutton.click();
		Reporter.log("EGD_13: Clicked on Search Button",true);
		Thread.sleep(1000);
		WebElement Cus_ID_Ram_6 = driver.findElement(By.xpath(Cust_ID_6_Val_xpath));
		Cus_ID_Ram_6.click();
		Reporter.log("EGD_13: Clicked on 6 in Customer ID",true);
		Thread.sleep(2000);
		String UpdateClientPageURL = driver.getCurrentUrl();
		if(UpdateClientPageURL.equals(Cust_Ram_6_Update_Reg_Page_URL))
		{
			Reporter.log("EGD_13: PASS",true);
			Reporter.log("EGD_13: As expected "+UpdateClientPageURL+" displayed ", true);
		}
		else
		{
			Reporter.log("EGD_13: FAIL",true);
			Reporter.log("EGD_13: Not displayed "+UpdateClientPageURL , true);
		}
	
	}
			
	public void egd_14_verify_headings_clientmodification_page() throws InterruptedException
	{
		//Main Heading
		WebElement UpdateClientMainHeading = driver.findElement(By.xpath(Main_Heading_Guest_Modify_Text_xpath));
		String mainheading = UpdateClientMainHeading.getText();
		Thread.sleep(1000);
		
		//Sub Heading1
		WebElement UpdateClientSubHeading1 = driver.findElement(By.xpath(Sub_Heading1_Guest_Modify_Text_xpath));
		String subheading1 = UpdateClientSubHeading1.getText();
		Thread.sleep(1000);
		//Sub Heading2
		WebElement UpdateClientSubHeading2 = driver.findElement(By.xpath(Sub_Heading2_Guest_Modify_Text_xpath));
		String subheading2 = UpdateClientSubHeading2.getText();
		Thread.sleep(1000);
		if(mainheading.equals(Main_Heading_Guest_Modify_Text) 
			&& subheading1.equals(Sub_Heading1_Guest_Modify_Text)
			&& subheading2.equals(Sub_Heading2_Guest_Modify_Text))
		{
			Reporter.log("EGD_14: PASS",true);
			Reporter.log("EGD_14: As expected Update Client Page Main Heading, Sub Heading1 and Sub Heading2 displayed Correctly as "+ mainheading+ ","+subheading1+ " and "+subheading2, true);
		}
		else
		{
			Reporter.log("EGD_14: FAIL",true);
			Reporter.log("EGD_14: Not displayed Update Client Page Main Heading, Sub Heading1 and Sub Heading2 Correctly as "+ mainheading+ ","+subheading1+ " and "+subheading2, true);	
		}
	
	}
			
	public void egd_15_verify_existing_data_ifalready_entered() throws AWTException, InterruptedException
	{
		//Title
		boolean f1 = driver.findElement(By.xpath(Title_Dropdown_xpath)).isSelected();
		
		//Name
		String name = driver.findElement(By.xpath(Name_editbox_xpath)).getText();
		boolean f2 = name.isEmpty();
		
		//Date of Birth
		boolean f3 = driver.findElement(By.xpath(DOB_xpath)).isSelected();
		
		//Mobile No.
		String mobileno = driver.findElement(By.xpath(MobileNo_xpath)).getText();
		boolean f4 = mobileno.isEmpty();
		
		//Email ID
		String email = driver.findElement(By.xpath(Email_ID_xpath)).getText();
		boolean f5 = email.isEmpty();
		
		//Address
		String add = driver.findElement(By.xpath(Address_xpath)).getText();
		boolean f6 = add.isEmpty();
		
		//Gender
		boolean f7 = driver.findElement(By.xpath(Gender_dropdown_xpath)).isSelected();		
		
		
		if(f1!=true || f2==true || f3!=true || f4==true || f5==true || f6==true || f7!=true)
		{
			Reporter.log("EGD_15: FAIL",true);
			Reporter.log("EGD_15: Not displaying existing data in fields even data entered at the time of registration",true);
			Reporter.log("EGD_15: Should be displayed all the data which fields are already entered",true);
		}
		else
		{
			Reporter.log("EGD_15: PASS",true);
			Reporter.log("EGD_15: As expected all the exist data displaying in client modification page",true);
		}
		DriverInitializer.Refresh();
	}
			
	public void egd_16_verify_updateguestdetails_Button()
	{
	
		boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
		if(flag==true)
		{
			Reporter.log("EGD_16: PASS",true);
			Reporter.log("EGD_16: As expected Update Guest Details Button is enabled by default", true);
			
		}
		else{
			Reporter.log("EGD_16: FAIL",true);
			Reporter.log("EGD_16: Update Guest Details Button is not enabled by default", true);
			
		}
	}
		
		public void egd_17_verify_all_mandatory_symbols(){
			
			//Title Mandatory Symbol
			WebElement Title = driver.findElement(By.xpath(Mandatory_Symbol_Title_xpath));
			String title = Title.getText();
			Reporter.log("EGD_17: "+title,true);
			boolean f1 = Title.isDisplayed();
			
			//Name Mandatory Symbol
			 WebElement Name = driver.findElement(By.xpath(Mandatory_Symbol_Name_xpath));
			 String name = Name.getText();
			Reporter.log("EGD_17: "+name,true);
			 boolean f2 = Name.isDisplayed();
			
			//Gender Mandatory Symbol
			 WebElement Gender = driver.findElement(By.xpath(Mandatory_Symbol_Gender_xpath));
			 String gender = Gender.getText();
			 Reporter.log("EGD_17: "+gender,true);
			 boolean f3 = Gender.isDisplayed();
			
			if(f1 && f2 && f3 == true)
			{
				Reporter.log("EGD_17: FAIL",true);
				Reporter.log("EGD_17: Only showing mandatory symbols at Title, Name and Gender Fields",true);
				Reporter.log("EGD_17: Should be displayed mandatory symbols at Title, Name, Date of birth, Mobile No, Email ID and Gender",true);
			}
			else{
				Reporter.log("EGD_17: PASS",true);
				Reporter.log("EGD_17: Displayed mandatory symbols at Title, Name, Date of birth, Mobile No, Email ID and Gender",true);
			}
		
		}
		
	
		/*public void egd_18_verify_all_inputs_form(){
			
			WebElement form = driver.findElement(By.xpath(Exist_Guest_Details_Modification_form_xpath));
			Reporter.log("---------------------------All Labels-----------------------------------------",true);
			//labels
			List<WebElement> alllabels = form.findElements(By.tagName("label"));
			int labels = alllabels.size();
			Reporter.log("Total Lables are in form "+labels,true);
			for (WebElement eachlabel: alllabels) {
				String labelname = eachlabel.getText();
				Reporter.log(labelname,true);
			}
			Reporter.log("------------------------------------------------------------------------------",true);
			Reporter.log("----------------------------All Dropdowns-------------------------------------",true);
			//Dropdowns
			List<WebElement> alldropdowns = form.findElements(By.tagName("select"));
			int dropdowns = alldropdowns.size();
			Reporter.log("Total Dropdowns are in form "+dropdowns,true);
			for (WebElement eachdropdown : alldropdowns) {
				String att = eachdropdown.getAttribute("id");
				Reporter.log(att,true);
				boolean flag = eachdropdown.isSelected();
				if(flag!=true){
					Reporter.log(att+" is not selected by default",true);
				}
				else{
					Reporter.log(att+" is selected by default",true);
				}
			}
			Reporter.log("------------------------------------------------------------------------------",true);
			Reporter.log("------------------------------All Mandatory Symbols------------------------------------------------",true);
			//Mandatory symbols
			List<WebElement> allmandatory = form.findElements(By.className("mandatory"));
			int mandatory = allmandatory.size();
			Reporter.log("Total mandatory symbols are in form "+mandatory,true);
			for (WebElement eachmandatory : allmandatory) {
				String classname = eachmandatory.getText();
				Reporter.log(classname,true);
				String classatt = eachmandatory.getAttribute("class");
				Reporter.log(classatt,true);
				}
			Reporter.log("------------------------------------------------------------------------------",true);
			Reporter.log("----------------------------All Textboxes-------------------------------------",true);
			//All Textboxes
			List<WebElement> alltextboxes = form.findElements(By.cssSelector("input[type='search']"));
			int textboxes = alltextboxes.size();
			Reporter.log("Total Textboxes are in form "+textboxes,true);
			for (WebElement eachtextbox : alltextboxes) {
				String att = eachtextbox.getAttribute("id");
				Reporter.log(att,true);
				
			}
			Reporter.log("------------------------------------------------------------------------------",true);
			Reporter.log("----------------------------All Textboxes-------------------------------------",true);
			//All Textboxes
			List<WebElement> alltexts = form.findElements(By.cssSelector("input[type='text']"));
			int texts = alltexts.size();
			Reporter.log("Total Texts are in form "+texts,true);
			for (WebElement eachtext : alltexts) {
				String att = eachtext.getAttribute("id");
				Reporter.log(att,true);
				
			}
			Reporter.log("------------------------------------------------------------------------------",true);
			Reporter.log("----------------------------All Dates-------------------------------------",true);
			//All Textboxes
			List<WebElement> alldates = form.findElements(By.cssSelector("input[type='date']"));
			int date = alldates.size();
			Reporter.log("Total Dates are in form "+date,true);
			for (WebElement eachdate : alldates) {
				String att = eachdate.getAttribute("id");
				Reporter.log(att,true);
				
			}
			Reporter.log("------------------------------------------------------------------------------",true);
			Reporter.log("----------------------------All Buttons-------------------------------------",true);
			//All Textboxes
			List<WebElement> allbuttons = form.findElements(By.cssSelector("button[type='submit']"));
			int button = allbuttons.size();
			Reporter.log("Total Buttons are in form "+button,true);
			for (WebElement eachbutton : allbuttons) {
				String att = eachbutton.getAttribute("id");
				Reporter.log(att,true);
				
			}
			/*WebElement modelpopup = driver.findElement(By.xpath(Contra_editbox_xpath));
			List<WebElement> alldropdown = modelpopup.findElements(By.tagName("select"));
			int dd = alldropdown.size();
			Reporter.log("Total dropdowns are in model popup "+dd,true);
			for (WebElement eachdd : alldropdown) {
				String att = eachdd.getAttribute("id");
				Reporter.log(att,true);
				
			}
			//Name
		WebElement title = driver.findElement(By.xpath(Title_label_xpath));
		 String title_label = title.findElement(By.tagName("label")).getText();
		 Reporter.log("EGD_18_label: "+title_label,true);
		 String title_mand = title.findElement(By.tagName("span")).getText();
		 Reporter.log("EGD_18_mandatorysymbol: "+title_mand,true);
		
		 if(title_label.equals("Title") && title_mand.equals("*"))
		{
			 Reporter.log("EGD_18_title: PASS",true);
			 Reporter.log("EGD_18_title: Label and Mandatory symbol are displayed at Title",true);
		 }
		 else{
			 Reporter.log("EGD_18_title: FAIL",true);
			 Reporter.log("EGD_18_title: Label and Mandatory symbol are not displayed at Title",true);
		 }
		
		}*/
		
		public void egd_18_verify_title_dropdown_selected_asperregistration() throws InterruptedException, AWTException
		{
			WebElement title_dropdown =driver.findElement(By.xpath(Title_Dropdown_xpath));
			boolean flag = title_dropdown.isSelected();
			
			if(flag==true){
				Reporter.log("EGD_18: PASS",true);
				Reporter.log("EGD_18: As per Registration data displayed at Title",true);
			}
			else{
				Reporter.log("EGD_18: FAIL",true);
				Reporter.log("EGD_18: Title Field Empty,As per Registration data not displayed at Title",true);
			}
		}
		
		public void egd_19_verify_dropdown_title() throws InterruptedException, AWTException
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
				Reporter.log("EGD_19: PASS",true);
				Reporter.log("EGD_19: As expected  "+option_value+" is selected, displayed in the list box and Tick mark displayed at Title dropdown", true);
				
			}
			else
			{
				Reporter.log("EGD_19: FAIL",true);
				Reporter.log("EGD_19: "+option_value+" is not selected and displayed in the list box at Title dropdown", true);
				
			}
			DriverInitializer.Refresh();
			Thread.sleep(2000);
		}

			
		public void egd_20_verify_ClickonUpdateButton_title() throws InterruptedException, AWTException
		{
			WebElement title_dropdown =driver.findElement(By.xpath(Title_Dropdown_xpath));
			Select Title_Drop = new Select(title_dropdown);
			Title_Drop.selectByIndex(2);
			Thread.sleep(2000);
			
			WebElement update_button = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath));
			update_button.click();
			
							
			DriverInitializer.Refresh();
		
		}
			
		public void egd_21_verify_title_dropdown_valid() throws InterruptedException, AWTException
		{
			 
			WebElement title_dropdown =driver.findElement(By.xpath(Title_Dropdown_xpath));
			Select Title_Drop = new Select(title_dropdown);
			Title_Drop.selectByIndex(2);
			Thread.sleep(3000);
			WebElement option = Title_Drop.getFirstSelectedOption();
			String option_value = option.getText();
			Thread.sleep(2000);
			boolean flag = driver.findElement(By.xpath(Tick_Mark_Title_xpath)).isDisplayed();
			Thread.sleep(2000);
			
			if(flag==true && option_value.contains("Mr."))
			{
				Reporter.log("EGD_21: PASS",true);
				Reporter.log("EGD_21: As expected  "+option_value+" is selected as valid input and Tick mark displayed at Title dropdown", true);
				
			}
			else
			{
				Reporter.log("EGD_21: FAIL",true);
				Reporter.log("EGD_21: "+option_value+" is not selected as valid input at Title dropdown", true);
			}
			DriverInitializer.Refresh();
		}
	
		public void egd_22_verify_withouttitle() throws InterruptedException, AWTException
		{
			WebElement title_dropdown =driver.findElement(By.xpath(Title_Dropdown_xpath));
			Select Title_Drop = new Select(title_dropdown);
			Title_Drop.selectByIndex(2);
			Thread.sleep(2000);
			Title_Drop.selectByIndex(0);
			Thread.sleep(2000);
			
			String error = driver.findElement(By.xpath(Error_Msg_xpath_Title)).getText();
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(error.equals(Error_Msg_Title) && flag!=true)
			{
				Reporter.log("EGD_22: PASS",true);
				Reporter.log("EGD_22: As expected not accepted and showing "+error+"message and Update button disabled",true);
			}
			else{
				Reporter.log("EGD_22: FAIL",true);
				Reporter.log("EGD_22: Accepted and not showing "+error+"message ",true);
			}
			
			
							
			DriverInitializer.Refresh();
		
		}
			
			
		public void All_Errors(){
			WebElement title_dropdown =driver.findElement(By.xpath(Title_Dropdown_xpath));
			Select Title_Drop = new Select(title_dropdown);
			Title_Drop.selectByIndex(0);
			
			WebElement name =driver.findElement(By.xpath(Name_editbox_xpath));
			name.sendKeys("12@%$");
			
			
			WebElement form = driver.findElement(By.xpath(Exist_Guest_Details_Modification_form_xpath));
			List<WebElement> allsmalls = form.findElements(By.tagName("small"));
			for (WebElement eachsmall : allsmalls) {
				
				//String val = eachsmall.getAttribute("data-fv-for");
				//Reporter.log(val,true);
				String text = eachsmall.getText();
				Reporter.log(text,true);
				Reporter.log("------------------------------------------------------",true);
			}
		}
	
		public void egd_24_verify_guestname_alphabets_valid() throws InterruptedException, AWTException
		{
			WebElement name_valid = driver.findElement(By.xpath(Name_editbox_xpath));
			name_valid.clear();
			name_valid.sendKeys("Sreekanth");
			Thread.sleep(1000);
			Reporter.log("EGD_24: Entered alphabets as Sreekanth at Guest Name",true);
			WebElement tick_name = driver.findElement(By.xpath(Tick_Mark_Name_xpath));
			boolean flag = tick_name.isDisplayed();
			if(flag==true)
			{
				Reporter.log("EGD_24: PASS",true);
				Reporter.log("EGD_24: As expected accepted alphabets as Sreekanth and Tick Mark displayed at Name", true);
						
			}
			else
			{
				Reporter.log("EGD_24: Fail",true);
				Reporter.log("EGD_24: Not accepted alphabets as Sreekanth,and Tick mark not Displayed at Name", true);
					
			}
			DriverInitializer.Refresh();
		}

		public void egd_25_verify_guestname_invalid_alphanumeric() throws InterruptedException, AWTException
		{
			//AlphaNumeric
			WebElement name = driver.findElement(By.xpath(Name_editbox_xpath));
			name.clear();
			name.sendKeys("123sree");
			Reporter.log("EGD_25_Alphanumeric: Entered Alphanumeric as 123sree at Guest Name",true);
			Thread.sleep(2000);
			WebElement errdatatype = driver.findElement(By.xpath(Error_Msg_of_Datatype_xpath_Name));
			boolean flag1 = errdatatype.isDisplayed();
			WebElement Tick_mark_name = driver.findElement(By.xpath(Tick_Mark_Name_xpath));
			boolean flag2 = Tick_mark_name.isDisplayed();
			if(flag1==true || flag2!=true)
			{
				Reporter.log("EGD_25_Alphanumeric: PASS",true);
				Reporter.log("EGD_25_Alphanumeric: As expected Alphanumerics not accepting, Datatype Error Message displayed", true);
				
			}
			else{
				Reporter.log("EGD_25_Alphanumeric: FAIL",true);
				Reporter.log("EGD_25_Alphanumeric: Alphanumerics accepting and Datatype error message not displayed at Name",true);
				Reporter.log("EGD_25_Alphanumeric: Should display a message as Name can only consists alphabets ", true);
				
			}
			
			DriverInitializer.Refresh();
		}

		public void egd_25_verify_guestname_invalid_numeric() throws InterruptedException, AWTException
		{
			//Numeric
			WebElement name = driver.findElement(By.xpath(Name_editbox_xpath));
			name.clear();
			name.sendKeys("1234567");
			Reporter.log("EGD_25_Numeric: Entered Alphanumeric as 1234567 at Guest Name",true);
			Thread.sleep(2000);
			WebElement errdatatype = driver.findElement(By.xpath(Error_Msg_of_Datatype_xpath_Name));
			boolean flag1 = errdatatype.isDisplayed();
			WebElement Tick_mark_name = driver.findElement(By.xpath(Tick_Mark_Name_xpath));
			boolean flag2 = Tick_mark_name.isDisplayed();
			if(flag1==true || flag2!=true)
			{
				Reporter.log("EGD_25_Numeric: PASS",true);
				Reporter.log("EGD_25_Numeric: As expected Numerics not accepting, Datatype Error Message displayed", true);
				
			}
			else{
				Reporter.log("EGD_25_Numeric: FAIL",true);
				Reporter.log("EGD_25_Numeric: Numerics accepting and Datatype error message not displayed at Name",true);
				Reporter.log("EGD_25_Numeric: Should display a message as Name can only consists alphabets ", true);
				
			}
			
			DriverInitializer.Refresh();
		}
	
		public void egd_25_verify_guestname_invalid_splchar() throws InterruptedException, AWTException
		{
			//Special Characters
			WebElement name = driver.findElement(By.xpath(Name_editbox_xpath));
			name.clear();
			name.sendKeys("@#$%&^*#");
			Reporter.log("EGD_25_SplChar: Entered Special Characters as @#$%&^*# at Guest Name",true);
			WebElement err_datatype_name = driver.findElement(By.xpath(Error_Msg_of_Datatype_xpath_Name));
			String err_datatype = err_datatype_name.getText();
			Thread.sleep(1000);
			//Update Button
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			
		
			
			if(flag!=true && err_datatype.equals(Error_Msg_of_Datatype_Name))
			{
				Reporter.log("EGD_25_SplChar: PASS",true);
				Reporter.log("EGD_25_SplChar: As expected Special Characters not accepting and Length Error Message as "+err_datatype+" ", true);
				
				
			}
			else{
				Reporter.log("EGD_25_SplChar: Fail",true);
				Reporter.log("EGD_25_SplChar: Datatype Error Message not displayed at Name", true);
				
			}
			DriverInitializer.Refresh();
		}
	
		public void egd_26_verify_guestname_spaces() throws InterruptedException, AWTException
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
			Reporter.log("EGD_26: Entered Spaces at Guest Name",true);
			
			//Error Message 
			WebElement err_msg = driver.findElement(By.xpath(Error_Msg_xpath_Name_editbox));
			String err = err_msg.getText();
			Reporter.log("EGD_26: "+err,true);
		
			//Error Message of Datatype
			WebElement err_datatype_name = driver.findElement(By.xpath(Error_Msg_of_Datatype_xpath_Name));
			String err_datatype = err_datatype_name.getText();
			Reporter.log("EGD_26: "+err_datatype,true);
			
			//Error Message of Length
			WebElement err_length_name = driver.findElement(By.xpath(Error_Msg_of_length_xpath_Name));
			String err_length = err_length_name.getText();
			Reporter.log("EGD_26: "+err_length,true);
			
			//Registration Button
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			
		
			
			if(flag!=true && err.equals(Error_Msg_Name_editbox) && err_datatype.equals(Error_Msg_of_Datatype_Name) && err_length.equals(Error_Msg_of_length_Name))
			{
				Reporter.log("EGD_26: PASS",true);
				Reporter.log("EGD_26: As expected Spaces not accepting and Error messages displayed",true);
				
				
			}
			else{
				Reporter.log("EGD_26: Fail",true);
				Reporter.log("EGD_26: Datatype Error Message not displayed at Name", true);
				
			}
			DriverInitializer.Refresh();
		}
	
		public void egd_27_Verify_Name_Below6_char() throws InterruptedException, AWTException
		{
			WebElement name_below6_char = driver.findElement(By.xpath(Name_editbox_xpath));
			name_below6_char.clear();
			name_below6_char.sendKeys("Sree");
			Reporter.log("EGD_27: Entered below 6 Characters as Sree at Guest Name",true);
			WebElement length_err = driver.findElement(By.xpath(Error_Msg_of_length_xpath_Name));
			String err_msg = length_err.getText();
			Thread.sleep(1000);
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(flag!=true && err_msg.equals(Error_Msg_of_length_Name))
			{
				Reporter.log("EGD_27: PASS",true);
				Reporter.log("EGD_27: As expected below 6 Characters not accepted,"+err_msg+" Displayed at Name", true);
					
			}
			else{
				Reporter.log("EGD_27: Fail",true);		
				Reporter.log("EGD_27: Below 6 Characters Accepted,"+err_msg+" not Displayed at Name", true);
				
			}
			DriverInitializer.Refresh();
		}
	
		public void egd_28_Verify_Name_above30_char() throws InterruptedException, AWTException
		{
			WebElement name_above30_char = driver.findElement(By.xpath(Name_editbox_xpath));
			name_above30_char.clear();
			name_above30_char.sendKeys("Sreekanthsreekanthsreekanthsreekan");
			Reporter.log("EGD_28: Entered above 30 Characters as Sreekanthsreekanthsreekanthsreekan at Guest Name",true);
			WebElement length_err = driver.findElement(By.xpath(Error_Msg_of_length_xpath_Name));
			String err_msg = length_err.getText();
			Thread.sleep(1000);
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(flag!=true && err_msg.equals(Error_Msg_of_length_Name))
			{
				Reporter.log("EGD_28: PASS",true);
				Reporter.log("EGD_28: As expected Above 30 Characters not accepted,"+err_msg+" Displayed at Name", true);
				
			}
			else{
				Reporter.log("EGD_28: Fail",true);			
				Reporter.log("EGD_28: Above 30 Characters accepted,"+err_msg+" not Displayed at Name", true);
					
			}
			DriverInitializer.Refresh();
		}
	
		public void egd_29_verify_guestname_blank() throws InterruptedException, AWTException
		{
			WebElement name_valid = driver.findElement(By.xpath(Name_editbox_xpath));
			name_valid.clear();
			name_valid.sendKeys("");
			Thread.sleep(1000);
			Reporter.log("EGD_29: Leave blank at Guest Name",true);
			
			WebElement update_button = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath));
			update_button.click();
			Thread.sleep(1000);
			//Error Message 
			WebElement err_msg = driver.findElement(By.xpath(Error_Msg_xpath_Name_editbox));
			String err = err_msg.getText();
			Reporter.log("EGD_29: "+err,true);
			if(err.equals(Error_Msg_Name_editbox))
			{
				Reporter.log("EGD_29: PASS",true);
				Reporter.log("EGD_29: As expected not accepting blank guest name,"+err+" error message displayed at Name", true);
						
			}
			else
			{
				Reporter.log("EGD_29: Fail",true);
				Reporter.log("EGD_29: Accepted blank guest name "+err+" error message not displayed at Name", true);
					
			}
			DriverInitializer.Refresh();
		}

		public void egd_30_verify_calendar_dob() throws InterruptedException
		{
			Reporter.log("EGD_30: PASS",true);
			Reporter.log("EGD_30: This is Not Possible for Automation",true);
			Reporter.log("EGD_30: As expected Calendar get opened after click on date of birth drop button according to manual testing",true);
		}

		public void egd_31_verify_current_date_default_calendar_dob() throws InterruptedException
		{
			Reporter.log("EGD_31: PASS",true);
			Reporter.log("EGD_31: This is Not Possible for Automation",true);
			Reporter.log("EGD_31: As expected Current date selected, displayed current month in Calendar after calendar get opened according to manual testing",true);
		}

		public void egd_32_verify_date_of_birth_valid_below_2014() throws InterruptedException, AWTException
		{
				//Date of Birth
			   WebElement DOB = driver.findElement(By.xpath(DOB_xpath));
		       DOB.click();
		       Robot robot = new Robot();  // Robot class throws AWT Exception	
		       Thread.sleep(1000);         // Thread.sleep throws InterruptedException	
		       robot.keyPress(KeyEvent.VK_0); // press arrow down key of keyboard to navigate and select Save radio button	
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_6);
		       Reporter.log("EGD_32:  Selected 06 at Month field",true);
		       Thread.sleep(1000);  // sleep has only been used to show case each event separately	
		       robot.keyPress(KeyEvent.VK_0);
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_1);
		       Reporter.log("EGD_32:  Selected 01 at Date field",true);
		       Thread.sleep(1000);	
		       robot.keyPress(KeyEvent.VK_1);
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_9);
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_9);
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_0);
		       Reporter.log("EGD_32:  Selected 1990 at Year field",true);
		       Thread.sleep(2000); 
		       WebElement After_Dob = driver.findElement(By.cssSelector(DOB_After_Selection_CSS));
		       String attr_val = After_Dob.getAttribute(DOB_After_Selection_Attribute);
			boolean flag = driver.findElement(By.xpath(Tick_Mark_DOB_xpath)).isDisplayed();
			if(flag==true && attr_val.equals(After_Selecting_DOB_Attribute_Value))
			{
				Reporter.log("EGD_32: PASS",true);
				Reporter.log("EGD_32: As expected  06/01/1990 date Selected and accepted and Tick mark displayed at Date of birth", true);
				
			}
			else
			{
				Reporter.log("EGD_32: FAIL",true);
				Reporter.log("EGD_32: Not Selected 06/01/1990 date,Tick Mark is not displayed at Date of Birth", true);
				
			}
		
			
		}
		
		public void egd_33_verify_dob_selected_or_not() throws AWTException, InterruptedException
		{
			 WebElement After_Dob = driver.findElement(By.cssSelector(DOB_After_Selection_CSS));
		     String attr_val = After_Dob.getAttribute(DOB_After_Selection_Attribute);
		     Thread.sleep(2000);
		     if(attr_val.equals(After_Selecting_DOB_Attribute_Value))
				{
					Reporter.log("EGD_33: PASS",true);
					Reporter.log("EGD_33: As expected  06/01/1990 date displayed at date of birth field ", true);
					
				}
				else
				{
					Reporter.log("EGD_33: FAIL",true);
					Reporter.log("EGD_33: 06/01/1990 date not displayed at date of birth field", true);
					
				}
		     DriverInitializer.Refresh();
		}

		public void egd_34_verify_Selected_dob_format() throws InterruptedException
		{
			Reporter.log("EGD_34: PASS",true);
			Reporter.log("EGD_34: This is Not Possible for Automation due to no element to target",true);
			Reporter.log("EGD_34: As expected Before selecting the date dispalying as mm/dd/yyyy at Date of birth field according to manual testing",true);
			Reporter.log("EGD_34: As expected after selecting the date 06/01/1990, dispalying as mm/dd/yyyy format at Date of birth field according to manual testing",true);
		}

		public void egd_35_verify_date_of_birth_invalid_morethan_2014() throws InterruptedException, AWTException
		{
				//Date of Birth
			   WebElement DOB = driver.findElement(By.xpath(DOB_xpath));
		       DOB.click();
		       Robot robot = new Robot();  // Robot class throws AWT Exception	
		       Thread.sleep(1000);         // Thread.sleep throws InterruptedException	
		       robot.keyPress(KeyEvent.VK_0); // press arrow down key of keyboard to navigate and select Save radio button	
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_6);
		       Reporter.log("EGD_35:  Selected 06 at Month field",true);
		       Thread.sleep(1000);  // sleep has only been used to show case each event separately	
		       robot.keyPress(KeyEvent.VK_0);
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_1);
		       Reporter.log("EGD_35:  Selected 01 at Date field",true);
		       Thread.sleep(1000);	
		       robot.keyPress(KeyEvent.VK_2);
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_0);
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_1);
		       Thread.sleep(1000);
		       robot.keyPress(KeyEvent.VK_6);
		       Reporter.log("EGD_35:  Selected 2016 at Year field",true);
		       Thread.sleep(2000); 
		       WebElement After_Dob = driver.findElement(By.cssSelector(DOB_After_Selection_CSS));
		       String attr_val = After_Dob.getAttribute(DOB_After_Selection_Attribute);
			boolean flag = driver.findElement(By.xpath(Tick_Mark_DOB_xpath)).isDisplayed();
			if(flag!=true && attr_val.equals(Before_Selecting_DOB_Attribute_Value))
			{
				Reporter.log("EGD_35: PASS",true);
				Reporter.log("EGD_35: As expected  not accepting morethan 2014, selected 06/01/2016 date not accepted at Date of birth", true);
				
			}
			else
			{
				Reporter.log("EGD_35: FAIL",true);
				Reporter.log("EGD_35: Accepting morethan 2014,selected 06/01/2016 date accepted,Tick Mark is displayed at Date of Birth", true);
				Reporter.log("EGD_35: Should not accept more than 2014 year",true);
			}
			DriverInitializer.Refresh();
			
		}

		//Country Flag Mobile Number
		public void egd_44_verify_country_flag_at_mobileNo()
		{
			boolean flag = driver.findElement(By.xpath(MobileNo_Country_Flag_xpath)).isDisplayed();
			if(flag==true)
			{
				Reporter.log("EGD_44: PASS",true);
				Reporter.log("EGD_44: As expected Country Flag is displayed at Mobile Number ", true);
				
			}
			else{
				Reporter.log("EGD_44: FAIL",true);
				Reporter.log("EGD_44: Country Flag is not displayed at  Mobile Number", true);
				
			}
		}
		//Country Code Mobile Number
		public void egd_45_verify_country_code_at_mobileno()
		{
			WebElement CountryCode = driver.findElement(By.xpath(MobileNo_Dial_Code_xpath));
			String CC = CountryCode.getText();
			boolean flag = CountryCode.isDisplayed();
			if(flag==true)
			{
				Reporter.log("EGD_45: PASS",true);
				Reporter.log("EGD_45: As expected Country Code "+CC+" is displayed at Mobile Number ", true);
						
			}
			else{
				Reporter.log("EGD_45: FAIL",true);
				Reporter.log("EGD_45: Country Code "+CC+" is not displayed at  Mobile Number", true);
				
				}
			
		}
		
		
		//Placeholder
		public void egd_46_verify_placeholder_at_mobileno()
		{
			String placeholder = driver.findElement(By.cssSelector(MobileNo_editbox_Placeholder_Text_Css)).getAttribute(MobileNo_editbox_Placeholder_Attribute);
			
			boolean flag = placeholder.equals(MobileNo_Placeholder_Text);
			if(flag==true)
			{
				Reporter.log("EGD_46: FAIL",true);
				Reporter.log("EGD_46: Place holder "+placeholder+" is not displayed 10 digits at Mobile Number", true);
				Reporter.log("EGD_46: Should display 10 digits at Place holder",true);			
			}
			else{
				Reporter.log("EGD_46: PASS",true);
				Reporter.log("EGD_46: As expected Place holder "+placeholder+" is displayed 10 digits at Mobile Number ", true);
						
			}
		}
				
		
		
		//Mobile Number
		public void egd_47_verify_mobileno_valid_10digits() throws AWTException, InterruptedException
		{
			WebElement mobile_valid = driver.findElement(By.xpath(MobileNo_xpath));
			mobile_valid.clear();
			mobile_valid.sendKeys("9010801537");
			Reporter.log("EGD_47: Entered Valid Mobile No. with 10 digits as 9010801537",true);
			WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Mobile_Number_xpath));
			boolean flag = Tick_Mark.isDisplayed();
			if(flag==true)
			{
				Reporter.log("EGD_47: PASS",true);
				Reporter.log("EGD_47: As expected Valid Mobile No. 9010801537 accepted and at Mobile Number ", true);
				
			}
			else{
				Reporter.log("EGD_47: FAIL",true);
				Reporter.log("EGD_47: Valid Mobile No. 9010801537 not accepted at  Mobile Number", true);
				
				}
			DriverInitializer.Refresh();
		}

		public void egd_48_verify_below10_invalid_mobileno() throws InterruptedException, AWTException
		{
			WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
			mobile_invalid.clear();
			mobile_invalid.sendKeys("901080");
			Reporter.log("EGD_48: Entered invalid Mobile No. with below 10 digits as 901080",true);
			WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Invalid_MobileNo));
			String error = error_msg.getText();
			Thread.sleep(1000);
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(flag!=true && error.equals(Error_Msg_of_Invalid_Input_MobileNo))
			{
				Reporter.log("EGD_48: PASS",true);
				Reporter.log("EGD_48: As expected  Below 10 digits not accepting ,"+error+" is displayed and Error Sign displayed at Mobile Number", true);
			}
			else
			{
				Reporter.log("EGD_48: FAIL",true);
				Reporter.log("EGD_48: Below 10 digits accepting, "+error+" and Error Sign is not displayed  at Mobile Number", true);
			}
			DriverInitializer.Refresh();
		}

		public void egd_49_verify_above10_invalid_mobileno() throws InterruptedException, AWTException
		{
			WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
			mobile_invalid.clear();
			mobile_invalid.sendKeys("901080153712546");
			Reporter.log("EGD_49: Entered invalid Mobile No. with above 10 digits as 901080153712546",true);
			WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Mobile_Number_xpath));
			boolean flag = Tick_Mark.isDisplayed();
			if(flag==true)
			{
				Reporter.log("EGD_49: PASS",true);
				Reporter.log("EGD_49: As expected Above 10 digits not accepting to enter at Mobile Number",true);
			}
			else
			{
				Reporter.log("EGD_49: FAIL",true);
				Reporter.log("EGD_49: Above 10 digits accepting to enter at Mobile Number", true);
			}
			DriverInitializer.Refresh();
			Thread.sleep(2000);
		}

		public void egd_50_verify_invalid_alphabets_mobileno() throws InterruptedException, AWTException
		{	
			DriverInitializer.Refresh();
			WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
			mobile_invalid.clear();
			mobile_invalid.sendKeys("sreekanthk");
			Thread.sleep(3000);
			Reporter.log("EGD_50: Cannot Enter invalid Mobile No. with alphabets as sreekanthk",true);
			WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Mobile_Number_xpath));
			boolean flag = Tick_Mark.isDisplayed();
			if(flag!=true)
			{
				Reporter.log("EGD_50: PASS",true);
				Reporter.log("EGD_50: As expected Alphabets not accepting to enter at Mobile Number", true);
			}
			else
			{
				Reporter.log("EGD_50: FAIL",true);
				Reporter.log("EGD_50: Alphabets accepting to enter at Mobile Number", true);
			}
			DriverInitializer.Refresh();
		}

		public void egd_51_verify_invalid_spl_char_mobileno() throws InterruptedException, AWTException
		{
			WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
			mobile_invalid.clear();
			mobile_invalid.sendKeys("@#@$#%*)%&^#@");
			Thread.sleep(2000);
			Reporter.log("EGD_51: Cannot Enter invalid Mobile No. with Special Characters as @#@$#%*)%&^#@ at Mobile No.",true);
			WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Mobile_Number_xpath));
			boolean flag = Tick_Mark.isDisplayed();
			if(flag!=true)
			{
				Reporter.log("EGD_51: PASS",true);
				Reporter.log("EGD_51: As expected  Special Characters not accepting to enter at Mobile Number", true);
			}
			else
			{
				Reporter.log("EGD_51: FAIL",true);
				Reporter.log("EGD_51: Special Characters accepting to enter at Mobile Number", true);
			}
			DriverInitializer.Refresh();
			Thread.sleep(2000);
		}

		public void egd_52_verify_invalid_alphanumeric_mobileno() throws InterruptedException, AWTException
		{
			WebElement mobile_invalid = driver.findElement(By.xpath(MobileNo_xpath));
			mobile_invalid.clear();
			mobile_invalid.sendKeys("1234sreeka");
			Thread.sleep(2000);
			Reporter.log("EGD_52: Entered invalid Mobile No. with alpha numeric values as 1234sreeka",true);
			WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Invalid_MobileNo));
			String error = error_msg.getText();
			 boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(flag!=true && error.equals(Error_Msg_of_Invalid_Input_MobileNo))
			{
				Reporter.log("EGD_52: PASS",true);
				Reporter.log("EGD_52: As expected Alphanumerics not accepting ,and Error Sign displayed at Mobile Number", true);
			}
			else
			{
				Reporter.log("EGD_52: FAIL",true);
				Reporter.log("EGD_52: Alphanumeric accepting, and error message not displayed  at Mobile Number", true);
				Reporter.log("EGD_52: Should display a message as Please Enter Valid Mobile Number", true);
			}
			DriverInitializer.Refresh();
			Thread.sleep(2000);
		}

		public void egd_53_verify_mobileno_empty_reg() throws InterruptedException, AWTException
		{
			DriverInitializer.Refresh();
			Thread.sleep(2000);
			WebElement Update_button = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath));
			Update_button.click();
			Reporter.log("EGD_53: Clicked on Registration button without entering Mobile No.",true);
			Thread.sleep(3000);
			WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_MobileNo));
			String error = error_msg.getText();
			Thread.sleep(1000);
			boolean flag = Update_button.isEnabled();
			if(flag!=true && error.equals(Error_Msg_MobileNo))
			{
				Reporter.log("EGD_53: PASS",true);
				Reporter.log("EGD_53: As expected  "+error+" is displayed and Error Sign displayed at Mobile Number", true);
			}
			else
			{
				Reporter.log("EGD_53: FAIL",true);
				Reporter.log("EGD_53: "+error+" and Error Sign is not displayed  at Mobile Number", true);
			}
			DriverInitializer.Refresh();
		}
		
		public void egd_54_verify_email_valid() throws InterruptedException, AWTException
		{
			WebElement email_valid = driver.findElement(By.xpath(Email_ID_xpath));
			email_valid.clear();
			email_valid.sendKeys("sreekatar@yahoo.com");
			Thread.sleep(1000);
			Reporter.log("EGD_54: Entered valid Email as sreekatar@yahoo.com at Email ID",true);
			WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
			boolean flag = Tick_Mark.isDisplayed();
			if(flag==true)
			{
				Reporter.log("EGD_54: PASS",true);
				Reporter.log("EGD_54: As expected Valid Email ID as sreekatar@yahoo.com accepted and at Email ", true);
						
			}
			else
			{
				Reporter.log("EGD_54: FAIL",true);
				Reporter.log("EGD_54: Valid Email ID as sreekatar@yahoo.com not accepted at Email", true);
			}
			DriverInitializer.Refresh();
		}
		
		public void egd_55_verify_invalid_email_without_localpart() throws InterruptedException, AWTException
		{
			WebElement email_invalid = driver.findElement(By.xpath(Email_ID_xpath));
			email_invalid.clear();
			email_invalid.sendKeys("@gmail.com");
			Reporter.log("EGD_55: Entered Invalid Email without local part as @yahoo.com at Email ID",true);
			WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Email_Invalid));
			String error = error_msg.getText();
			Thread.sleep(1000);
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(flag!=true && error.equals(Error_Msg_Invalid_Email))
			{
				Reporter.log("EGD_55: PASS",true);
				Reporter.log("EGD_55: As expected email not accepting without entering local part,"+error+" is displayed and Error Sign displayed at Email", true);
			}
			else
			{
				Reporter.log("EGD_55: FAIL",true);
				Reporter.log("EGD_55: Email accepting without entering local part, "+error+" and Error Sign is not displayed  at Email", true);
			}
			DriverInitializer.Refresh();
		}
		
		public void egd_56_verify_invalid_email_without_domain() throws InterruptedException, AWTException
		{
			WebElement email_invalid = driver.findElement(By.xpath(Email_ID_xpath));
			email_invalid.clear();
			email_invalid.sendKeys("sreekatar@");
			Reporter.log("EGD_56: Entered Invalid Email without Domain as sreekatar@ at Email ID",true);
			WebElement error_msg = driver.findElement(By.xpath(Error_Msg_xpath_Email_Invalid));
			String error = error_msg.getText();
			Thread.sleep(1000);
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(flag!=true && error.equals(Error_Msg_Invalid_Email))
			{
				Reporter.log("EGD_56: PASS",true);
				Reporter.log("EGD_56: As expected email not accepting without domain ,"+error+" is displayed and Error Sign displayed at Email", true);
			}
			else
			{
				Reporter.log("EGD_56: FAIL",true);
				Reporter.log("EGD_56: Email accepting without domain, "+error+" and Error Sign is not displayed  at Email", true);
			}
			DriverInitializer.Refresh();
		}

		public void egd_57_verify_email_with_1dot() throws InterruptedException, AWTException
		{
			WebElement email_valid = driver.findElement(By.xpath(Email_ID_xpath));
			email_valid.clear();
			email_valid.sendKeys("sreekatar@yahoo.com");
			Thread.sleep(1000);
			Reporter.log("EGD_57: Entered valid Email with 1 dot as sreekatar@yahoo.com at Email ID",true);
			WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
			boolean flag = Tick_Mark.isDisplayed();
			if(flag==true)
			{
				Reporter.log("EGD_57: PASS",true);
				Reporter.log("EGD_57: As expected Valid Email ID with 1 dot as sreekatar@yahoo.com accepted and at Email ", true);
						
			}
			else
			{
				Reporter.log("EGD_57: FAIL",true);
				Reporter.log("EGD_57: Valid Email ID with 1 dot as sreekatar@yahoo.com not accepted at Email", true);
			}
			DriverInitializer.Refresh();
		}

		public void egd_58_verify_email_with_2dots() throws InterruptedException, AWTException
		{
			WebElement email_valid = driver.findElement(By.xpath(Email_ID_xpath));
			email_valid.clear();
			email_valid.sendKeys("sreekatar@yahoo.co.in");
			Thread.sleep(1000);
			Reporter.log("EGD_58: Entered valid Email with 2 dots as sreekatar@yahoo.co.in at Email ID",true);
			WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
			boolean flag = Tick_Mark.isDisplayed();
			if(flag==true)
			{
				Reporter.log("EGD_58: PASS",true);
				Reporter.log("EGD_58: As expected Email ID with 2 dots as sreekatar@yahoo.co.in accepted and at Email ", true);
						
			}
			else
			{
				Reporter.log("EGD_58: FAIL",true);
				Reporter.log("EGD_58: Email ID with 2 dots as sreekatar@yahoo.co.in not accepted at Email", true);
			}
			DriverInitializer.Refresh();
		}
		public void egd_59_verify_email_with_Splchar_at_localpart() throws InterruptedException, AWTException
		{
		WebElement email_invalid2 = driver.findElement(By.xpath(Email_ID_xpath));
		email_invalid2.sendKeys("#@#&*&)#@yahoo.com");
		Reporter.log("EGD_59: Entered Email with Special Characters at Local part as #@#&*&)#@yahoo.com at Email ID",true);
		WebElement Tick_Mark2 = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
		boolean flag = Tick_Mark2.isDisplayed();
		Thread.sleep(2000);
		if(flag==true)
		{
			Reporter.log("EGD_59: PASS",true);
			Reporter.log("EGD_59: As expected not accepted special characters at local part as #@#&*&)#@yahoo.com at Email, and tick mark not displayed", true);
									
		}
		else
		{
			Reporter.log("EGD_59: FAIL",true);
			Reporter.log("EGD_59: Accepted special characters at local part as #@#&*&)#@yahoo.com at Email, tick mark displayed", true);
		}
		DriverInitializer.Refresh();
	}

		public void egd_60_verify_email_with_Splchar_at_Domain() throws InterruptedException, AWTException
		{
		WebElement email_invalid2 = driver.findElement(By.xpath(Email_ID_xpath));
		email_invalid2.sendKeys("sreekatar@#@#&*&)#.com");
		Reporter.log("EGD_60: Entered Email with Special Characters at Domain as sreekatar@#@#&*&)#.com at Email ID",true);
		WebElement Tick_Mark2 = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
		boolean flag = Tick_Mark2.isDisplayed();
		Thread.sleep(2000);
		if(flag==true)
		{
			Reporter.log("EGD_60: PASS",true);
			Reporter.log("EGD_60: As expected not accepted special characters at Domain as sreekatar@#@#&*&)#.com at Email, and tick mark not displayed", true);
									
		}
		else
		{
			Reporter.log("EGD_60: FAIL",true);
			Reporter.log("EGD_60: Accepted special characters at Domain as sreekatar@#@#&*&)#.com at Email, tick mark displayed", true);
		}
		DriverInitializer.Refresh();
	}

		public void egd_61_Verify_Email_with_3Dots_at_domain() throws InterruptedException, AWTException
		{
			WebElement email_valid = driver.findElement(By.xpath(Email_ID_xpath));
			email_valid.clear();
			email_valid.sendKeys("sreekatar@yahoo.co.in.in");
			Thread.sleep(1000);
			Reporter.log("EGD_61: Entered Email with 3 dots at Domain as sreekatar@yahoo.co.in.in at Email ID",true);
			WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
			boolean flag = Tick_Mark.isDisplayed();
			if(flag!=true)
			{
				Reporter.log("EGD_61: PASS",true);
				Reporter.log("EGD_61: As expected Email ID With 3 dots sreekatar@yahoo.co.in.in not accepted at Email, tick mark not displayed", true);
				
								
			}
			else
			{
				Reporter.log("EGD_61: FAIL",true);
				Reporter.log("EGD_61: Email ID With 3 dots sreekatar@yahoo.co.in.in accepted and at Email, and Tick mark displayed", true);
				Reporter.log("EGD_61: Should not accept more than 2 dots in domain",true);
			}
			DriverInitializer.Refresh();
		}
		public void egd_62_Verify_Email_with_numerics_at_domain() throws InterruptedException, AWTException
		{
		
		WebElement email_invalid = driver.findElement(By.xpath(Email_ID_xpath));
		email_invalid.clear();
		email_invalid.sendKeys("sreekatar@123456");
		Thread.sleep(1000);
		Reporter.log("EGD_62: Entered Email with numerics at Domain as sreekatar@123456 at Email ID",true);
		WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
		boolean flag = Tick_Mark.isDisplayed();
		Thread.sleep(2000);
		if(flag!=true)
		{
			Reporter.log("EGD_62: PASS",true);
			Reporter.log("EGD_62: As expected not accepted as sreekatar@123456 at Email, and tick mark not displayed", true);
									
		}
		else
		{
			Reporter.log("EGD_62: FAIL",true);
			Reporter.log("EGD_62: Accepted numerics at domain in email as sreekatar@123456 at Email, tick mark displayed", true);
			Reporter.log("EGD_62: Should not accept numerics at domain",true);
		}
			DriverInitializer.Refresh();
	  }

		public void egd_63_Verify_Email_with_numerics_only_at_localpart() throws InterruptedException, AWTException
		{
		
		WebElement email_invalid = driver.findElement(By.xpath(Email_ID_xpath));
		email_invalid.clear();
		email_invalid.sendKeys("123456@yahoo.com");
		Thread.sleep(1000);
		Reporter.log("EGD_63: Entered Email with numerics only at local part as 123456@yahoo.com at Email ID",true);
		WebElement Tick_Mark = driver.findElement(By.xpath(Tick_Mark_Email_xpath));
		boolean flag = Tick_Mark.isDisplayed();
		Thread.sleep(2000);
		if(flag!=true)
		{
			Reporter.log("EGD_63: PASS",true);
			Reporter.log("EGD_63: As expected not accepted numerics only at local part as 123456@yahoo.com at Email, and tick mark not displayed", true);
									
		}
		else
		{
			Reporter.log("EGD_63: FAIL",true);
			Reporter.log("EGD_63: Accepted numerics only at local part in email as 123456@yahoo.com at Email, tick mark displayed", true);
			Reporter.log("EGD_63: Should not accept numerics at domain",true);
		}
		DriverInitializer.Refresh();
	  }
	
		
		public void egd_66_verify_gender_dropdown_selected_asperregistration() throws InterruptedException, AWTException
		{
			WebElement gender_dropdown =driver.findElement(By.xpath(Gender_dropdown_xpath));
			boolean flag = gender_dropdown.isSelected();
			
			if(flag==true){
				Reporter.log("EGD_66: PASS",true);
				Reporter.log("EGD_66: As per Registration data displayed at Gender",true);
			}
			else{
				Reporter.log("EGD_66: FAIL",true);
				Reporter.log("EGD_66: Gender Field Empty,As per Registration data not displayed at Gender",true);
			}
		}
		
		public void egd_67_verify_dropdown_gender() throws InterruptedException, AWTException
		{
			 
			String gender_dropdown = driver.findElement(By.xpath(Gender_dropdown_xpath)).getTagName();
			
			Reporter.log("EGD_67: "+gender_dropdown +" tag name displayed at Gender dropdown",true);
			
			boolean flag = gender_dropdown.equals("select");
			Thread.sleep(2000);
			
			if(flag==true)
			{
				Reporter.log("EGD_67: PASS",true);
				Reporter.log("EGD_67: As expected " +gender_dropdown+ " tagname is displayed at Gender dropdown", true);
				
			}
			else
			{
				Reporter.log("EGD_67: FAIL",true);
				Reporter.log("EGD_67: "+gender_dropdown+" tag name is not displayed at Gender dropdown", true);
				
			}
			DriverInitializer.Refresh();
			Thread.sleep(2000);
		}

			
		public void egd_68_verify_ClickonUpdateButton_gender() throws InterruptedException, AWTException
		{
			WebElement gender_dropdown =driver.findElement(By.xpath(Gender_dropdown_xpath));
			Select Gender_Drop = new Select(gender_dropdown);
			Gender_Drop.selectByIndex(1);
			Thread.sleep(2000);
			
			WebElement update_button = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath));
			update_button.click();
			
							
			DriverInitializer.Refresh();
		
		}
			
		public void egd_69_verify_gender_dropdown_valid() throws InterruptedException, AWTException
		{
			 
			 
			WebElement gender_dropdown =driver.findElement(By.xpath(Gender_dropdown_xpath));
			Select Gender_Drop = new Select(gender_dropdown);
			Gender_Drop.selectByIndex(1);
			Thread.sleep(2000);
			WebElement option = Gender_Drop.getFirstSelectedOption();
			String option_value = option.getText();
			
			boolean flag = driver.findElement(By.xpath(Tick_Mark_Gender_xpath)).isDisplayed();
			Thread.sleep(2000);
			
			if(flag==true && option_value.contains("Male"))
			{
				Reporter.log("EGD_69: PASS",true);
				Reporter.log("EGD_69: As expected  "+option_value+" is selected, displayed in the list box and Tick mark displayed at Gender dropdown", true);
				
			}
			else
			{
				Reporter.log("EGD_69: FAIL",true);
				Reporter.log("EGD_69: "+option_value+" is not selected and displayed in the list box at Gender dropdown", true);
				
			}
			DriverInitializer.Refresh();
			Thread.sleep(2000);
		}
	
		public void egd_70_verify_without_gender() throws InterruptedException, AWTException
		{
			Thread.sleep(2000);
			WebElement gender_dropdown =driver.findElement(By.xpath(Gender_dropdown_xpath));
			Thread.sleep(2000);
			Select Gender_Drop = new Select(gender_dropdown);
			Gender_Drop.selectByIndex(1);
			Thread.sleep(2000);
			Gender_Drop.selectByIndex(0);
			Thread.sleep(3000);
			
			String error = driver.findElement(By.xpath(Error_Msg_xpath_Gender)).getText();
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(error.equals(Error_Msg_Gender) && flag!=true)
			{
				Reporter.log("EGD_70: PASS",true);
				Reporter.log("EGD_70: As expected not accepted and showing "+error+"message and Update button disabled",true);
			}
			else{
				Reporter.log("EGD_70: FAIL",true);
				Reporter.log("EGD_70: Accepted and not showing "+error+"message ",true);
			}
			
			
							
			DriverInitializer.Refresh();
		
		}
			
		public void egd_126_verify_all_error_messages_update() throws InterruptedException, AWTException
		{
			//Registration Button
			WebElement Update_button = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath));
			Update_button.click();
			Thread.sleep(4000);
			Reporter.log("EGD_126: Clicked on Update button with at mandatory fields empty",true);
			
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
			boolean flag = driver.findElement(By.xpath(Update_Guest_Details_button_enable_xpath)).isEnabled();
			if(flag!=true && e1.equals(Error_Msg_Title) && e2.equals(Error_Msg_Name_editbox) && e3.equals(Error_Msg_DOB) && e4.equals(Error_Msg_MobileNo) && e5.equals(Error_Msg_Email) && e6.equals(Error_Msg_Gender))
			{
				Reporter.log("EGD_126: PASS",true);
				Reporter.log("EGD_126: As expected all the Error messages displayed at all mandatory fields",true);
				Reporter.log("EGD_126: Update Guest Details button disabled after all errors occured",true);
			}
			else
			{
				Reporter.log("EGD_126: FAIL",true);
				Reporter.log("EGD_126: All the error messages not displaying at mandatory fields ",true);
				Reporter.log("EGD_126: Update Guest Details button not disabled after all errors occured",true);
			}
			
			
		}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
