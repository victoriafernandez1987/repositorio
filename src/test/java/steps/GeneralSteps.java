package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConfigProp;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.HomePage;

public class GeneralSteps {
	final Logger LOGGER = LoggerFactory.getLogger(GeneralSteps.class);
	WebDriver driver;
	DriverFactory driverFactory;
	HomePage home;
	
	public void setup() throws IOException{
		driverFactory= new DriverFactory();
		driverFactory.getDriver(ConfigProp.getBrowser());
		driver= driverFactory.driver();	
		home = new HomePage(driver);
		LOGGER.info("@BeforeTest- Setup");
	}
	
	public void tearDown(){
		driverFactory.tearDown();
		LOGGER.info("@AfterTest- tearDown");
	}
	
	@Before
	public void beforeScenario() throws IOException {
		setup();
	}
	
	@After
	public void afterScenario() {
		tearDown();
	}
	
	@Step("I open the Automation Practice")
	@Given("^I open the Automation Practice$")
	   public void GoToOpenUrl() throws InterruptedException, IOException{
		home.goToOpenUrl();
	   }
	
	@Step("I go search {item}")
	@When("^I go search (.*)$")
	   public void GoSearchItem(String item) throws InterruptedException, IOException{
		home.goSearchItem(item);
	   }
	
	@Step("I validate result '{result}'")
	@Then("^I validate result '(.*)'$")
	   public void ValidateResultItem(String result) throws InterruptedException, IOException{
		home.validateResultItem(result);
	   }
	
}
