package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.testlisteners.ExtentReportListener;
import com.qa.opencart.utils.Constants;


//@Listeners(ExtentReportListener.class)
public class LoginPageTest extends BaseTest{	
	
	@Test(priority = 1)
	public void verifyLoginPageTitle() {	
		String title=loginPage.getLoginPageTitle();
		System.out.println("Login page title is : "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyLoginPageHeadersListTest() {
		List<String> headers=loginPage.getHeadersInLoginPage();
		System.out.println("Headers are as follows : ");
		headers.stream().forEach(System.out::println);
		Assert.assertEquals(headers, Constants.getCommonHeadersList());
	}
	
	@Test(priority = 3)
	public void verifyForgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkDisplayed());
	}
	
	@Test(priority = 4)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
