Feature: DashBoard page

  Scenario Outline: Verify after login admin lands on manage program as dashboard page
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Verify the response time
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Verify LMS title
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should see "LMS - Learning Management System"  as title

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Validate navigation bar text
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should see correct spelling in navigation bar text

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Validate navigation bar order 1st Program
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should see correct spelling Program in navigation bar text
    Then Admin should see correct spelling Batch in navigation bar text

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Validate navigation bar order 2nd Batch
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should see correct spelling Batch in navigation bar text

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Validate navigation bar order 3rd User
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should see correct spelling User in navigation bar text

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Validate navigation bar order 4th Logout
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should see correct spelling Logout in navigation bar text

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Validate alignment for navigation bar
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then LMS title should be on the top left corner of page

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |

  Scenario Outline: Validate alignment for navigation bar
    Given Admin is in Home Page
    When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button
    Then Admin should see the navigation bar text on the top right side

    Examples: 
      | Sheetname | RowNumber |
      | Login     |         0 |
    #Scenario Outline: Validate navigation bar order 1st Program
    #Given Admin is in Home Page
    #When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button  
    #Then Admin should see correct spelling "Program"  in navigation bar text 
       #Then Admin should see correct spelling "Batch" in navigation bar text 
       #Then Admin should see correct spelling "User"  in navigation bar text 
       #Then Admin should see correct spelling "Logout" in navigation bar text 
   #Examples: 
      #| Sheetname | RowNumber |
      #| Login     |         0 |
    #
    #Scenario: Verify broken link
    #Given Admin is in Home Page
    #When Admin enter valid credentials and clicks login button 
    #When The Admin enter valid username and password from excel "<Sheetname>" and <RowNumber> and clicks login button        
    #Then HTTP response >= 400 the link is broken
     # Examples: 
      #| Sheetname | RowNumber |
      #| Login     |         0 |
