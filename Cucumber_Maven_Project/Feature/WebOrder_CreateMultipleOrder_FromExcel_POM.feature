#Author: Abhi
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
@sanity
Feature: To Test Web Order Create Order Functionality

  Background: Successful Login with Valid Credentials in WebOrder application
    Given User has Launched Edge Browser
    When User Navigate to Sign In Page of WebOrder Application
    And User enters valid username and password in weborder login page
    And User Click on Login button in from weborder login page
    Then User should be logged in and List of All Orders page should display

  Scenario Outline: Create Order with multiple positive and negative scenarios
    And User Clicks on Order link in All Order Page
    And User enters order data from "<SheetName>" and <RowNumber> into Create Order page
    Then User should should get proper expect result from "<SheetName>" and <RowNumber> after click Process button

    Examples: With Multiple Data
      | SheetName | RowNumber |
      | Sheet1    |         0 |
      | Sheet1    |         1 |
      | Sheet1    |         2 |
      | Sheet1    |         3 |
      | Sheet1    |         4 |
      | Sheet1    |         5 |
      | Sheet1    |         6 |
      | Sheet1    |         7 |
      | Sheet1    |         8 |
      | Sheet1    |         9 |
      | Sheet1    |        10 |
      | Sheet1    |        11 |
      | Sheet1    |        12 |
