package core;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import java.io.IOException;
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
    
    /**
     * Wait for Page to load DOM 
     **/
    public static void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(webDriver, 60);
        wait.until(pageLoadCondition);
    }
    
    /**
     * An expectation for checking that an element is present on the DOM of a
     * page. This does not necessarily mean that the element is visible.
     *
     * @param by used to find the element
     * @return the WebElement once it is located
     */
    public static boolean isElementPresent(final By by) {
        try {
            new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(by));

        } catch (TimeoutException exception) {
            LOG.info(exception.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Returns the current URL from page
     **/
    public static String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

}
