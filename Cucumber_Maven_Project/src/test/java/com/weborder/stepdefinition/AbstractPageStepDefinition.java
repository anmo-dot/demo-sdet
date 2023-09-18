package com.weborder.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.AfterAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractPageStepDefinition {
	protected static WebDriver driver;

	protected static WebDriver getDriver() {
		if (driver == null)
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	

}
