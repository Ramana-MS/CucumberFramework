Feature: Registration functionality
     @smoke
  Scenario: User creates an account only with credentials
    Given User navigates to Register Account page
    When User enters the details into below fields
      | firstName | V                     |
      | lastName  | Ramana                |
      | telephone | 1234567890            |
      | password  | 12345                 |
    And User selects Privacy Policy
    And User Clicks on Continue button
    Then User should get created successfully

  Scenario: User creates an account only with all credentials
    Given User navigates to Register Account page
    When User enters the details into below fields
      | firstName | V                     |
      | lastName  | Ramana                |
      | telephone | 1234567890            |
      | password  | 12345                 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User Clicks on Continue button
    Then User should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Register Account page
    When User enters the details into below fields with duplicate email
      | firstName | V                     |
      | lastName  | Ramana                |
      | email     | Ramanastvd@gmail.com  |
      | telephone | 1234567890            |
      | password  | 12345                 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User Clicks on Continue button
    Then User should get a proper warning about duplicate email

  Scenario: User creates an account without filling any details
    Given User navigates to Register Account page
    When User dont enter any details into fields
    And User Clicks on Continue button
    Then User should get a proper warning messages for every mandatory field
