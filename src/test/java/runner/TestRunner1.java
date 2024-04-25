package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/LMSFeatures"}, //location of feature files
					glue= {"stepDefinitions","AppHooks"},
					plugin= {"pretty",
							 "json:target/json-Report/cucumber.json",
							 "html:target/cucumberHtml-Report/LMSCucumberReport.html",
							 "junit:target/cucumberXml-Report/report.xml",
							 "rerun:target/rerun.txt", //mandatory for capture failure
							 "timeline:test-output-thread/",
							 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
},
					monochrome=true  //console output color
				)

public class TestRunner1 {

}



