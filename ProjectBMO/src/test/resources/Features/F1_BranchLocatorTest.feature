#Author: Seshasai
#Date: 23, Oct 2025.



Feature: As a user I want to see the branches from the mentioned address


	Background:
		Given User is in the home page
		When Click on the branch locator
		Then User is able to see Branch Locator page 
		

	Scenario Outline: User should not be able to locate the branches with invalid details
		
		And User enters "<Invalid>" details
		And User should be able to see the error message "We came up empty! Double-check your spelling, or try adding a city, province or postal code."
		
		Examples:
		
			|Invalid|
			|suduai |
			|star129|
			|y3492d |
		
	Scenario Outline: User should be able to provide valid address
		
		When User enters "<Valid>" details
		Then Nearby Branches should be visible
	
	Examples:

		|Valid  |
		|Toronto|
		|Scarborough|
	
		