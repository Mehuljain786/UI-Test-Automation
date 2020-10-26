package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.ExecutionRecord;
import core.ScreenshotHook;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        features = ".//Features",
        plugin = {"html:target/cucumber-report", "pretty"},
        monochrome = true,
        glue = {"stepDefinitions"})

public class Debugger {
	
}
