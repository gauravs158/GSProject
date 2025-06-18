Feature: Adjudication module GetCaseDataMFY API verification
@Adj @G2G
Scenario Outline: GetCaseDataMFY API verification

Given the user has the authToken
And the user create GetCaseDataMFY parameter list with <state_cd>, <crn>, <casetypcd>, <action>
When the user hits GetCaseDataMFY
Then the user gets success statusCode for GetCaseDataMFY

Examples: 

|	state_cd	| crn							|	casetypcd						|	action				|
|	30				|	AD300325000164Z	|	AMYAE								|	MFYGETCASE		|
#|
#|