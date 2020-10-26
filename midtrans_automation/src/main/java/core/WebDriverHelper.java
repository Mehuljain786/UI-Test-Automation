package core;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverHelper {
	
	private static final Logger LOG = LoggerFactory.getLogger(WebDriverHelper.class);
	public static WebDriver REAL_DRIVER = null;
    private static final Thread CLOSE_THREAD = new Thread(() -> {
        closeWebDriver();
    });
	static {
		System.out.println("Sucess");
		System.out.println("launchBrowser: Browser requested: " + Params.BROWSER);
        launchBrowser();
    }
	
	/**
	    * Launch the browser based on the mention in property file
	    *
	    **/
    private static void launchBrowser() {

        try {
            System.out.println("launchBrowser: Browser requested: " + Params.BROWSER);
            switch (Params.BROWSER.toLowerCase()) {
                case ("chrome"):
                    startChromeDriver();
                    break;
                case ("firefox"):
                    startFireFoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser " + Params.BROWSER + " or Platform "
                            + Params.PLATFORM + " type not supported");

            }
        } catch (IllegalStateException e) {
            LOG.error("FIX path for driver.root.dir in pom.xml " + Params.DRIVER_ROOT_DIR
                    + " Browser parameter " + Params.BROWSER + " Platform parameter " + Params.PLATFORM
                    + " type not supported");
            e.printStackTrace();
            throw e;
        }
    }
    
    
    public static WebDriver startChromeDriver() {
    	ChromeOptions chromeOptions = getChromeOptions();
        LOG.info("startChromeDriver: initiating... starting a new chrome driver");
        System.setProperty("webdriver.chrome.driver","/Users/me20050937/git/UI-Test-Automation/midtrans_automation/Drivers/Chromedriver/Mac32/chromedriver");
        REAL_DRIVER = new ChromeDriver();
        REAL_DRIVER.get("https://demo.midtrans.com/");
        //REAL_DRIVER = new SafariDriver();
        //maximize();
        return REAL_DRIVER;
    }
    
    public static WebDriver startFireFoxDriver() {
    	LOG.info("startFirefoxDriver: initiating... starting a new Firefox driver");
        REAL_DRIVER = new FirefoxDriver();
        maximize();
        return REAL_DRIVER;
    }
    
    public static void maximize() {
        REAL_DRIVER.manage().window().maximize();
    }
    
    /**
     * Close the quite all the driver instances  
     *
     **/
    public static void closeWebDriver() {
        LOG.debug("Closing Webdriver");
        REAL_DRIVER.close();
        REAL_DRIVER.quit();
    }
    
    public static WebDriver getWebDriver() {
        return REAL_DRIVER;
    }
    
    private static ChromeOptions getChromeOptions() {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.INFO);
        logPrefs.enable(LogType.DRIVER, Level.INFO);
        LOG.info("startChromeDriver: initiating... set chromeOptions... for desktop");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--start-maximized");
        LOG.info("startChromeDriver: initiating... set chromeOptions... for desktop... complete");
        return chromeOptions;
    }

}
