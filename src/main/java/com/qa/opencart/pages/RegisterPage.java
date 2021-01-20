package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage extends BasePage {

	private ElementUtil elementUtil;

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");

	private By agreeCheckBox = By.xpath("//input[@type='checkbox' and @name='agree']");
	private By submitBtn = By.xpath("//input[@type='submit' and @value='Continue']");

	private By accountCreatioSuccMsg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public boolean accountRegisteration(String firstname, String lastname, String email, String telephone,
			String password, String subscribe) {
		elementUtil.doSendKeys(this.firstname, firstname);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);

		if (subscribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		} else {
			elementUtil.doClick(subscribeNo);
		}

		elementUtil.doClick(agreeCheckBox);
		elementUtil.doClick(submitBtn);

		String text = elementUtil.doGetText(accountCreatioSuccMsg);
		if (text.contains(Constants.ACCOUNT_CREATION_SUCCESS_MSG)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		return false;
	}

}
