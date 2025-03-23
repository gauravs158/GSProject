Feature: Registration module GetEntity API verification

Scenario: GetEntity API verification

Given the user has the authToken
And the user has the url
When the user hits GetEntityAPI
Then the user gets success statusCode