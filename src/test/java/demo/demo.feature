Feature: Demo

  Background:
    * url baseUrl
    * def DemoTestRunner = Java.type('demo.DemoTestRunner')

  Scenario: Add a message
    Given path '/'
    And request { "message": "Hello" }
    When method post
    Then status 200
    And DemoTestRunner.assertTable('Hello')

  Scenario: Find messages
    Given path '/'
    When method get
    Then status 200
    And match response == [ { "ID": 1, "MESSAGE": "Hello" } ]
