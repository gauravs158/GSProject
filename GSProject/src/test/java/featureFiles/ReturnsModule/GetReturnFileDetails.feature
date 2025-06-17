Feature: User is able to get the File Details for the mentioned file number
@Return @G2G
Scenario Outline: User is able to get the File Details for the mentioned file number

Given the user has the authToken
And the user create ReturnFileDetails parameter list with <state_cd>, <type>, <date>, <action>, <file_num>
#When the user hits GetReturnFileCountAPI
#And the user validates the responseData for number of fileCounts
#And the user gets the fileCount
When the user hits GetReturnFileDetailsAPI
Then the user receives success statusCode on GetReturnFileDetailsAPI
#And the user validates the responseData for fileNumber and url

Examples: 

|	state_cd	| type					|	date						|	action	|	file_num	|
|	07				|	ANX1					|	15-05-2022			|	FILEDET	|	2					|
#|
#|