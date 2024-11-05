Feature: Search and place order for Products


Scenario: Search experience for product search in both home and Offers page

Given User is in GreenCart Landing page
When User searched shortname "Tom" and extracted actual name of product.
Then User search the "Tom" shortname in Ofers page and check if product exists.
And validate Product name in offers page.