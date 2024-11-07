package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefination {
TestContextSetup testContextSetup;
CheckoutPage checkoutPage;

public CheckoutPageStepDefination(TestContextSetup testContextSetup) {
	this.testContextSetup = testContextSetup;
	checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
}

@Then("Add {int} more of the item")
public void add_three_more_of_the_item(int quantity) {
    // Write code here that turns the phrase above into concrete actions
	
	checkoutPage.incrementQuantity(quantity);
	
	checkoutPage.addToCart();
	checkoutPage.viewCart();
	checkoutPage.proceedToCheckout();
}
@Then("^User opens the checkout page and verifies the product (.+)$")
public void user_opens_the_checkout_page_and_verifies_the_product(String shortName) {
    // Write code here that turns the phrase above into concrete actions
	
	testContextSetup.checkoutPagePname = checkoutPage.getProductName(shortName);
	System.out.println(testContextSetup.checkoutPagePname +" is the Checkout Page product Name");
	Assert.assertEquals(testContextSetup.landingPagePname, testContextSetup.checkoutPagePname);
    
}
@Then("after validation user checks out")
public void after_validation_user_checks_out() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(3000);
	
	Assert.assertEquals(checkoutPage.verifyPromo(), true);
	checkoutPage.checkout();
    
}
}
