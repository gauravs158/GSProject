Feature: BOServices module GetAlerts API verification

Scenario: GetAlerts API verification

Given the user has the authToken
And the user has the url
When the user hits GetAlertBOAPI
Then the user gets success statusCode