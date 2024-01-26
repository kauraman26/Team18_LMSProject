@Register
Feature: Feature file to test register
@TS_Register_01
  Scenario: The user is presented with error message for empty fields below username textbox
    Given The user opens Register page
    When The user clicks "Register" button with all fields empty
    Then It should display an error message "Please fill out this field."
@TS_Register_02
  Scenario: The user is presented with error message for empty fields below Password textbox
    Given The user opens Register page
    When The user enters username "Numpy@sdet82" with other fields empty and then clicks Register button.
    Then It should throws an error "Please fill out this field."
@TS_Register_03
  Scenario: The user is presented with error message for empty fields below Password1 textbox
    Given The user opens Register page
    When The user clicks Register button after giving the username "Numpy@sdet82" and password "Ninja123" with password confirmation field empty
    Then The user can see the error message "Please fill out this field."
@TS_Register_04
  Scenario Outline: The user is presented with an error message
    Given The user opens Register page
    When The user enters "<username>", "<password>", and "<password1>"
    And the user clicks the register button
    Then the user should see the error message indicating "<errormessage>"

    Examples: 
      | username       | password  | password1  | errormessage                                                      |
      | Numpy@123!     | Numpy@123 | Numpy@123  | Please enter valid username                                       |
      | Numpy@SDET84_1 | Numpy@123 | Numpy@123  | Username already exists                                           |
      | kalasdet118    | Numpy@123 | Numpy@1234 | password_mismatch:The two password fields didn’t match.           |
      | kalasdet118    | Numpy     | Numpy      | Password should contain at least 8 characters                     |
      | kalasdet118    |  12345678 |   12345678 | Password cannot be entirely numeric                               |
      | kalasdet118    | sdet@123  | sdet@123   | Password cannot be too similar to your other personal information |
      | kalasdet118    | Test@1    | Test@1     | Password cannot be commonly used password                         |
@TS_Register_05
  Scenario Outline: User on Register page and register with valid inputs from Excel
    Given The user is on Register page
    When The user enters sheetname "<Sheetname>" and rownumber <RowNumber>
    Then click the Register button and verify success message "New Account Created. You are logged in as "

    Examples: 
      | Sheetname | RowNumber |
      | Register  |         0 |
