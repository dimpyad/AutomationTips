Feature: This feature will validate the Azure activities.

  Background:
    * url  apiHost

  Scenario: get list of all activities and get the first activity
    Given path 'Activities'
    When method get
    Then status 200

    * def first = response[0]

    Given path 'Activities', first.id
    When method get
    Then status 200

  Scenario: Create a new activity (Post request)
    * def newActivity =
     """
      {
      "title": "test dummy",
      "dueDate": "2021-12-08T10:33:11.598Z",
      "completed": false
      }
      """

    Given path 'Activities'
    And request newActivity
    And method post
    * def title = response.title
    Then status 200
    And match title == "test dummy"


  Scenario: Update activity (Put request)
    * def updateActivity =
     """
      {
      "title": "updated title",
      "completed": false
      }
      """
    Given path 'Activities', 0
    And request updateActivity
    And method put
    * def updatedTitle = response.title
    * def updatedStatus = response.completed
    Then status 200
    And match updatedTitle == "updated title"
    And match updatedStatus == false

  Scenario: Delete activity (Delete request)
    Given path 'Activities', 0
    And method delete
    Then status 200