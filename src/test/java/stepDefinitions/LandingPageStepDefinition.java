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

public class LandingPageStepDefinition {
	
	// define the objects here as global inside the class
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	// Define objects in the constructor as this block is going to be executed first
	//this means it will be assigned to global variable of the current class
	public LandingPageStepDefinition (TestContextSetup testcontextsetup){
		this.testContextSetup =  testcontextsetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();

	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rhythm\\OneDrive\\Documents\\chromedriver_win32");
		testContextSetup.driver = new ChromeDriver();	
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise");
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	@When("^user search with shortname (.+) and extract the actual name of the product$")
	public void user_search_with_short_name_and_extract_the_actual_name_of_the_product(String shortname) throws InterruptedException {
//		LandingPage landingpage = new LandingPage(testcontextsetup.driver);
		landingPage.searchItem(shortname);
		Thread.sleep(2000);
//		landingPageProductName = testcontextsetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();

		System.out.println(landingPageProductName + "is extracted from the Home Page");
		
	}}
