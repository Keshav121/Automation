package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features= {"src/test/java"},
glue= {"stepDefinitions"},
strict=true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
