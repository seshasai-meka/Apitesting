package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanCalculatorPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public LoanCalculatorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	}
	
	@FindBy(id="pers-3flp78PHQGnI09hJlmyFqO-loanAmount-loanAmount")
	private WebElement loanAmount;
	
	@FindBy(id="pers-3flp78PHQGnI09hJlmyFqO-interestRate-interestRate")	
	private WebElement interestRate;
	
	@FindBy(id=":Rcsqksl76:")	
	private WebElement selectFrequency;
	
	
	@FindBy(id=":Rd4qksl76:")
	private WebElement selectAmortization;

	@FindBy(xpath="//div[@class=\"css-9em63n e19lk9qy7\"]")
	private WebElement displayMessage;
	
	@FindBy(xpath="//div[@class=\"css-1tz2h1c e19lk9qy8\"]")
	private WebElement resultMessage;
	
	@FindBy(xpath="//button[contains(text(),'Accept')]")
	private WebElement acceptButton;
	
	
	@FindBy(id="error-pers-3flp78PHQGnI09hJlmyFqO-loanAmount-loanAmount")
	private WebElement loanAmountError;
	
	@FindBy(id="error-pers-3flp78PHQGnI09hJlmyFqO-interestRate-interestRate")
	private WebElement interestRateError;
	
	
	public void clickAccept() {
		wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
}
	
	
	public void locateLoanAmount() throws InterruptedException {
		//  scroll the element into view 
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", loanAmount);
        Thread.sleep(1000);
        
		wait.until(ExpectedConditions.visibilityOf(loanAmount));

		js.executeScript("arguments[0].click();", loanAmount);
		
		
	}

	
	public void enterLoanAmount(String amount) throws InterruptedException {
		loanAmount.isEnabled();
		 try {
		        wait.until(ExpectedConditions.visibilityOf(loanAmount));
		        Thread.sleep(1000);
		        
		        loanAmount.sendKeys(Keys.COMMAND, "a");  
		        
		        loanAmount.sendKeys(Keys.DELETE);

		 } catch (Exception e) {
		    	e.printStackTrace();
		    }
		finally {
			
	        loanAmount.sendKeys(amount);

		}
	}
	
	
	public void enterInterestAmount(String interest) {
		loanAmount.isEnabled();
		 try {
		        wait.until(ExpectedConditions.visibilityOf(interestRate));
		        
		        Thread.sleep(1000);
		        
		        interestRate.sendKeys(Keys.COMMAND, "a");  
		        
		        interestRate.sendKeys(Keys.DELETE);
		        
		       
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		 finally {
			 interestRate.sendKeys(interest);
			 interestRate.sendKeys(Keys.TAB);
		 }
	}
	
	
	public void selectLoanFrequency(String frequency) {
		 try {
		        wait.until(ExpectedConditions.visibilityOf(selectFrequency));
		        
		        Select mySelectFrequency = new Select(selectFrequency);
		        mySelectFrequency.selectByValue(frequency);
		       		         
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		
		
	}
	
	public void selectLoanAmortization(String years) {
		 try {
		        wait.until(ExpectedConditions.visibilityOf(selectAmortization));
		        
		        Select myselectAmortization = new Select(selectAmortization);
		        
		        myselectAmortization.selectByValue(years);
		       		         
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }	
		
	}
	
	
	public boolean MessageDisplayed() {
		
		return displayMessage.isDisplayed();
		
	}
	
	
	public String resultDisplayed() {
		return resultMessage.getText();
	}
	
	
	public boolean isLoanErrorDisplayed() throws InterruptedException {

		loanAmount.sendKeys(Keys.TAB);
	    wait.until(ExpectedConditions.visibilityOf(loanAmountError));
	        
		return loanAmountError.isDisplayed();
		
	}
	
	public boolean isInterestErrorDisplayed() throws InterruptedException {
		
			interestRate.sendKeys(Keys.TAB);

	        wait.until(ExpectedConditions.visibilityOf(interestRateError));
	        
	   
	    	return interestRateError.isDisplayed();
		
	}

}
