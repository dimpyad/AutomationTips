Feature: This feature contains simple mock responses for greeting request

  Scenario: pathMatches('/greeting') && paramExists('name')
    * def content = 'Hello ' + paramValue('name') + '!'
    * def response = { content: '#(content)' }

  Scenario: pathMatches('/greeting')
    * def response = { content: 'Hello World!' }
