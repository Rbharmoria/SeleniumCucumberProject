package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public OffersPage offersPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		 landingPage = new LandingPage(driver);
		 return landingPage;
	}
	
	public OffersPage getOffersPagege() {	
		offersPage = new OffersPage(driver);
		 return offersPage;
	}
	
	
	
	
}
