Feature: Place the Order for Products

@PlaceOrder
  Scenario Outline: Search Experience for Product Seach in both home and Offers page
    Given User is on GreenCart Landing Page
    When User search with shortname <Name> and extracted Actual name of Product
    And Added "3" items of the selected product to cart
    Then User Proceeds to Checkout and Validate the <Name> items in checkout page
    And verify user has ability to eneter promo code and place the order
    

    Examples: 
    | Name |
    | Tom  |
  
   