package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.qa.orangehrm.utils.ElementUtil;

public class PunchInPage {

	ElementUtil util;;
	
	PunchInPage (WebDriver driver){
		util = new ElementUtil(driver);
	}
	
	By date = By.id("attendance_date");
	By time = By.id("attendance_time");
	By note = By.id("attendance_note");
	By inButtom = By.id("btnPunch");
	By punchInTime = By.xpath("//*[@id=\"punchTimeForm\"]/fieldset/ol/li[1]/label[1]");
	By header = By.xpath("//h1[text() = 'Punch Out']");
	
	
	public boolean headerDisplay() {
		
		return util.doIsDisplayed(header);
	}
	
	public boolean punchIn() {
		
		util.doSendKeys(date, "2022-08-15");
		util.doSendKeys(time, "19:00");
		util.doSendKeys(note, "note demo");
		util.doClick(inButtom);
		
		return util.doIsDisplayed(punchInTime);
	}
	
}
