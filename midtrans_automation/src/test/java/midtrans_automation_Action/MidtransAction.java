package midtrans_automation_Action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import core.Props;
import core.utilities;
import midtrans_automation_pageObject.MidtransPage;
import stepDefinitions.Hooks;

public class MidtransAction extends utilities {
	private final static String midtransHeader = "Midtrans Pillow";
	private final static String RegExAmount = "^([1-9]{0,3}|1{4}|20,000)";
	private final static String Amountcurrency = "Rp";
	private final static String midtransSubHeader = "Get cozy with our new pillow!";
	private final static String buyNow = "BUY NOW";
	public static String productAmount;

	private static final Logger LOG = LoggerFactory.getLogger(MidtransAction.class);

	public static void navigatesTomidtrans() throws InterruptedException {
		String url = Props.getProp("midtrans");
		if (url.equalsIgnoreCase("")) {
			System.out.println("URL is not present in Config file");
		} else {
			navigateToURL(url);
		}
		waitForPageLoad();

		if (isElementPresent(MidtransPage.homePageHeader)) {
			System.out.println("midtrans page is loaded");
			Assert.assertEquals(getCurrentUrl(), url);
			LOG.info("Midtrans Page is loaded Successfully ");
			// Hooks.stepRecordAndFocusedScreenshot("Midtrans Page is loaded Successfully
			// ");
		} else {
			LOG.error("Midtrans Page is not loaded Properly ");
			Assert.fail();
			// Hooks.stepRecordAndFocusedScreenshot("Midtrans Page is not loaded Properly");
		}
	}

	public static void verifyExpectedcontentDisplayed() {
		Assert.assertEquals(midtransHeader, getText(MidtransPage.midTranstitle));
		System.out.println(
				"Amount match function output " + MatchTextwithRegex(RegExAmount, getText(MidtransPage.productAmount)));
		Assert.assertTrue("Verify Amount should be number",
				MatchTextwithRegex(RegExAmount, getText(MidtransPage.productAmount)));
		productAmount = getText(MidtransPage.productAmount).trim();
		highLightElement(MidtransPage.productAmount);
		Assert.assertEquals(Amountcurrency, getText(MidtransPage.amountCurrency));
		Assert.assertTrue(isElementPresent(MidtransPage.buyNow));
		Assert.assertEquals(buyNow, getText(MidtransPage.buyNow));
		Assert.assertEquals(midtransSubHeader, getText(MidtransPage.midtransSubHeader));
		LOG.info("Midtrans Page content verified Successfully ");
		// Hooks.stepRecordAndFocusedScreenshot("Midtrans Page content verified Successfully");
	}
}
