# Author: Seshasai
# Date: 30th Oct 2025

Feature: As a user I want to manage staff members under managers by updating and deleting their details

  Background:
    Given the API is running

  Scenario: As an user, I want to be able to update list of the staffs based on managers id and verify them
    When user updates the list of staffs for manager with id "1"
    Then user should be able to verify all staffs are updated for that manager

  Scenario: As an user, I want to be able to delete a staff based on staffs id with one manager and count them 
    When user deletes the staff with id 2 under manager "1"
    Then user should be able to verify the remaining staff count under that manager
