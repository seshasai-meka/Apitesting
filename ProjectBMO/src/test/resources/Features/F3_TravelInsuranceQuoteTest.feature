# Author : Seshasai
# Date   : 24 Oct 2025

Feature: As an User I want to get the Travel Insurance Quote

  Background:
    Given the user is on the BMO Travel Insurance Quote page
    And Before you begin Page appears

  Scenario: User selects "Yes" for the existing quote and gets warning message
    When User selects existing insurance option "Yes"
    Then a warning message "This coverage might not be appropriate for you, please call 1-800-661-9060 for further assistance." should be displayed

  Scenario: User selects "No" and verifies navigation to Trip Information page
    When User selects existing insurance option "No"
    And clicks on "LET'S BEGIN" button
    Then the trip information form should be displayed

    
