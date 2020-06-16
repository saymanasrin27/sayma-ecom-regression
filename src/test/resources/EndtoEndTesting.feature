Feature: End to end feature

  @sayma
  Scenario: Create an order with a Gift Card
    Given I am in homepage url "http://twentyconsulting-001-site1.dtempurl.com/"
    When   I click on login link from navigation  bar
    And   I enter email 'sayma.nasrin27@gmail.com'
    And   I enter password as 'Rony4143'
    And   I click on login button
    And   I click on add to cart
    And   I go to cart
    And   I enter Gift Card number
    And   I click on Add Gift Card
    And   I click on terms and condition
    And   I click on checkout
    And   I click on continue
    And   I set default shipping method
    And   I click on confirm
    Then  The order confirmation screen is shown "Your order has been successfully processed!"
