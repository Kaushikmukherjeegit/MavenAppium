package com.appium.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {
	
	public static AndroidDriver driver;
	public static File f1;
	
	public static DesiredCapabilities cap;
	public static AppiumServiceBuilder build;
	public static AppiumDriverLocalService server;
	public static Date d;
	
	
	
	public static AndroidDriver InstallInvokeApp( String autName, String platName, String devName, String platVer, String timeout, String uniqueNum) throws MalformedURLException {
		//Settings for the Android Real time Device or Virtual Device to install APK application and/or invoke it
		//1. Define the path of the native App.
		//f1 = new File(System.getProperty("user.dir")+"\\ApiDemos-debug.apk");
		
				
		cap = new DesiredCapabilities();
				
				
		//2.Define the automation name
		cap.setCapability("appium:automationName", autName);
				
		//3. Define the Platform
		cap.setCapability("platformName", platName);
				
		//4. Define the Application path
		cap.setCapability("appium:app", System.getProperty("user.dir")+"\\ApiDemos-debug.apk");
				
		//5. Define the Device name - For Virtual device, THE AVD name. For real time device, get it from ABOUT PHONEs section of SETTINGS
		cap.setCapability("appium:deviceName", devName);

		//6. Define the Android Platform version- For Virtual device, look at settings>about emulated device. For real time device, get it from ABOUT PHONEs section of SETTINGS
		cap.setCapability("appium:platformVersion", platVer);
				
		//7. Define the session timeout between Appium server and device - it is in seconds
		cap.setCapability("appium:newCommandTimeout", timeout);
				
		//8. Define the unique ID of the device
		cap.setCapability("udid", uniqueNum);
				
		//Define the path/url of the Appium server and use Android Driver class to run the settings
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		
		return driver;
	}
	
	//Function to open a specific page of application in Android
	public static AndroidDriver InstallInvokeAppWithActivity( String pacName, String actName, String autName, String platName, String devName, String platVer, String timeout, String uniqueNum) throws MalformedURLException {
		//Settings for the Android Real time Device or Virtual Device to install APK application and/or invoke it
		
		
		cap = new DesiredCapabilities();
				
				
		//2.Define the automation name
		cap.setCapability("appium:automationName", autName);
				
		//3. Define the Platform
		cap.setCapability("platformName", platName);
				
		//4. Define the Application path
		cap.setCapability("appium:app", System.getProperty("user.dir")+"\\ApiDemos-debug.apk");
				
		//5. Define the Device name - For Virtual device, THE AVD name. For real time device, get it from ABOUT PHONEs section of SETTINGS
		cap.setCapability("appium:deviceName", devName);

		//6. Define the Android Platform version- For Virtual device, look at settings>about emulated device. For real time device, get it from ABOUT PHONEs section of SETTINGS
		cap.setCapability("appium:platformVersion", platVer);
				
		//7. Define the session timeout between Appium server and device - it is in seconds
		cap.setCapability("appium:newCommandTimeout", timeout);
				
		//8. Define the unique ID of the device
		cap.setCapability("udid", uniqueNum);
		
		//9. Define the package name of the application
		cap.setCapability("appPackage", pacName);
		
		//9. Define the activity name of the application
		cap.setCapability("appActivity", actName);
		
				
		//Define the path/url of the Appium server and use Android Driver class to run the settings
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
		
		return driver;
	}
	
	//	Programmatically run the Appium server
	
	//Function to create Appium Server instance
		public static void SetInstance() throws FileNotFoundException {
			d = new Date();
			String dat = d.toString().replace(" ", "_").replace(":", "_");
			
			build = new AppiumServiceBuilder();
			// Build the configuration on AppiumJS
			build.withAppiumJS(new File("C:\\Users\\kaush\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.usingDriverExecutable(new File ("C:\\Program Files\\nodejs\\node.exe"))
			.usingPort(4723)
			.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
			.withArgument(GeneralServerFlag.LOG_LEVEL, "info:debug")
            .withArgument(GeneralServerFlag.ALLOW_INSECURE, "adb_shell")
            .withArgument(GeneralServerFlag.RELAXED_SECURITY)
            .withArgument(GeneralServerFlag.USE_PLUGINS, "images")
            .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
			.withLogFile(new File(System.getProperty("user.dir")+"\\AppiumServerLog\\logAppium_"+dat+".log"))
			.withIPAddress("127.0.0.1");
			
				
			//Pass the configuration of Appium server in Appium Local Service 
			server = AppiumDriverLocalService.buildService(build);
				
			
					
		}
		
		//Function to get the server instance
		public static AppiumDriverLocalService getInstance() throws FileNotFoundException {
			if(server ==  null) {
				SetInstance();
			}
			return server;
				
		}
		
		//Function to Start the server
		public static void StartServer() throws AppiumServerHasNotBeenStartedLocallyException, FileNotFoundException {
			getInstance().start();
				
		}
			
		//Function to Stop the server
		public static void StopServer() throws FileNotFoundException {

			if(server !=  null) {
				getInstance().stop();
			}
			System.out.println("Appium Server Stopped");
		}
		
		//Function to start and stop emulator
		//Start the emulator
		public static void StartEmulator() {
					
			String[] command = {"cmd.exe", "/C", "Start", "C:\\Users\\kaush\\OneDrive\\Desktop\\IBM_Appium_16012024\\Workspace_Appium\\AppiumAndroidNativeMaven\\src\\main\\java\\com\\appium\\config\\StartEmulator.bat"};
		          
			try {
				Process p =  Runtime.getRuntime().exec(command);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
				
		//Start the emulator
		public static void StopEmulator() {
							
			String[] command = {"cmd.exe", "/C", "Start", "C:\\Users\\kaush\\OneDrive\\Desktop\\IBM_Appium_16012024\\Workspace_Appium\\AppiumAndroidNativeMaven\\src\\main\\java\\com\\appium\\config\\StopEmulator.bat"};
				          
			try {
				Process p =  Runtime.getRuntime().exec(command);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
	

}
