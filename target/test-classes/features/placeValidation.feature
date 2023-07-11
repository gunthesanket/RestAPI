
@all
Feature: validation of adding the place

@Addplace
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
Given add payload "<name>", "<address>","<language>"
When User hits "AddAPI" with "post"  request
Then verify the status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify the get request with "<name>"


Examples:
|name|address|language|
|Sanket1|Pune1|Marathi1|
#|Neha|Nashik|English|

@Deleteplace
Scenario: Delete location
Given Add Payload
When User hits "DeleteAPI" with "post"  request
Then verify the status code 200
And "status" in response body is "OK"