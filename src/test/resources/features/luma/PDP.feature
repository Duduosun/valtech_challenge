Feature: Luma Product Details Page - Category and Search
  As a customer
  I want to see the details for the product I am interested in
  So that I can decide whether it is the product I want

  Background:
    Given Luma Home Page

  @eproduct
  Scenario Outline: Navigate Simple Product
    When User Click Top Level "<tcat>" CTA
    And User Click Simple Product "<eproduct>"
    Then Audi PDP is Displayed with "<eproduct>"

    Examples:
      | tcat | eproduct |
      | Accessories | New Auto Test |


  Scenario: Navigate Configurable Product
    When User Click Second Level "<scat>" CTA
    And User Click Configurable Product
    Then Audi PDP is Displayed

  Scenario: Navigate Audi Experience Product
    When User Navigate Category
    When User Click Top Level "<tcat>" CTA
    And User Click Audi Experience Product
    Then Audi PDP is Displayed


  Scenario: Search Simple Product
    When User Search Product
    When User Search Audi Store with String "<search>"
    And User Click Simple Product
    Then Audi PDP is Displayed

  Scenario: Search Configurable Product
    When User Search Product
    When User Search Audi Store with String "<search>"
    And User Click Configurable Product
    Then Audi PDP is Displayed

  Scenario: Search Audi Experience Product
    When User Search Product
    When User Search Audi Store with String "<search>"
    And User Click Audi Experience Product
    Then Audi PDP is Displayed