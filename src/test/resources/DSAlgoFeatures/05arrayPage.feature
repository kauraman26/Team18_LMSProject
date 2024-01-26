@array
Feature: User launch dsalgo application and test Array page

  @TS_array_01
  Scenario: The user is able to navigate to Arrays Data Structure Page
    Given The user is on the home page after logged in
    When The user clicks Get Started button under Array
    Then The user be directed to "Array" Data Structure Page

  @TS_array_02
  Scenario: The user is able to navigate to Arrays in Python page
    Given The user is on the Array Page after logged in
    When The user clicks "Arrays in Python" link
    Then The user should be redirected to "Arrays in Python" page

  @TS_array_03
  Scenario: The user is able to navigate to a page having an tryEditor from Arrays in Python page
    Given The user is on the Arrays in Python after logged in
    When The user clicks "Try Here" button on "Arrays in Python" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  @TS_array_04
  Scenario Outline: The user is able run code in tryEditor for Arrays in Python page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with Run result

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @TS_array_05
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Arrays in Python page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with error message as "NameError: name 'hello' is not defined on line 1"

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         2 |
