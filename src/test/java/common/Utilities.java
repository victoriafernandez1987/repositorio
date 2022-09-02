package common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;


public class Utilities {
	final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);
	
	public String replaceText(String Xpath, String replacement){
		return Xpath.replaceFirst("#text#", replacement);
	}
	
	// screeshots
	
	@Description("Screenshot")
	public void captureScreenshot(RemoteWebDriver driver) throws IOException{
		  try {
			  TakesScreenshot ts = (TakesScreenshot)driver;
			  
			  Calendar currentDate = Calendar.getInstance();
	          SimpleDateFormat formatter = new SimpleDateFormat(
	                  "yyyy/MMM/dd HH:mm:ss");
	          String dateN = formatter.format(currentDate.getTime()).replace("/","_");
	          dateN = dateN.replaceAll(":", "-");
	          String title = driver.getTitle();
	          title	= title.replace("|", "-");  
	          String nameFile = "Screenshot_" + title + "_" + dateN;
	          
			  File file = ts.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(file, new File("./screenshots/"+nameFile+".png")); 
	      } catch(IOException e) {
	    	  System.out.println("Failed to capture screenshot: " + e.getMessage());
	      }

	}
	
	@Attachment(value = "Page screenshot", type = "image/png")
	public void allureCaptureScreenshotRe(RemoteWebDriver driver) throws IOException{
		try {
			Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
