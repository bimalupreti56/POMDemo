package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;

public class PunchInPageTest extends BaseTest{

	//@BeforeClass
	public void setUp() {
		pimPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		punchInPage = loginPage.navToPunchInPage();
	}
	
	//@Test
	public void punchIn() {
	
		Assert.assertTrue(punchInPage.punchIn());
	}
	
	//@Test
	public void headerDisplay() {
		Assert.assertTrue(punchInPage.headerDisplay());
	}
	
}
