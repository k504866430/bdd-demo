Feature: Payments
	As a customer
	In order to buy clothes
	I must be able to pay using credit card
	
	Background: I have "checked out" clothing items worth "200" dollars 
	
	Scenario: Credit card payment option
	When I visit the "payment" page
	Then I should be able to select "Credit Card" from payment options
	
	Scenario: Credit card information
	When I select "Credit Card" from payment options
	Then I should be able to select "Credit Card Type"
	And I should be able to input "Credit Card Number"
	And I should be able to input "Billing Address"
	
	Scenario: Credit card validation failed
	Given I have selected "Credit Card" from payment options
	When I select "VISA" "Credit Card Type"
	And I input "4111 1111 1111-1121" "Credit Card Number"
	Then I should see "Incorrect Format" message
	When I input "4111 1111 1111-11i1" "Credit Card Number"
	Then I should not see "Incorrect Format" message
	
	Scenario: Process payment
	Given I have selected "Credit Card" from payment options
	When I select "VISA" "Credit Card Type"
	And I input "4111 1111 1111-1111" "Credit Card Number"
	And I input "11121 Saffold Way, Reston VA 20190" "Billing Address"
	And I click "Confirm"
	Then I should see "Payment Processing successful" message