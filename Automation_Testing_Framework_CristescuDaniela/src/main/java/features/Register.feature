Feature: Register feature test suite


  Scenario: Register Page URL is accessible from Home Page
    Given "https://demo.opencart.com/" is accessed
    When my account button is clicked
    Then register account button is displayed

  Scenario: Register Page is accessible from Home Page
    Given "https://demo.opencart.com/" is accessed
    When my account button is clicked
    And register account button is clicked
    Then the new url contains the following string "register"






