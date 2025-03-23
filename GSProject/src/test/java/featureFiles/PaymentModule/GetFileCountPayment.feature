Feature: Payment module GetFileCount API verification

Scenario: GetFileCount API verificantion

Given the paymentuser has the authToken
And the user has the url
When the user hits PaymentGetFileCountAPI
Then the user gets success statusCode
