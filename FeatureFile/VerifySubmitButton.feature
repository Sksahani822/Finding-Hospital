Feature: Submit Buttton

  Scenario: PassingInvalidEmail
    Given the user should click on the For Corporate
    When the user should select the Health and Wellness Plan
    Then the user should fill the required detail with in valid Email
   

  Scenario: PassingInvalidPhoneNumber
    Given the user should refresh the page
    When the user should fill the required detail with invalid PhoneNumber
    
  Scenario: PassingValidDetails
    Given the user should refresh the page for valid details
    Then the user should fill the required detail with in valid Details
    And the user should click on the Schedule to demo  button and get Thankyou message
