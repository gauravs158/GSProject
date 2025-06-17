Feature: Audit module Get Audit Case Details API verification
@Audit @G2G
Scenario Outline: Get Audit Case Details API verification

Given the user has the authToken
And the user create Get Audit Case Details parameter list with <crn>, <action>
When the user hits Get Audit Case Details API
Then the user gets success statusCode for Get Audit Case Details

Examples: 

| crn							|	action				|
|	AD070225000209K	|	AUDCSINF			|
#|
#|