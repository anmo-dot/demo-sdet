package com.spreecom.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spreecom.home.Spreecom_MenPage;
import com.spreecom.home.Spreecom_SportswearPage;
import com.spreecom.home.Spreecom_WomenPage;

public class Spreecom_BasePage {
	private WebDriver driver;
	

	@FindBy(xpath = "//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle'][normalize-space()='Women']")
	WebElement linkWomen;
	
	@FindBy(xpath = "//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle'][normalize-space()='Men']")
	WebElement linkMen;
	
	@FindBy(xpath = "//a[@class='nav-link main-nav-bar-item main-nav-bar-category-button dropdown-toggle'][normalize-space()='Sportswear']")
	WebElement linkSportswear;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public Spreecom_BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Spreecom_WomenPage goToWomenPage() {
		linkWomen.click();
		return new Spreecom_WomenPage(driver);
	}
	
	public Spreecom_MenPage goToMenPage() {
		linkMen.click();
		return new Spreecom_MenPage(driver);
	}
	
	public Spreecom_SportswearPage goToSportswearPage() {
		linkSportswear.click();
		return new Spreecom_SportswearPage(driver);
	}
}
