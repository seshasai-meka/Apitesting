package com.fdmgroup.stepdefinitions;


import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Managers;
import com.fdmgroup.pojos.Staff;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ManagerLogic {
	
	public static Response updateStaffsUnderManager(String managerId, List<Staff> newStaffList) {

        Managers updatedManager = new Managers();
        updatedManager.setStaffs(newStaffList);

        return given()
                    .contentType(ContentType.JSON)
                    .body(updatedManager)
                    .log().all()
               .when()
                    .patch("/managers/" + managerId)
               .then()
                    .log().all()
                    .extract().response();
    }
	
	
	public static Response getManagerById(String managerId) {
        return given()
                    .contentType(ContentType.JSON)
                    .log().all()
               .when()
                    .get("/managers?id=" + managerId)
               .then()
                    .log().all()
                    .extract().response();
    }
	
	
	public static Response deleteStaffUnderManager(String managerId, int staffId) {
		
		Response getResponse = getManagerById(managerId);
	    Managers manager = getResponse.jsonPath().getList("", Managers.class).get(0);

	    
	    List<Staff> updatedStaffs = new ArrayList<>();
	    for (Staff staff : manager.getStaffs()) {
	        if (staff.getId() != staffId) {
	            updatedStaffs.add(staff);
	        }
	    }


	    Managers updatedManager = new Managers();
	    updatedManager.setStaffs(updatedStaffs);

	    return given()
	                .contentType(ContentType.JSON)
	                .body(updatedManager)
	                .log().all()
	           .when()
	                .patch("/managers/" + managerId)
	           .then()
	                .log().all()
	                .extract().response();
	}

	

}
