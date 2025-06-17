Feature: Payment module GetFileDetails API verification
@Payment @G2G
Scenario Outline: GetFileDetails API verification

Given the user has the authToken
And the user create PaymentGetFileDtls parameter list with <file_type>, <date>, <state_cd>, <action>, <file_num>
When the user hits PaymentGetFileDetailsAPI
Then the user validates the fileDetails

Examples: 
|	state_cd	| file_type					|	date							|	action		|	file_num	|
|	99				|	CIN								|	12-12-2023				|	FILEDTLS	|	32				|
#|
#|