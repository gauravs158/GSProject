Feature: Get All Application Requests - Registration Module
@Reg @G2G
Scenario Outline: Get All Application API verification

Given the user has the authToken
And the user create GetAllApplicationRequests parameter list with <state_cd>, <start_tm>, <end_tm>, <aplty>, <action>
When the user hits GetAllApplication
Then the user gets success statusCode for GetAllApplicationRequests API

Examples: 

#|	state_cd	| start_tm					|	end_tm						|	action	|
#|	99				|	2022-07-26:12:00	|	2022-07-26:13:00	|	LST			|

|	state_cd	| start_tm					|	end_tm						|	aplty		|	action	|
|	33				|	2022-07-26:12:03	|	2022-07-26:13:00	|	APLRG		|	LST			|
#|	99				|	2022-07-26:12:00	|	2022-07-26:13:00	|	CNREV		|	LST			|
#|