Feature: Register feature test suite

  Background:
    Given "HomePage" is opened

  @Flexible
  Scenario: Register button is displayed on Home Page
    When "myAccountButton" button is clicked
    And "registerButton" button is clicked
    Then the new url contains the following string "register"

  @Flexible
  Scenario Outline: Register page url contains the following <keyword>
    When "myAccountButton" button is clicked
    And "registerButton" button is clicked
    Then the new url contains the following string "<keyword>"
    Examples:
      | keyword          |
      | index            |
      | account/register |

  @FieldValidation @run
  Scenario Outline: Error message is displayed when using invalid <email> email value
    When "myAccountButton" button is clicked
    And "registerButton" button is clicked
    Then "RegisterPage" is opened
    Then the new url contains the following string "register"
    When the register account is populated with below data:
      | firstName | Daniela   |
      | lastName  | Cristescu |
      | email     | <email>   |
      | password  | Eklipse17 |
    And "privacyCheckBox" button is clicked
    And "continueButton" button is clicked
    Then the following errors are displayed on the screen:
      | <error>                                                                           |
      | Warning: Please include an '@' in the email address. '<email>' is missing an '@'. |
    Examples:
      | email      | error                                                                    |
      | @gmail.com | Please include an '@' in the email address. '<email>' is missing an '@'. |

