@testType=all
Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  Scenario Outline: all existing fruits search <fruits>
    When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/test/<fruits>"
    Then he sees each item contains '<fruits>' in title
    And he sees each product has 'provider', 'brand', 'price', 'unit' and 'image'
    Examples:
      | fruits |
      | mango  |
      | apple  |
      | tofu   |
      | water  |

  Scenario: search for the not existing fruit
    When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/test/watermelon"
    Then he sees the 'Not Found' error message
