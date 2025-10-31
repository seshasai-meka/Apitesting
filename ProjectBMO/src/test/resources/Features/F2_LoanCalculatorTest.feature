# Author : Seshasai
# Date : 24 oct, 2025


Feature: As a user I want to test the loan calculator is working properly


	Background:
	
	 Given User is in the BMO Loan calculator page
	 
Scenario Outline: User should be able to calculate with valid input values

    When the user enters loan amount "<Amount>"
    And the user enters interest rate "<Interest>"
    And the user selects payment frequency "<Frequency>"
    And the user selects amortization "<Amortization>"
    Then an estimated payment is displayed
    And User estimated payment matches the value of "<Expected>"

  Examples:
    | Amount  | Interest | Frequency | Amortization | Expected |
    | 2000.00 | 10%      | Weekly    | 10 years     | $6       |
    | 3000.00 | 8%       | Monthly   | 5 years      | $61      |
    | 5000.00 | 12%      | Bi-Weekly | 3 years      | $166      |

    
    
    
  Scenario: User should see validation messages for invalid input values

  
    When the user enters loan amount "20002000"
    And the user enters interest rate "500%"
    Then a validation message "Enter an amount between $2,000 and $9,999,999." should be displayed
    And a validation message "Please enter a value between 0% and 100%." should be displayed	
   	
   

    


