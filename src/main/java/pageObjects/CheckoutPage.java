package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	By productName = By.xpath("//p[@class=\"product-name\"]");
	By increment = By.xpath("//a[@class='increment']");
	By addToCartIcon = By.xpath("//img[@alt='Cart']");
	By addToCartButt = By.cssSelector("div[class='product-action'] button[type='button']");
	By proceedToCheckout = By.cssSelector("div[class='cart-preview active'] button[type='button']");
	By checkout = By.xpath("//button[normalize-space()='Place Order']");
	By promo = By.xpath("//input[@class=\"promoCode\"]");
	
	public String getProductName(String name) {
		return driver.findElement(productName).getText().split(" ")[0];
	}
	public void addItem() {
		driver.findElement(increment).click();
	}
	public void addToCart() {
		driver.findElement(addToCartButt).click();
	}
	
	public void viewCart() {
		driver.findElement(addToCartIcon).click();
	}
	public void proceedToCheckout() {
		driver.findElement(proceedToCheckout).click();
	}
	public void checkout() {
		driver.findElement(checkout).click();
	}
	public boolean verifyPromo() {
		return driver.findElement(promo).isDisplayed();
	}
	
	public void incrementQuantity(int quantity) {
		//int q = Integer.parseInt(quantity);
		for (int i=0; i<quantity-1;i++) {
			addItem();
		}
	}
	
}
	