package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        features = ".//Features",
        plugin = {"pretty"},
        monochrome = true,
        glue = {"stepDefinitions"})

public class Debugger {

}
