@regression
  Feature: Testing Web Service with Serenity

    Background:
      Given Web API Entry Point

    @apismoke
    Scenario Outline: Connect to WebAPI
      When User perform GET request for "<URL>" and "<endpoint>"
      Then User Get "<code>" HTTP Status Code
      Examples:
        | URL | endpoint | code |
        | http://www.thomas-bayer.com | /sqlrest/CUSTOMER/ | 200 |
        | http://magento2-demo.nexcess.net | /api/rest/products/ | 404 |
        #| http://www.dulux.com.sg | /en/api/products/colors | 404 |


    @apismoke
    Scenario Outline: WebAPI Collection List
      When User perform GET request for "<URL>" and "<endpoint>"
      Then Collection "<list>" is returned
      Examples:
        | URL | endpoint | list |
        | http://www.thomas-bayer.com | /sqlrest/CUSTOMER/ | 7777 |
        | http://magento2-demo.nexcess.net | /api/rest/products/ | Women |