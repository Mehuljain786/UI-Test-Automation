
@tag
Feature: Purchase Midtrans Pillow

  Background: Lauch midtrans in browser
    Given User will Lauch midtrans site in browser 
    And Unauth User verify the product and page content


  @tag1
  Scenario: Unauth Customer should able to purchase sucessfully “Pillow” using Credit Card as payment method.
    When User clicks on Buy Now button
    Then Shopping Cart layover screen has to be displayed
    And Verify the details on Checkout page
    And Click on CHECKOUT button
    #Examples: 
    #| Card_Number | Expiry_Date | CVV_Number | Bank’s_OTP |
    #| 4811 1111 1111 1114 | 12/24 | 123 | 112233 |
    
     
#  @tag2
 # Scenario Outline: Unauth Customer try to purchase “Pillow” using Credit Card as payment method and Payment got fail.
  #  Given I want to write a step with <name>
   # When I check for the <value> in step
    #Then I verify the <status> in step

    #Examples: 
     # | name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
