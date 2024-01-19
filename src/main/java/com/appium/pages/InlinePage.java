package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InlinePage {
	
	public AppiumDriver driver;
	public Actions act;
	
	public InlinePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	//Locator for 12 hour		
	@AndroidFindBy(uiAutomator="new UiSelector().index(11)")
	public WebElement TwelvehourElement;
	
	//Locator for 9 hour
	@AndroidFindBy(xpath="//*[@index = '8']")
	public WebElement NinehourElement;
	
	//Locator for 30 min
	@AndroidFindBy(xpath="//*[@content-desc = '30']")
	public WebElement ThirtyMinElement;
	
	//Locator for AM
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"android:id/am_label\")")
	public WebElement AMElement;
	
	
	//Action to move from 12 hour to 9 hour
	public void MovementTwelveToNine() {
		act = new Actions(driver);
		act.dragAndDrop(TwelvehourElement, NinehourElement).build().perform();
	}
	
	//Action to click on 30 Min
	public void ClickThirtyMin() {
		act = new Actions(driver);
		act.click(ThirtyMinElement).build().perform();
	}
	
	//Action to click on AM
	public void ClickAM() {
		AMElement.click();
	}
		
}
