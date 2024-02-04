package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;
import io.cucumber.java.en.And;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;

public class OffersPageStepDefinition {
	public String offersPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;
	
	public OffersPageStepDefinition (TestContextSetup testcontextsetup){
		this.testContextSetup =  testcontextsetup;
		 this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	

	@Then("user search for same shortname {string} on offers page")
	public void user_search_for_same_short_name_on_offers_page(String shortname) throws InterruptedException {

		switchToOffersPage();
		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		offersPage.searchItem(shortname);
		Thread.sleep(2000);
		offersPageProductName = offersPage.getProductName();	}
	
public void switchToOffersPage() {
	
	
//	pageObjectManager = new PageObjectManager(testcontextsetup.driver);
	landingPage.selectTopDealsPage();
	
//		testcontextsetup.driver.findElement(By.linkText("Top Deals")).click();
	   Set<String> s1 = testContextSetup.driver.getWindowHandles();
	   Iterator <String> i1 = s1.iterator();
	   String parentWindow = i1.next();
	   String childWindow = i1.next();
	   testContextSetup.driver.switchTo().window(childWindow);
//	   testcontextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
//	   offersPageProductName = testcontextsetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}
	
	@And("Validate the product name on Offer page matches with that on Landing page")
	public void validate_the_product_name_on_offer_page_matches_with_that_on_landing_page() {
	  Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
}}