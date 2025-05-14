package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to the feature files
        glue = {"stepDefs", "hooks"}, // Path to step definitions and hooks
        plugin = {"pretty", "html:target/cucumber-report.html"}, // Generate a report
        monochrome = true // Make the output more readable
)
public class TestRunner {}


