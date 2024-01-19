package com.appium.test;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appium.base.Base;
import com.appium.pages.InlinePage;
import com.appium.utilities.ExtentManager;
import com.appium.utilities.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class DataWidgetsPageActivityPackageTest extends Base{
	public AndroidDriver driver;
	public Actions act;
	public WebDriverWait wait;
	public WebElement w1;
	public WebElement w2;
	public Utilities u;
	public InlinePage i;
	
	//Create an object of ExtentSparksReporter class
	ExtentSparkReporter report = ExtentManager.getInstanceExtentSparkReporter();
	//Create an object of ExtentReports class
	ExtentReports extent = ExtentManager.getInstanceExtentReports();
	//This class acts like a log report creater
	ExtentTest logger;
	
	
	
	@BeforeMethod
	public void SetUp() throws MalformedURLException, AppiumServerHasNotBeenStartedLocallyException, FileNotFoundException {
		//Start the Appium Server Programmatically
		WifiSettingsTest.StartServer();
		
		driver = WifiSettingsTest.InstallInvokeAppWithActivity("io.appium.android.apis","io.appium.android.apis.view.DateWidgets2","UiAutomator2", "Android", "Pixel7R", "11", "200", "emulator-5554");
		
		u = new Utilities(driver);
		
		i = new InlinePage(driver);
	}
	
	@Test
	public void DateWidgetPageActivityPackage() throws MalformedURLException, InterruptedException {
		
		//Create the Test Case
		logger = extent.createTest("Api Demo Date Widget Test case - Wifi Settings");
								
		//Create the category for testing - using the assign category method of ExtentTest class
		logger.assignCategory("Functional Test Category");
		
		//Stepwise screenshot
		u.StepScreenshot("OpenApiDemoDateWidget");
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
				
		wait = new WebDriverWait(driver , Duration.ofSeconds(20L));
			
		Thread.sleep(4000L);
		
		//Explicit wait for the text AM to be present
		wait.until(ExpectedConditions.textToBePresentInElementLocated(AppiumBy.xpath("//android.widget.RadioButton[@text='AM']"), "AM"));
		
		//Assert on the text AM
		u.AssertTextAndroid("AM", "xpath", "//android.widget.RadioButton[@text='AM']", "Text AM is not present for radio button");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Changed PM to AM - ApiDemo App Preference",ExtentColor.GREEN));

		
		//Change the time from PM to AM
		//driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/am_label\")")).click();
		i.ClickAM();
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on AM",ExtentColor.BLUE));

		
		//Explicit wait for 12 AM
		wait.until(ExpectedConditions.attributeContains(AppiumBy.xpath("//*[@content-desc='12']"), "content-desc", "12"));
		
		//Explicit wait for 9 AM
		wait.until(ExpectedConditions.attributeContains(AppiumBy.xpath("//*[@content-desc='9']"), "content-desc", "9"));
				
		//Assert the the attribute value is 12 for attribute content -desc for 12AM
		u.AssertAttributeValueAndroid("12", "xpath", "//*[@content-desc='12']", "The content-desc value 12 is not present for 12AM", "content-desc");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("The attribute value is 12 for attribute content -desc for 12AM is present",ExtentColor.GREEN));

		
		//Assert the the attribute value is 9 for attribute content-desc for 9AM
		u.AssertAttributeValueAndroid("9", "xpath", "//*[@content-desc='9']", "The content-desc value 9 is not present for 9AM", "content-desc");
			
		logger.log(Status.PASS, MarkupHelper.createLabel("The attribute value is 9 for attribute content -desc for 9AM is present",ExtentColor.GREEN));

		
		//Drag the hour needle from 12am  to 9am
		//Keep the address of 12 hours
//		w1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().index(11)"));
//		//Keep the address of 9 hour
//		w2  = driver.findElement(AppiumBy.xpath("//*[@index = '8']"));
//		act = new Actions(driver);
//		act.dragAndDrop(w1, w2).build().perform();
		i.MovementTwelveToNine();
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Movement of hour needle from 12 to 9",ExtentColor.BLUE));

		
		Thread.sleep(4000L);
		
		//Explicit wait for 15 min
		wait.until(ExpectedConditions.attributeContains(AppiumBy.xpath("//*[@content-desc='15']"), "content-desc", "15"));
				
		//Explicit wait for 30 min
		wait.until(ExpectedConditions.attributeContains(AppiumBy.xpath("//*[@content-desc='30']"), "content-desc", "30"));
						
		//Assert the the attribute value is 3 for attribute index for 15 min
		u.AssertAttributeValueAndroid("15", "xpath", "//*[@content-desc='15']", "The content-desc value 15 is not present for 15MIN", "content-desc");
			
		logger.log(Status.PASS, MarkupHelper.createLabel("The attribute value is 15 for attribute content -desc for 15 min is present",ExtentColor.GREEN));

		
		//Assert the the attribute value is 6 for attribute index for 30MIN
		u.AssertAttributeValueAndroid("30", "xpath", "//*[@content-desc='30']", "The content-desc value 30 is not present for 30MIN", "content-desc");
				
		logger.log(Status.PASS, MarkupHelper.createLabel("The attribute value is 30 for attribute content -desc for 30 min is present",ExtentColor.GREEN));

		
		//Drag the hour needle from 15min  to 30min
		//Keep the address of 15 min
		//w1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().index(3)"));
		//Keep the address of 30 min 
//		w2  = driver.findElement(AppiumBy.xpath("//*[@content-desc = '30']"));
//		act = new Actions(driver);
//		//act.dragAndDrop(w1, w2).build().perform();
//		act.click(w2).build().perform();
		i.ClickThirtyMin();
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on 30 minutes",ExtentColor.BLUE));

		
		Thread.sleep(4000L);
		
	}
	
	@AfterMethod
	public void TearDownMethod(ITestResult result) throws FileNotFoundException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshot = u.FailScreenshot(result.getName());
			//Also put the failed screenshot in Extent report
			// Adding screenshots to log of Extent Report
			logger.fail("Assertion failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
			// Adding screenshots to test
			logger.fail("Assertion failed").addScreenCaptureFromPath(screenshot);
			//Add the test annotation method name which has failed in the log
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-- Date Widget Test case Failed", ExtentColor.RED));
			//Add the exception name on assertion failure to the log
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "-- Date Widget Test case Failed", ExtentColor.RED));
		}
		//Flush out the report
		extent.flush();
		
		//Close the app
		//driver.quit();
		u.CloseApplication();
		
		//Stop the Appium Server programmatically
		WifiSettingsTest.StopServer();
		
	}
}
