Feature: Payment module GetFileDetails API verification
@Payment
Scenario: GetFileDetails API verification

Given the user has the authToken
And the user has the url
When the user hits PaymentGetFileDetailsAPI
Then the user validates the fileDetails