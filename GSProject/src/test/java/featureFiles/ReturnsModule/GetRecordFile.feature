Feature: Returns module GetRecordFIle API verification

Scenario Outline: GetRecordFIle API verification

Given the user has the authToken
And the user create RecordFIle parameter list with <state_cd>, <type>, <date>, <action>
When the user hits GetRecordFIleAPI
Then the user gets success statusCode for GetRecordFIleAPI

Examples: 

|	state_cd	| type					|	date						|	action	|
|	07				|	ANX1					|	15-05-2022			|	FILECNT	|
#|
#|