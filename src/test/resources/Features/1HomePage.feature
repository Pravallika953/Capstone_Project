Feature: Home Page
@Priority1
Scenario: Verifying major section
Given User is on the Home Page
When User enters "mac" in the search bar
When User clicks the search button
Then User redirected to the search page