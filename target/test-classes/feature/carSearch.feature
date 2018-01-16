Feature: validation of car search page
  In order to validate car search 
  as a buyer 
  I navigate https://www.carsguide.com.au/

  Scenario: Searching for a new car
    Given I am on the home page https://www.carsguide.com.au/ of carsguide website
    When I move to Car for Sale Menu
    Then I click on Search Cars
    And I select Make as "BMW"
    And I select Model as "Select Model"
    And I select location as "Australia"
    And I select price as "$10,000"
    Then I should see list of searched cars from "BMW"
    And the page title should be "BMW 1 Series Under $10,000 for Sale | CarsGuide"
