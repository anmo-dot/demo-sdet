package com.orangeHRM.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.common.OrangeHRM_BasePage;
import com.orangeHRM.common.OrangeHRM_BaseSetup;
import com.orangeHRM.home.OrangeHRM_SignInPage;
import com.orangeHRM.utils.OrangeHRM_TestData;

public class OrangeHRM_Login extends OrangeHRM_BaseSetup {

	OrangeHRM_SignInPage signIn;
	OrangeHRM_BasePage basePage;
	OrangeHRM_BaseSetup baseSetup;
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new OrangeHRM_BasePage(driver);
	}

	@Test(dataProvider = "Login", dataProviderClass = OrangeHRM_TestData.class, description = "verifySignInPageURL() method call for URL verification", priority = 1)
	public void urlTest(String userName, String passWord) throws Exception {
		test = extent.createTest("Test Case 2", "Verify Login Page URL");
		signIn = basePage.GoToHomePageAndSignIn(userName, passWord);
		Thread.sleep(5000);
		signIn.verifySignInPageURL();
		basePage.logout();
	}

}