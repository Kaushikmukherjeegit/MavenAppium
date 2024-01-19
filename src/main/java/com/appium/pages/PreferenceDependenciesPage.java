package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependenciesPage {
	public AppiumDriver driver;
	
	public PreferenceDependenciesPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	//Locator for WifiCheckbox
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement WifiCheckboxElement;
			
	//Locator for WifiCheckbox	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='WiFi settings']")
	public WebElement WifiSettings;
	
	//Locator for Wifi Edit box	
	@AndroidFindBy(id = "android:id/edit")
	public WebElement WifiEditBox;	
	
	//Locator for Wifi Ok Button	
	@AndroidFindBy(xpath = "//android.widget.Button[@index = '1']")
	public WebElement WifiOkButton;	
	
	
	
	//Action on Wifi Checkbox
	public void ClickWifiCheckbox() {
		WifiCheckboxElement.click();
	}
	
	//Action on Wifi Settings
	public void ClickWifiSettings() {
		WifiSettings.click();
	}
	
	//Action on Wifi EditBox
	public void TypeWifiEditbox(String chars) {
		WifiEditBox.sendKeys(chars);
	}
	
	//Action on Wifi Ok button
	public void ClickWifiOkButton() {
		WifiOkButton.click();
	}
	
}
