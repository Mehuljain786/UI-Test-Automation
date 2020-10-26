package midtrans_automation_Action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import TestRunner.Hooks;

import org.junit.Assert;
import core.Props;
import core.utilities;
import midtrans_automation_pageObject.midtransPage;



public class midtransAction extends utilities{
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
        	Hooks.stepRecordAndFocusedScreenshot("Midtrans Page is loaded Successfully ");
        }
        else {
        	LOG.error("Midtrans Page is not loaded Properly ");
            Assert.fail();
            Hooks.stepRecordAndFocusedScreenshot("Midtrans Page is not loaded Properly ");
        }
        
    }
}
	

