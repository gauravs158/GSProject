Feature: Registration module GetEntity API verification
@Reg @G2G
Scenario Outline: GetEntity API verification

Given the user has the authToken
And the user create GetEntity parameter list with <state_cd>, <idty>, <id>, <action>
When the user hits GetEntityAPI
Then the user gets success statusCode

Examples: 

|	state_cd	| idty	|	ID							|	action	|
|	07				|	GSTIN	|	07QPXXA1220A1ZN	|	ENT			|
#|
#|