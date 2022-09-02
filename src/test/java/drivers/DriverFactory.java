package drivers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public Driver genericDriver;

	public void getDriver(String browser) throws IOException{
		genericDriver = new DriverChrome();
		genericDriver.instanceDriver();
	}

	public void tearDown() {
		genericDriver.freeDriver();
	}

	public WebDriver driver() {
		return genericDriver.returnDriver();
	}

}
