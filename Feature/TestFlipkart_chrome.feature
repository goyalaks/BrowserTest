@Feature1
Feature: LogIn Action Test
  Description: This feature will test a LogIn and LogOut functionality

  Scenario: Successful Login with Valid Credentials
  	Given User switch on "chrome"
    When User goes to "flipkart"
    Then User bypass the LogIn Page
    Then User search for "Search for products, brands and more"
    Then User click on criteria
    Then User prints the list of phones
    Then User close the browser
