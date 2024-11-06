package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	WebDriver driver;
	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tbody tr td:nth-child(1)");
	
	public void searchItem(String shortName) {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	}
	
	public String getProductName(String name) {
		return driver.findElement(productName).getText().split(" ")[0];
	}
}
