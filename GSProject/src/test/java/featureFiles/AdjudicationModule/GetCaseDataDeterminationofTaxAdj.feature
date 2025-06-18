Feature: Adjudication module Get Case Data - Determination of Tax API verification
@Adj @G2G
Scenario Outline: Get Case Data - Determination of Tax API verification

Given the user has the authToken
And the user create GetCaseData Determination of Tax parameter list with <state_cd>, <crn>, <casetypcd>, <action>
When the user hits GetCaseData Determination of Tax
Then the user gets success statusCode for GetCaseData Determination of Tax

Examples: 

|	state_cd	| crn							|	casetypcd						|	action				|
|	07				|	AD070225000209K	|	ADJDT								|	GETDOTCASE		|
#|
#|