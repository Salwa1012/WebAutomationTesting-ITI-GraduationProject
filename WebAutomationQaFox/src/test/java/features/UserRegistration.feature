
Feature: User Registration
  As a user, I want to register on the website so that I can create an account.

  Scenario Outline: Successful User Registration
    Given the user is on the home page
    When the user clicks on "Account" and selects "Register"
    And user fills in the registration form with email "<firstname>", "<lastname>", "<telephone>", "<password>"
    Then the registration should be completed successfully
    And the user should see the confirmation message

    Examples:
      | firstname | lastname | telephone     | password  |
      | salwa     | abdallah | 1234567890    | password1 |
