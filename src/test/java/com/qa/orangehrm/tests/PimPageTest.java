package com.qa.orangehrm.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.utils.Constants;


public class PimPageTest extends BaseTest{
	
	@BeforeClass
	public void DashboardPageSetUp() {
		pimPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void dashboardPageHeaderTest() {
		String dashboardHeader = pimPage.getDashboardPageHeader();
		Assert.assertEquals(dashboardHeader, Constants.PIM_PAGE_HEADER);		
	}
	
//	@Test(priority = 2)
//	public void dashboardQuickLaunchCountTest() {
//		Assert.assertEquals(dbPage.getQuickLaunchListCount(), Constants.DASHBOARD_QUICKLAUNCH_COUNT);
//	}
//	
//	@Test(priority = 3)
//	public void quickLaunchListTest() {
//		List<String> actQuickLaunchList = dbPage.getQuickLaunchList();
//		System.out.println(actQuickLaunchList);
//		Assert.assertEquals(actQuickLaunchList, Constants.expectedQuickLaunchList());		
//	}

}
