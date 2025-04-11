Feature: User is able to get the File Details for the mentioned file number
@ReturnFileCountDetails
Scenario: User is able to get the File Details for the mentioned file number

Given the user has the authToken
And the user has the url
When the user hits GetReturnFileCountAPI
And the user validates the responseData for number of fileCounts
And the user gets the fileCount
When the user hits GetReturnFileDetailsAPI
Then the user receives success statusCode
And the user validates the responseData for fileNumber and url