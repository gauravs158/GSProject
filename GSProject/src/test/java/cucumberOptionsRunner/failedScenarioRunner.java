package cucumberOptionsRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",
glue="stepDefinitionFiles", monochrome=true,
dryRun=false,
plugin = {
		"html:target/cucumber.html",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
  })

public class failedScenarioRunner  extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}

