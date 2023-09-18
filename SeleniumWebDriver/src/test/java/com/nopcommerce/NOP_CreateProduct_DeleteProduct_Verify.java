package com.nopcommerce;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NOP_CreateProduct_DeleteProduct_Verify {

	WebDriver driver;

	@BeforeTest
	public void pre_condition() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://admin-demo.nopcommerce.com/");
		driver.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
		driver.findElement(By.xpath("//a[@class='nav-link']/p[normalize-space()='Catalog']")).click();
		driver.findElement(By.xpath("//a[@class='nav-link']/p[normalize-space()='Products']")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void post_condition() {
		driver.close();
	}

	
	public String getNumProduct() throws InterruptedException {
		Thread.sleep(2000);
		String productInfos = driver.findElement(By.id("products-grid_info")).getText();
		return productInfos.split(" ")[2];
//		return productInfos;
	}
	@Test(priority=1)
	public void addProduct() throws InterruptedException {
		int numProductBefore = Integer.parseInt(getNumProduct());
		System.out.println(numProductBefore);

		driver.findElement(By.xpath("//i[@class='fas fa-plus-square']")).click();
		driver.findElement(By.id("Name")).sendKeys("Minh_product");
		driver.findElement(By.id("Sku")).sendKeys("Minh_sku");

		
		driver.findElement(By.xpath("//div[@id='product-price-area']/div[2]/span/span/input[1]")).sendKeys("1000");
		driver.findElement(By.xpath("//div[@class='content-header clearfix']/div/button[1]")).click();
		
		int numProductAfter = Integer.parseInt(getNumProduct());
		System.out.println(numProductAfter);
		Assert.assertTrue(numProductAfter > numProductBefore);
	}
	
}
