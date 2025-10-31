package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.stepdefinitions.Hooks;

import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath=("//*[text()='Branch locator']"))
	public WebElement branchLocatorButton;
	
	
	
	@FindBy(xpath="//button[contains(text(),'Accept')]")
	private WebElement acceptButton;
	


	public void clickAccept() {
			wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
	}
	
	
	public void clickBranchLocatorButton() {
		//  scroll the element into view 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", branchLocatorButton);
		
		wait.until(ExpectedConditions.visibilityOf(branchLocatorButton));

		js.executeScript("arguments[0].click();", branchLocatorButton);
		
		
	}
	
	public boolean isBranchLocatorClickable() {
		
		return branchLocatorButton.isEnabled();
	}


	

}
