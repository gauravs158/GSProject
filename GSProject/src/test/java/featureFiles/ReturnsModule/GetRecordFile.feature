Feature: Returns module GetRecordFile API verification

Scenario: GetRecordFile API verification

Given the user has the authToken
And the user has the url
When the user hits GetAlertAPI
Then the user gets success statusCode