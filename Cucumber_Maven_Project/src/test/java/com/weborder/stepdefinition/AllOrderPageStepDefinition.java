package com.weborder.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.weborder.pages.AllOrderPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AllOrderPageStepDefinition extends AbstractPageStepDefinition {
	static WebDriver driver = getDriver();
	
	AllOrderPage allOrderPage = new AllOrderPage(driver);
	
	@Then("User should be logged in and List of All Orders page should display")
	public void user_should_be_logged_in_and_list_of_all_orders_page_should_display() {
		allOrderPage = new AllOrderPage(driver);
		allOrderPage.assertText();
		allOrderPage.assertTitle();
		allOrderPage.assertUrl();
	}
	
	@When("User click on Logout link from the All Order Page")
	public void user_click_on_logout_link_from_the_all_order_page() {
	    allOrderPage.logout();
	}
	
	@Then("User Clicks on Order link in All Order Page")
	public void user_clicks_on_order_link_in_all_order_page() {
	   allOrderPage.goToCreateOrder();
	}
	
	
}
