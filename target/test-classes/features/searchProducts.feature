
@tag
Feature: Search and Place the Order

  @tag1
  Scenario: Search Experience for product in both home and offer page
    Given User is on GreenKart landing page
    When user search with shortname "tom" and extract the actual name of the product
    Then user search for same shortname "tom" on offers page
    And Validate the product name on Offer page matches with that on Landing page
    
     Scenario Outline: Search Experience for product in both home and offer page
     Given User is on GreenKart landing page
     When user search with shortname <Name> and extract the actual name of the product
    Examples:
    | Name | 
     | Tom | 
      | Beet | 

 