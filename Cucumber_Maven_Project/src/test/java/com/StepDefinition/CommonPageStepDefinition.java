package com.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonPageStepDefinition extends AbstractPageStepDefinition {

	WebDriver driver = getDriver();

	@Given("User is on OrangeHRM Home Page")
	public void user_is_on_orange_hrm_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@When("User Navigate to Log-in Page of OrangeHRM")
	public void user_navigate_to_log_in_page_of_orange_hrm() {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//h5[normalize-space()='Login']")).isDisplayed();
	}
	@When("User enters username {string} and password {string} of OrangeHRM page")
	public void user_enters_username_and_password_of_orange_hrm_page(String Username, String Password) {
	    // Write code here that turns the phrase above into concrete actions
		  // Write code here that turns the phrase above into concrete actions
				driver.findElement(By.name("username")).sendKeys(Username);
				driver.findElement(By.name("password")).sendKeys(Password);
				driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@When("User enters valid credential")
	public void user_enters_valid_credential(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> data = dataTable.asLists();
		//This is to get the first data of the set (First Row + First Column)
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0)); 
		//This is to get the first data of the set (First Row + Second Column)
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Then("User should be in Dashboard page.")
	public void user_should_be_in_dashboard_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is on Dashboard Page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	}
	
	@After
	public void CloseBrowser() {
		//driver.quit()
	}
}
