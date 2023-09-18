package com.spreecom.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spreecom.common.Spreecom_BasePage;
import com.spreecom.common.Spreecom_BaseSetup;
import com.spreecom.home.Spreecom_SportswearPage;


public class Spreecom_SportswearPage_Test extends Spreecom_BaseSetup {
	Spreecom_SportswearPage sportswearPage;
	Spreecom_BasePage basePage;
	Spreecom_BaseSetup baseSetup;
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new Spreecom_BasePage(driver);
	}
	
	@Test(priority = 1)
	public void validateSportswearPage() throws Exception {
		test = extent.createTest("Test case 3", "verify sportwear page");
		sportswearPage = basePage.goToSportswearPage();
		Thread.sleep(2000);
		sportswearPage.validateURL();
	}
	@Test(priority = 2)
	public void validateTitle() {
		sportswearPage.validateTitle();
	}
	
	@Test(priority = 3)
	public void validateText() {
		sportswearPage.validateAllTexts();
	}
}
