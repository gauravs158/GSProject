Feature: User is able to get the Return File Count for the mentioned date
@Return @G2G
Scenario Outline: User is able to get the Return File Count for the mentioned date

Given the user has the authToken
And the user create ReturnFileCount parameter list with <state_cd>, <type>, <date>, <action>
When the user hits GetReturnFileCountAPI
Then the user receives success statusCode for GetReturnFileCountAPI

Examples: 

|	state_cd	| type					|	date						|	action	|
|	07				|	ANX1					|	15-05-2022			|	FILECNT	|
#|
#|