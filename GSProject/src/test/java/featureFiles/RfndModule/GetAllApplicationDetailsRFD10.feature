Feature: Registration module GetAllApplicationDetailsRFD10 API verification
@Rfnd @G2G
Scenario Outline: GetAllApplicationDetailsRFD10 API verification

Given the user has GetAllApplicationDetailsRFD10 authToken
And the user create GetAllApplicationDetailsRFD10 parameter list with <stcd>, <arn>, <action>
When the user hits GetAllApplicationDetailsRFD10
Then the user gets refund success statusCode

Examples: 

|	stcd	| 	arn				|	action				|
|	99		|	abcdef123456	|	GETAPPDTLRFD10		|