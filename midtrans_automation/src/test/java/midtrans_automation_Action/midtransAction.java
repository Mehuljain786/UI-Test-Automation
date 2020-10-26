package midtrans_automation_Action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import TestRunner.Hooks;

import org.junit.Assert;
import core.Props;
import core.utilities;
import midtrans_automation_pageObject.midtransPage;



public class midtransAction extends utilities{
    private final static String midtransHeader = "Midtrans Pillow";
    private final static String RegExAmount= "^([1-9]{0,3}|1{4}|20,000)";
    private final static String Amountcurrency = "Rp";
    private final static String midtransSubHeader = "Get cozy with our new pillow!";
    private final static String buyNow = "BUY NOW";
	
	
	private static final Logger LOG = LoggerFactory.getLogger(midtransAction.class);

  public static void navigatesTomidtrans() throws InterruptedException {
		String url = Props.getProp("midtrans");
        if(url.equalsIgnoreCase(""))
        {
        	System.out.println("URL is not present in Config file");
        }
        else {
        	navigateToURL(url);
        }
        waitForPageLoad();
    
        if (isElementPresent(midtransPage.homePageHeader)) {
        	System.out.println("midtrans page is loaded");
        	Assert.assertEquals(getCurrentUrl(), url);
        	LOG.info("Midtrans Page is loaded Successfully ");
        	//Hooks.stepRecordAndFocusedScreenshot("Midtrans Page is loaded Successfully ");
        }
        else {
        	LOG.error("Midtrans Page is not loaded Properly ");
            Assert.fail();
            //Hooks.stepRecordAndFocusedScreenshot("Midtrans Page is not loaded Properly ");
        }
    }
  
  public static void verifyExpectedcontentDisplayed() {
      Assert.assertEquals(midtransHeader, getText(midtransPage.midTranstitle));
      System.out.println("Amount match function output " + MatchTextwithRegex(RegExAmount,getText(midtransPage.productAmount)));
      Assert.assertTrue("Verify Amount should be number",MatchTextwithRegex(RegExAmount,getText(midtransPage.productAmount)));
      highLightElement(midtransPage.productAmount);
      Assert.assertEquals(Amountcurrency, getText(midtransPage.amountCurrency));
      Assert.assertTrue(isElementPresent(midtransPage.buyNow));
      Assert.assertEquals(buyNow, getText(midtransPage.buyNow));
      Assert.assertEquals(midtransSubHeader, getText(midtransPage.midtransSubHeader));
      LOG.info("Midtrans Page content verified Successfully ");
      //Hooks.stepRecordAndFocusedScreenshot("Midtrans Page content verified Successfully");
   }
}
	

