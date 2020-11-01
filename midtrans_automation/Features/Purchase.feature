
@tag
Feature: Purchase Midtrans Pillow

  Background: Lauch midtrans in browser
    Given User will Lauch midtrans site in browser 
    And Unauth User verify the product and page content


  @tag1
  Scenario Outline: Unauth Customer should able to purchase “Pillow” sucessfully and Unsucessful using Credit Card as payment method.
    When User clicks on Buy Now button
    Then Shopping Cart layover screen has to be displayed
    And Verify the details on Checkout page
    When Click on CHECKOUT button
    Then Display Order detail screen
    And Click on Continue Button
    Then Display Select Payment screen
    And User click on Credit Debit card option
    Then Display Credit Debit Card detail screen
    And User enter "<Card_Number>" in card number field "<Expiry_Date>" and "<CVV_Number>" in CVV field
    And Click on PayNow button
    And User enter "<Banks_OTP>" in Password field and click submit
    Then Display "<Payment_status>" Transaction status
    
    Examples: 
    | Card_Number | Expiry_Date | CVV_Number | Banks_OTP | Payment_status |
    | 4811 1111 1111 1114 | 12/24 | 123 | 112233 | Thank you for your purchase |
   # | 4811 1111 1111 1113 | 12/24 | 123 | 112233 | Transaction failed |
   
