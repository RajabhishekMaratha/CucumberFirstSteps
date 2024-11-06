package stepDefinations;



import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefination {
	WebDriver driver;
	public String landingPagePname;
	public String offerPagePname;
	TestContextSetup testContextSetup;
	
	public LandingPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		
	}
	@Given("User is in GreenCart Landing page")
	public void user_is_in_green_cart_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
//	    String title = testContextSetup.driver.getTitle();
//	    Assert.assertEquals(title, "GreenKart - veg and fruits kart");
	}
	@When("User searched shortname {string} and extracted actual name of product.")
	public void user_searched_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    testContextSetup.landingPagePname = landingPage.getProductName(shortName);
	    System.out.println(testContextSetup.landingPagePname + " is the Product name");
	    Assert.assertEquals(testContextSetup.landingPagePname, "Tomato");
	    
	}
	
}
