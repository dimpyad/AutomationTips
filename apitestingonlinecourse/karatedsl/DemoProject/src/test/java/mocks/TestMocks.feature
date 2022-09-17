Feature: A demo mock test started from a junit runner

  Background:
    * def mockUrl = `http://localhost:${karate.properties['mock_server_port']}`
    * print `Mock server url is ${mockUrl}`
    * url mockUrl

  Scenario: Test greeting endpoint
    * path 'greeting'
    * method get
    * status 200
    * match response == { content: "Hello World!"}

  Scenario: Test greeting endpoint with parameter
    * path 'greeting'
    * param name = "Dimpy"
    * method get
    * status 200
    * match response == { content: "Hello Dimpy!"}

