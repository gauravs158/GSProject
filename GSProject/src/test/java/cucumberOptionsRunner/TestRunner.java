package cucumberOptionsRunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/featureFiles",
glue={"stepDefs"}, monochrome=true,
tags = "@G2G",
dryRun=false,
plugin = {
	      "com.aventstack.chaintest.plugins.ChainTestCucumberListener:",
	      "pretty",
	      "html:target/cucumber.html",
	      "json:target/cucumber.json",
	      "rerun:target/failed_scenarios.txt"
}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}