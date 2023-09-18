package com.orangeHRM.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_SignInPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement lnDashboard;
	
	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement txtDashboard;
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement divLogo_img;

	public OrangeHRM_SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateLogo() {
		divLogo_img.isDisplayed();
		return true;
	}
	
	public boolean verifySignInPageURL() {
		String pageURL = driver.getCurrentUrl();
		String expectedPageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		return pageURL.contains(expectedPageURL);
	}

	public boolean verifySignInPageText() {
		String pageText = txtDashboard.getText();
		String expectedPageText = "Dashboard";
		return pageText.contains(expectedPageText);
	}

}
