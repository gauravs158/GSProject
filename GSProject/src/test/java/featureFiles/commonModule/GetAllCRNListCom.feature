Feature: Common module GetAllCRNList API verification

Scenario: GetAllCRNList API verification

Given the user has the authToken
And the user has the url
When the user hits GetAllCRNList
Then the user gets success statusCode