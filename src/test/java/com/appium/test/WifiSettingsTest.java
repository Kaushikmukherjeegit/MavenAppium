package com.appium.test;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appium.base.Base;
import com.appium.config.DataProviderData;
import com.appium.pages.LandingPage;
import com.appium.pages.PreferenceDependenciesPage;
import com.appium.pages.PreferencePage;
import com.appium.utilities.ExtentManager;
import com.appium.utilities.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class WifiSettingsTest extends Base{
	
	public AndroidDriver driver;
	public TakesScreenshot t;
	public WebDriverWait wait;
	public File f1;
	public File f2;
	public Utilities u;
	public LandingPage l;
	public PreferencePage pp;
	public PreferenceDependenciesPage pdp;
	
	//Create an object of ExtentSparksReporter class
	ExtentSparkReporter report = ExtentManager.getInstanceExtentSparkReporter();
	//Create an object of ExtentReports class
	ExtentReports extent = ExtentManager.getInstanceExtentReports();
	//This class acts like a log report creater
	ExtentTest logger;
	
	@BeforeSuite
	public void SuiteSetUp() throws InterruptedException {
		WifiSettingsTest.StartEmulator();
		
		Thread.sleep(10000L);
	}
	
	@AfterSuite
	public void SuiteTearDown() {
		WifiSettingsTest.StopEmulator();
	}
	
	
	
	@BeforeMethod
	public void SetUp() throws MalformedURLException, AppiumServerHasNotBeenStartedLocallyException, FileNotFoundException {
		//Start the Appium Server Programmatically
		WifiSettingsTest.StartServer();
		
		driver = WifiSettingsTest.InstallInvokeApp("UiAutomator2", "Android", "Pixel7R", "11", "200", "emulator-5554");
		
		u = new Utilities(driver);
		
		l = new LandingPage(driver);
		
		pp = new PreferencePage(driver);
		
		pdp = new PreferenceDependenciesPage(driver);
		
		
	}
	
	@Test(dataProvider = "DataWifiSettings", dataProviderClass = DataProviderData.class)
	public void WifiSettings(Hashtable <String, String> h) throws MalformedURLException {
		
		//Create the Test Case
		logger = extent.createTest("Api Demo Wifi Settings Test case - Wifi Settings");
						
		//Create the category for testing - using the assign category method of ExtentTest class
		logger.assignCategory("Functional Test Category");
		
		//Stepwise screenshot
		u.StepScreenshot("OpenApiDemo");
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Opening of App - OpenApiDemo App Preference",ExtentColor.BLUE));

		
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
		
		wait = new WebDriverWait(driver , Duration.ofSeconds(20L));
		
		//Wait until the text for PREFERENCES is "Preference"
		wait.until(ExpectedConditions.textToBePresentInElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc='Preference']"), "Preference"));
		
		//Assert the text for PREFERENCES is "Preference" 
		u.AssertTextAndroid("Preference", "xpath", "//android.widget.TextView[@content-desc='Preference']", "Preference text for PREFERENCE is not present");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Opening of App - OpenApiDemo App Preference",ExtentColor.GREEN));

		
		//Click on PREFERENCES
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Preference']")).click();
		l.ClickPreference();
		
		//Stepwise screenshot
		u.StepScreenshot("ClickedPreferences");
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on Preference",ExtentColor.BLUE));

				
		
		//Wait until the text for PREFERENCE DEPENDENCIES is "3. Preference dependencies"
		wait.until(ExpectedConditions.textToBePresentInElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='3. Preference dependencies']"), "3. Preference dependencies"));
			
		//Assert the text for PREFERENCES DEPENDENCIES  is "3. Preference dependencies" 
		u.AssertTextAndroid("3. Preference dependencies", "xpath", "//android.widget.TextView[@text='3. Preference dependencies']", "3. Preference dependencies text for PREFERENCE DEPENDENCIES is not present");
				
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion passed for Preference Dependency",ExtentColor.GREEN));
		
		//Click on PREFERENCES DEPENDENCIES
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		pp.ClickPreferenceDependencies();	
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on Preference Dependency",ExtentColor.BLUE));
		
		
		//Stepwise screenshot
		u.StepScreenshot("ClickedPreferencesDependencies");
		
		//Wait for the WIFI CHECKBOX to have an attribute resource-id with value of "android:id/checkbox"
		wait.until(ExpectedConditions.attributeContains(AppiumBy.id("android:id/checkbox"), "resource-id", "android:id/checkbox"));
		
		//Assert the attribute value for  WIFI CHECKBOX  is "android:id/checkbox"  for attribute "resource-id"
		u.AssertAttributeValueAndroid("android:id/checkbox", "id", "android:id/checkbox", "android:id/checkbox attribute value for resource-id attribute is not present for WIFI CHECKBOX","resource-id");	
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion passed for Wifi Checkbox edit box",ExtentColor.GREEN));
		
		//Click on WIFI CHECKBOX
		//driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		pdp.ClickWifiCheckbox();
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Checked Wifi checkbox",ExtentColor.BLUE));

		
		//Stepwise screenshot
		u.StepScreenshot("ClickedWifiCheckbox");
		
		
		//Wait for the WIFI SETTINGS to have an text with value of "WiFi settings"
		wait.until(ExpectedConditions.textToBePresentInElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']"), "WiFi settings"));
			
		//Assert for the text WiFi settings
		u.AssertTextAndroid("WiFi settings", "xpath", "//android.widget.TextView[@text='WiFi settings']", "WiFi settings text is not found");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion passed for Wifi Settings",ExtentColor.GREEN));
		
		//Click on WIFI SETTINGS
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		pdp.ClickWifiSettings();
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Clicked Wifi Settings",ExtentColor.BLUE));

		
		//Stepwise screenshot
		u.StepScreenshot("ClickedWifiSettings");
		
		//Wait for the TYPE ON EDIT BOX  to have an attribute resource-id with value of "android:id/edit"
		wait.until(ExpectedConditions.attributeContains(AppiumBy.id("android:id/edit"), "resource-id", "android:id/edit"));
			
		//Assert for attribute value "android:id/edit" for attribute "resource-id" in EDIT box for typing WIfi Name
		u.AssertAttributeValueAndroid("android:id/edit", "id", "android:id/edit", "android:id/edit attribute value for resource-id attribute is not present for edit box where Wifiname is typed","resource-id");	
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion passed for Wifi Edit Box ",ExtentColor.GREEN));
		
		
		//Type on the EDIT BOX FOR WIFI
		//driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Kaushik");
		//pdp.TypeWifiEditbox(name);
		pdp.TypeWifiEditbox(h.get("wifiname"));
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Typed on Wifi Edit box - ",ExtentColor.BLUE));
		
		//Stepwise screenshot
		u.StepScreenshot("TypedWifiEditbox");
		
		//Wait for the OK BUTTON to have an text with value of "OK"
		wait.until(ExpectedConditions.textToBePresentInElementLocated(AppiumBy.id("android:id/button1"), "OK"));
				
		//Assert the text "OK" for Ok button
		//Purposely failing the OK text assertion
		u.AssertTextAndroid("HI", "id", "android:id/button1", "OK text is not found");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion passed for OK button",ExtentColor.GREEN));
		
		//Click on OK BUTTON
		//driver.findElement(AppiumBy.xpath("//android.widget.Button[@index = '1']")).click();
		pdp.ClickWifiOkButton();
		
		logger.log(Status.INFO, MarkupHelper.createLabel("Clicked on OK button",ExtentColor.BLUE));

		
		
		//Stepwise screenshot
		u.StepScreenshot("ClickedOkButton");
		
		//Click on BACK button of Mobile
		//driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		u.PressBack();
		
		//Stepwise screenshot
		u.StepScreenshot("ClickedBackButtonOnce");
		
		//Click on BACK button of Mobile
		//driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		u.PressBack();
		
		//Stepwise screenshot
		u.StepScreenshot("ClickedBackButtonTwice");
		
		
		
		
		
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
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-- Api Demo Wifi Settings  Test case Failed", ExtentColor.RED));
			//Add the exception name on assertion failure to the log
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "-- Api Demo  Wifi Settings Test case Failed", ExtentColor.RED));
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
