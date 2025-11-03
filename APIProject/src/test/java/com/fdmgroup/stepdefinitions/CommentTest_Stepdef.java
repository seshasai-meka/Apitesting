package com.fdmgroup.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import com.fdmgroup.pojos.Comments;

import static org.hamcrest.Matchers.anyOf;


public class CommentTest_Stepdef {
	
	
    private Response response;

	
	

@When("user creates a new comment with Id {string}, userId {int}, body {string} and foodId {int}")
public void user_creates_a_new_comment_with_id_user_id_body_and_food_id(String id, int userId, String body, int foodId) {
   
	response=CommentLogic.performPOSTFoodItem(id, userId, body, foodId);
	
	
}

@Then("user should be able to see the comment created successfully")
public void user_should_be_able_to_see_the_comment_created_successfully() {
    
	assertThat(response.statusCode(), is(201));
	
	assertThat(response.jsonPath().getInt("userid"), is(7));
	assertThat(response.jsonPath().getString("body"), is("worst"));
	assertThat(response.jsonPath().getString("id"), is("7"));
	assertThat(response.jsonPath().getInt("foodId"), is(7));
	
}

@When("user deletes the comment with Id {string}")
public void user_deletes_the_comment_with_id(String id) {
    
	response = CommentLogic.deleteCommentById(id);
	
}

@Then("user should not be able to see the comment anymore")
public void user_should_not_be_able_to_see_the_comment_anymore() {
	
	
    assertThat(response.statusCode(), anyOf(is(200), is(204)));
	assertThat(response.jsonPath().getString("body"), is("worst"));

}

@When("user retrieves the comment using userId {int} and foodId {int}")
public void user_retrieves_the_comment_using_user_id_and_food_id(int userId, int foodId) {
   
    response = CommentLogic.getCommentByUserAndFood(userId, foodId);
	
}

@Then("user should be able to see the comment body {string}")
public void user_should_be_able_to_see_the_comment_body(String body) {
	
    assertThat(response.jsonPath().getString("[0].body"), is(body));
}


}
