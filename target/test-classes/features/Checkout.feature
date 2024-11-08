Feature: Place order for Products and Checkout

@PlaceOrder
Scenario: Search experience for product and proceeding to checkout

Given User is in GreenCart Landing page
When User searched shortname <Name> and extracted actual name of product.
And Add 3 more of the item
Then User opens the checkout page and verifies the product <Name>.
And after validation user checks out

Examples:
| Name |
| Tom  |