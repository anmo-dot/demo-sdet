package com.WebOrder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebOrder_UpdateOrder_VerifyOrder {
	WebDriver driver;
	String expUsername;
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
		expUsername = "Dixit" + randomInt;
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
	
	@Test(priority=3)
	public void update_order() throws InterruptedException {
		driver.findElement(By.xpath("//td[text()='" + expUsername +"']//following-sibling::td/input")).click();
		driver.findElement(By.xpath("//h2[normalize-space()='Edit Order']")).isDisplayed();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("TX");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
		String actState = driver.findElement(By.xpath("//td[text()='" + expUsername +"']//following-sibling::td[text()='TX']")).getText();
//		String expState = "TX";
		String expState = "CA";
		Assert.assertEquals(actState, expState);
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
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
}