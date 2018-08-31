package com.Tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.PageLibrary.New_Client_Registration;
import com.util.DriverInitializer;

public class New_Client_Registration_Test 
{
	New_Client_Registration ncr = new New_Client_Registration();

  //NCR_01
  @Test (groups = {"positive"},priority=0)
  public void NCR_01_Verify_Client_Menu_Options() throws InterruptedException, AWTException 
  {
	  ncr.ncr_01_client_menu_options();
	  DriverInitializer.Refresh();
	  Thread.sleep(2000);
  }
  
 /* //NCR_02
  @Test (groups = {"positive"},priority=1)
  public void NCR_02_Verify_New_Client_Reg_Page() throws InterruptedException 
  {
	  ncr.ncr_02_new_client_reg_page();
	  Thread.sleep(1000);
  }
  
 //NCR_03
  @Test (groups = {"positive"},priority=2)
  public void NCR_03_Verify_UI() throws InterruptedException 
  {
	  ncr.ncr_03_Verify_UI();
	  Thread.sleep(1000);
  }
  
  //NCR_04
  @Test (groups = {"positive"},priority=3)
  public void NCR_04_Verify_PageHeadings() throws InterruptedException 
  {
	  ncr.ncr_04_Verify_headings();
	  Thread.sleep(1000);
  }
  
  //NCR_05
  @Test (groups = {"positive"},priority=4)
  public void NCR_05_Verify_All_Mandatory_Symbols() throws InterruptedException 
  {
	  ncr.ncr_05_verify_all_mandatory_symbols();
	  Thread.sleep(1000);
  }
  
  //NCR_06
  @Test (groups = {"positive"},priority=5)
  public void NCR_06_Verify_Default_option_Title() throws InterruptedException, AWTException 
  {
	  ncr.ncr_06_verify_default_option_at_title();
	  Thread.sleep(1000);
  }
  
  //NCR_07
  @Test (groups = {"negative"},priority=6)
  public void NCR_07_Verify_Error_Message_Title_Reg() throws InterruptedException, AWTException 
  {
	  ncr.ncr_07_verify_error_message_title_reg();
	  DriverInitializer.Refresh();
  }
  
  //NCR_08
  @Test (groups = {"positive"},priority=7)
  public void NCR_08_Verify_Dropdown_Valid() throws InterruptedException, AWTException 
  {
	  ncr.ncr_08_Verify_Dropdown_Title();
	  
  }
  
  //NCR_09
  @Test (groups = {"negative"},priority=8)
  public void NCR_09_Verify_Tab_Allfields() throws InterruptedException, AWTException 
  {
	  ncr.ncr_09_Verify_Tab_Orderwise();
	  
  }
  
  //NCR_10
  @Test (groups = {"negative"},priority=9)
  public void NCR_10_Verify_GuestName_Invalid_Alphanumeric() throws InterruptedException, AWTException 
  {
	  ncr.ncr_10_verify_guestname_invalid_alphanumeric();
	  
	  
  }
  
  //NCR_10
  @Test (groups = {"negative"},priority=10)
  public void NCR_10_Verify_GuestName_Invalid_Numeric() throws InterruptedException, AWTException 
  {
	  ncr.ncr_10_verify_guestname_invalid_numeric();
	  
	  
  }
  
  //NCR_11
  @Test (groups = {"negative"},priority=11)
  public void NCR_11_Verify_GuestName_Invalid_Splchar() throws InterruptedException, AWTException 
  {
	  ncr.ncr_11_verify_guestname_invalid_splchar();
	  
  }
  
  //NCR_12
  @Test (groups = {"negative"},priority=12)
  public void NCR_12_Verify_GuestName_Invalid_Spaces() throws InterruptedException, AWTException 
  {
	  ncr.ncr_12_verify_guestname_spaces();
	  
  }
  
  //NCR_13
  @Test (groups = {"positive"},priority=13)
  public void NCR_13_Verify_GuestName_alphabets_Reg() throws InterruptedException, AWTException 
  {
	  ncr.ncr_13_verify_guestname_alphabets_reg();
	  
  }
  
  //NCR_14
  @Test (groups = {"negative"},priority=14)
  public void NCR_14_Verify_GuestName_Blank_Reg() throws InterruptedException, AWTException 
  {
	  ncr.ncr_14_verify_guestname_blank();
	  
  }
  
  //NCR_15
  @Test (groups = {"negative"},priority=15)
  public void NCR_15_Verify_GuestName_Below6_Char() throws InterruptedException, AWTException 
  {
	  ncr.ncr_15_Verify_Name_Below6_char();
	  
  }
  
  //NCR_16
  @Test (groups = {"negative"},priority=16)
  public void NCR_16_Verify_GuestName_Above30_Char() throws InterruptedException, AWTException 
  {
	  ncr.ncr_16_Verify_Name_above30_char();
	  
  }
  
  //NCR_17
  @Test (groups = {"positive"},priority=17)
  public void NCR_17_Verify_Calendar_DOB() throws InterruptedException, AWTException 
  {
	  ncr.ncr_17_verify_calendar_dob();
	  
  }
  
  //NCR_18
  @Test (groups = {"positive"},priority=18)
  public void NCR_18_Verify_CurrentDate_default_Calendar_DOB() throws InterruptedException, AWTException 
  {
	  ncr.ncr_18_verify_current_date_default_calendar_dob();
	  
  }
  
  //NCR_19
  @Test (groups = {"positive"},priority=19)
  public void NCR_19_Verify_DOB_Valid_Below_2014() throws InterruptedException, AWTException 
  {
	  ncr.ncr_19_verify_date_of_birth_valid_below_2014();
	  
  }
  
  //NCR_20
  @Test (groups = {"positive"},priority=20)
  public void NCR_20_Verify_DOB_Selected_Or_Not() throws InterruptedException, AWTException 
  {
	  ncr.ncr_20_verify_dob_selected_or_not();
	  
  }
  
  //NCR_21
  @Test (groups = {"positive"},priority=21)
  public void NCR_21_Verify_Selected_DOB_Format() throws InterruptedException, AWTException 
  {
	  ncr.ncr_21_verify_Selected_dob_format();
	  
  }
  
  //NCR_22
  @Test (groups = {"negative"},priority=22)
  public void NCR_22_Verify_DOB_morethan_2014() throws InterruptedException, AWTException 
  {
	  ncr.ncr_22_verify_date_of_birth_invalid_morethan_2014();
	  
  }
  
  //NCR_29
  @Test (groups = {"positive"},priority=23)
  public void NCR_29_Verify_Country_Flag_Mobile_No() throws InterruptedException, AWTException 
  {
	  ncr.ncr_29_verify_country_flag_at_mobileNo();
  }  
  
  //NCR_30
  @Test (groups = {"positive"},priority=24)
  public void NCR_30_Verify_Country_Code_Mobile_No() throws InterruptedException, AWTException 
  {
	  ncr.ncr_30_verify_country_code_at_mobileno();
  }  

  //NCR_31
  @Test (groups = {"positive"},priority=25)
  public void NCR_31_Verify_Valid_Mobile_No_10digits() throws InterruptedException, AWTException 
  {
	  ncr.ncr_31_verify_mobileno_valid_10digits();
  }  
  
  //NCR_32
  @Test (groups = {"negative"},priority=26)
  public void NCR_32_Verify_invalid_Mobile_No_Below_10digits() throws InterruptedException, AWTException 
  {
	  ncr.ncr_32_verify_below10_invalid_mobileno();
  }  
  
  //NCR_33
  @Test (groups = {"negative"},priority=27)
  public void NCR_33_Verify_invalid_Mobile_No_Above_10digits() throws InterruptedException, AWTException 
  {
	  ncr.ncr_33_verify_above10_invalid_mobileno();
  }  
  
  //NCR_34
  @Test (groups = {"negative"},priority=28)
  public void NCR_34_Verify_invalid_Mobile_No_Alphabets() throws InterruptedException, AWTException 
  {
	  ncr.ncr_34_verify_invalid_alphabets_mobileno();
  }  
  
  //NCR_35
  @Test (groups = {"negative"},priority=29)
  public void NCR_35_Verify_invalid_Mobile_No_Spl_Char() throws InterruptedException, AWTException 
  {
	  ncr.ncr_35_verify_invalid_spl_char_mobileno();
  }  
  
  //NCR_36
  @Test (groups = {"negative"},priority=30)
  public void NCR_36_Verify_invalid_Mobile_No_AlphaNumeric() throws InterruptedException, AWTException 
  {
	  ncr.ncr_36_verify_invalid_alphanumeric_mobileno();
  }  
  

  //NCR_37
  @Test (groups = {"negative"},priority=31)
  public void NCR_37_Verify_MobileNo_Empty_Reg() throws InterruptedException, AWTException 
  {
	  ncr.ncr_37_verify_mobileno_empty_reg();
  } 
  
  //NCR_38
  @Test (groups = {"positive"},priority=32)
  public void NCR_38_Verify_Valid_Email() throws InterruptedException, AWTException 
  {
	  ncr.ncr_38_verify_email_valid();
  }  
  
  //NCR_39
  @Test (groups = {"negative"},priority=33)
  public void NCR_39_Verify_Email_Without_LocalPart() throws InterruptedException, AWTException 
  {
	  ncr.ncr_39_verify_invalid_email_without_localpart();
  }  
  
  //NCR_40
  @Test (groups = {"negative"},priority=34)
  public void NCR_40_Verify_Email_Without_Domain() throws InterruptedException, AWTException 
  {
	  ncr.ncr_40_verify_invalid_email_without_domain();
  }  
  
  //NCR_41
  @Test (groups = {"positive"},priority=35)
  public void NCR_41_Verify_Email_With_1Dot() throws InterruptedException, AWTException 
  {
	  ncr.ncr_41_verify_email_with_1dot();
  }  
  
  //NCR_42
  @Test (groups = {"positive"},priority=36)
  public void NCR_42_Verify_Email_With_2Dots() throws InterruptedException, AWTException 
  {
	  ncr.ncr_42_verify_email_with_2dots();
  }  
  
  //NCR_43
  @Test (groups = {"negative"},priority=37)
  public void NCR_43_Verify_Email_With_SplChar_At_LocalPart() throws InterruptedException, AWTException 
  {
	  ncr.ncr_43_verify_email_with_Splchar_at_localpart();
  }  
  
  //NCR_44
  @Test (groups = {"negative"},priority=38)
  public void NCR_44_Verify_Email_With_SplChar_At_Domain() throws InterruptedException, AWTException 
  {
	  ncr.ncr_44_verify_email_with_Splchar_at_Domain();
  }  
  
  //NCR_45
  @Test (groups = {"negative"},priority=39)
  public void NCR_45_Verify_Email_With_3dots_At_Domain() throws InterruptedException, AWTException 
  {
	  ncr.ncr_45_Verify_Email_with_3Dots_at_domain();
  }  
  
  //NCR_46
  @Test (groups = {"negative"},priority=40)
  public void NCR_46_Verify_Email_Numerics_At_Domain() throws InterruptedException, AWTException 
  {
	  ncr.ncr_46_Verify_Email_with_numerics_at_domain();
  } 
  
  //NCR_47
  @Test (groups = {"negative"},priority=41)
  public void NCR_47_Verify_Email_Numerics_Only_At_LocalPart() throws InterruptedException, AWTException 
  {
	  ncr.ncr_47_Verify_Email_with_numerics_only_at_localpart();
  } 
  
  //NCR_48
  @Test (groups = {"positive"},priority=42)
  public void NCR_48_Verify_Address_Valid() throws InterruptedException, AWTException 
  {
	  ncr.ncr_48_verify_address_valid();
	  
  } 
  
  //NCR_49
  @Test (groups = {"negative"},priority=43)
  public void NCR_49_Verify_Empty_Address_Reg() throws InterruptedException, AWTException 
  {
	  ncr.ncr_49_verify_Empty_address_reg();
	  
  } 
  
  //NCR_50
  @Test (groups = {"positive"},priority=44)
  public void NCR_50_Verify_Gender_Valid() throws InterruptedException, AWTException 
  {
	  ncr.ncr_50_Verify_Dropdown_Gender();
  } 
  
  //NCR_51
  @Test (groups = {"positive"},priority=45)
  public void NCR_51_Verify_Default_Option_Gender() throws InterruptedException, AWTException 
  {
	  ncr.ncr_51_verify_default_option_at_Gender();
  } 
  
  //NCR_52
  @Test (groups = {"negative"},priority=46)
  public void NCR_52_Verify_Empty_Gender_Reg() throws InterruptedException, AWTException 
  {
	  ncr.ncr_52_verify_empty_gender_reg();
  }
  
  //NCR_112
  @Test (groups = {"negative"},priority=47)
  public void NCR_112_Verify_All_Errors_Reg() throws InterruptedException, AWTException 
  {
	  ncr.ncr_112_verify_all_error_messages_reg();
  } 
  
  //NCR_118
  @Test (groups = {"negative"},priority=48)
  public void NCR_118_Verify_All_Errors_Book() throws InterruptedException, AWTException 
  {
	  ncr.ncr_118_verify_all_error_messages_book();
  } 
  
  //NCR_119
  @Test (groups = {"positive"},priority=49)
  public void NCR_119_Verify_Placeholder_Text_Name() throws InterruptedException, AWTException 
  {
	  ncr.ncr_119_verify_placeholder_text_name();
  } 
  
  //NCR_120
  @Test (groups = {"positive"},priority=50)
  public void NCR_120_Verify_Placeholder_Text_MobileNo() throws InterruptedException, AWTException 
  {
	  ncr.ncr_120_verify_placeholder_text_mobileno();
  } */
  

  
  
  
  
  
  
}
