Feature: User is able to get the Return File Count for the mentioned date
@ReturnFileCountDetails
Scenario: User is able to get the Return File Count for the mentioned date

Given the user has the authToken
And the user has the url
When the user hits GetReturnFileCountAPI
Then the user receives success statusCode
And the user validates the responseData for number of fileCounts