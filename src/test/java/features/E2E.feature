
Feature: Item Search and Checkout Process
  As a user, I want to search for an item, add it to my cart, and complete the purchase so that I can buy what I need.

  Background:
    Given the user is logged in

  Scenario Outline: Successful Item Search and Purchase
    When the user searches for "<item>"
    Then the user should see search results for "<item>"
    When the user selects the item from the search results
    And the user adds the item to the cart
    And the user proceeds to checkout
    Then the purchase should be completed successfully
    And the user should see a confirmation message

    Examples:
      | item        |
      | HP LP3065   |
