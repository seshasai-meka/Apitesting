package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Branch {
	WebDriver driver;
	WebDriverWait wait;
	public Branch(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	}

	@FindBy(xpath = "//input[@class='search-box']")	
	private WebElement addressEntryField;
	
	@FindBy(xpath="//div[@class='errortop']")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//*[@id='hideAreaMobile']//h1")
	private WebElement branchPageName;
	
	@FindBy(xpath = "//ul[@class='content-list poi-result']")
	private WebElement resultList;
	
	
	

	
	
	public boolean branchesVisible() {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(resultList));
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	

	public String getBranchPageName() {
	    WebElement visibleHeader = wait.until(
	        ExpectedConditions.visibilityOf(branchPageName)
	    );
	    return visibleHeader.getText();
	}	
	
	public void enterAddressEntry(String address) throws InterruptedException {
        
        WebElement visibleAddressField = wait.until(
            ExpectedConditions.visibilityOf(addressEntryField)
        );
        Thread.sleep(1000);
        visibleAddressField.clear();
        visibleAddressField.sendKeys(address);
        Thread.sleep(1000);
        visibleAddressField.sendKeys(Keys.ENTER);
    }
	
	public String  getErrorAlert() {
        WebElement errorElement = wait.until(
            ExpectedConditions.visibilityOf(errorMessage)
        );

        return errorElement.getText();
        
    }
	
	// branch names list (checking)*
		@FindBy(xpath = "//ul[@class='content-list poi-result']/li")
		private java.util.List<WebElement> branchItems;
		
		public void printAllBranches() {
		    wait.until(ExpectedConditions.visibilityOfAllElements(branchItems));

		    System.out.println(" Nearby Branches");
		    for (WebElement branch : branchItems) {
		    	
		        System.out.println(branch.getText());
		    }
		}
			
}
