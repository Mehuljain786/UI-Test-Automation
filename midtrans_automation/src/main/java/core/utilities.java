package core;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class utilities {
    private static final long DRIVER_WAIT_TIME = 40;
    private static final Logger LOG = LoggerFactory.getLogger(utilities.class);

    protected static WebDriverWait wait;
    protected static WebDriver webDriver;
    protected static WebDriver driver;
    protected static ArrayList<String> tabs;
    
    static{
        webDriver = WebDriverHelper.getWebDriver();
        wait = new WebDriverWait(webDriver, DRIVER_WAIT_TIME);
    }
    
    /**
     * Navigate to the  URL.
     **/
    public static void navigateToURL(String url) {
    	webDriver.navigate().to(url);
    }

}
