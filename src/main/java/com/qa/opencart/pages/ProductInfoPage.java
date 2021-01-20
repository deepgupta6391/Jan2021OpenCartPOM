package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productNameHeader = By.cssSelector("div#content h1");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By productImages = By.cssSelector("ul.thumbnails li img");
	private By successMsg=By.cssSelector("div.alert.alert-success.alert-dismissible");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public Map<String, String> getProductInformation() {
		
		Map<String,String> productInfoMap=new HashMap<String,String>();
		productInfoMap.put("name", elementUtil.doGetText(productNameHeader).trim());
		
		List<WebElement> productMetaDataList=elementUtil.getElements(productMetaData);
		for(WebElement e:productMetaDataList) {
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}
		
		List<WebElement> productPriceList=elementUtil.getElements(productPrice);
		productInfoMap.put("price", productPriceList.get(0).getText().trim());
		productInfoMap.put("exTaxPrice", productPriceList.get(1).getText().split(":")[1].trim());
		
		return productInfoMap;
	}

	public void selectQuantity(String quantity) {
		elementUtil.doSendKeys(this.quantity,quantity);
	}
	
	public boolean addToCart() {
		elementUtil.waitForElementToBeLocated(addToCartButton, 15);
		elementUtil.doClick(addToCartButton);
		elementUtil.waitForElementToBeLocated(successMsg, 15);
		String successMessage=elementUtil.doGetText(successMsg);
		System.out.println(successMessage);
		return successMessage.contains("Success");
	}
	
	public int getProductImagesCount() {
		int countImages=elementUtil.getElements(productImages).size();
		System.out.println("Total images : "+countImages);
		return countImages;
	}
	
	public String getProductInfoPageTitle(String productName) {
		return elementUtil.waitForTitlePresent(productName, 5);
	}
}
