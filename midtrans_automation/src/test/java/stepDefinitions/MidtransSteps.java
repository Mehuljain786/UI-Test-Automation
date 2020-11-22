package stepDefinitions;

import io.cucumber.java.en.*;
import midtrans_automation_Action.MidtransAction;

public class MidtransSteps{
    
	@Given("User will Lauch midtrans site in browser")
	public void user_will_Lauch_midtrans_site_in_browser() throws Throwable{
		MidtransAction.navigatesTomidtrans();	
	}


	@And("Unauth User verify the product and page content")
	public void unauth_User_verify_the_product_and_page_content() {
		MidtransAction.verifyExpectedcontentDisplayed();
	}
}
