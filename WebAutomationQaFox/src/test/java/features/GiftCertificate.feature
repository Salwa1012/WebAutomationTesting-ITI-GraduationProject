
Feature: Purchase a Gift Certificate
  As a user, I want to purchase a gift certificate so that I can send it to someone.

  Scenario Outline: Successful Gift Certificate Purchase
    Given the user is on the "Gift Certificate" page
    When the user fills in the gift certificate form with recipient "<recipientName>", "<recipientEmail>", sender "<senderName>", "<senderEmail>", theme "<theme>", message "<message>", and amount "<amount>"
    And the user agrees that gift certificates are non-refundable
    And the user clicks the "Continue" button
    Then the gift certificate purchase should be completed successfully

    Examples:
      | recipientName | recipientEmail      | senderName | senderEmail           | theme    | message         | amount |
      | Omar nasser     | omar@example.com| nasser | nasser@example.com| Birthday | Happy Birthday! | 1      |

