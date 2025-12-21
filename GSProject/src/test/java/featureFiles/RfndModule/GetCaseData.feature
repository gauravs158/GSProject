Feature: Refund module GetCaseData API verification
@Rfnd @G2G
Scenario Outline: GetCaseData API verification

Given the user has GetCaseData authToken
And the user create GetCaseData parameter list with <state_cd>, <crn>, <itemrefid>, <action>
When the user hits GetCaseData
Then the user gets GetCaseData success statusCode

Examples: 

|	state_cd	| 	crn				|	itemrefid	|	action			|
|	99			|	abcdef123456	|		21234	|	GETCASEDATA		|