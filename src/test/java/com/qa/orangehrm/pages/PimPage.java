package com.qa.orangehrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.utils.ElementUtil;

public class PimPage {
	
	ElementUtil elemUtil;
	
	By pimHeader = By.xpath("//h6[@class = 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	By quickLaunch = By.xpath("//*[@class = 'quickLinkText']");
	
	@FindBy (xpath = "//li[@class = \"oxd-topbar-body-nav-tab --parent\" ]")
	WebElement configuration;
	
	@FindBy (xpath = "//a[contains(text(),'Optional Fields')]")
	WebElement optionalField;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/label/span")
	WebElement ssnCheckBox;
	
	@FindBy (xpath = "//ul[@class = 'oxd-main-menu']/li[6]/a")
	WebElement infoPage;
	
	@FindBy (xpath = "//button[@type = 'submit']")
	WebElement save;
	
	@FindBy (xpath = "//div[@class = 'oxd-grid-3 orangehrm-full-width-grid'][3]/div[1]//label")
	WebElement ssnNum;
	
	@FindBy (xpath = "//a[contains(text(),'Add Employee')]")
	WebElement addEmp;
	
	@FindBy (xpath = "//input[@name = 'firstName']")
	WebElement firstName;
	
	@FindBy (xpath = "//input[@name = 'middleName']")
	WebElement middleName;
	
	@FindBy (xpath = "//input[@name = 'lastName']")
	WebElement lastName;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
	WebElement id;
	
	
	public PimPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		elemUtil = new ElementUtil(driver);		
	}
	
	public String getDashboardPageHeader() {
		return elemUtil.doGetElementText(pimHeader);
	}
	
	public boolean showSSNOnProfileButton() {
		configuration.click();
		optionalField.click();
		ssnCheckBox.click();
		save.click();
		infoPage.click();
		return ssnNum.isDisplayed();
	}
	
	public void addEmployee(String fName,String mName,String lName, String id ) {
		
		addEmp.click();
		firstName.sendKeys(fName);
		middleName.sendKeys(mName);
		lastName.sendKeys(lName);
		this.id.sendKeys(id);
		
	}
	
//	public List<String> getQuickLaunchList() {
//		List<WebElement> quickLaunchList = elemUtil.getElements(quickLaunch);
//		List<String> quickLaunchTextList = new ArrayList<String>();
//		for(WebElement e : quickLaunchList) {
//			quickLaunchTextList.add(e.getText());
//		}
//		return quickLaunchTextList;
//	}
//	
//	public int getQuickLaunchListCount() {
//		return getQuickLaunchList().size();
//	}
	

}
