package com.fdmgroup.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.Branch;
import com.fdmgroup.pages.LoanCalculatorPage;
import com.fdmgroup.pages.LoginPage;
import com.fdmgroup.pages.TravelInsurancePage;
import com.fdmgroup.util.DriverUtilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

	static DriverUtilities driverUtilities;
	static WebDriver driver;
	static LoginPage loginPage;
	static Branch branchPage;
	static LoanCalculatorPage loanCalPage;
	static TravelInsurancePage travelInsurancePage;
	
	
	@Before
	public void init() {
		
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		
		loginPage = new LoginPage(driver);
		branchPage = new Branch(driver); 
		loanCalPage = new LoanCalculatorPage(driver);
		travelInsurancePage = new TravelInsurancePage(driver);
		
		
		
		driver.manage().window().maximize();
		
	}
	
	@After
	public void tearDown() {
		
		try {
			// Wait 5 seconds before closing the browser
			Thread.sleep(5000); 
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		//driver.quit();

		DriverUtilities.resetDriver();
	}
	
	
}
