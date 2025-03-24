Feature: BOServices module GetAllAlertCom API verification
@Smoke
Scenario: GetAllAlertCom API verification

Given the user has the authToken
And the user has the url
When the user hits GetAllAlertComAPI
Then the user gets success statusCode