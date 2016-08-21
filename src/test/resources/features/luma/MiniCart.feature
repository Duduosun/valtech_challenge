@regression
  Feature: Mini Cart

    Background:
      Given Luma Home Page

    Scenario: Open and Close Mini Cart
      When User Trigger Mini Cart
      Then Mini Cart remain Open
      When User Close Mini Cart
      Then Mini Cart is Closed

    Scenario Outline: Populate and Verify Non Empty Cart
      And User Trigger Top Level Entry "<topcat>"
      And User Add One of Listed Products "<aProduct>" to Cart
      When User Trigger Mini Cart
      Then Product "<aProduct>" is Visible in Mini Cart
      Examples:
        | topcat | aProduct |
        | What's New | Wayfarer Messenger Bag |
        | Gear | Fusion Backpack |
        #| Training | Solo Power Circuit |