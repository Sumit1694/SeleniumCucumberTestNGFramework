Feature: Search and place the order for products
@OffersPage
Scenario Outline: Search experience for product search in both home and offers page

Given User is on Greenkart landing page
When User searched with shortname <Name> and extracted actual name of product
Then user serached for <Name> shortname in offers page to check if product exist with same name
And validate product name in offers page matches with landing page

Examples:
|Name|
|Tom|
|BeetT|