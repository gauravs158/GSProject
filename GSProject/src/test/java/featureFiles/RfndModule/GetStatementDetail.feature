Feature: Refund module GetStatementDetail API verification
@Rfnd @G2G
Scenario Outline: GetStatementDetail API verification

Given the user has GetStatementDetail authToken
And the user create GetStatementDetail parameter list with <stcd>, <arn>, <action>
When the user hits GetStatementDetail
Then the user gets GetStatementDetail success statusCode

Examples: 

|	stcd	| 	arn				|	action			|
|	99		|	abcdef123456	|	GETSTMNTDETAIL	|