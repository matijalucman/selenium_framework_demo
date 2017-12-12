Feature: Google Search
  As Google user
  In order to search various terms
  I want that Google search works as intended

  Scenario: Simple Google Search
    Given I have opened Google main page
    When I search term Cucumber
    Then I will get results that contain searched term