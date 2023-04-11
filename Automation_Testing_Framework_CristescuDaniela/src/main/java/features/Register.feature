@run
Feature: Register feature test suite

  Background:
    Given "https://demo.opencart.com/" is accessed

  @run
  Scenario: Register Page URL is accessible from Home Page
    When My account button is clicked
    And Register button is clicked
    Then "register" is present within current url

  Scenario Outline: Register page url contains the following <keyword>
    When My account button is clicked
    And Register button is clicked
    Then "<keyword>" is present within current url
    Examples:
      | keyword          |
      | index            |
      | account/register |

