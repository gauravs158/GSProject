Feature: Returns module GetComparisionReport API verification

Scenario: GetComparisionReport API verification

Given the user has the authToken
And the user has the url
When the user hits GetComparisionReportAPI
Then the user gets success statusCode