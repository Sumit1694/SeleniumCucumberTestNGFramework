Feature: User search for product and add to cart

@PlaceOrder
Scenario Outline: Search for products from Excel file, add them to cart, and complete the order

Given User is on Greenkart landing page
When User searches for product "<ProductName>"
And User adds "<Quantity>" of the product to cart
Then User verifies the product is added in the cart with correct "<Quantity>"

Examples:
|ProductName  | Quantity |
|Tomato       | 2        |
|Beans        | 3        |
|Cucumber     | 1        |
|Beetroot     | 4        |
