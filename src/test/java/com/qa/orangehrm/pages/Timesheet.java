package com.qa.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.orangehrm.utils.ElementUtil;

public class Timesheet {

	ElementUtil util;
	
	public Timesheet (WebDriver driver){
		PageFactory.initElements(driver, this);
		util = new ElementUtil(driver);
	}

	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div/button")
	WebElement view;
	
	@FindBy (xpath = "//button[@class = \"oxd-button oxd-button--medium oxd-button--ghost\"]")
	WebElement edit;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/table/tbody/tr[1]/td[4]/div/div[2]/input")
	WebElement hoursInput;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[3]")
	WebElement save;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[2]/table/tbody/tr[5]/td[10]")
	WebElement totalHour;
	
	public void editingHours() {
		
		util.waitForElementPresence(view, 5).click();;
		util.waitForElementPresence(edit, 5).click();;
		util.waitForElementPresence(hoursInput, 5);
		hoursInput.clear();
		hoursInput.sendKeys("08:00");
		save.click();
		String hours = util.waitForElementPresence(totalHour, 5).getText();
		//String hours = totalHour.getText();
		Assert.assertEquals("48:30", hours);
	}
	
}
