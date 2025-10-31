package com.fdmgroup.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {
	
	//using singleton design pattern
	// we need private static instance and 
	//private constructor and static getInstance()
	
	
	private static DriverUtilities driverUtilities;
	
	private WebDriver driver;
	
	private  DriverUtilities() {
		
		super();
	}
	
	public static DriverUtilities getInstance() {
		
		if (driverUtilities == null) {
			
			driverUtilities = new DriverUtilities();
		}
		
		return driverUtilities;
		
	}
	
	
	public static void resetDriver() {
		driverUtilities.driver.quit();
		driverUtilities.driver = null;
		driverUtilities = null;
	}
	
	
	public WebDriver getDriver() {
		if (driver==null) {
			createDriver();
		}
		return driver;
	}

	private void createDriver() {
		
		String driverName = getDriverName();
		
		switch(driverName) {
		case "Chrome":
			this.driver=new ChromeDriver();
			break;
			
		case "Firefox":
			this.driver=new FirefoxDriver(); 
			break;
			
		case "Edge":
			this.driver=new EdgeDriver(); 
			break;
			
		default:
			break;
			
		}
		
		
	}

	private String getDriverName() {
		
		//this method returns the browser that we are going to use 
		
		
		Properties config = new Properties();
		
		try {
			config.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return config.getProperty("browser");
 
	}
	
	
}



