package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.utils.ElementUtil;

public class Leave {

	ElementUtil elemUtil;
	
	By leavelist = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5");
	
	public Leave(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		elemUtil = new ElementUtil(driver);
		
	}
	
	public boolean visibility() {
		return elemUtil.doIsDisplayed(leavelist);
	}
	
	
	
}
