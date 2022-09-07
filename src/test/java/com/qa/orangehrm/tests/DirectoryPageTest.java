package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;

public class DirectoryPageTest extends BaseTest{

	@BeforeClass
	public void directoryPageSetUp() {
		
		dir = loginPage.navToDirectoryPage(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test
	public void headerTest() {
		
		Assert.assertEquals(dir.headerVarify(), "Directory");
	}
}
