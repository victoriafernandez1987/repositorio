package run;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.ConfigProp;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.Description;

@Test
//@RunWith(Cucumber.class)
@CucumberOptions(
//		tags="",
		plugin = {"pretty", "junit:target/cucumber-reports/cucumber.xml",
		"html:target/cucumber-reports/cucumber.html", 
		"json:target/cucumber-reports/cucumber.json"},
		
		features = {"src/test/resources/features"}, 
		
		glue = {"steps"},
		monochrome = true
)

public class RunTests extends AbstractTestNGCucumberTests {
	
//	@Override
//  @DataProvider(parallel = false)
//  public Object[][] scenarios() {
//      return super.scenarios();
//  }

}