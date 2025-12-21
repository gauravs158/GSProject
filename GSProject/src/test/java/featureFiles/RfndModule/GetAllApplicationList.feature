Feature: Registration module GetAllApplicationList API verification
@Rfnd @G2G
Scenario Outline: GetAllApplicationList API verification

Given the user has refund authToken
And the user create GetAllApplicationList parameter list with <stcd>, <start_tm>, <end_tm>, <action>
When the user hits GetAllApplicationList
Then the user gets refund success statusCode

Examples: 

|	stcd	| start_tm				|	end_tm				|	action				|
|	99		|	2025-12-18:12:12:12	|	2025-12-18:12:32:12	|	GETALLREFUNDLIST	|