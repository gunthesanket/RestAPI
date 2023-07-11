package TestRunnerclass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "StepDefinations", tags = "@all", plugin = "json:JsonReports/cucumber-json.json")
public class TestRunner extends AbstractTestNGCucumberTests {

}
