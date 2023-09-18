package com.weborder.stepdefinition;

import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.utilities.Excel_Parsing;

import com.weborder.pages.CreateOrderPage;

import io.cucumber.java.en.Then;


public class CreateOrderPageStepDefinition extends AbstractPageStepDefinition {

	static WebDriver driver = getDriver();
	CreateOrderPage createOrderPage = new CreateOrderPage(driver);

	@Then("User enters order data from {string} and {int} into Create Order page")
	public void user_enters_order_data_from_and_into_create_order_page(String sheetName, Integer rowNumber) throws EncryptedDocumentException, IllegalFormatException, IOException {
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
	    createOrderPage.createOrder(quantity, name, street, city, zipcode, card, cardNr, expDate);
	}
	@Then("User should should get proper expect result from {string} and {int} after click Process button")
	public void user_should_should_get_proper_expect_result_from_and_after_click_process_button(String sheetName, Integer rowNumber) throws EncryptedDocumentException, IllegalFormatException, IOException, InterruptedException {
		  Excel_Parsing excel = new Excel_Parsing();
		    Object[][] data = excel.getExcelData("OrderTable.xlsx", sheetName);
		    String expResult = data[rowNumber][8].toString();
		    createOrderPage.assertResultAfterClickProcess(expResult);
	}
	
}
