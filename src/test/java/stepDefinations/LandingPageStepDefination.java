package stepDefinations;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageStepDefination {
	WebDriver driver;
	public String productName;
	public String offerPagePname;
	
	@Given("User is in GreenCart Landing page")
	public void user_is_in_green_cart_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
	    driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    driver.manage().window().maximize();
	    String title = driver.getTitle();
	    Assert.assertEquals(title, "GreenKart - veg and fruits kart");
	}
	@When("User searched shortname {string} and extracted actual name of product.")
	public void user_searched_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    productName = driver.findElement(By.cssSelector("h4.product-name")).getText().split(" ")[0];
	    System.out.println(productName + " is the Product name");
	    Assert.assertEquals(productName, "Tomato");
	    
	}
	@Then("User search the {string} shortname in Ofers page and check if product exists.")
	public void user_search_the_same_shortname_in_ofers_page_and_check_if_product_exists(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText("Top Deals")).click();
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    String parentId = i1.next();
	    String childId = i1.next();
	    
	    driver.switchTo().window(childId);
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    offerPagePname = driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
	    
	    
	}
	
	@Then("validate Product name in offers page.")
	public void validate_Product_name_in_offers_page() {
		Assert.assertEquals(productName, offerPagePname);
		driver.quit();
	}
}
