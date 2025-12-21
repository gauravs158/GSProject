Feature: Registration module GetBankValidationStatus API verification
@Rfnd @G2G
Scenario Outline: GetBankValidationStatus API verification

Given the user has GetBankValidationStatus authToken
And the user create GetBankValidationStatus parameter list with <stcd>, <crn>, <action>
When the user hits GetBankValidationStatus
Then the user gets GetBankValidationStatus success statusCode

Examples: 

|	stcd	| 	crn				|	action			|
|	99		|	abcdef123456	|	BNKASSESSE		|