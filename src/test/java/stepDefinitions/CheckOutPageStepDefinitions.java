package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObject.CheckOutPage;
import Utils.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckOutPageStepDefinitions {
	public WebDriver driver;
	public String LandingPageProductName;
	public String OfferPageProductName;
	public TestContextSetUp testContextSetUp;
	public CheckOutPage checkOutPage;
	
	

	public CheckOutPageStepDefinitions(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.checkOutPage=testContextSetUp.pageObjectManager.getCheckOutPage();
	}
	//@Then("User Proceeds to Checkout and Validate the <Name> items in checkout page")
	@Then ("^User Proceeds to Checkout and Validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_name_items_in_checkout_page(String name) throws InterruptedException {
		checkOutPage.CheckOutItems();
		//Thread.sleep(2000);
		
	}

	@And("verify user has ability to eneter promo code and place the order")
	public void verify_user_has_ability_to_eneter_promo_code_and_place_the_order() {

		
		Assert.assertTrue(checkOutPage.verifyPromobtn());
		Assert.assertTrue(checkOutPage.verifyPlaceOderbtn());

	}


}
