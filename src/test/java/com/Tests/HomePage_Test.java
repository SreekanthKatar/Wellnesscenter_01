package com.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.PageLibrary.HomePage;
import com.util.DriverInitializer;

public class HomePage_Test 
{
	
	public HomePage hp = new HomePage();
 
  //HP_01: Verify Home Page
  @Test (groups ={"positive","negative"},priority=0)
  public void HP_01_Verify_HomePage() throws InterruptedException {
	  
	  hp.hp_01_HomePage();
	  
  }
  
 //HP_02: Verify UI
  @Test (groups ={"positive","positive"},priority=1)
  public void HP_Verify_UI() throws InterruptedException {
	  
	  hp.hp_02_UI();
	  
  }
  
  //HP_03: Verify Staff Login Page after Clicked on Click here To Login 
  @Test (groups ={"positive"},priority=2)
  public void HP_03_Verify_Click_here_to_login_button() throws InterruptedException {
	  
	  hp.hp_03_ClickHereToLoginButton();
  }
  
  //HP_04: Verify Staff Login Page after Clicked on Click here To Login 
  @Test (groups ={"positive"},priority=3)
  public void HP_04_Verify_StaffLoginPage() throws InterruptedException {
	  
	  hp.hp_04_ClickHereToLogin();
  }
  
  
  
  
  
  
  @BeforeTest
  public void Launch() {
	  DriverInitializer.launch();
  }

  @AfterTest
  public void Close() {
	  DriverInitializer.close();
  }

}
