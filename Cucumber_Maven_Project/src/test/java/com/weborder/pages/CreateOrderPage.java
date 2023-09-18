package com.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrderPage extends BasePage {
	private WebDriver driver;

	@FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
	WebElement txtQuantity;

	@FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
	WebElement txtName;

	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
	WebElement txtStreet;

	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
	WebElement txtCity;

	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
	WebElement txtZipcode;

	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
	WebElement txtCardNr;

	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
	WebElement txtExpDate;

	@FindBy(linkText = "Process")
	WebElement processBtn;

	@FindBy(xpath = "//strong[normalize-space()='New order has been successfully added.']")
	WebElement successMessage;

	@FindBy(xpath = "//em[normalize-space()=\"Field 'Quantity' cannot be empty.\"]")
	WebElement emptyQuantityErr;

	@FindBy(xpath = "//span[normalize-space()='Quantity must be greater than zero.']")
	WebElement invalidQuantityErr;

	@FindBy(xpath = "//span[normalize-space()=\"Field 'Customer name' cannot be empty.\"]")
	WebElement emptyNameErr;

	@FindBy(xpath = "//span[normalize-space()=\"Field 'Street' cannot be empty.\"]")
	WebElement emptyStreetErr;

	@FindBy(xpath = "//span[normalize-space()=\"Field 'City' cannot be empty.\"]")
	WebElement emptyCityErr;

	@FindBy(xpath = "//span[normalize-space()=\"Field 'Zip' cannot be empty.\"]")
	WebElement emptyZipErr;

	@FindBy(xpath = "//span[normalize-space()='Invalid format. Only digits allowed.']")
	WebElement invalidZipErr;

	@FindBy(xpath = "//span[normalize-space()='Select a card type.']")
	WebElement emptyCardErr;

	@FindBy(xpath = "//span[normalize-space()=\"Field 'Card Nr' cannot be empty.\"]")
	WebElement emptyCardNrErr;

	@FindBy(xpath = "//span[normalize-space()='Invalid format. Only digits allowed.'] [@id=\"ctl00_MainContent_fmwOrder_RegularExpressionValidator2\"]")
	WebElement invalidCardNrErr;

	@FindBy(xpath = "//span[normalize-space()=\"Field 'Expire date' cannot be empty.\"]")
	WebElement emptyExpDateErr;

	@FindBy(xpath = "//span[normalize-space()=\"Invalid format. Required format is mm/yy.\"]")
	WebElement invalidExpDateErr;

	public CreateOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createOrder(String quantity, String name, String street, String city, String zipcode, String card,
			String cardNr, String expDate) {
		txtQuantity.sendKeys(quantity);

		txtName.sendKeys(name);
		txtStreet.sendKeys(street);
		txtCity.sendKeys(city);
		txtZipcode.sendKeys(zipcode);
		if (!card.equals("")) {
			driver.findElement(By.xpath("//input[@value='" + card + "']")).click();
		}
		txtCardNr.sendKeys(cardNr);
		txtExpDate.sendKeys(expDate);

	}

	public void assertResultAfterClickProcess(String expResult) throws InterruptedException {
		if (!expResult.equals("empty_quantity"))
			processBtn.click();

		switch (expResult) {
		case "valid":
			String expMessage = successMessage.getText();
			String actMessage = "New order has been successfully added.";
			Assert.assertEquals(expMessage, actMessage);
			break;
		case "empty_quantity":
			txtQuantity.clear();
			Assert.assertTrue(emptyQuantityErr.isDisplayed());
			break;
		case "invalid_quantity":
			Assert.assertTrue(invalidQuantityErr.isDisplayed());
			break;
		case "empty_name":
			Assert.assertTrue(emptyNameErr.isDisplayed());
			break;
		case "empty_street":
			Assert.assertTrue(emptyStreetErr.isDisplayed());
			break;
		case "empty_city":
			Assert.assertTrue(emptyCityErr.isDisplayed());
			break;
		case "empty_zip":
			Assert.assertTrue(emptyZipErr.isDisplayed());
			break;
		case "invalid_zip":
			Assert.assertTrue(invalidZipErr.isDisplayed());
			break;
		case "empty_card":
			Assert.assertTrue(emptyCardErr.isDisplayed());
			break;
		case "empty_cardnr":
			Assert.assertTrue(emptyCardNrErr.isDisplayed());
			break;
		case "invalid_cardnr":
			Assert.assertTrue(invalidCardNrErr.isDisplayed());
			break;
		case "empty_expdate":
			Assert.assertTrue(emptyExpDateErr.isDisplayed());
			break;
		case "invalid_expdate":
			Assert.assertTrue(invalidExpDateErr.isDisplayed());
			break;
		}
		Thread.sleep(2000);
	}
}
