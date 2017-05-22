@apismoke
Feature: Service to get and search Country with ISO codes and its name

  @apirestassured
  Scenario Outline: REST web-service to get a list of all Countries
    Given GroupKT REST
    When User trigger GroupKT get call on "<endpoint>"
    Then HTTP status code "<hcode>"
    And Display all countries "<record>"
    Examples:
      | endpoint | hcode | record |
      #| http://services.groupkt.com/country/get/all | 200 | Total |
      | http://services.groupkt.com/country/get/all | 200 | 249 |
      #| http://services.groupkt.com/country/get/all | 200 | records found |
      #| http://services.groupkt.com/country/get/all | 200 | RestResponse |
      #| http://services.groupkt.com/country/get/all | 200 | www.groupkt.com |
      #| http://services.groupkt.com/country/get/all | 200 | result |

  Scenario: REST web-service to search country by 2 character alphanumeric ISO code
  Scenario:  REST web-service to search country by 3 character alphanumeric ISO code
  Scenario:  REST web-service to search country by 3 character ISO code or 2 character ISO code or country name