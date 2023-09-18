package com.WebOrder;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Pagination_SearchName {

	WebDriver driver;
	String tgtFName = "Sakura";
	String expSalary = "$139,575";

	// searching for name and check salary
	public boolean checkSalary(List<WebElement> fNameElements) {

		for (WebElement fName : fNameElements) {
			String currentFName = fName.getText();
			if (currentFName.equals(tgtFName)) {
//				WebElement salaryElement = fName.findElement(By.xpath("//following-sibling::td[5]"));
				WebElement salaryElement = driver.findElement(By.xpath("//table[@id='example']/tbody/tr/td[1] [text()='"
						+ currentFName + "']/following-sibling::td[5]"));
				Assert.assertEquals(salaryElement.getText(), expSalary);
				return true;
			}
		}
		return false;
	}

	@BeforeTest
	public void pre_condition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void post_condition() {
		driver.close();
	}

	@Test
	public void searchName() throws InterruptedException {
		boolean found = false;
		driver.get("https://datatables.net/examples/data_sources/server_side");
		Thread.sleep(2000);
		List<WebElement> fNameElements = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
		found = checkSalary(fNameElements);
		String nextButton = driver.findElement(By.id("example_next")).getAttribute("class");
		while (!found && !nextButton.contains("disabled")) {
			driver.findElement(By.id("example_next")).click();
			Thread.sleep(2000);
			fNameElements = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
			found = checkSalary(fNameElements);
		}
	}
}
