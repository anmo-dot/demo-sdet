#Author: Abhi
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#@E2E @smoke
Feature: To Test Spree Sign In and Sign-out Functionality

  Scenario: Successful Login with Valid Credentials in Spree application
    Given User has Launched Edge Browser
    When User Navigate to Sign In Page of Spree Application
    And User enters valid username and password in Spree login page
    And User Click on Login Button in from Spree login page
    Then User should be logged in and My Account page should display

  Scenario: Successful LogOut from Spree Application
    When User click on Logout link from the account page of Spree
    Then user should be taken back to home page of Spree.
