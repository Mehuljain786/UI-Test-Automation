package midtrans_automation_Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.Props;
import core.utilities;



public class midtransAction extends utilities{
	private static final Logger LOG = LoggerFactory.getLogger(midtransAction.class);

  public static void navigatesTomidtrans() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","/Users/me20050937/git/UI-Test-Automation/midtrans_automation/Drivers/Chromedriver/Mac32/chromedriver");
      WebDriver driver = new ChromeDriver();
		String url = Props.getProp("midtrans");
        if(url.equalsIgnoreCase(""))
        {
        	System.out.println("URL is not present in Config file");
        }
        else {
        	navigateToURL(url);
        }
	
/*    waitForPageLoad();
    waitForElementAtIntervals(MyTelstraPage.homePageText, 1, 5);
    if (isElementPresent(MyTelstraPage.homePageText)) {
        System.out.println("Home page is loaded");
    } else {
        waitForExpectedElement(MyTelstraPage.welcome_heading);
        System.out.println("Guided onboarding page is present");
        MyTelstraAction.skipGuidedOnboardScreen();*/
    }
}
	

