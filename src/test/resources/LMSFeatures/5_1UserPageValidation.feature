Feature: Home Page Verification

  @TS_login_01
  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page

  @TS_login_03
  Scenario Outline: User on login page and login with valid credentials from Excel "<Sheetname>" and <RowNumber>
    Given Admin is in Home Page
    When The Admin enter valid credentials from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  @TS_validate_user_fields
  Scenario: Validate landing in UserPage
    Given Admin is on dashboard page after Login
    When Admin clicks on "user" from navigation bar
    Then Wait for 3000 ms
    Then Admin should see the "user" in the URL
    Then Wait for 2000 ms
    Then Admin should see a heading with text "Manage User" on the page
    Then Wait for 2000 ms
    Then Wait for 2000 ms
    Then Admin Should see the data table with column name "ID" at postition 2
    Then Wait for 2000 ms
    Then Admin Should see the data table with column name "Name" at postition 3
    Then Admin Should see the data table with column name "Location" at postition 4
    Then Admin Should see the data table with column name "Phone Number" at postition 5
    Then Admin Should see the data table with column name "Edit / Delete" at postition 6
    Then Wait for 2000 ms
    Then Admin should see a Delete button on the top left hand side as Disabled for user
    Then Admin should be able to see the "new" button at position 1 with text "Add New User" button above the data table
    Then Admin should be able to see the "Assign" button at position 2 with text "Assign Staff" button above the data table
    Then Admin should be able to see the "Assign" button at position 1 with text "Assign Student" button above the data table
    Then Admin should be able to see the search text box "filterGlobal" above the data table
    Then Admin should see two records at position 2 and 3 displayed on the data table
    Then Each row in the data table should have a checkbox
    Then Each row in the data table should have a "p-button-rounded p-button-danger p-button p-component p-button-icon-only" that is enabled
    Then Each row in the data table should have a "p-button-rounded p-button-success p-button p-component p-button-icon-only" that is enabled

  #@TS_User_sorting_05
  #Scenario Outline: Sort Program validation
    #When Admin clicks "<headerName>" link at "<order>"
    #Then Datatable should be arranged in "<order>"
#
    #Examples: 
      #| testcase | headerName      | order |
      #|          | userId          | asc   |
      #|          | userId          | dsc   |
      #|          | userFirstName   | asc   |
      #|          | userFirstName   | dsc   |
      #|          | userPhoneNumber | asc   |

  @TS_User_Delete
  Scenario Outline: Single or Multiple delete Program validation
    When Admin clicks "<type>" checkbox in the data table
    Then Admin should see common delete option enabled under header Manage Program
    When Admin clicks on common delete button
    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
    When Admin clicks "Yes" button on the alert
    Then Admin gets a message "Successful" alert and able to see that program deleted in the data table

    Examples: 
      | testcase | type     |
      |          | Single   |
      |          | Multiple |

  @TS_User_pagination
  Scenario Outline: Navigation Program validation
    When Admin clicks "<nextPage>" pagelink at <currentPage>
    Then <currentPage> should be enabled and "<nextPage>" should be disabled

    Examples: 
      | testcase | nextPage | currentPage |
      |          | next     |           1 |
      |          | previous |           2 |
      |          | last     |           1 |
      |          | first    |           5 |

  @TS_User_validate_searchnox
  Scenario Outline: search user by name
    Given Admin is on Manage User Page
    When Admin enters "<validusername>" into search box
    Then Admin should see "<validusername>" displayed with the entered name

    Examples: 
      | validusername |
      | john Matthew  |

  @TS_User_validate_searchnox
  Scenario Outline: search user by name
    Given Admin is on Manage User Page
    When Admin clear data in search box
    When Admin enters "<invalidusername>" into search box
    Then Wait for 2000 ms
    Then Admin should see "Showing 0 to 0 of 0 entries" on the data table

    Examples: 
      | invalidusername |
      | xxx             |

  @TS_validate_user_popup
  Scenario: Validate User Details Popup window
    Given Admin is on Manage User Page
    When Admin clicks "new" button
    Then Wait for 2000 ms
    Then Admin should see pop up open for user details with "First name" "Middle name" "Last name" "Location" "Phone no" "LinkedIn Url" "Under Graduate" "Post Graduate" "Time Zone" "User Comments" "Cancel" "Submit"
    Then Admin close the popup

  @TS_validate_user_popup
  Scenario: Validate User Details Popup window
    Given Admin is on Manage User Page
    Then Wait for 3000 ms
    When Admin clicks "new" button
    Then Wait for 2000 ms
    Then Admin should see pop up open for user details with labels "User Role" "User Role Status" "User Visa Status"
    Then Admin close the popup

  @TS_validate_user_popup
  Scenario: Validate input fields and text boxes in user details form
    Given Admin is on Manage User Page
    When Admin clicks "new" button
    Then Wait for 2000 ms
    Then Admin should see txtfields "First name" "Middle name" "Last name" "Location" "Phone no" "LinkedIn Url" "Under Graduate" "Post Graduate" "Time Zone" "User Comments"
    Then Admin close the popup

  @TS_validate_user_popup
  Scenario: Validate dropdown fields in user details form
    Given Admin is on Manage User Page
    When Admin clicks "new" button
    Then Wait for 2000 ms
    Then Admin should see drop downs for the fields "Select Role","Select Role Status", "Select Visa Status" on user details pop up
    Then Admin close the popup

  @TS_add_user
  Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on  User details pop up
    When Admin clicks "new" button
    And Admin enters mandatory fields from exel "<testcase>" in the form and clicks on submit button
    And Wait for 3000 ms
    Then Admin gets message "User Added Successfully"

    Examples: 
      | testcase   |
      | addUser_01 |

  @TS_add_user
  Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on  User details pop up
    When Admin clicks "new" button
    And Admin enters mandatory fields and same email and same phone number "<FirstName>","<MiddleName>","<LastName>","<Location>","<Phone>","<linkedin>","<email>","<ug>","<pg>","<TZ>","<cmt>"in the form and clicks on submit button
    And Wait for 3000 ms
    Then Admin gets fail popup

    Examples: 
      | FirstName | MiddleName | LastName | Location | Phone      | linkedin                       | email                | ug | pg | TZ  | cmt         |
      | rama      | sree       | marani   | ohio     | 6147076085 | https://www.linkedin.com/feed/ | ramasreemd@gmail.com | BE | ME | EST | hhdhfhfdhhf |

  @TS_add_user
  Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on  User details pop up
    When Admin clicks "new" button
    And Admin enters mandatory fields from exel "<testcase>" in the form and clicks on submit button
    And Wait for 3000 ms
    Then Admin should see "First name is " below the test field "First name is required"
    Then Admin should see "Middle name is " below the test field "Middle name is required"

    Examples: 
      | testcase   |
      | addUser_02 |

  @TS_add_user
  Scenario: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on  User details pop up
    And Wait for 3000 ms
    When Admin clicks "new" button
    And Wait for 3000 ms
    And Admin clicks on submit button without entering data
    And Wait for 3000 ms
    Then Admin should see "First name is " below the test field "First name is required"
    Then Admin should see "Middle name is " below the test field "Middle name is required"
    
     @TS_validate_user_popup
  Scenario: Validate User Details Popup window
    Given Admin is on Manage User Page
    When Admin clicks "Assign" button
    Then Wait for 2000 ms
    Then Admin should see pop up open for user details with "First name" "Middle name" "Last name" "Location" "Phone no" "LinkedIn Url" "Under Graduate" "Post Graduate" "Time Zone" "User Comments" "Cancel" "Submit"
    Then Admin close the popup
    
    
    
