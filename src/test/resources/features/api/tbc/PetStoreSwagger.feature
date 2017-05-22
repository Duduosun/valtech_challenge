@apiwip
Feature: Pet Store GET and POST
  Scenario: Add Pet to Store
    Given Donald have pets
    When Donald add the pet to the store "<fido>"
    Then Pet is available in store