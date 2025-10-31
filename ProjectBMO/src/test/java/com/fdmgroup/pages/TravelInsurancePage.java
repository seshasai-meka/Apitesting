package com.fdmgroup.pages;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public TravelInsurancePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));	
	}
	
	@FindBy(xpath="//button[contains(text(),'Accept')]")
	private WebElement acceptButton;
	
	
	@FindBy(xpath="//span[contains(text(),'Before you begin')]")
	private WebElement titlePage;
	
	@FindBy(id="q1-yes-input-label")
	private WebElement yesLabel;
	
	@FindBy(id="q1-no-input-label")
	private WebElement noLabel;
	
	@FindBy(xpath="//div[@id= \"invalidCoverage\"]")
	private WebElement infoMessage;
	
	@FindBy(xpath="//button[@id=\"btnFirstStep\"]")
	private WebElement beginButton;
	
	@FindBy(xpath="//span[contains(text(),'Tell us about your trip')]")
	private WebElement tripInfoPagetitle;
	
	
	public void clickAccept() {
		wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
	
}
	
	
	public boolean getTitleText() {
		wait.until(ExpectedConditions.visibilityOf(titlePage));
		return titlePage.isDisplayed();
	}
	
	
	public void clickOption(String option) {
		
		
		if(option.equalsIgnoreCase("Yes")) {
			
			
		    wait.until(ExpectedConditions.elementToBeClickable(yesLabel)).click();
			yesLabel.isEnabled();


		}else if (option.equalsIgnoreCase("No")) {
			
		    wait.until(ExpectedConditions.elementToBeClickable(noLabel)).click();
			noLabel.isEnabled();
	
		}
		
	}
	
	
	public String getWarningDisplayed() {
	    wait.until(ExpectedConditions.visibilityOf(infoMessage));
		infoMessage.isDisplayed();
		return infoMessage.getText();
	}
	
	public void clickBeginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(beginButton)).click();
		
	}
	
	public boolean isTripInfoDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(tripInfoPagetitle));
		return tripInfoPagetitle.isDisplayed();
	}
		

}
