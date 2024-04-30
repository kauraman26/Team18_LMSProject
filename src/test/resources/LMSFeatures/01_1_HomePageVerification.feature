@LoginPage
Feature: Home Page Verification

  @TS_login_01
  Scenario: Verify admin is able to land on home page with invalid URL
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve 404 page not found error

  @TS_login_02
  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
  
  @TS_login_20
  Scenario Outline: Validate login with invalid credentials from Excel "<Sheetname>" and <RowNumber>
    Given Admin is in Home Page
    When Admin enter invalid credentials  from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Error Message "Invalid username and password Please try again"

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         1 |
      
  #@TS_login_04
  #Scenario: Verify for broken link
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then HTTP response >= 400. Then the link is broken

  @TS_login_05
  Scenario: Verify the text spelling in the page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields

  #@TS_login_06
  #Scenario: Verify the company logo
  #Given Admin launch the browser
  #When Admin gives the correct LMS portal URL
  #Then Admin should see logo on the left  side
  #
  #@TS_login_07
  #Scenario: Verify application name
  #Given Admin launch the browser
  #When Admin gives the correct LMS portal URL
  #Then Admin should see  LMS - Learning Management System
  #
  #@TS_login_08
  #Scenario: Verify company name
  #Given Admin launch the browser
  #When Admin gives the correct LMS portal URL
  #Then Admin should see company name below the app name
  #
  @TS_login_09
  Scenario: Validate sign in content
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"

  @TS_login_10
  Scenario: Verify text field is present
  Given Admin launch the browser
  When Admin gives the correct LMS portal URL
  Then Admin should see two text field
  
  @TS_login_11
  Scenario: Verify text on the first text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should "User" in the first text field

  @TS_login_12
  Scenario: Verify asterik next to user text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "*" symbol next to user text

  @TS_login_13
  Scenario: Verify text on the second text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should "Password" in the second text field

  @TS_login_14
  Scenario: Verify asterik next to password text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "*" symbol next to password text

  #@TS_login_15
  #Scenario: Verify the alignment input field for the login
  #Given Admin launch the browser
  #When Admin gives the correct LMS portal URL
  #Then Admin should see input field on the centre of the page
  
  @TS_login_16
  Scenario: verify Login is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button

  #@TS_login_17
  #Scenario: Verify the alignment of the login button
    #Given Admin launch the browser
    #When Admin gives the correct LMS portal URL
    #Then Admin should see login button on the centre of the page

  @TS_login_18
  Scenario: Verify input descriptive test in user field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see user in gray color

  @TS_login_19
  Scenario: Verify input descriptive test in password field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see password in gray color

  @TS_login_20
  Scenario: Validate login credentials with null username
    Given Admin is in Home Page
    When Admin enter "" value only in password and clicks login button
    Then Error message "please enter your password"

  @TS_login_21
  Scenario: Validate login credentials with null password
    Given Admin is in Home Page
    When Admin enter "" value only in username and clicks login button
    Then User gets Error message "please enter your user name"

  @TS_login_22
  Scenario Outline: verify login button action through keyboard with valid credentials from Excel "<Sheetname>" and <RowNumber>
    Given Admin is in Home Page
    When Admin enter valid credentials from excel "<Sheetname>" and <RowNumber>  and clicks login button through keyboard
    Then Admin should land on dashboard page
    
     Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |
      
  @TS_login_23
  Scenario: verify login button action through mouse
    Given Admin is in Home Page
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on dashboard page
    

      