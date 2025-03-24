Feature: Get All Application Requests - Registration Module

@Smoke
Scenario: Get All Application API verification

Given the user has the authToken
And the user has the url
When the user hits GetAllApplication
Then the user gets success statusCode