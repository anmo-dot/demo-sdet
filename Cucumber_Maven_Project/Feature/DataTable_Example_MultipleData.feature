#Author: Abhinay Dixit
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: To Test WeBorder Login functionality with multiple value

  Scenario Outline: Successful Login with multiple Valid Credentials
    #Scenario: Successful Login with Valid Credentials
    Given User has Launched Chrome Browser
    When User Navigate to Sign In Page of WebOrder Application
    When User enters "<Username>" and "<Password>"
    And User Click on Login Button in from weborder login page
    Then User should get proper "<ExpResult>"

    Examples: With Multiple Data
      | Username | Password | ExpResult                  |
      | Tester   | test1    | Invalid Login or Password. |
      | Tester1  | test     | Invalid Login or Password. |
      |          | test     | Invalid Login or Password. |
      | Tester   |          | Invalid Login or Password. |
      | Tester   | test     | Logout                     |
