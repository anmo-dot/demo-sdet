package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebOrder_Login_DataDrivenTest extends WebOrder_TestData {
	WebDriver driver;

	@Test(dataProvider = "LoginExcelData")
	public void login_to_app(String uname, String pass) {
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys(pass);
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$login_button']")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
		driver.findElement(By.xpath("//h2[normalize-space()='List of All Orders']")).isDisplayed();
		driver.findElement(By.linkText("Logout")).click();

	}

	@BeforeTest
	public void pre_condition(ITestContext context) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
		context.setAttribute("WebDriver", driver);
	}

	@AfterTest
	public void post_condition() {

		driver.close();
	}
}
