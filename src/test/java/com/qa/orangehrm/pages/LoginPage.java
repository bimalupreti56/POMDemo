package com.qa.orangehrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.orangehrm.utils.Constants;
import com.qa.orangehrm.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil elemUtil;
	
	// By locators
	@FindBy(xpath = "//input[@name = 'username']") 
	WebElement username;
	//By username = By.xpath("//input[@name = 'username']");
	By password = By.xpath("//input[@type = 'password']");	
	By loginBtn = By.xpath("//button[@type = 'submit']");
	By forgotPwd = By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']");
	
	//locator to nav to employee page 
	By pim = By.id("menu_pim_viewPimModule");
	By addEmployee = By.id("menu_pim_addEmployee");
	
	//locator to nav to punch in page 
	By time  = By.id("menu_time_viewTimeModule");
	By attendence = By.id("menu_attendance_Attendance");
	By punchIn = By.xpath("//*[@id=\"menu_attendance_punchIn\"]");
	
	By dir = By.xpath("//span[text()= 'Directory']");
	//Page Actions
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elemUtil = new ElementUtil(driver);
		
	}
	
	
	public String getLoginPageTitle() {	
		return elemUtil.waitForTitleIs(5,Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean isForgotPwdLinkExist() {

		elemUtil.waitForElementPresence(forgotPwd, 3);
		return elemUtil.doIsDisplayed(forgotPwd);
	}
	
	public PimPage doLogin(String un, String pwd) {
		
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys(un);
		
		elemUtil.doSendKeys(password, pwd);
		elemUtil.doClick(loginBtn);
		return new PimPage(driver);		
	}
	
	public AddEmployeePage navigateToAddEmpPage(String un, String pwd) {
	
		doLogin(un,pwd);
		elemUtil.waitForElementToBeClickable(pim, 3);
		elemUtil.doMoveToElement(pim);
		elemUtil.doClick(addEmployee);
		return new AddEmployeePage(driver);
	}
	
	public PunchInPage navToPunchInPage() {
		
		elemUtil.waitForElementToBeClickable(time, 3);
		elemUtil.doMoveToElement(time);
		elemUtil.doMoveToElement(attendence);
		elemUtil.doClick(punchIn);
		return new PunchInPage(driver);
	}
	
	public Directory navToDirectoryPage(String un, String pwd) {
		
		doLogin(un,pwd);
		elemUtil.doClick(dir);
		return new Directory(driver);
		
	}
	
	public Leave navToLeave(String un, String pwd) {
		doLogin(un,pwd);
		elemUtil.doClick(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a"));
		return new Leave(driver);
	}

}
