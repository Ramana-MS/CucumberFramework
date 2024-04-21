Feature: login functionality
  @smoke
  Scenario: Login with valid credentials
    Given User has navigated to login page
    When User enters valid email address "Ramanastvd@gmail.com" into email field
    And User enters valid password "12345" into passwords field
    And User clicks on Login button
    Then User should get successfully logged in
   
  Scenario: Login with invalid credentials
    Given User has navigated to login page
    When User enters invalid email address into email field
    And User enters invalid password "1234534354545" into passwords field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    Given User has navigated to login page
    When User enters valid email address "Ramanast@gmail.com" into email field
    And User enters invalid password "1234534354545" into passwords field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with invalid email and valid password
    Given User has navigated to login page
    When User enters invalid email address into email field
    And User enters valid password "12345" into passwords field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User has navigated to login page
    When User dont enters email address into email field
    And User dont enters password into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
