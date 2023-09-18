#Author: Abhi
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
@sanity
Feature: To Test TestComplete Order Functionality

  Background: Successful Login with Valid Credentials in WebOrder application
    Given User has Launched Chrome Browser
    When User Navigate to Sign In Page of WebOrder Application
    And User enters valid username and password in weborder login page
    And User Click on Login Button in from weborder login page
    Then User should be logged in and List of All Orders page should display

  Scenario: Successful Order in TestComplete App
    And User Clicks on Order link in TestComplete
    And User enters quantity, customer name, street, city, zip, card, card number, expire date in TestComplete
    And User Click on Process Button in TestComplete
    Then User should see order success message in TestComplete
