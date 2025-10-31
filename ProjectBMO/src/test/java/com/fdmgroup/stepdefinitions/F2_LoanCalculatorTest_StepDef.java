package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F2_LoanCalculatorTest_StepDef {
	
	@Given("User is in the BMO Loan calculator page")
	public void user_is_in_the_bmo_loan_calculator_page() throws InterruptedException {
	   
		Hooks.driver.navigate().to(DataFile.loanPageURL);
		Hooks.loginPage.clickAccept();
		Thread.sleep(2000);

		
	}

	@When("the user enters loan amount {string}")
	public void the_user_enters_loan_amount(String amount) throws InterruptedException {
		
		Thread.sleep(1000);
		Hooks.loanCalPage.locateLoanAmount();
	    
		Hooks.loanCalPage.enterLoanAmount(amount);
		
	}

	@When("the user enters interest rate {string}")
	public void the_user_enters_interest_rate(String interest) throws InterruptedException {
		//Thread.sleep(2000);
	    
		Hooks.loanCalPage.enterInterestAmount(interest);
		
	}

	@When("the user selects payment frequency {string}")
	public void the_user_selects_payment_frequency(String frequency) {
	    
		Hooks.loanCalPage.selectLoanFrequency(frequency);
	}

	@When("the user selects amortization {string}")
	public void the_user_selects_amortization(String years) {
	    
		Hooks.loanCalPage.selectLoanAmortization(years);
	
	}

	@Then("an estimated payment is displayed")
	public void an_estimated_payment_is_displayed() {
	   
		assertTrue(Hooks.loanCalPage.MessageDisplayed());
		
		
	}

	@Then("User estimated payment matches the value of {string}")
	public void user_estimated_payment_matches_the_value_of(String result) {
	   
		assertEquals(result,Hooks.loanCalPage.resultDisplayed());
		
	}
	
	
	@Then("a validation message {string} should be displayed")
	public void a_validation_message_should_be_displayed(String string) throws InterruptedException {
	   
		assertTrue(Hooks.loanCalPage.isLoanErrorDisplayed());
		
		assertTrue(Hooks.loanCalPage.isInterestErrorDisplayed());
		Hooks.loanCalPage.selectLoanFrequency("5 years");

	}

	

}
