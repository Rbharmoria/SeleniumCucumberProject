package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/features", 
glue="stepDefinitions",
monochrome=true,
dryRun=true,
plugin= {"html:target/ccumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenario.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
//	@Override
//	@DataProvider(parallel=true);=
////	public Object[][] scenarios(); 
//	{
//		return super.scenarios();
//	}

}
