package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void ProductInfoSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void ProductInfoPageTitleTest_iMac() {
		accountsPage.doSearch("iMac");
		productInfoPage=accountsPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");
	}

	@Test(priority = 2)
	public void verifyProductInfoTest_MacBook() {
		String productName = "Macbook";

		Assert.assertTrue(accountsPage.doSearch(productName));
		
		productInfoPage = accountsPage.selectProductFromResults("MacBook Pro");
		
		Assert.assertTrue(productInfoPage.getProductImagesCount()==4);
		
		Map<String,String> productInfoMap=productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		
		//{Brand=Apple, Availability=Out Of Stock, price=$2,000.00, name=MacBook Pro, 
		//Product Code=Product 18, Reward Points=800, exTaxPrice=$2,000.00}
		Assert.assertEquals(productInfoMap.get("name"),"MacBook Pro");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("price"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
	}
	
	@Test(priority = 3)
	public void verifyProductInfoTest_iMac() {
		String productName = "iMac";

		Assert.assertTrue(accountsPage.doSearch(productName));
		
		productInfoPage = accountsPage.selectProductFromResults("iMac");
		
		Assert.assertTrue(productInfoPage.getProductImagesCount()==3);
		
		Map<String,String> productInfoMap=productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		
		Assert.assertEquals(productInfoMap.get("name"),"iMac");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("price"), "$100.00");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 14");
	}
	
	@Test(priority = 4)
	public void verifyIfProductIsAddedToCart() {
		accountsPage.doSearch("iMac");
		productInfoPage=accountsPage.selectProductFromResults("iMac");
		Assert.assertTrue(productInfoPage.addToCart());
	}
}
