
@tag
Feature: Purchase The Order From Ecommerce Website
  I want to use this template for my feature file

  Background: 
  Given: I landed on Ecomerce Page

  @tag2
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> and password <password>
    When I add product <productname> to cart
    And  Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on finalPage

    Examples: 
      | name                   | password    | productname     |
      | pritammandal@gmail.com | Rikprit23@  | ADIDAS ORIGINAL |
