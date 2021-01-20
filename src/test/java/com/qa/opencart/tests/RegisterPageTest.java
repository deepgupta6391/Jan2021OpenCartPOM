package com.qa.opencart.tests;

import java.util.Hashtable;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{

	
	@BeforeClass
	public void registerPageSetUp() {
		registerPage=loginPage.navigateToRegisterPage();
	}
	
	@DataProvider(parallel = true)
	public Object[][] getRegisterData() {
		Object data[][]=ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	
	
	@Test(dataProvider = "getRegisterData")
	public void userRegisterationTest(Hashtable<String, String> data) {
		registerPage.accountRegisteration(data.get("firstname"), data.get("lastname"),
				data.get("email"),data.get("telephone"),data.get("password"),data.get("subscribe"));
	}
	
	
}
