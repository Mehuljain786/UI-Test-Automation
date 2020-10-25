
@tag
Feature: Purchase Midtrans Pillow

  @tag1
  Scenario: Unauth Customer should able to purchase sucessfully “Pillow” using Credit Card as payment method.
    Given User Launch browser
    When User open URL "https://demo.midtrans.com/"
    Then Page title should be "Midtrans Pillow"
    And Amount should be "RP 20000"
    When User clicks on Buy Now button
    Then Shopping Cart layover screen has to be displayed
    And CHECKOUT button has to be displayed

#  @tag2
 # Scenario Outline: Unauth Customer try to purchase “Pillow” using Credit Card as payment method and Payment got fail.
  #  Given I want to write a step with <name>
   # When I check for the <value> in step
    #Then I verify the <status> in step

    #Examples: 
     # | name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
