package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Pagination_Sort {

	WebDriver driver;

	@BeforeTest
	public void pre_condition(ITestContext context) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
	}

	@AfterTest
	public void post_condition() {			
		driver.close();
	}

	@Test
	public void verifySort() throws InterruptedException {
		driver.get("https://datatables.net/examples/data_sources/server_side");
		Thread.sleep(2000);
		WebElement header = driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]"));
		
		Assert.assertTrue(header.getAttribute("class").contains("asc"));
		WebElement firstRow = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[1]"));
		String firstFName = firstRow.getText();
//		Assert.assertEquals(firstFName, "Airi");
		Assert.assertEquals(firstFName, "Ana");
		
		header.click();
		Thread.sleep(2000);
		Assert.assertTrue(header.getAttribute("class").contains("desc"));
		firstRow = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[1]"));
		firstFName = firstRow.getText();
		Assert.assertEquals(firstFName, "Zorita");
		
		header.click();
		Thread.sleep(2000);
		Assert.assertTrue(header.getAttribute("class").contains("asc"));
		firstRow = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[1]/td[1]"));
		firstFName = firstRow.getText();
		Assert.assertEquals(firstFName, "Airi");
	}
}
