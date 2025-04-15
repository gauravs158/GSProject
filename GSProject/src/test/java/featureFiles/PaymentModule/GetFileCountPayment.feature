Feature: Payment module GetFileCount API verification
@Payment
Scenario: GetFileCount API verification

Given the user has the authToken
And the user has the url
When the user hits PaymentGetFileCountAPI
Then the user validates the fileCount