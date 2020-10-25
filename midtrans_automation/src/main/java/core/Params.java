package core;


import java.awt.Dimension;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Params {
    private static final Logger LOG = LoggerFactory.getLogger(Params.class);

    public static String BROWSER;
    public static String PLATFORM;
    public static boolean HIGHLIGHT;
    public static boolean STEP_RECORD;


    protected static String DRIVER_PATH;
    public static String DRIVER_ROOT_DIR;
    protected static Dimension BROWSER_WINDOW_SIZE;
    protected static Integer BROWSER_WINDOW_WIDTH;
    protected static Integer BROWSER_WINDOW_HEIGHT;



    static {
        LOG.info("Loading command line properties...");
        BROWSER = Props.getSystemProp("browser");
        STEP_RECORD = Boolean.parseBoolean(Props.getSystemProp("record"));
        HIGHLIGHT = Boolean.parseBoolean(Props.getSystemProp("highlight"));

        LOG.info("Loading file properties...");
        Props.loadRunConfigProps("/environment.properties");
        PLATFORM = Props.getProp("platform");
        BROWSER_WINDOW_WIDTH = Integer.parseInt(Props.getProp("browser.width"));
        BROWSER_WINDOW_HEIGHT = Integer.parseInt(Props.getProp("browser.height"));
        BROWSER_WINDOW_SIZE = new Dimension(BROWSER_WINDOW_WIDTH, BROWSER_WINDOW_HEIGHT);
        DRIVER_ROOT_DIR = Props.getProp(
                "driver.root.dir"); DRIVER_ROOT_DIR = Props.getProp(
                "driver.root.dir");

        if (!DRIVER_ROOT_DIR.equals("DEFAULT_PATH")) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            System.setProperty("webdriver.gecko.driver", getGekoDriverPath());
        }
    }


    private static String getChromeDriverPath() {
        String chromeDriverProp = Props.getSystemProp("driver.chrome.dir");
        if(chromeDriverProp == null || chromeDriverProp.isEmpty()) {
            DRIVER_PATH = Props.getSystemProp("user.dir") + "/" + Props.getProp("driver.chrome.dir");
        }
        else{
            DRIVER_PATH = chromeDriverProp;
        }
        return FilenameUtils.normalize(DRIVER_PATH);
    }

    private static String getGekoDriverPath() {
        DRIVER_PATH = Props.getProp("driver.gecko.dir");
        return FilenameUtils.normalize(DRIVER_PATH);
    }
}
