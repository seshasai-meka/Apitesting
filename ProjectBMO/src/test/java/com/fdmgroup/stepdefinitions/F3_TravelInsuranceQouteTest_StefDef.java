package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F3_TravelInsuranceQouteTest_StefDef {
	

@Given("the user is on the BMO Travel Insurance Quote page")
public void the_user_is_on_the_bmo_travel_insurance_quote_page() throws InterruptedException {
    
	 
	Hooks.driver.navigate().to(DataFile.travelQuotePageURL);
	Hooks.travelInsurancePage.clickAccept();
	Thread.sleep(2000);
	
}



@Given("Before you begin Page appears")
public void before_you_begin_page_appears() {
   
	assertTrue(Hooks.travelInsurancePage.getTitleText());
	
}

@When("User selects existing insurance option {string}")
public void user_selects_existing_insurance_option(String option) {
    
	Hooks.travelInsurancePage.clickOption(option);
}

@Then("a warning message {string} should be displayed")
public void a_warning_message_should_be_displayed(String string) {
   
	assertEquals(string, Hooks.travelInsurancePage.getWarningDisplayed());
	
}

@When("clicks on {string} button")
public void clicks_on_button(String string) {
   
	Hooks.travelInsurancePage.clickBeginButton();
	
}

@Then("the trip information form should be displayed")
public void the_trip_information_form_should_be_displayed() {
	
	assertTrue(Hooks.travelInsurancePage.isTripInfoDisplayed());	
}	

}
