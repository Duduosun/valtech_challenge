Feature: Guest User and Registered User Entry Point
  As a User
  I want to browse Magento 2 Demo Website

  Background:
    Given Luma Home Page

  @quicksmoke
  Scenario: Home Page Browse Header
    When User Explores Home Page
    Then Header Elements are Interactive

  @quicksmoke
  Scenario: Home Page Browse Footer
    When User Explores Home Page
    Then Footer Elements are Interactive

  @quicksmoke
    Scenario Outline: Guest User
    When User Interact with Luma Website
    Then Luma Module for Guest "<gUser>" is available
    But Luma Modules for Registered "<rUser>" is not available
    Examples:
      | gUser | rUser |
      | Default welcome msg! | Welcome, BDD1001 Duduosun! |
      | Sign In | BDD1002 Duduosun |
      | Create an Account | Welcome Pinguino Volante! |

  @quicksmoke
  Scenario Outline: Registered User
    When User Interact with Luma Website
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    Then Luma Module for Registered "<rUser>" is available
    But Luma Modules for Guest "<gUser>" is not available
    Examples:
      | rUser | rUsername | rPassword | gUser |
      | Welcome, bdd1002 Serenity! | bdd1002@duduosun.com | salmon02 | Sign In |