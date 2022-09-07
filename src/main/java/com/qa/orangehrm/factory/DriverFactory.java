package com.qa.orangehrm.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	WebDriver driver; 
	Properties prop;
	
	public WebDriver init_driver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}	
		else {
			System.out.println("Browser not found...");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		return driver;
	}
	
	/**
	 * This method initialize the properties from .properties file
	 * @return Properties (prop)
	 */
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip;
					
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");//path was mistake before now corrected
				prop.load(ip); //was missing.it stores all properties from config file
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return prop;
	}
}
