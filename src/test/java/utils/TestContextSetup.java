package utils;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String offerPageProductName;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	
	public TestContextSetup() {
		pageObjectManager = new PageObjectManager(driver);
		
	}

}
