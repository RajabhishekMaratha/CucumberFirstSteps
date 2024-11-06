package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");
	
	public void searchItem(String shortName) {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	}
	
	public String getProductName(String name) {
		return driver.findElement(productName).getText().split(" ")[0];
	}
	
	public void selectTopDeals() {
		driver.findElement(topDeals).click();
	}
	
	
}
