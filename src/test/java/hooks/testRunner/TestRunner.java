package hooks.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://QEAutomation//Java Initiative//TestSmithDemoCucumber//features//TestSmithDemo.feature"//,
        //features = "C://QEAutomation//Java Initiative//TestSmithDemoCucumber//features//RegisterNewUser.feature",
        //glue = "stepsDefinitions"
)
public class TestRunner {
}
