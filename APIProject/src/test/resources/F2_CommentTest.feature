# Author: Seshasai
# Date: 29th Oct 2025

Feature: As a user I want to manage comments by creating, retrieving, and deleting them

  Background:
    Given the API is running

  Scenario: As an user, I want to create a new comment with foodId and verify it.
    When user creates a new comment with Id "7", userId 7, body "worst" and foodId 7
    Then user should be able to see the comment created successfully

  Scenario: As an user, I want to be able to delete the comment with Id 
    When user deletes the comment with Id "7"
    Then user should not be able to see the comment anymore

  Scenario: As an user, I want to get the comment information with user and food ids and verify it with body of the comment
    When user retrieves the comment using userId 1 and foodId 4
    Then user should be able to see the comment body "amazing"
