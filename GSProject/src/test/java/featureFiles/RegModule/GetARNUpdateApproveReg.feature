Feature: User is able to get the ApprovedARNUpdate for the mentioned file number
@Reg @G2G
Scenario Outline: User is able to get the ApprovedARNUpdate for the mentioned file number

Given the user has the authToken
And the user create ApprovedARNUpdate parameter list with <state_cd>, <arn>, <action>
When the user hits ApprovedARNUpdateAPI
Then the user receives success statusCode on ApprovedARNUpdateAPI

Examples: 

|	state_cd	| arn								|	action		|
|	99				|	AA260222000023A		|	ARNUPDATE	|