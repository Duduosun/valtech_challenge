Feature: Valtech Challenge

  Background:
    Given Valtech HomePage

  Scenario: Valtech Scenario One
  Navigate to the www.valtech.com homepage
  Assert that the "Latest News" section is displaying

    When User Navigate to HomePage
    Then Latest News section is displaying

  Scenario Outline: Valtech Scenario Two
  Navigate to ABOUT, SERVICES and WORK pages via top navigation and
  assert that H1 tag in each page is displaying the relevant page name
  Ex H1 tag ins Services page is displaying as "Services"

    When User Navigate to "<pages>" Pages via Top Navigation
    Then Header Tag in Page is displaying "<pages>" Page Name
    Examples:
      | pages |
      | ABOUT |
      | SERVICES |
      | WORK |

  Scenario: Valtech Scenario Three
  Navigate to Contact page and output how many Valtech offices in total
    When User Navigate to Contact Page
    And User Collate Valtech Offices
    Then Total Number of Valtech Office is returned