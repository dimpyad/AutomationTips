Feature: Demo example feature which demonstrates UI and API automation in a single script
# locators used are refered from locators.json file
# config parameters are refered from karate-config.js file

  Background:
    * configure driver = { type: 'chrome', showDriverLog: true, httpConfig: { readTimeout: 120000 } }
    * def locators = read('../locators.json')
    * def search_input_value = 'docker'
    * def tag_value = 'system'

  Scenario: Varifying search result functionality
  # Launcing the Web URL
    Given driver webUrlSearch

  # Waiting for the System category in the home page before
  # clicking on the same
    When waitFor(locators.homepage.system).click()

  # Entering search string with value 'docker'
    And input(locators.systempage.searchInput, search_input_value)

  # Submiting the search request
    And click(locators.systempage.searchIcon)

  # Static delay till search completes
    And delay(3000)

  # Capturing the total result count from UI
    And def actualResult = text(locators.systempage.searchResult).replace(" Results","")

  # Setting up API end point and query params
    Given url apiUrlSearch
    And param tags = tag_value
    And param keywords = search_input_value
  # Submitting a get request with the same parameter
    When method get

  # Verifying the response status
    Then status 200

  # Verifying that result count is same as displayed in UI
    And def colection_count = response.collection.count
    And def content_count = response.content.count
    And def expectedResult = (colection_count + content_count).toString()
    Then match actualResult == expectedResult