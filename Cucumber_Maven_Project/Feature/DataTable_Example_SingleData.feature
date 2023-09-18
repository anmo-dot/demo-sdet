#Author: Abhinay Dixit
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: To Test Flight Login Action

Scenario: To Successful Login with Valid Credentials
	Given User is on OrangeHRM Home Page
	When User Navigate to Log-in Page of OrangeHRM
	And User enters valid credential
#With Single Data
	| Admin | admin123 |
	Then User should be in Dashboard page.