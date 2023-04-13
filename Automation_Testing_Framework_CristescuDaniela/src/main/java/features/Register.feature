@run
Feature: Register feature test suite

  Background:
    Given "https://demo.opencart.com/" is accessed

  @run
  Scenario: Register Page URL is accessible from Home Page
    When my account button is clicked
    And  register account button is clicked
    Then the new url contains the following string "register"
    
  Scenario Outline: Register page url contains the following <keyword>
    When my account button is clicked
    And register account button is clicked
    Then the new url contains the following string "<keyword>"
    Examples:
      | keyword          |
      | index            |
      | account/register |

