Feature: Doctor Details

  Scenario: UrlCheck
    Given the user should navigate to practo website
    When the user should get current Url
    Then the user should check the current Url is matches with ExpectedUrl

  Scenario: DoctorsList
    Given user should click on Find  Doctor
    When the user should select the location and Doctor
    Then user should select the Patient Stories
    And user should select the Experience
    And user should select the All Filters
    And user should select the sorted by relevence
    #And the user should click on the 1st DoctorName
    #And new window will navigate for Doctors Details
    And the user should get the doctors details which is displayed

  #Scenario: Doctor2
    #Given the user should click on doctor2 link
    #When the user switch to another window
    #Then the user should get the Doctor Details
    #And the user should Switch to back to parent window
#
  #Scenario: Doctor3
    #Given the user should click on doctor3 link
    #When the user switch to another window for doctor3
    #Then the user should get the Doctor3 Details
    #And the user should Switch to back to parent window to get doctor 4 details
#
  #Scenario: Doctor4
    #Given the user should click on doctor4 link
    #When the user switch to another window for doctor4
    #Then the user should get the Doctor4 Details
    #And the user should Switch to back to parent window to get doctor5 details
#
  #Scenario: Doctor5
    #Given the user should click on doctor5 link
    #When the user switch to another window for doctor5
    #Then the user should get the Doctor5 Details
    #And the user should Switch to back to parent window to for next scenario
