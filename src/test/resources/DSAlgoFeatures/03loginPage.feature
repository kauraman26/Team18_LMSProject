@LoginPage
Feature: Verifying Signin Page feature

  @TS_login_01
  Scenario: Verify Register link
    Given User is on Signin Page
    When The user clicks on register link on signin page
    Then The user redirected to Registration page from signin page

  @TS_login_02
  Scenario: User on login page and click login button with password field empty
    Given The user is on signin page
    When The user enters username "Numpysdet841" and click Login button
    Then It should display an error "Please fill out this field." below password textbox

  @TS_login_03
  Scenario: User on login page and click login button with username field empty
    Given The user is on signin page
    When The user enters password "sdet84batch" and click Login button
    Then It should display an error "Please fill out this field." below username textbox

  @TS_login_04
  Scenario: User on login page and login with invalid credentials
    Given The user is on signin page
    When The user enters an invalid username "Numpysdet841" and  password "sdet84batch1" combination
    Then It should display an error "Invalid Username and Password"

  @TS_login_05
  Scenario: Verifying signout link
    Given The user is on signin page
    When The user enters valid username "Numpysdet84" and password "sdet84batch" and click on SignIn button
    Then The user redirected to homepage

  @TS_login_06
  Scenario Outline: User on login page and login with invalid and valid inputs from Excel "<Sheetname>" and <RowNumber>
    Given The user is on signin page
    When The user enter sheet "<Sheetname>" and <RowNumber>
    Then click login button

    Examples: 
      | Sheetname | RowNumber |
      | Login   |         0 |
      
      
