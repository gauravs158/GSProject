Feature: Registration module GetAllApplicationDetails API verification
@Rfnd @G2G
Scenario Outline: GetAllApplicationDetails API verification

Given the user has GetAllApplicationDetails authToken
And the user create GetAllApplicationDetails parameter list with <stcd>, <arn>, <formtype>, <action>
When the user hits GetAllApplicationDetails
Then the user gets refund success statusCode

Examples: 

|	stcd	| 	arn				|	formtype		|	action				|
|	99		|	abcdef123456	|	RFD01			|	GETAPPLNDETAILS		|