package runner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"/Users/basildzewu/Documents/workspace/Selenium/CucumberSelenium/src/test/java/feature"},
	glue={"steps"},
	monochrome=true,
	// tags={"@sanity,@prod"},
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"})      
	public class RunCuke {
	
	
	@BeforeClass
	public static void setup() {
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("target/cucumber/myreport.html");
	}

	
}
