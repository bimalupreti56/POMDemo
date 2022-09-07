package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(priority = 3)
	public void loginTest() {
		pimPage = loginPage.doLogin("Admin", "admin123");
		String dashboardHeader = pimPage.getDashboardPageHeader();
		Assert.assertEquals(dashboardHeader, Constants.PIM_PAGE_HEADER);		
	}

}
