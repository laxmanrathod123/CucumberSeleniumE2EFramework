Feature: Search and Place the Order for Products

@OffersPage
  Scenario Outline: Search Experience for Product Seach in both home and Offers page
    Given User is on GreenCart Landing Page
    When User search with shortname <Name> and extracted Actual name of Product
    Then User go and search for the <Name> shorname in Offer page
    And Validate the product name in offer page matches with Landing Page

    Examples:
    | Name |
    | Tom  |
    | Beet |