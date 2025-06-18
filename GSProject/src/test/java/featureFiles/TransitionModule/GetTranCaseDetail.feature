Feature: User is able to get the Get Tran Case Details for the mentioned date
@Transition @G2G
Scenario Outline: User is able to get the Get Tran Case Details for the mentioned date

Given the user has the authToken
And the user create GetTranCaseDetails parameter list with <stateCd>, <crn>, <caseTypeCd>, <action>
When the user hits GetTranCaseDetailsAPI
Then the user receives success statusCode for GetTranCaseDetailsAPI

Examples: 

|	stateCd	| crn								|	caseTypeCd			|	action	|
|	99			|	AD380922000014Q		|	TRAN2						|	GETTRAN	|
#|
#|