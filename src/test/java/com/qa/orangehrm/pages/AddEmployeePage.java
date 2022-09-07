package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.utils.ElementUtil;

public class AddEmployeePage {

	ElementUtil util;
	
	By fName = By.id("firstName");
	By lName = By.id("lastName");
	By photo = By.id("photofile");
	By save = By.id("btnSave");
	By header = By.xpath("//h1[text() = 'Personal Details']");
	By id = By.id("employeeId");
	
	public AddEmployeePage(WebDriver driver) {
		
		util = new ElementUtil(driver);
	}
	
	public boolean addEmployee() throws InterruptedException {
		util.doSendKeys(fName, "bimal");
		util.doSendKeys(lName, "bimal");
		util.doSendKeys(photo, "C:\\Users\\upret\\OneDrive\\Desktop\\Pizza Parlor\\Cake.jpg");
		util.doSendKeys(id, "0295");
		util.doClick(save);
		util.waitForElementPresence(header, 3);
		String hed = util.doGetElementText(header);
		if (hed.equals("Personal Details"))
			return true;
		else 
			return false;
	}

}
