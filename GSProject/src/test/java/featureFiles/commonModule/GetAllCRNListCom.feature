Feature: Common module GetAllCRNList API verification
@Smoke @G2G
Scenario Outline: GetAllCRNList API verification

Given the user has the authToken
And the user create CommonAPIAllCRNList parameter list with <state_cd>, <start_tm>, <end_tm>, <action>, <iseod>, <casetyp>
When the user hits GetAllCRNList
Then the user gets success statusCode on CommonAPIAllCRNList

Examples:

|	state_cd	| start_tm					|	end_tm						|	action	|	iseod	|	casetyp	|
|	07				|	2025-03-10:09:16	|	2025-03-10:10:16	|	CRNLST	|	Y			|	ADJDT		|
#|
#|
