Feature: Customer Table Validations in Sakila DB

  Scenario: Verify a customer exists by full name
    Given I connect to the Sakila database
    When I search for a customer named "MARY SMITH"
    Then I should find the customer

  Scenario: Validate customer's email address
    Given I connect to the Sakila database
    When I search for the customer "PATRICIA JOHNSON"
    Then the email should be "PATRICIA.JOHNSON@sakilacustomer.org"

  Scenario: Check customer account status
    Given I connect to the Sakila database
    When I check the status of "LINDA WILLIAMS"
    Then the customer should be active

  Scenario: Validate customer's assigned store
    Given I connect to the Sakila database
    When I look up the store for customer "BARBARA JONES"
    Then the store ID should be 2