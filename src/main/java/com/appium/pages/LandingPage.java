package com.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	//Keep all the elements of this  with their location and action here
	
	public AppiumDriver driver;
	
	public LandingPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	//Locator for Preference
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Preference']")
	public WebElement PreferenceElement;
	
	//Locator for VIEWS
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Views\")")
	public WebElement ViewsElement;		
	
	//Action on Preference 
	public void ClickPreference() {
		PreferenceElement.click();
	}
	
	//Action on Views 
	public void ClickViews() {
		ViewsElement.click();
	}
}
