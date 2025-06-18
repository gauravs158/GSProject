Feature: Payment module GetPaymentRecon API verification
@Payment @G2G
Scenario Outline: GetPaymentRecon API verification

Given the user has the authToken
And the user create PaymentGetPaymentRecon parameter list with <file_type>, <date>, <state_cd>, <file_num>, <action>
When the user hits PaymentGetPaymentReconAPI
Then the user validates the success status code for PaymentGetPaymentReconAPI

Examples: 

|	state_cd	| file_type					|	date							|	file_num	|	action		|
|	99				|	CIN								|	12-12-2023				|	2					|	PMTRECON	|
#|
#|