Feature: Registration module GetAlert API verification
@Reg
Scenario Outline: GetAlert API verification

Given the user has the authToken
And the user create alert parameter list with <state_cd>, <start_tm>, <end_tm>, <action>
When the user hits GetAlertAPI
Then the user gets success statusCode

Examples: 

|	state_cd	| start_tm					|	end_tm						|	action	|
|	99				|	2023-03-02:17:00	|	2023-03-02:18:00	|	ALERT		|
#|
#|