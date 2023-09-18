package com.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpreeStepDefinition extends AbstractPageStepDefinition {

	WebDriver driver = getDriver();

	@When("User Navigate to Sign In Page of Spree Application")
	public void user_navigate_to_sign_in_page_of_spree_application() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://demo.spreecommerce.org/");
		driver.findElement(By.id("account-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("LOGIN")).click();

	}

	@When("User enters valid username and password in Spree login page")
	public void user_enters_valid_username_and_password_in_spree_login_page() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("spree_user_email")).sendKeys("minh@spree.com");
		driver.findElement(By.id("spree_user_password")).sendKeys("123456");

	}

	@When("User Click on Login Button in from Spree login page")
	public void user_click_on_login_button_in_from_spree_login_page() {
		driver.findElement(By.xpath("//input[@name='commit']")).click();
	}

	@Then("User should be logged in and My Account page should display")
	public void user_should_be_logged_in_and_my_account_page_should_display() {
		driver.findElement(By.xpath("//span[text()='Logged in successfully']")).isDisplayed();
	}

	@When("User click on Logout link from the account page of Spree")
	public void user_click_on_logout_link_from_the_account_page_of_spree() throws InterruptedException {
		driver.findElement(By.id("account-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("LOGOUT")).click();
	}

	@Then("user should be taken back to home page of Spree.")
	public void user_should_be_taken_back_to_home_page_of_spree() {
		driver.findElement(By.xpath("//span[text()='Signed out successfully.']")).isDisplayed();
		driver.close();
	}
}
