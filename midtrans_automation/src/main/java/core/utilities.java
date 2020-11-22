package core;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    
    private static ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) throws NoSuchElementException {
        return driver -> {
           try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                LOG.error(e.getMessage());
            }
            WebElement element = webDriver.findElement(by);
            return element.isDisplayed() ? element : null;
        };
    }
    
    /**
     * Find the dynamic element wait until its visible
     *
     * @param by Element location found by css, xpath, id etc...
     **/
    protected static WebElement waitForExpectedElement(final By by) {
        System.out.println("Waiting for expected element");
        return wait.until(visibilityOfElementLocated(by));
    }

    public static void highLightElement(WebElement element)
    {
        if (Params.HIGHLIGHT) {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid Lime;');", element);
        }
    }
    
    public static void highLightElement(By by)
    {
        LOG.info("Element for Highlighting - " + by.toString());
        highLightElement(waitForExpectedElement(by));
    }
    
    /**
     * Returns the Text from the element
     **/
    public static String getText(final By by){
        highLightElement(by);
        return waitForExpectedElement(by).getText().trim();
    }
    
    
    /**
     * For regex match with text
     **/
    public static boolean MatchTextwithRegex(String regex, String text) {
        boolean isMatched = false;
        if ((regex == null) || (text == null)) {
            throw new NullPointerException("The parameters must not be null");
        }

        try {
            isMatched = text.matches(regex);
        } catch (Exception ex) {
            LOG.info(ex.getMessage());
        }
        return isMatched;

    }
    
    /**
     * Click on element using JavaScript
     **/
    public static void clickOnElementWithJSExecutor(WebElement element){
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }
    
    /**
     * Click on element using JavaScript
     **/
    public static void clickOnElementWithJSExecutor(final By by){
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", waitForExpectedElement(by));
    }
    
    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param by used to find the element
     * @return the WebElement once it is located and clickable (visible and enabled)
     */
    public static WebElement elementToBeClickable(By by) {
        return (new WebDriverWait(webDriver, DRIVER_WAIT_TIME)).until(ExpectedConditions.elementToBeClickable(by));
    }
    

    /**
     * Wrapper for clear data and sendKeys in Input Text box
     *
     * @param by Element location found by css, xpath, id etc...
     * @param inputText text to be entered
     **/

    protected static void clearEnterText(By by, String inputText) {
    	waitForExpectedElement(by).click();
        waitForExpectedElement(by).clear();
        waitForExpectedElement(by).sendKeys(inputText);
        highLightElement(by);
    }
    
    /**
     * Wrapper for sendKeys in Input Text box
     *
     * @param by Element location found by css, xpath, id etc...
     * @param inputText text to be entered
     **/

    protected static void EnterText(By by, String inputText) {
    	waitForExpectedElement(by).click();
        waitForExpectedElement(by).sendKeys(inputText);
    }
    
    /**
     * An expectation for checking whether the given frame is available to switch
     * to. <p> If the frame is available it switches the given driver to the
     * specified frame.
     *
     * @param by used to find the frame
     */
    public static WebDriver frameToBeAvailableAndSwitchToIt(final By by) {
        return new WebDriverWait(webDriver, DRIVER_WAIT_TIME).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }
    
    public static void switchToFrame(String frameid){

        webDriver.switchTo().frame(frameid);
    }

    public static void switchToParentFrame(){
        webDriver.switchTo().defaultContent();
    }
    
    public static void switchToFrame(int framenumber){
        webDriver.switchTo().frame(framenumber);
    }
    
}
