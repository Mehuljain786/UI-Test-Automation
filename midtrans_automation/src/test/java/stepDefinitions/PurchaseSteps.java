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
	
	@Then("Display Order detail screen")
	public void display_order_detail_screen() {
	    PurchaseAction.verifyOrderSummaryScreen();
	}
	
	@And("Click on Continue Button")
	public void click_on_continue_button() {
		PurchaseAction.clickContinueButton();
	}
	
	@Then("Display Select Payment screen")
	public void display_select_payment_screen() {
	    PurchaseAction.verifyPaymentModeScreen();
	}

	@And("User click on Credit Debit card option")
	public void user_click_on_credit_debit_card_option() {
	    PurchaseAction.clickOnPaymentMode(PurchaseAction.CREDITANDDEBIT);
	}
	
	@Then("Display Credit Debit Card detail screen")
	public void display_credit_debit_card_detail_screen() {
	    PurchaseAction.verifyCreditDebitCardScreen();
	}
	
	@And("User enter \"([^\"]*)\" in card number field \"([^\"]*)\" and \"([^\"]*)\" in CVV field$")
	public void user_enter_credit_debit_card_details(String CardNumber, String ExpiryDate, String CVVNumber) {
	    PurchaseAction.enterCardDetails(CardNumber,ExpiryDate,CVVNumber);
	}
	
	@And("Click on PayNow button")
	public void click_on_paynow_button() {
	    PurchaseAction.clickOnPayNow();
	}
	
	@And("User enter \"([^\"]*)\" in Password field and click submit")
	public void user_enter_bank_otp(String bankOtp) {
	    PurchaseAction.enterOtp(bankOtp);
	}
	
	@Then("Display \"([^\"]*)\" Transaction status")
	public void displayTransactionstatus(String PaymentStatus) {
	    PurchaseAction.verifyPaymentstatus(PaymentStatus);
	}
	
}
