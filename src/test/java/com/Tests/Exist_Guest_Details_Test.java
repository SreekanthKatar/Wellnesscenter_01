package com.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.PageLibrary.Exist_Guest_Details;

public class Exist_Guest_Details_Test 
{
	public Exist_Guest_Details egd = new Exist_Guest_Details();
  
  //Client Menu Options
  @Test (groups = {"positive"},priority=0)
  public void EGD_01_Client_Menu_Options() throws InterruptedException, AWTException, IOException 
  {
	  egd.egd_01_client_menu_options();
  }
  
  //Go to Existing Guest Details Page
  @Test (groups = {"positive"},priority=1)
  public void EGD_02_Exist_Guest_Details_Page() throws InterruptedException, AWTException, IOException 
  {
	  egd.egd_02_existing_guest_details_page();
  }
  
 //Verify Existing Guest Details Page Headings
  @Test (groups = {"positive"},priority=2)
  public void EGD_03_VeriPage_Headings() throws InterruptedException, AWTException 
  {
	  egd.egd_03_Verify_UI();
  }
  
  //Verify Existing Guest Details Page UI
  @Test (groups = {"positive"},priority=3)
  public void EGD_04_VeriPage_UI() throws InterruptedException, AWTException 
  {
	  egd.egd_04_Verify_headings();
  }
  
  //Verify Existing Guest Details Page WebTable Header
  @Test (groups = {"positive"},priority=4)
  public void EGD_05_Verify_Webtable() throws InterruptedException, AWTException, IOException 
  {
	  egd.egd_05_verify_webtable();
  }
  
  //Verify Existing Customer with Search name in Search box
  @Test (groups = {"positive"},priority=5)
  public void EGD_06_Verify_SearchCutomer_Valid() throws InterruptedException, AWTException 
  {
	  egd.egd_06_verify_SearchCustomer_valid();
  }
  
  //Verify Search result without entering exist customer name in search box
  @Test (groups = {"negative"},priority=6)
  public void EGD_07_Verify_SearchResult_WithoutName() throws InterruptedException, AWTException 
  {
	  egd.egd_07_verify_SearchResult_Without_Name_Search();
  }
  
  //Verify Search result with invalid exist customer name as ramu in search box
  @Test (groups = {"negative"},priority=7)
  public void EGD_08_Verify_UnregisteredCustomer_Search()throws InterruptedException, AWTException 
  {
	  egd.egd_08_verify_UnregisteredCustomer_Search();
  }
  
  //Verify Search result with invalid datatypes in search box
  @Test (groups = {"negative"},priority=7)
  public void EGD_09_Verify_InvalidDatatype_Search()throws InterruptedException, AWTException 
  {
	  egd.egd_09_verify_invalid_customersearch();
  }
  
  //Verify Search result with invalid datatypes in search box
  @Test (groups = {"positive"},priority=8)
  public void EGD_10_Verify_Search_Button()throws InterruptedException, AWTException 
  {
	  egd.egd_10_verify_search_button();
  }
  
  //Verify Search result with invalid datatypes in search box
  @Test (groups = {"positive"},priority=9)
  public void EGD_11_Verify_PageNo_Button()throws InterruptedException, AWTException 
  {
	  egd.egd_11_verify_pagenobuttons();
  }
  
  
  //Verify Customer ID
  @Test (groups = {"positive"},priority=10)
  public void EGD_12_Verify_Customer_ID()throws InterruptedException, AWTException 
  {
	  egd.egd_12_verify_customer_id();
  }
  
  
  //Verify Clients Modifiactions Page after clicked on Customer ID 
  @Test (groups = {"positive"},priority=11)
  public void EGD_13_Verify_ClientModificationPage_AfterClickedOn_Customer_ID()throws InterruptedException, AWTException 
  {
	  egd.egd_13_verify_clientmodificationspage_afterclickedon_custID();
  }
  
  //Verify Clients Modifiactions Page headings
  @Test (groups = {"positive"},priority=12)
  public void EGD_14_Verify_ClientModificationPage_Headings()throws InterruptedException, AWTException 
  {
	  egd.egd_14_verify_headings_clientmodification_page();
  }
  
  //Verify Existing data displaying or not if already entered while registration
  @Test (groups = {"positive"},priority=13)
  public void EGD_15_Verify_ExistingData_if_Registered()throws InterruptedException, AWTException 
  {
	  egd.egd_15_verify_existing_data_ifalready_entered();
  }
  
  //Verify Clients Modifiactions Page after clicked on Customer ID 
  @Test (groups = {"positive"},priority=14)
  public void EGD_16_Verify_Update_Guest_Details_Button()throws InterruptedException, AWTException 
  {
	  egd.egd_16_verify_updateguestdetails_Button();
  }
  
  //Verify Clients Modifiactions Page after clicked on Customer ID 
  @Test (groups = {"positive"},priority=15)
  public void EGD_17_Verify_All_The_Mandatory_symbols()throws InterruptedException, AWTException 
  {
	  egd.egd_17_verify_all_mandatory_symbols();
  }
  
  //Verify Dropdown Title selected option as per Registration
  @Test (groups = {"positive"},priority=16)
  public void EGD_18_Verify_Title_Dropdown_Selected_AsPerRegistration()throws InterruptedException, AWTException 
  {
	  egd.egd_18_verify_title_dropdown_selected_asperregistration();
  }
    
  //Verify Dropdown Title Valid
  @Test (groups = {"positive"},priority=17)
  public void EGD_19_Verify_Dropdown_Title()throws InterruptedException, AWTException 
  {
	  egd.egd_19_verify_dropdown_title();
  }
  
  
  //Verify functionality after clicked on Update button when title selected 
  @Test (groups = {"negative"},priority=18)
  public void EGD_20_Verify_ClickonUpdateButton_Title()throws InterruptedException, AWTException 
  {
	  egd.egd_20_verify_ClickonUpdateButton_title();
  }
  
  //Verify valid input at Title Dropdown
  @Test (groups = {"positive"},priority=19)
  public void EGD_21_Verify_Title_Dropdown_Valid()throws InterruptedException, AWTException 
  {
	  egd.egd_21_verify_title_dropdown_valid();
  }
  
  //Verify all errors
  @Test (groups = {"positive"},priority=20)
  public void Verify_All_Errors()throws InterruptedException, AWTException 
  {
	  egd.All_Errors();
  }
  
  //Verify Without Title
  @Test (groups = {"negative"},priority=21)
  public void EGD_22_Verify_Without_Title()throws InterruptedException, AWTException 
  {
	  egd.egd_22_verify_withouttitle();
  }
  
  //Verify valid input at Name
  @Test (groups = {"positive"},priority=22)
  public void EGD_24_Verify_Guestname_Alphabets_Valid()throws InterruptedException, AWTException 
  {
	  egd.egd_24_verify_guestname_alphabets_valid();
  }
  
  //Verify invalid input at Name as Alphanumeric
  @Test (groups = {"negative"},priority=23)
  public void EGD_25_Verify_Guestname_Invalid_Alphanumeric()throws InterruptedException, AWTException 
  {
	  egd.egd_25_verify_guestname_invalid_alphanumeric();
  }
  
  //Verify invalid input at Name as Numeric
  @Test (groups = {"negative"},priority=24)
  public void EGD_25_Verify_Guestname_Invalid_numeric()throws InterruptedException, AWTException 
  {
	  egd.egd_25_verify_guestname_invalid_numeric();
  }
  
  //Verify invalid input at Name as Spl Char
  @Test (groups = {"negative"},priority=25)
  public void EGD_25_Verify_Guestname_Invalid_SplChar()throws InterruptedException, AWTException 
  {
	  egd.egd_25_verify_guestname_invalid_splchar();
  }
  
  //Verify Name with only spaces
  @Test (groups = {"negative"},priority=26)
  public void EGD_26_Verify_Guestname_Spaces()throws InterruptedException, AWTException 
  {
	  egd.egd_26_verify_guestname_spaces();
  }
  
  //Verify Name with below 6 characters
  @Test (groups = {"negative"},priority=27)
  public void EGD_27_Verify_Name_Below6_char()throws InterruptedException, AWTException 
  {
	  egd.egd_27_Verify_Name_Below6_char();
  }
  
  //Verify Name with above 30 characters
  @Test (groups = {"negative"},priority=28)
  public void EGD_28_Verify_Name_Above30_char()throws InterruptedException, AWTException 
  {
	  egd.egd_28_Verify_Name_above30_char();
  }
  
  //Verify Name with Blank
  @Test (groups = {"negative"},priority=29)
  public void EGD_29_Verify_Guestname_Blank()throws InterruptedException, AWTException 
  {
	  egd.egd_29_verify_guestname_blank();
  }
  
  //EGD_30
  @Test (groups = {"positive"},priority=30)
  public void EGD_30_Verify_Calendar_DOB() throws InterruptedException, AWTException 
  {
	  egd.egd_30_verify_calendar_dob();
	  
  }
  
  //EGD_31
  @Test (groups = {"positive"},priority=31)
  public void EGD_31_Verify_CurrentDate_default_Calendar_DOB() throws InterruptedException, AWTException 
  {
	  egd.egd_31_verify_current_date_default_calendar_dob();
	  
  }
  
  //EGD_32
  @Test (groups = {"positive"},priority=32)
  public void EGD_32_Verify_DOB_Valid_Below_2014() throws InterruptedException, AWTException 
  {
	  egd.egd_32_verify_date_of_birth_valid_below_2014();
	  
  }
  
  //EGD_33
  @Test (groups = {"positive"},priority=33)
  public void EGD_33_Verify_DOB_Selected_Or_Not() throws InterruptedException, AWTException 
  {
	  egd.egd_33_verify_dob_selected_or_not();
	  
  }
  
  //EGD_34
  @Test (groups = {"positive"},priority=34)
  public void EGD_34_Verify_Selected_DOB_Format() throws InterruptedException, AWTException 
  {
	  egd.egd_34_verify_Selected_dob_format();
	  
  }
  
  //EGD_35
  @Test (groups = {"negative"},priority=35)
  public void EGD_35_Verify_DOB_morethan_2014() throws InterruptedException, AWTException 
  {
	  egd.egd_35_verify_date_of_birth_invalid_morethan_2014();
	  
  }
  
  //EGD_44
  @Test (groups = {"positive"},priority=36)
  public void EGD_44_Verify_Country_Flag_Mobile_No() throws InterruptedException, AWTException 
  {
	  egd.egd_44_verify_country_flag_at_mobileNo();
  } 
  
  //EGD_45
  @Test (groups = {"positive"},priority=37)
  public void EGD_45_Verify_Country_Code_Mobile_No() throws InterruptedException, AWTException 
  {
	  egd.egd_45_verify_country_code_at_mobileno();
  }  

  //EGD_46
  @Test (groups = {"positive"},priority=38)
  public void EGD_46_Verify_Placeholder_At_Mobileno() throws InterruptedException, AWTException 
  {
	  egd.egd_46_verify_placeholder_at_mobileno();
  }  
  //EGD_47
  @Test (groups = {"positive"},priority=39)
  public void EGD_47_Verify_Valid_Mobile_No_10digits() throws InterruptedException, AWTException 
  {
	  egd.egd_47_verify_mobileno_valid_10digits();
  }  
  
  //EGD_48
  @Test (groups = {"negative"},priority=40)
  public void EGD_48_Verify_invalid_Mobile_No_Below_10digits() throws InterruptedException, AWTException 
  {
	  egd.egd_48_verify_below10_invalid_mobileno();
  }  
  
  //EGD_49
  @Test (groups = {"negative"},priority=41)
  public void EGD_49_Verify_invalid_Mobile_No_Above_10digits() throws InterruptedException, AWTException 
  {
	  egd.egd_49_verify_above10_invalid_mobileno();
  }  
  
 //EGD_50
  @Test (groups = {"negative"},priority=42)
  public void EGD_50_Verify_invalid_Mobile_No_Alphabets() throws InterruptedException, AWTException 
  {
	  egd.egd_50_verify_invalid_alphabets_mobileno();
  }  
  
 //EGD_51
  @Test (groups = {"negative"},priority=43)
  public void EGD_51_Verify_invalid_Mobile_No_Spl_Char() throws InterruptedException, AWTException 
  {
	  egd.egd_51_verify_invalid_spl_char_mobileno();
  }  
  
 //EGD_52
  @Test (groups = {"negative"},priority=44)
  public void EGD_52_Verify_invalid_Mobile_No_AlphaNumeric() throws InterruptedException, AWTException 
  {
	  egd.egd_52_verify_invalid_alphanumeric_mobileno();
  }  
  

  //EGD_53
  @Test (groups = {"negative"},priority=45)
  public void EGD_53_Verify_MobileNo_Empty_Reg() throws InterruptedException, AWTException 
  {
	  egd.egd_53_verify_mobileno_empty_reg();
  } 
  
  //EGD_54
  @Test (groups = {"positive"},priority=46)
  public void EGD_54_Verify_Valid_Email() throws InterruptedException, AWTException 
  {
	  egd.egd_54_verify_email_valid();
  }  
  
  //EGD_55
  @Test (groups = {"negative"},priority=47)
  public void EGD_55_Verify_Email_Without_LocalPart() throws InterruptedException, AWTException 
  {
	  egd.egd_55_verify_invalid_email_without_localpart();
  }  
  
  //EGD_56
  @Test (groups = {"negative"},priority=48)
  public void EGD_56_Verify_Email_Without_Domain() throws InterruptedException, AWTException 
  {
	  egd.egd_56_verify_invalid_email_without_domain();
  }  
  
  //EGD_57
  @Test (groups = {"positive"},priority=49)
  public void EGD_57_Verify_Email_With_1Dot() throws InterruptedException, AWTException 
  {
	  egd.egd_57_verify_email_with_1dot();
  }  
  
  //EGD_58
  @Test (groups = {"positive"},priority=50)
  public void EGD_58_Verify_Email_With_2Dots() throws InterruptedException, AWTException 
  {
	  egd.egd_58_verify_email_with_2dots();
  }  
  
  //EGD_59
  @Test (groups = {"negative"},priority=51)
  public void EGD_59_Verify_Email_With_SplChar_At_LocalPart() throws InterruptedException, AWTException 
  {
	  egd.egd_59_verify_email_with_Splchar_at_localpart();
  }  
  
  //EGD_60
  @Test (groups = {"negative"},priority=52)
  public void EGD_60_Verify_Email_With_SplChar_At_Domain() throws InterruptedException, AWTException 
  {
	  egd.egd_60_verify_email_with_Splchar_at_Domain();
  }  
  
  //EGD_61
  @Test (groups = {"negative"},priority=53)
  public void EGD_61_Verify_Email_With_3dots_At_Domain() throws InterruptedException, AWTException 
  {
	  egd.egd_61_Verify_Email_with_3Dots_at_domain();
  }  
  
  //EGD_62
  @Test (groups = {"negative"},priority=54)
  public void EGD_62_Verify_Email_Numerics_At_Domain() throws InterruptedException, AWTException 
  {
	  egd.egd_62_Verify_Email_with_numerics_at_domain();
  } 
  
  //EGD_63
  @Test (groups = {"negative"},priority=55)
  public void EGD_63_Verify_Email_Numerics_Only_At_LocalPart() throws InterruptedException, AWTException 
  {
	  egd.egd_63_Verify_Email_with_numerics_only_at_localpart();
  } 
  
  //EGD_66
  @Test (groups = {"positive"},priority=56)
  public void EGD_63_Verify_Gender_Dropdown_Selected_AsPerRegistration() throws InterruptedException, AWTException 
  {
	  egd.egd_66_verify_gender_dropdown_selected_asperregistration();
  }
  
  //EGD_67
  @Test (groups = {"positive"},priority=57)
  public void EGD_67_Verify_Dropdown_Gender() throws InterruptedException, AWTException 
  {
	  egd.egd_67_verify_dropdown_gender();
  } 
  
  //EGD_68
  @Test (groups = {"negative"},priority=58)
  public void EGD_68_Verify_ClickonUpdateButton_Gender() throws InterruptedException, AWTException 
  {
	  egd.egd_68_verify_ClickonUpdateButton_gender();
  } 
  
  //EGD_69
  @Test (groups = {"positive"},priority=59)
  public void EGD_69_Verify_Gender_Dropdown_Valid() throws InterruptedException, AWTException 
  {
	  egd.egd_69_verify_gender_dropdown_valid();
  }
  
  //EGD_70
  @Test (groups = {"negative"},priority=60)
  public void EGD_70_Verify_Without_Gender()throws InterruptedException, AWTException 
  {
	  egd.egd_70_verify_without_gender();
  } 
  
  //EGD_126
  @Test (groups = {"positive"},priority=61)
  public void EGD_126_Verify_All_Error_Messages_Update()throws InterruptedException, AWTException 
  {
	  egd.egd_126_verify_all_error_messages_update();
  }
  
  
}
