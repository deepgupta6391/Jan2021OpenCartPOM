package com.qa.opencart.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.base.BasePage;

public class CommonComponents{

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By commonHeadersList= By.cssSelector("ul.nav.navbar-nav>li>a");
	
	public CommonComponents(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public List<String> getHeadersList() {
		return elementUtil.getTextFromListOfElements(commonHeadersList);
		
	}
	
}
