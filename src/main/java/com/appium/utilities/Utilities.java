package com.appium.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Utilities {
	
	public AndroidDriver driver;
	public TakesScreenshot t;
	public File f1;
	public File f2;
	public Date d;
	
	public Utilities(AndroidDriver driver) {
		this.driver = driver;
	}
	
	//Function to Take Stepwise Screenshot
	public void StepScreenshot(String stepName) {
		try {
			d = new Date();
			String strDate = d.toString().replace(" ", "_").replace(":", "_");
			t  = (TakesScreenshot)driver;
			//Temporary location where screenshot will be kept
			f1 = t.getScreenshotAs(OutputType.FILE); //JPEG, PNG
			//Permanent location where screenshot will be kept
			f2 = new File(System.getProperty("user.dir")+"\\StepScreenshot\\"+stepName+"_"+strDate+".png");
			//Copy from temporary location to permanent location
			FileUtils.copyFile(f1, f2);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	//Function to Assert by Text
	public void AssertTextAndroid(String expectedText, String locatorType, String locatorValue, String msg) {
		if(locatorType.equals("id")) {
			String actualText = driver.findElement(AppiumBy.id(locatorValue)).getText();	
			Assert.assertEquals(actualText, expectedText, msg);
		}else if (locatorType.equals("className")) {
			String actualText = driver.findElement(AppiumBy.className(locatorValue)).getText();	
			Assert.assertEquals(actualText, expectedText, msg);
		}else if(locatorType.equals("xpath")) {
			String actualText = driver.findElement(AppiumBy.xpath(locatorValue)).getText();	
			Assert.assertEquals(actualText, expectedText, msg);
		}else if(locatorType.equals("androidUIAutomator")) {
			String actualText = driver.findElement(AppiumBy.androidUIAutomator(locatorValue)).getText();	
			Assert.assertEquals(actualText, expectedText, msg);
		}
		
		
	}
	
	//Function to Assert by Attribute Value
	public void AssertAttributeValueAndroid(String expectedAttributeValue, String locatorType, String locatorValue, String msg, String attributeType) {
		if(locatorType.equals("id") && attributeType.equals("class")) {
			String actualAttributevalue = driver.findElement(AppiumBy.id(locatorValue)).getAttribute("class");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("id") && attributeType.equals("resource-id")) {
			String actualAttributevalue = driver.findElement(AppiumBy.id(locatorValue)).getAttribute("resource-id");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("id") && attributeType.equals("text")) {
			String actualAttributevalue = driver.findElement(AppiumBy.id(locatorValue)).getAttribute("text");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("id") && attributeType.equals("index")) {
			String actualAttributevalue = driver.findElement(AppiumBy.id(locatorValue)).getAttribute("index");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("id") && attributeType.equals("content-desc")) {
			String actualAttributevalue = driver.findElement(AppiumBy.id(locatorValue)).getAttribute("content-desc");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("className") && attributeType.equals("class")) {
			String actualAttributevalue = driver.findElement(AppiumBy.className(locatorValue)).getAttribute("class");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("className") && attributeType.equals("resource-id")) {
			String actualAttributevalue = driver.findElement(AppiumBy.className(locatorValue)).getAttribute("resource-id");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("className") && attributeType.equals("text")) {
			String actualAttributevalue = driver.findElement(AppiumBy.className(locatorValue)).getAttribute("text");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("className") && attributeType.equals("index")) {
			String actualAttributevalue = driver.findElement(AppiumBy.className(locatorValue)).getAttribute("index");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("className") && attributeType.equals("content-desc")) {
			String actualAttributevalue = driver.findElement(AppiumBy.className(locatorValue)).getAttribute("content-desc");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("xpath") && attributeType.equals("class")) {
			String actualAttributevalue = driver.findElement(AppiumBy.xpath(locatorValue)).getAttribute("class");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("xpath") && attributeType.equals("resource-id")) {
			String actualAttributevalue = driver.findElement(AppiumBy.xpath(locatorValue)).getAttribute("resource-id");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("xpath") && attributeType.equals("text")) {
			String actualAttributevalue = driver.findElement(AppiumBy.xpath(locatorValue)).getAttribute("text");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("xpath") && attributeType.equals("index")) {
			String actualAttributevalue = driver.findElement(AppiumBy.xpath(locatorValue)).getAttribute("index");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("xpath") && attributeType.equals("content-desc")) {
			String actualAttributevalue = driver.findElement(AppiumBy.xpath(locatorValue)).getAttribute("content-desc");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("androidUIAutomator") && attributeType.equals("class")) {
			String actualAttributevalue = driver.findElement(AppiumBy.androidUIAutomator(locatorValue)).getAttribute("class");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("androidUIAutomator") && attributeType.equals("resource-id")) {
			String actualAttributevalue = driver.findElement(AppiumBy.androidUIAutomator(locatorValue)).getAttribute("resource-id");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("androidUIAutomator") && attributeType.equals("text")) {
			String actualAttributevalue = driver.findElement(AppiumBy.androidUIAutomator(locatorValue)).getAttribute("text");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("androidUIAutomator") && attributeType.equals("index")) {
			String actualAttributevalue = driver.findElement(AppiumBy.androidUIAutomator(locatorValue)).getAttribute("index");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}else if(locatorType.equals("androidUIAutomator") && attributeType.equals("content-desc")) {
			String actualAttributevalue = driver.findElement(AppiumBy.androidUIAutomator(locatorValue)).getAttribute("content-desc");	
			Assert.assertEquals(actualAttributevalue, expectedAttributeValue, msg);
		}
		
	}
	
	//Function to Take Stepwise Screenshot
	public String FailScreenshot(String nameOfTestAnnotationMethod) {
		try {
    		d = new Date();
    		String dat = d.toString().replace(" ", "_").replace(":", "_");
    		t = (TakesScreenshot)driver;
        	//Temporary Location
        	f1 = t.getScreenshotAs(OutputType.FILE); //PNG or JPEG
        	
        	//Path for Permanent location
        	String path = System.getProperty("user.dir")+"\\FailScreenshot\\"+nameOfTestAnnotationMethod+"_"+dat+".png";
        	
        	//Permanent Location
        	f2 = new File(path);
        	//Move the file from f1 to f2 location
        	FileUtils.copyFile(f1, f2);
        	
        	return path;
    	}catch(Throwable t) {
    		String msg = t.getMessage();
    		return msg;
    		
    	}
	}
	
	//Function to click on back button
	public void PressBack() {
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}
	
	//Function to close application
	public void CloseApplication() {
		driver.quit();
	}

	
}
