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
    And User Click on Login Button in from weborder login page
    Then User should be logged in and List of All Orders page should display

  Scenario Outline: Create Order with multiple positive and negative scenarios
    And User Clicks on Order link in TestComplete
    #And User enters quantity, customer name, street, city, zip, card, card number, expire date in TestComplete
    And User enters "<Quantity>", "<Name>", "<Street>", "<City>", "<Zip>", "<Card>", "<CardNr>" and "<Date>" in create order page
    And User Click on Process Button in TestComplete
    Then User should should get proper "<ExpResult>" after click Process button

    Examples: With Multiple Data
      | Quantity | Name | Street          | City   | Zip   | Card | CardNr    | Date   | ExpResult        |
      |        5 | Minh | 123 Main Street | Dallas | 75000 | Visa | 123456789 | 12/23  | valid            |
      |          | Minh | 123 Main Street | Dallas | 75000 | Visa | 123456789 | 12/23  | empty_quantity   |
      |        0 | Minh | 123 Main Street | Dallas | 75000 | Visa | 123456789 | 12/23  | invalid_quantity |
      |        5 |      | 123 Main Street | Dallas | 75000 | Visa | 123456789 | 12/23  | empty_name       |
      |        5 | Minh |                 | Dallas | 75000 | Visa | 123456789 | 12/23  | empty_street     |
      |        5 | Minh | 123 Main Street |        | 75000 | Visa | 123456789 | 12/23  | empty_city       |
      |        5 | Minh | 123 Main Street | Dallas |       | Visa | 123456789 | 12/23  | empty_zip        |
      |        5 | Minh | 123 Main Street | Dallas | abcde | Visa | 123456789 | 12/23  | invalid_zip      |
      |        5 | Minh | 123 Main Street | Dallas | 75000 |      | 123456789 | 12/23  | empty_card       |
      |        5 | Minh | 123 Main Street | Dallas | 75000 | Visa |           | 12/23  | empty_cardnr     |
      |        5 | Minh | 123 Main Street | Dallas | 75000 | Visa | 123456789 |        | empty_expdate    |
      |        5 | Minh | 123 Main Street | Dallas | 75000 | Visa | 123456789 | abcdef | invalid_date     |
      |        5 | Minh | 123 Main Street | Dallas | 75000 | Visa | 123456789 | 12-23  | invalid_date     |
