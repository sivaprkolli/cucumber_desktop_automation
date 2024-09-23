Feature: Sample API

  Background:
    Given I want to test on Baseurl "https://reqres.in/api"

  @SampleAPI
  Scenario Outline:  Verify response when given a valid credentials
    Given I navigated to resourcePath "/login" and send request "<requestType>"
    And I send request with following payload
      | key      | value              |
      | email    | eve.holt@reqres.in |
      | password | cityslicka         |
#    Then I should get response "200"
#    But Body should not be Null
#    Then Body should contain "token"
    Examples:
      | requestType |
      | GET         |

    @SA2
  Scenario: Get user details
    Given I have the endpoint "https://jsonplaceholder.typicode.com/users/1"
    When I send a GET request to the endpoint
    Then the response status code should be 200
    And the response should contain the user with id 1

  Scenario: Create a new user
    Given I have the endpoint "https://jsonplaceholder.typicode.com/users"
    And I have the following user details
      | name | username | email            |
      | John | john_doe  | john@example.com |
    When I send a POST request to the endpoint
    Then the response status code should be 201

  Scenario: Update a user
    Given I have the endpoint "https://jsonplaceholder.typicode.com/users/1"
    And I have the following user details
      | name | username | email            |
      | Jane | jane_doe | jane@example.com |
    When I send a PUT request to the endpoint
    Then the response status code should be 200

  Scenario: Patch a user
    Given I have the endpoint "https://jsonplaceholder.typicode.com/users/1"
    And I have the following user details
      | name | username | email            |
      | Jane | jane_doe | jane@example.com |
    When I send a PATCH request to the endpoint
    Then the response status code should be 200


