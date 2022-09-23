package com.qa.orangehrm.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;

public class TimeSheetPageTest extends BaseTest {

	@BeforeTest
	public void navToTimeSheet () {
		timeSheet = loginPage.navToTimeSheet("admin", "admin123");
	}
	
	@Test
	public void editingHourTest () {
		timeSheet.editingHours();
	}
	
}
