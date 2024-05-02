
Feature:  Manage Program Validation 
# Background:
# Given user is logged on the LMS portal
   @TS_login_03
  Scenario Outline: User on login page and login with valid credentials from Excel "<Sheetname>" and <RowNumber>
    Given Admin is in Home Page
    When The Admin enter valid credentials from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |
 
 
 @tag1
  Scenario: Validate landing in Program page
    Given Admin is on dashboard page after Login for program module
    When Admin clicks "Program" on the navigation bar for program module
   #Then Admin should see URL with "Manage Program"
    Then Admin should see a heading with text "Manage Program" on the page for program module
   Then Admin should see the text as "Showing <x> to <y> of <z> entries" along with Pagination icon below the table. 
   #Then Admin should see the footer as ""In total there are z programs"".z- Total number of records"
    Then Admin should see a Delete button on the top left hand side as Disabled
    Then Admin should see a "A New Program" button on the program page above the data table
   #Then Admin should see the number of records (rows of data in the table) displayed on the page are 5
   Then Admin should see data table on the Manage Program Page with following column headers(Program Name, Program Description, Program Status, Edit,Delete)
   Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
   Then Admin should see check box on the left side in all rows of the data table 
   Then Admin should see the Edit and Delete buttons on each row of the data table
   Then Admin should see Search bar with text as "Search..."     
    
