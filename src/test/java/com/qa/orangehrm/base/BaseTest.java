package com.qa.orangehrm.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.orangehrm.factory.DriverFactory;
import com.qa.orangehrm.pages.Directory;
import com.qa.orangehrm.pages.Leave;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.PimPage;
import com.qa.orangehrm.pages.PunchInPage;
import com.qa.orangehrm.pages.Timesheet;
import com.qa.orangehrm.utils.ElementUtil;


public class BaseTest {
	
	public ElementUtil util;
	static WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public PimPage pimPage;
	public PunchInPage punchInPage;
	public Directory dir;
	public Leave leave;
	public Timesheet timeSheet;
	DriverFactory driverFact;
	
	
	@BeforeTest
	public void setUp() {
		driverFact = new DriverFactory();	
		prop = driverFact.init_prop();
		driver = driverFact.init_driver(prop.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
	
	public void fail() {
		TakesScreenshot shot =((TakesScreenshot)driver);
		File file = shot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\upret\\OneDrive\\Pictures\\Screenshots\\shot.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
