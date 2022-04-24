Feature: Signup to Gmail
  Scenario Outline: Signup with invalid password
    Given user visits to signup page
    When user inputs "<short_password>"
    Then user cannot signup
    Examples:
      | short_password |
      | fsfe           |
      | anfwf          |
      | 3227           |

  Scenario Outline: Signup with invalid password
    Given user visits to signup page
    When user enters "<weak_password>"
    Then user cannot signup again
    Examples:
      | weak_password |
      | abcdefgh      |
      | aaaaaaaa      |
      | 11223344      |