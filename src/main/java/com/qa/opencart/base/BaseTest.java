package com.qa.opencart.base;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest {


	public BasePage basePage;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ProductInfoPage productInfoPage;
	public RegisterPage registerPage;

	public Properties prop;
	public WebDriver driver;
	//public Logger log=Logger.getLogger(BaseTest.class);

	@Parameters("browser")
	@BeforeTest
	public void setUp(@Optional String browserName) {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		
		if(browserName!=null) {
			browser=browserName;
		}

		driver = basePage.init_driver(browser);

		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		//log.info("start");
	}

	@AfterTest
	public void tearDown() {
		 driver.quit();

	}
}
