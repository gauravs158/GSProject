Feature: Payment module GetFileDetails API verification

Scenario: GetFileDetails API verificantion

Given the paymentuser has the authToken
And the user has the url
When the user hits PaymentGetFileDetailsAPI
Then the user gets success statusCode