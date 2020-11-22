package midtrans_automation_Action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.utilities;
import midtrans_automation_pageObject.MidtransPage;
import midtrans_automation_pageObject.PurchasePage;


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
	private final static String OrderSummary = "Order Summary";
    public static final String CREDITANDDEBIT = "Credit/Debit Card";
    public static final String GOPAY = "Go pay";
	
    
    /**
     * Context: This method verifies BuyNow button
     * and verifies if tapping on BuyNow navigates back to Checkout screen.
     *
     * @author Mehul
     */
	public static void clickByNowButton() {
		Assert.assertTrue(isElementPresent(MidtransPage.buyNow));
		try {
            elementToBeClickable(MidtransPage.buyNow);
            LOG.info("Element for click -> " + MidtransPage.buyNow.toString());
            highLightElement(MidtransPage.buyNow);
            waitForExpectedElement(MidtransPage.buyNow).click();
            LOG.info("Element clicked -> " + MidtransPage.buyNow.toString());
        } catch (Exception exception) {
            Assert.fail();
        }
	}
	
    /**
     * Context: This method verifies Shoping Card screen
     *
     * @author Mehul
     */
	public static void verifyShoppingCardScreen() {
		Assert.assertTrue(isElementPresent(PurchasePage.shopingCardLayover));
		Assert.assertTrue(isElementPresent(PurchasePage.shopingCardHeading));
		LOG.info("Element Shoping card displayed -> " + PurchasePage.shopingCardHeading.toString());
		Assert.assertTrue("Verify Card item count should be number",
				MatchTextwithRegex(CardItemCount, getText(PurchasePage.cardItemCount)));
	}
	
    /**
     * Context: This method verifies Shoping Card content
     *
     * @author Mehul
     */
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
	}
	
    /**
     * Context: This method Click on CheckOut button for in Card product
     *
     * @author Mehul
     */
	public static void clickCheckOut() {
		try {
            elementToBeClickable(PurchasePage.checkOutBtn);
            LOG.info("Checkout for click -> " + PurchasePage.checkOutBtn.toString());
            highLightElement(PurchasePage.checkOutBtn);
            waitForExpectedElement(PurchasePage.checkOutBtn).click();
            LOG.info("Checkout button clicked -> " + PurchasePage.checkOutBtn.toString());
        } catch (Exception exception) {
            Assert.fail();
        }
	}
	
    /**
     * Context: This method Verify the Order Summary screen
     *
     * @author Mehul
     */
	public static void verifyOrderSummaryScreen() {
		frameToBeAvailableAndSwitchToIt(PurchasePage.orderSummaryFrame);
		Assert.assertTrue(isElementPresent(PurchasePage.orderSummaryHeading));
		Assert.assertEquals(OrderSummary, getText(PurchasePage.orderSummaryHeading));
		Assert.assertEquals(MidtransAction.productAmount, getText(PurchasePage.amountOrderSummary));
		Assert.assertTrue(isElementPresent(PurchasePage.continueBtn));
		LOG.info("Verified Order Summary content displayed");
	}
	
    /**
     * Context: This method Click on Continue button in Order Summary screen
     *
     * @author Mehul
     */
	public static void clickContinueButton() {
		try {
            elementToBeClickable(PurchasePage.continueBtn);
            LOG.info("Continue for click -> " + PurchasePage.continueBtn.toString());
            highLightElement(PurchasePage.continueBtn);
            clickOnElementWithJSExecutor(PurchasePage.continueBtn);
            LOG.info("Continue button clicked");
        } catch (Exception exception) {
        	LOG.info("Failed to Click on Continue element " + exception.getMessage());
            Assert.fail();
        }
	}
	
    /**
     * Context: This method Verify the Payment Method Screen
     *
     * @author Mehul
     */
	public static void verifyPaymentModeScreen() {
		Assert.assertTrue(isElementPresent(PurchasePage.selectPaymentHeading));
		Assert.assertTrue(isElementPresent(PurchasePage.backChevron));
		Assert.assertTrue(isElementPresent(PurchasePage.creditDebitCard));
		LOG.info("Verified Payment Modes are displayed");
	}
	
    /**
     * Context: This method Click on Payment method based on the user requirement
     * I have added switch case to add more payment method option to make dynamic
     * 
     *  @param PaymentMode to check Payment type
     * @author Mehul
     */
	public static void clickOnPaymentMode(String PaymentMode) {
		switch (PaymentMode) {
        case CREDITANDDEBIT:
        	waitForExpectedElement(PurchasePage.creditDebitCard).click();
            break;
        case GOPAY:
        	waitForExpectedElement(PurchasePage.goPay).click();
            break;
        default:
            Assert.fail();
		}
	}
	
    /**
     * Context: This method Verify the Credit Debit card Screen
     *
     * @author Mehul
     */
	public static void verifyCreditDebitCardScreen() {
		Assert.assertTrue(isElementPresent(PurchasePage.creditDebitCard));
		Assert.assertTrue(isElementPresent(PurchasePage.backChevron));
		Assert.assertTrue(isElementPresent(PurchasePage.cardNumber));
		Assert.assertTrue(isElementPresent(PurchasePage.expiryDate));
		Assert.assertTrue(isElementPresent(PurchasePage.cVV));
		Assert.assertTrue(isElementPresent(PurchasePage.payNow));
		LOG.info("Verified Debitcard screen displayed");
	}
	
    /**
     * Context: This method enter the Credit/Debit card details
     *
     * @param CardNumber to enter CardNumber
     * @param ExpiryDate to enter Expiry Date
     * @param CVVNumber to enter CVV
     * @author Mehul
     */
    public static void enterCardDetails(String CardNumber, String ExpiryDate, String CVVNumber) {
        clearEnterText(PurchasePage.cardNumber, CardNumber);
        clearEnterText(PurchasePage.expiryDate, ExpiryDate);
        clearEnterText(PurchasePage.cVV, CVVNumber);
        LOG.info("Enter Card details Successfully");
    }

    /**
     * Context: This method Click on PayNow button for Credit/Debit card screen Screen
     *
     * @author Mehul
     */
	public static void clickOnPayNow() {
		try {
            elementToBeClickable(PurchasePage.payNow);
            LOG.info("PayNow for click -> " + PurchasePage.payNow.toString());
            highLightElement(PurchasePage.payNow);
            clickOnElementWithJSExecutor(PurchasePage.payNow);
            waitForExpectedElement(PurchasePage.creditDebitCardHeading);
        } catch (Exception exception) {
            LOG.info("PayNow button is not able to click");
            Assert.fail();
        }
	}
	
    /**
     * Context: This method enter the OTP details
     *
     * @param bankOTP to enter OTP
     * @author Mehul
     */
    public static void enterOtp(String bankOTP) {
    	switchToFrame(0);
    	//frameToBeAvailableAndSwitchToIt(PurchasePage.OTPFrame);
    	waitForExpectedElement(PurchasePage.passwordOtp);
        clearEnterText(PurchasePage.passwordOtp, bankOTP);
        clickOnElementWithJSExecutor(PurchasePage.submitOtp);
        LOG.info("Enter OTP Successfully");
    }
    
    /**
     * Context: This method Verify the Payment Status details
     *
     * @param transactionStatus to verify status Fail or Successfull
     * @author Mehul
     */
    public static void verifyPaymentstatus(String transactionStatus) {
    	if(transactionStatus.contains("Thank you")) {
    		Assert.assertEquals("Verify Transaction Successfull status is displayed", transactionStatus, getText(MidtransPage.transactionSuccessStatus));
            LOG.info("Successfully got the transactionn status");
    	}
    	else {
    		frameToBeAvailableAndSwitchToIt(PurchasePage.orderSummaryFrame);
    		Assert.assertEquals("Verify Transaction failed status is displayed", transactionStatus, getText(PurchasePage.transactionStatusFail));
            LOG.info("Transaction got fail status");
    	}
    }
}
