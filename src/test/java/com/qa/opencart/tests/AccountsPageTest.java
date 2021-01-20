package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void AccountsPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 3)
	public void verifyAccountsPageTitleTest() {
		String title=accountsPage.getAccountPageTitle();
		System.out.println("accounts page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test(priority = 1)
	public void verifyAccountsPageHeaderTest() {
		String headerValue= accountsPage.getHeaderValue();
		System.out.println("accounts page header is : " + headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Test(priority = 2)
	public void verifyAccountsPageHeadersList() {
		List<String> headersList=accountsPage.getAccountsPageHeadersList();
		Assert.assertEquals(headersList, Constants.getCommonHeadersList());
	}
	
	@Test(priority = 4)
	public void verifyMyAccountSectionsCountTest() {
		Assert.assertTrue(accountsPage.getAccountSectionsCount()==Constants.ACCOUNTS_SECTIONS);
	}
	
	@Test(priority = 5)
	public void verifyMyAccountSectionsListTest() {
		Assert.assertEquals(accountsPage.getAccountSectionsList(),Constants.getAccountSecHeadersList());
	}
	
	@Test(priority = 6)
	public void serachTest() {
		Assert.assertTrue(accountsPage.doSearch("iMac"));
	}
	
	
	
}
