@DeleteProgram 
Feature: Program Page Verification

#Background: Admin is on Dashboard page 
#Given Admin in Dashboard Page 

@TS_Program_Delete_01
Scenario Outline: Delete Program Feature validation
Given Admin is on Manage Program page for "<testcase>"
When Admin clicks <Delete> button on the data table for any row
Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
And Admin should see a message "Are you sure you want to delete {Program name}?"

Examples:
|testcase|
|deleteprogram_01|

@TS_Program_Delete_02
Scenario Outline: Deletion Alert buttons validation
Given Admin is on Confirm Deletion alert for "<testcase>"
When Admin clicks "<button>" button on the alert
Then Admin can see the deletion alert disappears without any changes

Examples:
|testcase|button|
|deleteprogram_01|Close|
|deleteprogram_01|No|


@TS_Program_Delete_03
Scenario Outline: Deletion Alert buttons validation
Given Admin is on Confirm Deletion alert for "<testcase>"
When Admin clicks "<button>" button on the alert
Then Admin gets a message "Successful" alert and able to see that program deleted in the data table
Examples:
|testcase|button|
|deleteprogram_01|Yes|

@TS_Program_Delete_04
Scenario: Multiple delete Program validation
Given Admin is in Manage Program page
When Admin clicks any checkbox in the data table
Then Admin should see common delete option enabled under header Manage Program

@TS_Program_Delete_05
Scenario Outline: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert
When Admin clicks "<button>" button on the alert
Then Admin should land on Manage Program page and can see the selected program is deleted from the data table
And Admin should land on Manage Program page and can see the selected program is not deleted from the data table

Examples:
|button|
|Yes|
|No|
