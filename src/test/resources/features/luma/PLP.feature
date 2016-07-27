Feature: Luma Product List Page
  As a customer
  I want to choose whether I want to see products presented as a list or a grid view
  So that I can see it in a way that works for me

  Background:
    Given Luma Home Page

  @eproduct
  Scenario Outline: Navigate Simple Products Default
    When User Trigger Top Level "<topcat>" then Sub Category Level "<subcategory>"
    Then Simple Products "<sproducts>" are Displayed in Grid View
    Examples:
      | topcat | subcategory | sproducts |
      | Gear | Bags | Diva Gym Tee |
      | Training | Video Download | Solo Power Circuit |

  @eproduct
  Scenario Outline: Navigate Configurable Products Default
    When User Trigger Top Level "<topcat>" then Sub Category Level "<subcategory>"
    Then Configurable Products "<cproducts>" are Displayed in Grid View
    Examples:
      | topcat | subcategory | cproducts |
      | Women | Women Tops | Diva Gym Tee |
      | Men | Men Bottoms | Rapha Sports Short |

  @eproduct
  Scenario Outline: Navigate Simple Products PLP List View
    When User Trigger Sub Category Level "<subcategory>"
    Then Simple Products "<sproducts>" are Displayed in Grid View
    When User Click Switch View CTA
    Then Simple Products "<sproducts>" are Displayed in List View
    Examples:
      | subcategory | sproducts |

  @eproduct
  Scenario Outline: Navigate Configurable Products PLP List View
    When User Trigger Sub Category Level "<subcategory>"
    Then Configurable Products "<cproducts>" are Displayed in Grid View
    When User Click Switch View CTA
    Then Configurable Products "<cproducts>" are Displayed in List View
    Examples:
      | subcategory | cproducts |
