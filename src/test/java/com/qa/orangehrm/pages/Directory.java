package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.orangehrm.utils.ElementUtil;

public class Directory {

	ElementUtil util;
	

	public Directory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		util = new ElementUtil(driver);		
	}
	
	
	@FindBy(xpath = "//input[@placeholder = 'Type for hints...']")
	WebElement empNameField;
	//By empNameField = By.xpath("//input[@placeholder = 'Type for hints...']");
	By job = By.xpath("//div[@class = 'oxd-grid-item oxd-grid-item--gutters'][2]//@tabindex");
	By dropDown = By.xpath("//div[@class = 'oxd-form-row']/div/div[2]//i");
	
	By header = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
	
	public String headerVarify() {
		
		empNameField.sendKeys("Charlie");
		String hed = util.doGetElementText(header);
		return hed;
		//util.doClick(dropDown);
		//util.doMoveToElement(job);
		//util.doClick(job);
	}
}
