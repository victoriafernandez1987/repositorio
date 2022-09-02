package drivers;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


 abstract class Driver {
	 final Logger LOGGER = LoggerFactory.getLogger(Driver.class);	
	
	protected WebDriver driver;
	
	public abstract void instanceDriver() throws IOException;

	public abstract void freeDriver();

	public abstract WebDriver returnDriver();

}
