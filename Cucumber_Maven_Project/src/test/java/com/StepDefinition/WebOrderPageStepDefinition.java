package com.StepDefinition;

import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.Excel_Parsing;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebOrderPageStepDefinition extends AbstractPageStepDefinition {
	static WebDriver driver = getDriver();

	@Given("User has Launched Chrome Browser")
	public void user_has_launched_chrome_browser() {
		System.out.println("Chrome browser has launched");
	}
	
	@Given("User has Launched Edge Browser")
	public void user_has_launched_edge_browser() {
		System.out.println("Chrome browser has launched");
	}

	@When("User Navigate to Sign In Page of WebOrder Application")
	public void user_navigate_to_sign_in_page_of_web_order_application() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
	}

	@When("User enters valid username and password in weborder login page")
	public void user_enters_valid_username_and_password_in_weborder_login_page() {
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String uname, String upass) {
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(uname);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(upass);
	}

	@When("User Click on Login Button in from weborder login page")
	public void user_click_on_login_button_in_from_weborder_login_page() {
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}

	@Then("User should be logged in and List of All Orders page should display")
	public void user_should_be_logged_in_and_list_of_all_orders_page_should_display() {
		driver.findElement(By.xpath("//h2[normalize-space()='List of All Orders']")).isDisplayed();
	}

	@When("User click on Logout link from the home page")
	public void user_click_on_logout_link_from_the_home_page() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_logout")).click();
	}
	@Then("user should be taken back to Login page.")
	public void user_should_be_taken_back_to_login_page() {
		driver.findElement(By.id("ctl00_MainContent_login_button")).isDisplayed();
		driver.close();
	}

	@Given("^User Clicks on Order link in TestComplete$")
	public void user_Clicks_on_Order_link_in_TestComplete() throws Throwable {
		driver.findElement(By.linkText("Order")).click();
//		Log_Message.debug("User Cliked on Order Link");
	}

	@Given("^User enters quantity, customer name, street, city, zip, card, card number, expire date in TestComplete$")
	public void user_enters_quantity_customer_name_street_city_zip_card_card_number_expire_date_in_TestComplete() throws Throwable {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("Abc");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("xyz");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("1001");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("1234");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("22/44");
//		Log_Message.debug("User enter all the Details like Customer Name, Street, City, Zip and etc.");
	}

	@Given("^User Click on Process Button in TestComplete$")
	public void user_Click_on_Process_Button_in_TestComplete() throws Throwable {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	}

	@Then("^User should see order success message in TestComplete$")
	public void user_should_see_order_success_message_in_TestComplete() throws Throwable {
		driver.findElement(By.xpath("//strong[normalize-space()='New order has been successfully added.']")).isDisplayed();
//		Log_Message.debug("It should display -'order success message in TestComplete'...");
		driver.close();
	}
	
	@Then("User should get proper {string}")
	public void user_should_get_proper(String ExpResult) {
		if (ExpResult.equalsIgnoreCase("Invalid Login or Password.")) {
			String ActResult = driver.findElement(By.id("ctl00_MainContent_status")).getText();
			Assert.assertEquals(ActResult, ExpResult);
		} else 
		{
			String ActResult = driver.findElement(By.linkText("Logout")).getText();
			Assert.assertEquals(ActResult, ExpResult);
			driver.findElement(By.linkText("Logout")).click();
		}
	}
	
	@Then("User enters {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string} in create order page")
	public void user_enters_and_in_create_order_page(String quantity, String name, String street, String city, String zipcode, String card, String cardNr, String expDate) {
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipcode);
		if (!card.equals("")) {
			driver.findElement(By.xpath("//input[@value='" + card + "']")).click();
		}

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNr);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expDate);
	}
	
	@Then("User enters order data from {string} and {int} into Order page")
	public void user_enters_order_data_from_and_into_order_page(String sheetName, Integer rowNumber) throws EncryptedDocumentException, IllegalFormatException, IOException {
	    Excel_Parsing excel = new Excel_Parsing();
	    Object[][] data = excel.getExcelData("OrderTable.xlsx", sheetName);
	    String quantity = data[rowNumber][0].toString();
	    String name = data[rowNumber][1].toString();
	    String street = data[rowNumber][2].toString();
	    String city = data[rowNumber][3].toString();
	    String zipcode = data[rowNumber][4].toString();
	    String card = data[rowNumber][5].toString();
	    String cardNr = data[rowNumber][6].toString();
	    String expDate = data[rowNumber][7].toString();
	    user_enters_and_in_create_order_page(quantity, name, street, city, zipcode, card, cardNr, expDate);
	    
	    
	}
	@Then("User should should get proper expect result from {string} and {int} after click Process button")
	public void user_should_should_get_proper_expect_result_from_and_after_click_process_button(String sheetName, Integer rowNumber) throws EncryptedDocumentException, IllegalFormatException, IOException, InterruptedException {
	    Excel_Parsing excel = new Excel_Parsing();
	    Object[][] data = excel.getExcelData("OrderTable.xlsx", sheetName);
	    String expResult = data[rowNumber][8].toString();
	    user_should_should_get_proper_after_click_Process_button(expResult);
	}
	
	@Then("User should should get proper {string} after click Process button")
	public void user_should_should_get_proper_after_click_Process_button(String expResult) throws InterruptedException {
		if (!expResult.equals("empty_quantity"))
			driver.findElement(By.linkText("Process")).click();

		switch (expResult) {
		case "valid":
			String expMessage = driver
					.findElement(By.xpath("//strong[normalize-space()='New order has been successfully added.']"))
					.getText();
			String actMessage = "New order has been successfully added.";
			Assert.assertEquals(expMessage, actMessage);
			break;
		case "empty_quantity":
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
			Assert.assertTrue(
					driver.findElement(By.xpath("//em[normalize-space()=\"Field 'Quantity' cannot be empty.\"]"))
							.isDisplayed());
			break;
		case "invalid_quantity":
			Assert.assertTrue(
					driver.findElement(By.xpath("//span[normalize-space()='Quantity must be greater than zero.']"))
							.isDisplayed());
			break;
		case "empty_name":
			Assert.assertTrue(
					driver.findElement(By.xpath("//span[normalize-space()=\"Field 'Customer name' cannot be empty.\"]"))
							.isDisplayed());
			break;
		case "empty_street":
			Assert.assertTrue(
					driver.findElement(By.xpath("//span[normalize-space()=\"Field 'Street' cannot be empty.\"]"))
							.isDisplayed());
			break;
		case "empty_city":
			Assert.assertTrue(
					driver.findElement(By.xpath("//span[normalize-space()=\"Field 'City' cannot be empty.\"]"))
							.isDisplayed());
			break;
		case "empty_zip":
			Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Field 'Zip' cannot be empty.\"]"))
					.isDisplayed());
			break;
		case "invalid_zip":
			Assert.assertTrue(
					driver.findElement(By.xpath("//span[normalize-space()='Invalid format. Only digits allowed.']"))
							.isDisplayed());
			break;
		case "empty_card":
			Assert.assertTrue(
					driver.findElement(By.xpath("//span[normalize-space()='Select a card type.']")).isDisplayed());
			break;
		case "empty_cardnr":
			Assert.assertTrue(
					driver.findElement(By.xpath("//span[normalize-space()=\"Field 'Card Nr' cannot be empty.\"]"))
							.isDisplayed());
			break;
		case "invalid_cardnr":
			Assert.assertTrue(driver.findElement(By.xpath(
					"//span[normalize-space()='Invalid format. Only digits allowed.'] [@id=\"ctl00_MainContent_fmwOrder_RegularExpressionValidator2\"]"))
					.isDisplayed());
			break;
		case "empty_expdate":
			Assert.assertTrue(
					driver.findElement(By.xpath("//span[normalize-space()=\"Field 'Expire date' cannot be empty.\"]"))
							.isDisplayed());
			break;
		case "invalid_expdate":
			Assert.assertTrue(driver
					.findElement(By.xpath("//span[normalize-space()=\"Invalid format. Required format is mm/yy.\"]"))
					.isDisplayed());
			break;

		}
		Thread.sleep(2000);
	}
	
	@AfterAll
	public static void afterAll() {
	   driver.close();
	}

}
