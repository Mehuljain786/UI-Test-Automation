package stepDefinitions;

import core.ExecutionRecord;
import core.ScreenshotHook;
import core.WebDriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);
    public static ExecutionRecord record;
    long startTime;

    public static void stepRecordHook(String step){
            record.stepRecord(step);
    }

    public static void stepRecordAndFocusedScreenshot(String step){
            record.stepRecordAndScreenshot(step);
    }
    
    @Before
    public void setUp(Scenario scenario){
        LOG.info("_______Before scenario- - - >" + scenario.getName() + "_______");
        startTime = System.currentTimeMillis();
        record = new ExecutionRecord("./target/screenshots/"+scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        LOG.info("_________After scenario- - - >" + scenario.getName() + "______");
        long estimatedTime = System.currentTimeMillis() - startTime;
        ScreenshotHook.embedScreenshot(scenario);
        if(scenario.isFailed()) {
            ScreenshotHook.embedScreenshot(scenario);
            stepRecordHook("FAILED_STEP");        }
            record.closeScenarioRecord(scenario, getDurationBreakdown(estimatedTime));
            record.setTestResults(scenario);
            WebDriverHelper.closeWebDriver();    
    }

    public static String getDurationBreakdown(long millis) {
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        return String.format("%d Minutes %d Seconds",minutes, seconds);
    }
}
