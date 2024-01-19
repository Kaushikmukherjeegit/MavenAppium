package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferencePage {
	
	public AppiumDriver driver;
	
	public PreferencePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	//Locator for Preference Dependencies
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc ='3. Preference dependencies']")
	public WebElement PreferenceDependenciesElement;
	
	//Action for Preference Dependencies
	public void ClickPreferenceDependencies() {
		PreferenceDependenciesElement.click();
	}

}
