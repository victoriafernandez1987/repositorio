package common;


import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class SeleniumUtils {
    RemoteWebDriver driver;
    WebDriverWait wait;
	private Object Assert;
	
	public SeleniumUtils(WebDriver driver){
		this.driver = (RemoteWebDriver) driver;
		wait = new WebDriverWait(driver, 100);
	}
	
	
	public void sendText(By element, String text){
		driver.findElement(element).sendKeys(text);
	}
	
	public void sendTextWithEnter(By element, String text){
		driver.findElement(element).sendKeys(text, Keys.ENTER);
	}
	
	public void enterValue(By element) {
		waitWebElementVisibleBy(element);
		driver.findElement(element).sendKeys(Keys.ENTER);
	}
	
	public WebElement finElement(By locator) {
		waitWebElementVisibleBy(locator);
		return driver.findElement(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		waitWebElementVisibleBy(locator);
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		waitWebElementVisibleBy(locator);
		driver.findElement(locator).sendKeys(inputText);
	}
	
//	protected void sendKeys(WebElement we, String keyvalue) throws Exception {
//		WebElement webElement = new WebDriverWait(getDriverProvider().get(), 45)
//			.until(ExpectedConditions.visibilityOf(we));
//		webElement.sendKeys(keyvalue);
//		Thread.sleep(500);
//	}
	
	public void click(By element){
		waitWebElementVisibleBy(element);
		waitWebElementClickableBy(element);
		driver.findElement(element).click();
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public void AssertElement(String elementActual, String txtError){
		assertEquals(elementActual, txtError);
	}
	
	public boolean ElementExists(By byElement) throws Exception {
		int Counter = 0;
		boolean isPresence = false;

		while (Counter < 3) {
			if (getElements(byElement).size()>0)	{
				isPresence = true;
				break;
			}
			Thread.sleep(100);
			Counter = Counter + 1;
		}
		return isPresence;
	}
	
	public boolean elementExists(By locator)
	{
		return !driver.findElements(locator).isEmpty();
	}
	
	//	Actions actions = new Actions(driver)
	
	public void moveToElement(By by) {
//		waitWebElementsVisibleBy(by);
		WebElement element = driver.findElement(by);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public void moveToElement(String string) {
		By StringBy = By.xpath(string);
//		waitWebElementsVisibleBy(StringBy);
		WebElement element = driver.findElement(StringBy);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	/////////////////////////////////////
	
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/* ### Selenium Actions ### */
	
	public void waitLoginPageFinishLoad(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").equals("complete");
	}
	
	public void click(String Xpath){
		waitWebElementVisibleBy(By.xpath(Xpath));
		waitWebElementClickableBy(By.xpath(Xpath));
		driver.findElement(By.xpath(Xpath)).click();
	}
	

	public void setText(By element, String text){
		waitWebElementVisibleBy(element);
		driver.findElement(element).sendKeys(text);
	}

	public void mouseOver(String Xpath){
		waitWebElementVisibleBy(By.xpath(Xpath));
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(Xpath))).perform();		
	}
	
	public void mouseOver(By element){
		waitWebElementVisibleBy(element);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(element)).perform();		
	}
	
	public List<WebElement> getElements(By elements){
		waitWebElementsVisibleBy(elements);
		return driver.findElements(elements) ;
	}
	/* ### Explicit Wait ### */
	public void waitWebElementClickableBy(By element){
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitWebElementVisibleBy(By element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void waitWebElementsVisibleBy(By elements){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elements));
	}
	
	/* ### Asserts ### */ 
	public void AssertElementPresent(WebElement element){
		((junit.framework.Assert) Assert).assertTrue(element.isDisplayed());
	}
	
	public void AssertElementPresent(By element){
		waitWebElementVisibleBy(element);
		((junit.framework.Assert) Assert).assertTrue(driver.findElement(element).isDisplayed());
	}
		
	public void AssertTextIsPresent(WebElement element,String text){
		System.out.print(element.getText()+"  ---  ");
		System.out.print(text);
		((junit.framework.Assert) Assert).assertTrue(element.getText().contains(text));
	}

	public void AssertTextIsPresent(By element,String text){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
		System.out.print(driver.findElement(element).getText()+"  ---  ");
		System.out.print(text);
		((junit.framework.Assert) Assert).assertTrue(driver.findElement(element).getText().contains(text));
	}
	
	public void d(By element){
		waitWebElementVisibleBy(element);
		((junit.framework.Assert) Assert).assertTrue(driver.findElement(element).isDisplayed());
	}
	
	public void AssertEquals(String elementExpected, String elementActual) {
		((junit.framework.Assert) Assert).assertEquals(elementExpected, elementActual);
	}
	
	
}
