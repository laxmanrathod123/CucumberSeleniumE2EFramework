package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObject.LandingPage;
import Utils.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	public String LandingPageProductName;
	public String OfferPageProductName;
	public TestContextSetUp testContextSetUp;
	LandingPage LandingPage;

	public LandingPageStepDefinitions(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.LandingPage= testContextSetUp.pageObjectManager.getLandingPage();
	}

	
	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		//WebDriverManager.chromedriver().setup();
		//testContextSetUp.driver = new ChromeDriver();
		//testContextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//testContextSetUp.driver.manage().window().maximize();
		//testContextSetUp.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Assert.assertTrue(LandingPage.getTittleLandingPage().contains("GreenKart"));

	}

	@When("^User search with shortname (.+) and extracted Actual name of Product$")
	public void user_search_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
	
		LandingPage.searchItem(shortName);
		//testContextSetUp.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(3000);
		testContextSetUp.LandingPageProductName = LandingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetUp.LandingPageProductName +" " + "ProductName is extracted from the home Page");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity) throws InterruptedException {
		LandingPage.IncrementQuantity(Integer.parseInt(quantity));
		Thread.sleep(2000);
		LandingPage.addToCart();
	}

}
