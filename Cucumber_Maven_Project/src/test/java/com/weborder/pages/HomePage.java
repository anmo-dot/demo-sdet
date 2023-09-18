package com.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {
	
	private WebDriver driver;
	static String baseUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx";
	
	@FindBy(id="ctl00_MainContent_username")
	WebElement txtUsername;
	
	@FindBy(id="ctl00_MainContent_password")
	WebElement txtPassword;
	
	@FindBy(id="ctl00_MainContent_login_button")
	WebElement loginBtn;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToHomePage() {
		driver.get(baseUrl);
	}
	
	public void enterInfo(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void assertTitle() {
		Assert.assertEquals("Web Orders Login", driver.getTitle());
	}
}
