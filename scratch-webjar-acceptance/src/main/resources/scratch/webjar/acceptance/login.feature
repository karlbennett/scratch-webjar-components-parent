Feature: Login
  As a user I would like to login so that I can use the logged in functionality of the web application.

  Scenario: Can login to an account
    Given I am an existing user
    When I login
    Then I should be on the homepage
    And I should see that I am logged in
    And I should be able to logout