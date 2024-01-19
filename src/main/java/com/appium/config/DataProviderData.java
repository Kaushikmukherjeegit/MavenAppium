package com.appium.config;

import org.testng.annotations.DataProvider;

import com.appium.utilities.ExcelFunction;
import com.appium.utilities.Xls_Reader;

public class DataProviderData {
	
	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\appium\\config\\TestData.xlsx");
	
	@DataProvider(name = "DataWifiSettings")
	public Object[][] DataWifiSettings(){
		
		// We want to run Wifi Settings 3 times, then define 3 as row size
		//In Wifi Settings test case , we provide data at one point i.e. when we type on Wifi Edit box - 1 point means  column size is 1
		
//		Object[][] obj = new Object[3][1];
//		
//		//First Run
//		obj[0][0]  = "Kaushik";
//		
//		//Second Run
//		obj[1][0]  = "Sam";
//		
//		//Second Run
//		obj[2][0]  = "Robert";
//		
//		return obj;
		
		return ExcelFunction.ReadExcel("WifiSettingsTest", xls);
		
	}
	
	@DataProvider(name = "DataDateWidget")
	public Object[][] DataDateWidget(){
		
		
		return ExcelFunction.ReadExcel("DataWidgetsPageActivityPackageTest", xls);
		
	}


}
