Feature: Registration module GetAlert API verification
@testLogging
Scenario: GetAlert API verification

Given the user has the authToken
And the user has the url
When the user hits GetAlertAPI
Then the user gets success statusCode