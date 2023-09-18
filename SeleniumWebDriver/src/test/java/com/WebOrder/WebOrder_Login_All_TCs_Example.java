package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebOrder_Login_All_TCs_Example {
	WebDriver driver;
	
	@Test(dataProvider="WebOrder_Login_All_TCs", dataProviderClass=WebOrder_TestData.class)
	public void login_to_app(String uname, String pass, String expResult) {
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).clear();
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys(pass);
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$login_button']")).click();
		if(expResult.equalsIgnoreCase("Logout")) {
			String actMes = driver.findElement(By.linkText("Logout")).getText();
			Assert.assertEquals(actMes, expResult);
			driver.findElement(By.xpath("//h2[normalize-space()='List of All Orders']")).isDisplayed();
			driver.findElement(By.linkText("Logout")).click();
		} else {
			String actErr = driver.findElement(By.id("ctl00_MainContent_status")).getText();
			Assert.assertEquals(actErr, expResult);
		}
	}

	@BeforeTest
	public void pre_condition(ITestContext context) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		context.setAttribute("WebDriver", driver);
	}

	@AfterTest
	public void post_condition() {
		driver.close();
	}
}
