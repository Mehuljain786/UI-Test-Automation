package stepDefinitions;

import io.cucumber.java.en.*;
import midtrans_automation_Action.PurchaseAction;

public class PurchaseSteps {
	
	@When("User clicks on Buy Now button")
	public void user_clicks_on_buy_now_button() {
		PurchaseAction.clickByNowButton();
	}

	@Then("Shopping Cart layover screen has to be displayed")
	public void shopping_cart_layover_screen_has_to_be_displayed() {
	    PurchaseAction.verifyShoppingCardScreen();
	}

	@And("Verify the details on Checkout page")
	public void verify_the_details_on_checkout_page() {
		PurchaseAction.verifyShoppingCardContent();
	}

	@And("Click on CHECKOUT button")
	public void click_on_checkout_button() {
		PurchaseAction.clickCheckOut();
	}

}
