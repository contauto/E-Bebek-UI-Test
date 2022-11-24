@SearchTest
Feature: Cart handling
  Scenario:Add a feeding bottle to cart
    Given a web browser is at the home page
    When user write feeding bottle to search field
    And user search
    And user click first item
    And user add item to cart
    And user go to the cart
    Then user see item in the cart
    And user delete the item from the cart
    And user redirected to the homepage






