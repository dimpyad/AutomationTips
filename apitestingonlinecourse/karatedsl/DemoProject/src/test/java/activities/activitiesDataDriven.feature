Feature: This feature will validate the Azure activities.

  Background:
    * url apiHost

  Scenario: Create a new activity (Post request)
    * def newActivity = read("../resources/activity_request.json")
    Given path 'Activities'
    And request newActivity
    And method post
    * def title = response.title
    * def expectedResponse = read("../resources/activity_response.json")
    Then status 200
    And match title == "test_data_driven"
    And match response == expectedResponse