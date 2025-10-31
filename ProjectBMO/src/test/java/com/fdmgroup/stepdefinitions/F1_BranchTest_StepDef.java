package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F1_BranchTest_StepDef {
	


@Given("User is in the home page")
public void user_is_in_the_home_page() throws InterruptedException {
	
	Hooks.driver.navigate().to(DataFile.loginURL);
	
	//handling the cookies 
	Hooks.loginPage.clickAccept();

}

@When("Click on the branch locator")
public void click_on_the_branch_locator() throws InterruptedException  {
   
	assertTrue(Hooks.loginPage.isBranchLocatorClickable());	
	Hooks.loginPage.clickBranchLocatorButton();
}


@Then("User is able to see Branch Locator page")
public void user_is_able_to_see_branch_locator_page() {
	
	
	assertEquals(DataFile.branchPageName,Hooks.branchPage.getBranchPageName());
}

@Then("User enters {string} details")
public void user_enters_details(String string) throws InterruptedException {
   
	Hooks.branchPage.enterAddressEntry(string);
	
}


@Then("User should be able to see the error message {string}")
public void user_should_be_able_to_see_the_error_message(String string) {
   
	assertEquals(string , Hooks.branchPage.getErrorAlert());
	
}

@Then("Nearby Branches should be visible")
public void nearby_branches_should_be_visible() {
    
	assertTrue(Hooks.branchPage.branchesVisible());
	
	//Hooks.branchPage.printAllBranches();
	
	
}



}
