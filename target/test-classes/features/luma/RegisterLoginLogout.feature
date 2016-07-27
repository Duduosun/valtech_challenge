Feature: Guest User to Registered User Login and Logout
  As a guest user
  I want to register on Luma
  So as to Login and Logout

  Background:
    Given Luma Home Page

  @recscenario
    Scenario Outline: Guest User Sign Up to be Registered User
      When User Trigger Sign Up Action with "<firstName>","<lastName>","<email>","<password>" Details
      Then New User "<rUser>" is active
      Examples:
        | firstName | lastName | email | password | rUser |
        | bdd1001 | Serenity | bdd1001@duduosun.com | salmon01 | bdd1001 Serenity |
        | bdd1002 | Serenity | bdd1002@duduosun.com | salmon02 | bdd1002 Serenity |

  @quicksmoke
  Scenario Outline: Registered User Login and Logout
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Module for Registered "<rUser>" is available
      Then User "<rUser>" is active
    Examples:
      | rUser | rUsername | rPassword |
      | bdd1001 Serenity | bdd1001@duduosun.com | salmon01 |