package com.fdmgroup.stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Foods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FoodItemLogic {

	
public static Response getAllItems() { 
		
	return given()
            .contentType(ContentType.JSON)
            .log().all()
       .when()
            .get("/foods")
       .then()
            .log().all()
            .extract().response();
		
}

	

public static Response performPOSTFoodItem(String id,String name,double price) {
	
		
	Foods newFood = new Foods(id, name, price);
    return given()
                .contentType(ContentType.JSON)
                .body(newFood)
                .log().all()
           .when()
                .post("/foods")
           .then()
                .log().all()
                .extract().response();
    

}


public static Response updateFoodPrice(String id, double newPrice) {
	
	
    Foods updatedPrice = new Foods();
    updatedPrice.setPrice(newPrice);

    return given()
                .contentType(ContentType.JSON)
                .body(updatedPrice)
           .when()
                .patch("/foods/" + id)
           .then()
           .log().all()
                .extract().response();
}

}
