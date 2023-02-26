package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;

	}
 By cartBag= By.cssSelector("img[alt='Cart']");
 By CheckOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
 By PromoButton= By.cssSelector(".promoBtn");
 //By PromoButton= By.xpath("//button[@class='promoBtn']");
 By PlaceOrderButton = By.xpath("//button[text()='Place Order']");
	
 public void CheckOutItems() {
	 driver.findElement(cartBag).click();
	 driver.findElement(CheckOutButton).click();
 }
 
 public boolean verifyPromobtn() {
	return  driver.findElement(PromoButton).isDisplayed();
 }
 
 public boolean verifyPlaceOderbtn() {
		return  driver.findElement(PlaceOrderButton).isDisplayed();
	 }
	



}
