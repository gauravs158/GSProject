Feature: Registration module Get Application Requests - Amendment Core Submit API verification
@Reg @G2G
Scenario Outline: GetApplnReqAmendmentCoreSubmit API verification

Given the user has GetApplnReqAmendmentCoreSubmit authToken
And the user create GetApplnReqAmendmentCoreSubmit parameter list with <state_cd>, <arn>, <action>
When the user hits GetApplnReqAmendmentCoreSubmit API
Then the user gets GetApplnReqAmendmentCoreSubmit success statusCode

Examples: 
|	state_cd	| arn				|		action	|
|	99			| abcde12345		|		REQ		|