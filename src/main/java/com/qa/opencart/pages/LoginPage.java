package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.CommonComponents;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	private CommonComponents common;
	private ElementUtil elementUtil;
	
	//1. By locators:OR
	private By emailId=By.id("input-email");
	private By password=By.id("input-password");
	private By loginButton=By.xpath("//input[@value='Login' and @type='submit']");
	private By forgotPwdLink=By.linkText("Forgotten Password");	
	
	private By registerLink=By.linkText("Register");
	
	
	//2. Constructor of the LoginPage class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		common=new CommonComponents(driver);
		elementUtil=new ElementUtil(driver);
	}
	
	//3. page actions: features(Behaviour) of the page in the form methods:
	
	public String getLoginPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean isForgotPwdLinkDisplayed() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public AccountsPage doLogin(String un,String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
	}
	
	public List<String> getHeadersInLoginPage() {
		return common.getHeadersList();
	}
	
	public RegisterPage navigateToRegisterPage() {
		driver.findElement(registerLink).click();
		return new RegisterPage(driver);
	}
	
	

}
