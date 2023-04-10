Feature: Register feature test suite


  Scenario: Register Page URL is accessible from Home Page
    Given "https://demo.opencart.com/" is accessed
    When My account button is clicked
    And Register button is clicked
    Then "register" is present within current url