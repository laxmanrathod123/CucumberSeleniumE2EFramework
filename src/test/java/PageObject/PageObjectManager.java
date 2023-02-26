package PageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public OffersPage offersPage;
	WebDriver driver;
	public CheckOutPage checkOutPage;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;

	}
	
	
	public LandingPage getLandingPage() {

		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public OffersPage OfferPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckOutPage getCheckOutPage() {
		checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}

}
