@apismoke
Feature: Sample Api tests to demonstrate CRUD operation

  Background:
    Given Web API Entry Point

  @apirestassured
    Scenario Outline: Retrieve an Item - GET
    When User Retrieve and Item "<itemType>" and "<itemName>"
    Then "<itemName>" is Retrieved
    Examples:
      | itemType | itemName |
      |  |  |


  @apirestassured
  Scenario Outline: Create an Item - POST
    When User create an Item "<itemType>" and "<itemName>"
    Then "<itemName>" is Created

    Examples:
      | itemType | itemName |
      | tablet   | ipad     |
      | mobile   | iphone   |

  @apirestassured
  Scenario Outline: Update an Item - PUT
    When User update an Item "<itemType>" and "<itemName>"
    Then "<itemName>" is Updated

    Examples:
      | itemType | itemName |
      | tablet   | tab pro  |
      | mobile   | note 5   |

  @apirestassured
  Scenario Outline: Delete an Item - DELETE
    When User Delete an Item "<itemType>" and "<itemName>"
    Then "<itemName>" is Deleted
    Examples:
      | itemType | itemName |
      | tablet   | ipad     |
      | mobile   | iphone   |
      | tablet   | tab pro  |
      | mobile   | note 5   |