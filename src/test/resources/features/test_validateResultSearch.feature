@Test

Feature: My First Test

Scenario: Validate result search
Given I open the Automation Practice
When I go search DRESSES
Then I validate result '"DRESSES"'