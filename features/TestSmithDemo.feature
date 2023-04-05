Feature: Test Smith Demo Login
  Scenario: Registration, Selecting a Product and Checkout as a User
    Given I launch chrome browser
    When The user will navigate to the Registration page
    When The user will fill all the required fields before submitting using the register button
    When User enters the email and password
    When The user will navigate to the Categories Hand Tools page
    When The user will select a product select the quantity then click the add to cart button
    When The user will fill all the required payment fields to be able to checkout the product
    Then The product will successfully be paid
    And The user will close the browser

