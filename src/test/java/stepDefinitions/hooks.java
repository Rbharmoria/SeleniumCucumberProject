package stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class hooks {
	TestContextSetup testContextSetup;
	
	public hooks() {
		this.testContextSetup = testContextSetup;
	}
	
	@AfterStep 
	public void AddScreenshot(Scenario scenario){
		WebDriver driver = testContextSetup.TestBase.WebDriverManager();
		if(scenario.isFailed()) {
			
		File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		System.out.println("Print");}
	}

}
