package com.weborder.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.weborder.pages.AllOrderPage;
import com.weborder.pages.HomePage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinition extends AbstractPageStepDefinition {

	static WebDriver driver = getDriver();
	HomePage homePage = new HomePage(driver);
	AllOrderPage allOrderPage;

	@Given("User has Launched Edge Browser")
	public void user_has_launched_edge_browser() {
		System.out.println("Chrome browser has launched");
	}

	@When("User Navigate to Sign In Page of WebOrder Application")
	public void user_navigate_to_sign_in_page_of_web_order_application() {
		homePage.goToHomePage();
	}

	@When("User enters valid username and password in weborder login page")
	public void user_enters_valid_username_and_password_in_weborder_login_page() {
		homePage.enterInfo("Tester", "test");
		
	}

	@When("User Click on Login button in from weborder login page")
	public void user_click_on_login_button_in_from_weborder_login_page() {
		homePage.clickLoginBtn();
	}
	
	@Then("user should be taken back to Login page.")
	public void user_should_be_taken_back_to_login_page() {
	    homePage.assertTitle();
	}


	@AfterAll
	public static void afterAll() {
	   driver.close();
	}
}
