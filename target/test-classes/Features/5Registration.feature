Feature: Registration and login page functionality

@Priority5
Scenario: Register a new user with data from Excel
Given User is on the registration page
When User enters registration details from Excel row 1
Then User created the account successfully

@Priority6
Scenario: Login with valid credentials from Excel
Given User is on the login page
When User enters login details from Excel row 1
When User recovering password from Excel row 1
Then User redirects to the homepage