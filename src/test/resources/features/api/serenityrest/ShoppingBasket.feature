@apismoke
Feature: Shopping Basket Scenarios

  @apiserenity
  Scenario: Empty Shopping Basket
    Given Shopping basket
    When User trigger get call to basket web service
    Then Shopping basket is empty

  @apiserenity
  Scenario: Shopping Basket is Populated
    Given User add one item to basket
    When User trigger POST call to basket web service
    Then Shopping basket is not empty
    And Item apppear in basket