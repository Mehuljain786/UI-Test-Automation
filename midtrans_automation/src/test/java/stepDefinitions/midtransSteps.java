package stepDefinitions;

import core.Props;
import io.cucumber.java.en.*;
import midtrans_automation_Action.midtransAction;

public class midtransSteps{
	@Given("User will Lauch midtrans site in browser")
	public void user_will_Lauch_midtrans_site_in_browser() throws Throwable{
		midtransAction.navigatesTomidtrans();	
	}


	@And("Unauth User verify the product and page content")
	public void unauth_User_verify_the_product_and_page_content() {
	    
	}
}
