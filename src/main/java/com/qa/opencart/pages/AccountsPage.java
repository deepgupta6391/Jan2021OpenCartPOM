package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.utils.CommonComponents;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;

public class AccountsPage {

	private WebDriver driver;
	private CommonComponents common;
	private ElementUtil elementUtil;
	private JavaScriptUtil jsUtil;

	// 1. By locators:OR
	private By header = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItemResult = By.cssSelector("div.product-layout div.product-thumb");
	private By resultItems = By.cssSelector("div.product-thumb h4 a");

	// 2. constructor of the page class:
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		common = new CommonComponents(this.driver);
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// 3.
	public String getAccountPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.ACCOUNTS_PAGE_TITLE, 10);
	}

	public String getHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public List<String> getAccountsPageHeadersList() {
		return common.getHeadersList();
	}

	public int getAccountSectionsCount() {
		return elementUtil.getElements(accountSectionHeaders).size();
	}

	public List<String> getAccountSectionsList() {
		// List<WebElement> accSectionHeadersList =
		// elementUtil.getElements(accountSectionHeaders);
		List<String> accountsHeaders = elementUtil.getTextFromListOfElements(accountSectionHeaders);
		return accountsHeaders;
	}

	public boolean doSearch(String productName) {
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if (elementUtil.getElements(searchItemResult).size() > 0) {
			return true;
		}
		return false;
	}

	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultItemList = elementUtil.getElements(resultItems);
		System.out.println("Total number of items displayed : " + resultItemList.size());

		for (WebElement e : resultItemList) {
			if (e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
}
