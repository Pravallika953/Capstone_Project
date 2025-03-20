Feature: Search Functionality
@Priority2
Scenario: Automate searching product
Given User in the search page
When User enters "mac" in search bar and clicks the seach button
When User select "Laptops & Notebooks" in sub search categories drop down list
When User select the grid option
Then User select "Price (High > Low)" in sort by drop down list 