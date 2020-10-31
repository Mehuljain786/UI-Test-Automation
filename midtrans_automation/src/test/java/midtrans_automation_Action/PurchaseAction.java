package midtrans_automation_Action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.utilities;
import midtrans_automation_pageObject.MidtransPage;
import midtrans_automation_pageObject.PurchasePage;
import stepDefinitions.Hooks;

public class PurchaseAction extends utilities{
	private static final Logger LOG = LoggerFactory.getLogger(PurchaseAction.class);
	private final static String CardItemCount = "^([1-9]{0,3})";
	private final static String CustomerDetails = "Customer Details";
	private final static String Name = "Name";
	private final static String Email = "Email";
	private final static String Mobile = "Phone no";
	private final static String City = "City";
	private final static String Address = "Address";
	private final static String PostalCode = "Postal Code";
	
	public static void clickByNowButton() {
		Assert.assertTrue(isElementPresent(MidtransPage.buyNow));
		try {
            elementToBeClickable(MidtransPage.buyNow);
            LOG.info("Element for click -> " + MidtransPage.buyNow.toString());
            highLightElement(MidtransPage.buyNow);
            waitForExpectedElement(MidtransPage.buyNow).click();
            LOG.info("Element clicked -> " + MidtransPage.buyNow.toString());
        } catch (Exception exception) {
            //Hooks.stepRecordAndFocusedScreenshot("Failed to click BuyNow element " + exception.getMessage());
            Assert.fail();
        }
	}
	
	public static void verifyShoppingCardScreen() {
		Assert.assertTrue(isElementPresent(PurchasePage.shopingCardLayover));
		Assert.assertTrue(isElementPresent(PurchasePage.shopingCardHeading));
		LOG.info("Element Shoping card displayed -> " + PurchasePage.shopingCardHeading.toString());
		Assert.assertTrue("Verify Card item count should be number",
				MatchTextwithRegex(CardItemCount, getText(PurchasePage.cardItemCount)));
		//Hooks.stepRecordAndFocusedScreenshot("Verified Shopping card page title and card item count");
	}
	
	public static void verifyShoppingCardContent() {
		Assert.assertTrue(isElementPresent(PurchasePage.productName));
		Assert.assertEquals(MidtransAction.productAmount, getText(PurchasePage.totalAmount));
		Assert.assertEquals(CustomerDetails, getText(PurchasePage.customerDetailsHeading));
		Assert.assertEquals(Name, getText(PurchasePage.nameOfCustomer));
		Assert.assertEquals(Email, getText(PurchasePage.emailOfCustomer));
		Assert.assertEquals(Mobile, getText(PurchasePage.mobileOfCustomer));
		Assert.assertEquals(City, getText(PurchasePage.cityOfCustomer));
		Assert.assertEquals(Address, getText(PurchasePage.addressOfCustomer));
		Assert.assertEquals(PostalCode, getText(PurchasePage.postalCode));
		Assert.assertTrue(isElementPresent(PurchasePage.checkOutBtn));
		Assert.assertTrue(isElementPresent(PurchasePage.cancelBtn));
		LOG.info("Verified Customer Details displayed");
		//Hooks.stepRecordAndFocusedScreenshot("Verified Customer Details displayed");
	}
	
	public static void clickCheckOut() {
		try {
            elementToBeClickable(PurchasePage.checkOutBtn);
            LOG.info("Checkout for click -> " + PurchasePage.checkOutBtn.toString());
            highLightElement(PurchasePage.checkOutBtn);
            waitForExpectedElement(PurchasePage.checkOutBtn).click();
            LOG.info("Checkout button clicked -> " + PurchasePage.checkOutBtn.toString());
        } catch (Exception exception) {
            //Hooks.stepRecordAndFocusedScreenshot("Failed to Click Checkout element " + exception.getMessage());
            Assert.fail();
        }
	}

}
