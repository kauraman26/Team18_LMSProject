Feature: Logout function

  Scenario: Verify Logout button function
    Given Admin is in dashboard page
    When Admin click Logout button on navigation bar
    Then Admin should land on the home page after logout
