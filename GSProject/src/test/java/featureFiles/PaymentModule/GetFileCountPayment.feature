Feature: Payment module GetFileCount API verification
@Payment @G2G
Scenario Outline: GetFileCount API verification

Given the user has the authToken
And the user create PaymentGetFileCount parameter list with <file_type>, <date>, <state_cd>, <action>
When the user hits PaymentGetFileCountAPI
Then the user validates the fileCount

Examples: 

|	state_cd	| file_type					|	date							|	action		|
|	99				|	CIN								|	12-12-2023				|	FILECNT		|
#|
#|