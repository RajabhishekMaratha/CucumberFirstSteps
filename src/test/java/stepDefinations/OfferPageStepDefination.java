package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefination {
	WebDriver driver;
	
	public String offerPagePname;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		
	}
	@Then("^User search the (.+) shortname in Ofers page and check if product exists.$")
	public void user_search_the_same_shortname_in_ofers_page_and_check_if_product_exists(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.OffersPage();
		offersPage.searchItem(shortName);
	    //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    offerPagePname = offersPage.getProductName(shortName);
	}
	public void switchToOffersPage() {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
		testContextSetup.genericUtils.switchWindowToChild();
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	    
	}
	@Then("validate Product name in offers page.")
	public void validate_Product_name_in_offers_page() {
		Assert.assertEquals(testContextSetup.landingPagePname, offerPagePname);
		//testContextSetup.driver.quit();
	}
}
