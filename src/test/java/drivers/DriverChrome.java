package drivers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.ConfigProp;



public class DriverChrome extends Driver {
	
	@Override
	public void instanceDriver() throws IOException{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("force-device-scale-factor=0.75");
		//options.addArguments("--headless");
		options.addArguments("disable-infobars");
		options.addArguments("lang=en-GB");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
	
		
		if (ConfigProp.getPlatform().equals("local")){
			System.setProperty("webdriver.chrome.driver",ConfigProp.getChromePath());
			LOGGER.debug("webdriver.chrome.driver,ConfigProp.getChromePath()");
			driver = new ChromeDriver(options);
		}else {
			String remoteUrl = "http://localhost:4444/wd/hub";
			URL url = new URL(remoteUrl);
			System.out.println("Selenium grid url is: " + remoteUrl);
			driver = new RemoteWebDriver(url,options);
		}
		
	}

	@Override
	public void freeDriver() {
		driver.quit();
	}

	@Override
	public WebDriver returnDriver() {
		return driver;
	}

}
