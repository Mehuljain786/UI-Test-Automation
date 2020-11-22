package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        features = ".//Features",
        plugin = { "pretty", "html:target/cucumber-report-html.html", "json:target/cucumber.json","pretty:target/cucumber-pretty.txt","junit:target/cucumber-results.xml"},
        monochrome = true,
        glue = {"stepDefinitions"})

public class Debugger {
  
}
