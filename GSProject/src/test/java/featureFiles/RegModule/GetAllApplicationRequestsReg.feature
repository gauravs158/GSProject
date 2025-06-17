Feature: Get All Application Requests - Registration Module
@Reg @G2G
Scenario Outline: Get All Application API verification

Given the user has the authToken
And the user create GetAllApplicationRequests parameter list with <state_cd>, <start_tm>, <end_tm>, <aplty>, <action>
When the user hits GetAllApplication
Then the user gets success statusCode

Examples: 

|	state_cd	| start_tm					|	end_tm						|	aplty		|	action	|
|	99				|	2025-03-08:15:30	|	2025-03-08:16:15	|	APLRG		|	LST			|
#|
#|