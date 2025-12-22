Feature: Registration module Composition Levy Excluded Taxpayer based on AATO API verification
@Reg @G2G
Scenario Outline: CompLevyExcludTPBasedAATO API verification

Given the user has CompLevyExcludTPbasedAATO authToken
And the user create CompLevyExcludTPBasedAATO parameter list with <state_cd>, <arn>, <action>
When the user hits CompLevyExcludTPBasedAATO API
Then the user gets CompLevyExcludTPbasedAATO success statusCode

Examples: 
|	state_cd	| arn				|		action	|
|	99			| abcde12345		|		REQ		|