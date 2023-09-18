package com.orangeHRM.home;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_PIM {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
	WebElement pimObject;

	@FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
	WebElement addEmployee;

	@FindBy(name = "firstName")
	WebElement Addfirstname;

	@FindBy(name = "lastName")
	WebElement AddlastName;

	@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	WebElement checkLogincheckBox;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSaveLoginDetails;

	@FindBy(xpath = "//input[@fdprocessedid='qht1se']")
	WebElement userName;

	@FindBy(xpath = "//input[@fdprocessedid='5dgbb9']")
	WebElement userPassword;

	@FindBy(xpath = "//input[@fdprocessedid='o48zj7']")
	WebElement rePassword;

	@FindBy(id = "dialogDeleteBtn")
	WebElement btnDialogDelete;

	@FindBy(id = "btnDelete")
	WebElement btnDelete;

	public OrangeHRM_PIM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private void addEmployeeOption(String firstName, String lastName, String userName, String userPass, String rePass)
			throws InterruptedException {

		Addfirstname.sendKeys(firstName);
		Thread.sleep(1000);
		AddlastName.sendKeys(lastName);
		Thread.sleep(1000);
		checkLogincheckBox.click();
		Thread.sleep(1000);
		this.userName.sendKeys(userName);
		Thread.sleep(1000);
		this.userPassword.sendKeys(userPass);
		this.rePassword.sendKeys(rePass);
		Thread.sleep(1000);
		btnSaveLoginDetails.click();
		Thread.sleep(2000);
	}

	private void addEmpHead() throws InterruptedException {

		Thread.sleep(1000);
		pimObject.click();
		Thread.sleep(1000);
		addEmployee.click();
		Thread.sleep(1000);

	}

	public void addEmployees(String strFirstName, String strLastName, String strUserName, String strPassword)
			throws InterruptedException {
		addEmpHead();
		Thread.sleep(1000);
		addEmployeeOption(strFirstName, strLastName, strUserName, strPassword, strPassword);
	}

	private void deleteEmpOption(String _empName) throws InterruptedException {
		Thread.sleep(1000);
		pimObject.click();
		Thread.sleep(1000);
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td/a"));
			int rows_lenght = rows.size()/3;
			System.out.println(rows_lenght);
		String beforeXpath = "//*[@id='resultTable']/tbody/tr[";
		String afterXpath = "]/td[4]";
		for (int i = 1; i < rows_lenght; i++) {
			String searchPath = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			if (searchPath.contains(_empName)) {
				if (!driver.findElement(By.xpath(beforeXpath + i + "]/td[1]/input")).isSelected()) {
					driver.findElement(By.xpath(beforeXpath + i + "]/td[1]/input")).click();
				}
			}
		}
		Thread.sleep(1000);
		btnDelete.click();
		Thread.sleep(1000);
		btnDialogDelete.click();
		Thread.sleep(1000);

	}

	public void deleteEmployees(String strLastName) throws InterruptedException {
		deleteEmpOption(strLastName);
		Thread.sleep(1000);
	}

}
