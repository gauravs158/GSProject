Feature: Returns module GetComparisionReport API verification

Scenario Outline: GetComparisionReport API verification

Given the user has the authToken
And the user create ComparisionReport parameter list with <gstin>, <fy>, <action>
When the user hits GetComparisionReportAPI
Then the user gets success statusCode for GetComparisionReportAPI

Examples: 

|	gstin									| fy					|	action			|
|	32PANHH2940R1ZE				|	2022				|	COMPREPORT	|
#|
#|