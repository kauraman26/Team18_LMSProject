@DeleteProgram 
Feature: Delete Program Page Verification


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
||Close|
||No|


@TS_Program_Delete_03
Scenario Outline: Deletion Alert buttons validation
Given Admin is on Confirm Deletion alert for "<testcase>"
When Admin clicks "<button>" button on the alert
Then Admin gets a message "Successful" alert and able to see that program deleted in the data table
Examples:
|testcase|button|
||Yes|

@TS_Program_Delete_04
Scenario Outline: Single or Multiple delete Program validation
Given Admin is on Manage Program page for "<testcase>"
When Admin clicks "<type>" checkbox in the data table
Then Admin should see common delete option enabled under header Manage Program
When Admin clicks on common delete button
Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
When Admin clicks "Yes" button on the alert
Then Admin gets a message "Successful" alert and able to see that program deleted in the data table


Examples:
|testcase|type|
||Single|
||Multiple|

@TS_Program_Delete_sorting_05
Scenario Outline: Sort Program validation
Given Admin is on Manage Program page for "<testcase>"
When Admin clicks "<headerName>" link at "<order>"
Then Datatable should be arranged in "<order>"
Examples:
|testcase|headerName|order|
||programName|asc|
||programName|dsc|
||programDescription|asc|
||programDescription|dsc|
||programStatus|asc|
||programStatus|dsc|

@TS_Program_Delete_Navigation_06
Scenario Outline: Navigation Program validation
Given Admin is on Manage Program page for "<testcase>"
When Admin clicks "<nextPage>" pagelink at <currentPage>
Then <currentPage> should be enabled and "<nextPage>" should be disabled
Examples:
|testcase|nextPage|currentPage|
||next|1|
||previous|2|
||last|1|
||first|5|

@TS_Program_Delete_Navigation_07
Scenario Outline: Navigation Validation from Manage Program to other Pages
Given Admin is on Manage Program page for "<testcase>"
When Admin clicks on "<navigation>" link
Then Admin redirected to "<target>" page

Examples:
|testcase|navigation|target|
||batchLink|Manage Batch|
||userLink|Manage User|
||logoutLink|home|
