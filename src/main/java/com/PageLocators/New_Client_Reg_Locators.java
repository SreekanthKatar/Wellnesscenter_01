package com.PageLocators;

public class New_Client_Reg_Locators 
{
	//Client Module Dropdown Xpath
	public String Client_Module_dropdown_xpath = "//*[@id='wrapper']/nav/div[2]/ul/li[2]/a";
	
	//Client module options list xpath
	public String MenuOptions_xpath = "//*[@id='client']";
	
	
	//New Client Registration Xpath
	public String New_Client_Reg_button_xpath = "//*[@id='client']/li[2]/a";
	
	//URL
	public String NCR_Expected_URL = "http://172.22.5.34:8080/wellness/registration";
	
	//Main Heading Text
	public String Main_Heading_Text ="Registration";
	
	//Main Heading Text Xpath
	public String Main_Heading_Text_xpath = "//*[@id='wrapper']/div[1]/div/div/h1/small";
	
	//Sub Heading1 Text
	public String Sub_Heading1_Text = "New Client Details";
	
	//Sub Heading1 Text Xpath
	public String Sub_Headin1_Text_xpath = "//*[@id='registrationform']/div[1]/div/div/div[1]/h3";
	
	//Sub Heading2 Text
	public String Sub_Heading2_Text = "Other Details";
	
	//Sub Heading2 Text Xpath
	public String Sub_Heading2_Text_xpath = "//*[@id='registrationform']/div[2]/div/div/div[1]/h3";
	
	//Title Dropdown List Xpath
	public String Title_Dropdown_xpath = "//*[@id='title']";

	//Name Editbox Xpath
	public String Name_editbox_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/input";
	
	//Name Editbox PlaceHolder Text
	public String Name_editbox_Placeholder_Text = "Jane Doe";
	
	//Name Editbox PlaceHolder Text CSS Selecector
	public String Name_editbox_Placeholder_Text_Css = "input[data-fv-field*='name'][type='text']";
		
	//Name Editbox PlaceHolder Attribute
	public String Name_editbox_Placeholder_Attribute = "placeholder";
	
	//Date of Birth Xpath
	public String DOB_xpath = "//*[@id='dob']";
	
	//Date of Birth CSS Selecector
	public String DOB_CSS_Selector = "input[onchange*='getAge()'][id='dob'][type='date']";
			
	//Date of Birth type Attribute
	public String DOB_type_Attribute = "type";
	
	//Date of Birth type Attribute Value
	public String DOB_type_Attribute_Value = "date";
	
	//Before Selecting DOB CSS Selector
	public String DOB_Before_Selection_CSS = "small[class='help-block'][data-fv-validator='date'][data-fv-for='dob']";
	
	//Before Selecting DOB Attribute
	public String DOB_Before_Selection_Attribute = "data-fv-result";
	
	//Before Selecting DOB Attribute Value
	public String Before_Selecting_DOB_Attribute_Value = "NOT_VALIDATED";
	
	//After Selecting DOB CSS Selector
	public String DOB_After_Selection_CSS = "small[class='help-block'][data-fv-validator='date'][data-fv-for='dob']";
		
	//After Selecting DOB Attribute
	public String DOB_After_Selection_Attribute = "data-fv-result";
		
	//Before Selecting DOB Attribute Value
	public String After_Selecting_DOB_Attribute_Value = "VALID";
		
	//Wedding Date
	public String Wedding_Date_xpath = "//*[@id='weddingday']"; 
	
	//Mobile No. Xpath
	public String MobileNo_xpath = "//*[@id='phoneNumber']"; 
	
	//Mobile No. Country Flag Xpath
	public String MobileNo_Country_Flag_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[2]/div/div/div/div/div[1]";
	
	//Mobile No. Dial Code Xpath
	public String MobileNo_Country_Code_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[2]/div/div/div/div/div[2]";

	//Mobile No. Editbox PlaceHolder Text
	public String MobileNo_editbox_Placeholder_Text = "Enter Mobile";
	
	//Mobile No. Editbox PlaceHolder Text CSS Selecector
	public String MobileNo_editbox_Placeholder_Text_Css = "input[data-fv-field*='phoneNumber'][type='text']";
	
	//Mobile No. Editbox PlaceHolder Attribute
	public String MobileNo_editbox_Placeholder_Attribute = "placeholder";
		
	//Email ID Xpath
	public String Email_ID_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[4]/div/input";
	
	//Address Xpath
	public String Address_xpath = "//*[@id='address']"; 

	//Gender Xpath
	public String Gender_dropdown_xpath = "//*[@id='gender']"; 
	
	//City Xpath
	public String City_dropdown_xpath = "//*[@id='city']"; 
	
	//State Xpath
	public String State_dropdown_xpath = "//*[@id='state1']"; 
	
	//Country Xpath
	public String Country_dropdown_xpath = "//*[@id='country']"; 
	
	//Nationality Editbox Xpath
	public String Nationality_editbox_xpath = "//*[@id='nationality']"; 
	
	//PinCode Editbox Xpath
	public String Pincode_editbox_xpath = "//*[@id='pincode']";
	
	//Age Editbox Xpath
	public String Age_editbox_xpath = "//*[@id='age']"; 
	
	//Contra Editbox Xpath
	public String Contra_editbox_xpath = "//*[@id='contratextId']";
	
	//Contra Pop up Close button Xpath
	public String Contra_pop_up_Close_button = "//*[@id='contramodalId']/div/div/div[3]/button[1]";
	
	//Occupation Editbox Xpath
	public String Occupation_editbox_xpath = "//*[@id='occupation']"; 
	
	//Category Editbox Xpath
	public String Category_editbox_xpath = "//*[@id='catogery']"; 
	
	//Segment Dropdown Xpath
	public String Segment_dropdown_xpath = "//*[@id='segmentmaster']";
	
	//Corporate Dropdown Xpath
	public String Corporate_dropdown_xpath = "//*[@id='corporate']"; 
	
	//Business Source Dropdown Xpath
	public String Business_dropdown_xpath = "//*[@id='businessSource']"; 
	
	//Billing Instruction Dropdown Xpath
	public String Billing_Instruction_dropdown_xpath = "//*[@id='billingInstruction']"; 
	
	//From Editbox Xpath
	public String From_editbox_xpath = "//*[@id='dndfrom']"; 
	
	//To Editbox Xpath
	public String To_editbox_xpath = "//*[@id='dndto']"; 
	
	//Registration Button Xpath
	public String Reg_button_xpath = "//*[@id='registrationform']/div[2]/div/div/div[2]/div[1]/table/tbody/tr[6]/td[4]/input";

	//Registration Button Disable Xpath
	public String Reg_button_Disable_xpath = "//*[@id=registrationform]/div[2]/div/div/div[2]/div[1]/table/tbody/tr[6]/td[4]";																						   
	
	
	//Book Appointment Button Xpath
	public String Book_Appointment_button_xpath = "//*[@id='registrationform']/div[2]/div/div/div[2]/div[1]/table/tbody/tr[6]/td[5]/div/button";
	
	//Book Appointment Button Disable Xpath
	public String Book_Appointment_button_Disable_xpath = "//*[@id='registrationform']/div[2]/div/div/div[2]/div[1]/table/tbody/tr[6]/td[5]/div";
	
	//Tick Mark Xpath at Title Drop down
	public String Tick_Mark_Title_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[2]/div/i";
	
	//Tick Mark Xpath at Name Editbox
	public String Tick_Mark_Name_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/i";

	//Tick Mark Xpath at Date of Birth Field
	public String Tick_Mark_DOB_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/div/i";
	
	//Tick Mark Xpath at Mobile Number
	public String Tick_Mark_Mobile_Number_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[2]/div/div/i";
	
	//Tick Mark Xpath at Email ID
	public String Tick_Mark_Email_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[4]/div/i";

	//Tick Mark Xpath at Gender
	public String Tick_Mark_Gender_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[4]/td[4]/div/i";
	
	//Tick Mark Xpath at Pincode
	public String Tick_Mark_Pincode_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[7]/td[2]/div/i";
	
	//Mandatory Symbol Xpath at Title
	public String Mandatory_Symbol_Title_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[1]/label/span";

	//Mandatory Symbol Xpath at Name
	public String Mandatory_Symbol_Name_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[3]/label/span";
	
	//Mandatory Symbol Xpath at Date of Birth
	public String Mandatory_Symbol_DOB_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[2]/td[1]/label/span";
	
	//Mandatory Symbol Xpath at Mobile Number
	public String Mandatory_Symbol_MobileNo_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[1]/label/span";
	
	//Mandatory Symbol Xpath at Email
	public String Mandatory_Symbol_Email_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[3]/label/span";
	
	//Mandatory Symbol Xpath at Address
	public String Mandatory_Symbol_Address_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[4]/td[1]/label/span";
	
	//Mandatory Symbol Xpath at Gender
	public String Mandatory_Symbol_Gender_xpath = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[4]/td[3]/label/span";

	//Error Message at Title 
	public String Error_Msg_Title = "Please select your title.";
	
	//Error Message Xpath at Title
	public String Error_Msg_xpath_Title = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[2]/div/small";

	//Error Message at Name
	public String Error_Msg_Name_editbox = "The username is required";
	
	//Error Message Xpath at Name
	public String Error_Msg_xpath_Name_editbox = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/small[1]";
	
	//Characters Length Error Message at Name
	public String Error_Msg_of_length_Name = "The username must be more than 6 and less than 30 characters long";
	
	//Characters Length Error Message Xpath at Name
	public String Error_Msg_of_length_xpath_Name = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/small[2]";
	
	//Datatype Error Message at Name
	public String Error_Msg_of_Datatype_Name = "The username can only consist of alphabetical, number, dot and underscore";
	
	//Datatype Error Message Xpath at Name
	public String Error_Msg_of_Datatype_xpath_Name = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/small[3]";
	
	//Error Message at Date of Birth
	public String Error_Msg_DOB = "The Date Of Birth is required";
	
	//Error Message Xpath at Date of Birth
	public String Error_Msg_xpath_DOB = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/div/small[1]";
	
	//Error Message for Invalid Input at Date of Birth
	public String Error_Msg_of_Invalid_Input_DOB = "The value is not a valid date";
	
	//Error Message Xpath of Invalid Input at Date of Birth
	public String Error_Msg_xpath_of_Invalid_Input_DOB = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/div/small[2]";
	
	//Error Message at Mobile Number
	public String Error_Msg_MobileNo = "The phone number is required";
	
	//Error Message Xpath at Mobile Number
	public String Error_Msg_xpath_MobileNo = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[2]/div/small[1]";

	//Error Message Xpath for Invalid input at Mobile Number
	public String Error_Msg_xpath_Invalid_MobileNo = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[2]/div/small[2]";
	
	//Error Message of Invalid Input at Mobile Number
	public String Error_Msg_of_Invalid_Input_MobileNo = "The phone number is not valid";
	
	//Error Message at Email ID
	public String Error_Msg_Email = "The email address is required";
	
	//Error Message Xpath at Email ID
	public String Error_Msg_xpath_Email = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[4]/div/small[1]";
	
	//Error Message of Invalid Input at Email ID
	public String Error_Msg_Invalid_Email = "The input is not a valid email address";
	
	//Error Message Xpath of Invalid Input at Email ID
	public String Error_Msg_xpath_Email_Invalid = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[3]/td[4]/div/small[2]";
		
	//Error Message at Gender
	public String Error_Msg_Gender = "Please enter a value";
	
	//Error Message Xpath at Gender
	public String Error_Msg_xpath_Gender = "//*[@id='registrationform']/div[1]/div/div/div[2]/div[1]/table/tbody/tr[4]/td[4]/div/small";
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

