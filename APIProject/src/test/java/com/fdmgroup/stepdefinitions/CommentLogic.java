package com.fdmgroup.stepdefinitions;

import static io.restassured.RestAssured.given;

import com.fdmgroup.pojos.Comments;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CommentLogic {
	
	
	
	public static Response performPOSTFoodItem(String id,int userId,String body,int foodId) {
		
		
		Comments newComment = new Comments(id, userId, body,foodId);
	    return given()
	                .contentType(ContentType.JSON)
	                .body(newComment)
	                .log().all()
	           .when()
	                .post("/comments")
	           .then()
	                .log().all()
	                .extract().response();

	}
	
	
	public static Response deleteCommentById(String id) {
        return given()
                    .log().all()
               .when()
                    .delete("/comments/" + id)
               .then()
                    .log().all()
                    .extract().response();
    }

	
	
    public static Response getCommentByUserAndFood(int userId, int foodId) {
        return given()
                    .contentType(ContentType.JSON)
                    .queryParam("userid", userId)
                    .queryParam("foodId", foodId)
                    .log().all()
               .when()
                    .get("/comments")
               .then()
                    .log().all()
                    .extract().response();
    }
    
    
	

}
