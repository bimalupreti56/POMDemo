package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;

public class AddEmployeeTest extends BaseTest{

//	@BeforeClass
	public void setUp() {
		pimPage = loginPage.doLogin("Admin", "admin123");
	}
	
//	@Test
	public void Employee() {
		Assert.assertTrue(true);;
	}
}
