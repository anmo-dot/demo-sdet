package com.hdfcbank;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Alert_Example {
	@Test
	public void f() {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//a[@class='btn btn-primary login-btn']")).click();
		String expAlertMes = "Customer ID cannot be left blank.";
		
		String actAlertMes = driver.switchTo().alert().getText();
		Assert.assertEquals(expAlertMes, actAlertMes);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
}
