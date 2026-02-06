Feature: Search and place the order for products
@CheckoutPage
Scenario Outline: Search experience for product search in both home and offers page

Given User is on Greenkart landing page
When User searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
|Name|
|Tom|
