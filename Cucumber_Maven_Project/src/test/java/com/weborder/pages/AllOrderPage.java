package com.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AllOrderPage extends BasePage {
	private WebDriver driver;
	
	@FindBy(linkText="Order")
	WebElement orderLink;
	
	@FindBy(xpath="//h2[normalize-space()='List of All Orders']")
	WebElement listAllOrderTxt;
	
	@FindBy(id="ctl00_logout")
	WebElement logOutLink;
	
	
	public AllOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void assertTitle() {
		Assert.assertEquals("Web Orders", driver.getTitle());
	}
	
	public void assertUrl() {
		Assert.assertEquals("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx",
				driver.getCurrentUrl());
	}
	
	public void assertText() {
		listAllOrderTxt.isDisplayed();
	}
	
	public void goToCreateOrder() {
		orderLink.click();
	}
	
	public void logout() {
		logOutLink.click();
	}
	

	
}
