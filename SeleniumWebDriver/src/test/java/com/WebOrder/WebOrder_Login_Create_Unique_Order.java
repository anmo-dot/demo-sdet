package com.WebOrder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebOrder_Login_Create_Unique_Order {
	WebDriver driver;
	@Test(priority=1)
	public void login_to_app() {
		
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$login_button']")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
		//verify text present or not
		String ActListElementName = driver.findElement(By.xpath("//h2[normalize-space()='List of All Orders']")).getText();
		String ExpListElementName = "List of All Orders";
		Assert.assertEquals(ExpListElementName, ActListElementName);
		//verify title of the page
		String ActTitle = driver.getTitle();
		String ExpTitlte = "Web Orders";
		Assert.assertEquals(ActTitle,ExpTitlte);
		//verify the URL of the page
		String ActUrl = driver.getCurrentUrl();
		String ExpUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx";
		Assert.assertEquals(ActUrl, ExpUrl);
	}

	@Test(priority=2)
	public void createOrder() throws InterruptedException {
		driver.findElement(By.linkText("Order")).click();
		Select product = new Select(driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")));
		product.selectByVisibleText("FamilyAlbum");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("5");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String expUsername = "Dixit" + randomInt;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(expUsername);
		Thread.sleep(5000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("ABC");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Redwood");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("75000");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("12345678");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("12/23");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		String expMessage = driver.findElement(By.xpath("//strong[normalize-space()='New order has been successfully added.']")).getText();
		String actMessage = "New order has been successfully added.";
		Assert.assertEquals(expMessage,actMessage);
		
		//go back to View All Order page and verify that order got created
		driver.findElement(By.linkText("View all orders")).click();
		String actUsername = driver.findElement(By.xpath("//td[text()='" + expUsername +"']")).getText();
		Assert.assertEquals(actUsername, expUsername);	
	}
	@BeforeTest
	public void pre_condition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	}

	@AfterTest
	public void post_condition() {
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
}
