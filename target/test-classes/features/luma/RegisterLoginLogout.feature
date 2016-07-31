@regression
Feature: Guest User to Registered User Login and Logout
  As a guest user
  I want to register on Luma
  So as to Login and Logout

  Background:
    Given Luma Home Page

  @createuser
    Scenario Outline: Guest User Sign Up to be Registered User
      When User Trigger Sign Up Action with "<firstName>","<lastName>","<email>","<password>" Details
      Then New User "<rUser>" is active
      Examples:
        | firstName | lastName | email | password | rUser |
        #| bdd1001 | Serenity | bdd1001@duduosun.com | salmon01 | bdd1001 Serenity |
        #| bdd1002 | Serenity | bdd1002@duduosun.com | salmon02 | bdd1002 Serenity |
        #| bdd1003 | Serenity | bdd1003@duduosun.com | salmon03 | bdd1003 Serenity |
        | bdd3005 | Duduosun | bdd3005@duduosun.com | salmon05 | bdd3005 Duduosun |

  @users
  Scenario Outline: Registered User Login and Logout
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      And User "<rUser>" is active
    Examples:
      | rUser | rUsername | rPassword |
      | BDD1001 Duduosun | bdd1001@duduosun.com | salmon01 |