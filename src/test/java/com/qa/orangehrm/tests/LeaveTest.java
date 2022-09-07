package com.qa.orangehrm.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;

public class LeaveTest extends BaseTest{

	//@BeforeClass 
	public void leavePageSetUp() {
		leave = loginPage.navToLeave(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	//@Test
	public void headerVisibility() {
		leave.visibility();
	}
}
