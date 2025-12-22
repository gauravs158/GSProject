Feature: Registration module CompulsoryWithdrawalTPResponsetoSCN API verification
@Reg @G2G
Scenario Outline: CompulsoryWithdrawalTPResponsetoSCN API verification

Given the user has CompulsoryWithdrawalTPResponsetoSCN authToken
And the user create CompulsoryWithdrawalTPResponsetoSCN parameter list with <state_cd>, <arn>, <action>
When the user hits CompulsoryWithdrawalTPResponsetoSCN API
Then the user gets CompulsoryWithdrawalTPResponsetoSCN success statusCode

Examples: 
|	state_cd	| arn				|		action	|
|	99			| abcde12345		|		REQ		|