package com.fdmgroup.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.pojos.Managers;
import com.fdmgroup.pojos.Staff;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;

import static org.hamcrest.Matchers.hasSize;


public class ManagerTest_Stepdef {
	
	private Response response;
	

@When("user updates the list of staffs for manager with id {string}")
public void user_updates_the_list_of_staffs_for_manager_with_id(String managerId) {
	
	List<Staff> updatedStaffs = new ArrayList<>();
    updatedStaffs.add(new Staff(0, "sai", 600));
    updatedStaffs.add(new Staff(1, "meka", 400));
    updatedStaffs.add(new Staff(2, "tarak", 500));

    response = ManagerLogic.updateStaffsUnderManager(managerId, updatedStaffs);
   
}

@Then("user should be able to verify all staffs are updated for that manager")
public void user_should_be_able_to_verify_all_staffs_are_updated_for_that_manager() {
   
	
    assertThat(response.statusCode(), anyOf(is(200), is(204)));

    Managers manager = response.as(Managers.class);
    
    List<Staff> staffList = manager.getStaffs();
    assertThat(staffList, hasSize(3));
    assertThat(staffList.get(0).getName(), is("sai"));

    
}

@When("user deletes the staff with id {int} under manager {string}")
public void user_deletes_the_staff_with_id_under_manager(Integer staffId, String managerId) {
    response = ManagerLogic.deleteStaffUnderManager(managerId, staffId);

}

@Then("user should be able to verify the remaining staff count under that manager")
public void user_should_be_able_to_verify_the_remaining_staff_count_under_that_manager() {
	
    assertThat(response.statusCode(), anyOf(is(200), is(204)));
    
    Managers manager = response.as(Managers.class);
    
    List<Staff> staffList = manager.getStaffs();
    assertThat(staffList, hasSize(2));
    
}


}


