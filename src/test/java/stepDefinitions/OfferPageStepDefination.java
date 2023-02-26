package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObject.LandingPage;
import PageObject.OffersPage;
import PageObject.PageObjectManager;
import Utils.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OfferPageStepDefination {
	public WebDriver driver;
	public String LandingPageProductName;
	public String OfferPageProductName;
	TestContextSetUp testContextSetUp;
	public PageObjectManager pageObjectManager;
	

	public OfferPageStepDefination(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	@Then("^User go and search for the (.+) shorname in Offer page$")
	public void user_go_and_search_for_the_shorname_in_offer_page(String shortName) throws InterruptedException {
		switchToOfferPage();
		
		OffersPage OffersPage = testContextSetUp.pageObjectManager.OfferPage();
		OffersPage.searchItem(shortName);
		// input[@type='search']
		//testContextSetUp.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		OfferPageProductName = OffersPage.getProductName();
	}
	
	public void switchToOfferPage() {
		//testContextSetUp.driver.findElement(By.linkText("Top Deals")).click();
		//pageObjectManager = new PageObjectManager(testContextSetUp.driver);
		LandingPage LandingPage =testContextSetUp.pageObjectManager.getLandingPage();

		LandingPage.selectTopDealsPage();
		testContextSetUp.genericUtils.switchWindowToChild();
	}

	@And("Validate the product name in offer page matches with Landing Page")
	public void validate_the_product_name_in_offer_page_matches_with_landing_page() {
		Assert.assertEquals( OfferPageProductName,testContextSetUp.LandingPageProductName);

	}
 
}
