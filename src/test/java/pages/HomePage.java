package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import common.ConfigProp;

public class HomePage extends WebPage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* ## Web Elements ##*/
	
	private By inputSearchBox = By.xpath("//input[@class='search_query form-control ac_input']");
	private By btnSearch = By.xpath("//button[@class='btn btn-default button-search']");
	private By resultXpath = By.xpath("//span[@class='lighter']");

	/* ## Methods ##*/

	public HomePage goToOpenUrl() throws IOException, InterruptedException{
		driver.get(ConfigProp.getUrl());
		driver.manage().window().maximize();
		System.out.println("URL is " + driver.getCurrentUrl());
		Thread.sleep(10000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new HomePage(driver);
	}
	
	public HomePage goSearchItem(String item) throws InterruptedException, IOException {
		seleniumUtils.sendTextWithEnter(inputSearchBox, item);
		System.out.println("Search item " + item);
//		seleniumUtils.click(btnSearch);
		Thread.sleep(10000);
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new HomePage(driver);
	}
	
	public HomePage validateResultItem(String result) throws IOException, InterruptedException {
		Thread.sleep(10000);
		seleniumUtils.waitWebElementVisibleBy(resultXpath);
		//String result_Xpath = seleniumUtils.getText(resultXpath);
		//seleniumUtils.AssertEquals(result, result_Xpath);
		seleniumUtils.AssertElementPresent(resultXpath);
		System.out.println("Se validó correctamente.");
		util.captureScreenshot(driver);
		util.allureCaptureScreenshotRe(driver);
		return new HomePage(driver);
	}
	
}
