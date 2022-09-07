package com.qa.orangehrm.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "OrangeHRM";
	public static final String PIM_PAGE_HEADER = "PIM";
	public static final int DASHBOARD_QUICKLAUNCH_COUNT = 6;
	public static final String EMP_SHEET_NAME = "Add Employee Data";
	
	public static List<String> expectedQuickLaunchList() {
		List<String> exepectedList = new ArrayList<String>();
		exepectedList.add("Assign Leave");
		exepectedList.add("Leave List");
		exepectedList.add("Timesheets");
		exepectedList.add("Apply Leave");
		exepectedList.add("My Leave");
		exepectedList.add("My Timesheet");
		return exepectedList;
	}
	
	
	

}
