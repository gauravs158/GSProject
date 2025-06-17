Feature: BOServices module GetAllAlertCom API verification
@Smoke @G2G
Scenario Outline: GetAllAlertCom API verification

Given the user has the authToken
And the user create CommonAPIAlerts parameter list with <state_cd>, <start_tm>, <end_tm>, <action>, <iseod>
When the user hits GetAllAlertComAPI
Then the user gets success on GetAllAlertCom

Examples:

|	state_cd	| start_tm					|	end_tm						|	action	|	iseod	|
|	99				|	2023-03-02:17:00	|	2023-03-02:18:00	|	ALERT		|	Y			|
#|
#|