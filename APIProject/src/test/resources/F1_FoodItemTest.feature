#Author : Seshasai

#Date : 29th oct 2025

Feature: As an user I want to manage the food items by getting, creating and updating the items 


Background:
		Given the API is running 
	

Scenario: As an user I want to see all the food Items with ID,name and price

	When User sends a GET request to "/foods"
	Then User should be able to see all the foods with ID, Name and Price
	
Scenario: As an user I want to create a  new item  and verify it
	
	When user creates a food item with the following details Id "5" , Name "shawarma", Price 9.99
	Then user should be able to see it successfully
	
Scenario: As an user I want to update the price of an Item and verify it

	When user updates the price of food with ID "5" to 5.99
	Then user should be able to see the updated price.
	
	
	