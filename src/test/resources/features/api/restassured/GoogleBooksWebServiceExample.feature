@apismoke
Feature: Get book by ISBN

  @apirestassured
  Scenario Outline: User calls web service to get a book by its ISBN Too
    Given Book exists with an "<ISBN>"
    When User retrieves the book by ISBN
    Then Status code is "<Successful>"
    Examples:
      | ISBN | Successful |
      | 9781451648546 | 200 |

  @apirestassured
  Scenario Outline: User verify JSON
    Given Book exists with an "<ISBN>"
    When User retrieves the book by ISBN
    Then Response include json field "<totalItems>" "<kind>"
    And Response contains json array "<title>" "<publisher>" "<pageCount>"
    Examples:
      | ISBN | totalItems | kind | title | publisher | pageCount |
      | 9781451648546 | 1 | books#volumes | Steve Jobs | Simon and Schuster | 630 |

  @apirestassured
  Scenario: User calls web service to get a book by its ISBN
    Given a book exists with an isbn of 9781451648546
    When a user retrieves the book by isbn
    Then the status code is 200
    And response includes the following
      | totalItems 	 	| 1 				|
      | kind				| books#volumes		|
    And response includes the following in any order
      | items.volumeInfo.title 		| Steve Jobs		  |
      | items.volumeInfo.publisher 	| Simon and Schuster  |
      | items.volumeInfo.pageCount 	| 630			      |