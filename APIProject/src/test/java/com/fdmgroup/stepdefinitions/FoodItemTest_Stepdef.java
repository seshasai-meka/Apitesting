package com.fdmgroup.stepdefinitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Foods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.anyOf;

public class FoodItemTest_Stepdef {
	
	private Response response;
	
@Given("the API is running")
public void the_api_is_running() {
	
        RestAssured.baseURI = "http://localhost:3000";
		
}

@When("User sends a GET request to {string}")
public void user_sends_a_get_request_to(String string) {
	
	 response = FoodItemLogic.getAllItems();	

	
}

@Then("User should be able to see all the foods with ID, Name and Price")
public void user_should_be_able_to_see_all_the_foods_with_id_name_and_price() {

	List<Foods> foods = response.jsonPath().getList("",Foods.class);
	assertThat(foods,hasSize(4));
	
	List<String> items = new ArrayList<>();
	
	for(Foods food: foods) {
		items.add(food.getName());
	}
	assertThat(items, containsInAnyOrder("cucumber salad","french fries","soft drink","burgers"));
  
}


@When("user creates a food item with the following details Id {string} , Name {string}, Price {double}")
public void user_creates_a_food_item_with_the_following_details_id_name_price(String id, String name, Double price) {
    
	
	response = FoodItemLogic.performPOSTFoodItem(id, name, price);
	
}

@Then("user should be able to see it successfully")
public void user_should_be_able_to_see_it_successfully() {
	
	assertThat(response.statusCode(), is(201));
	
	assertThat(response.jsonPath().getString("id"), is("5"));
	assertThat(response.jsonPath().getString("name"), is("shawarma"));
	assertThat(response.jsonPath().getDouble("price"), is(9.99));
	

}


@When("user updates the price of food with ID {string} to {double}")
public void user_updates_the_price_of_food_with_id_to(String id, Double price) {
	
	response=FoodItemLogic.updateFoodPrice(id, price);
   
}

@Then("user should be able to see the updated price.")
public void user_should_be_able_to_see_the_updated_price() {
	
	assertThat(response.jsonPath().getDouble("price"), is(5.99));

    assertThat(response.statusCode(), anyOf(is(200), is(204)));
    
   
}
	

}
