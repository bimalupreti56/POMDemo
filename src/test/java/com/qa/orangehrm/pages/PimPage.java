package com.qa.orangehrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.ElementUtil;

public class PimPage {
	
	ElementUtil elemUtil;
	
	By pimHeader = By.xpath("//h6[@class = 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	By quickLaunch = By.xpath("//*[@class = 'quickLinkText']");
	////*[@class = 'quickLaunge']
	
	public PimPage(WebDriver driver) {
		elemUtil = new ElementUtil(driver);		
	}
	
	public String getDashboardPageHeader() {
		return elemUtil.doGetElementText(pimHeader);
	}
	
	public List<String> getQuickLaunchList() {
		List<WebElement> quickLaunchList = elemUtil.getElements(quickLaunch);
		List<String> quickLaunchTextList = new ArrayList<String>();
		for(WebElement e : quickLaunchList) {
			quickLaunchTextList.add(e.getText());
		}
		return quickLaunchTextList;
	}
	
	public int getQuickLaunchListCount() {
		return getQuickLaunchList().size();
	}
	

}
