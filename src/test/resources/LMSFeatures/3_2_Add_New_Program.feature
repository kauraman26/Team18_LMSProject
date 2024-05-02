Feature:  Add New Program 

Scenario: Validate Program Details Popup window
    Given Admin is on Manage Program page for "<testcase>" for Program
    When Admin clicks <A New Program> button
    Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
    Then Admin should see two input fields and their respective text boxes in the program details window
    Then Admin should see two radio button for Program Status 
    
  Scenario Outline: Empty form submission
  Given Admin is on "Program Details" Popup window 
   When Admin clicks <Save> button without entering any data from "<testcase>"
   Then Admin gets a Error message alert   
    Examples: 
      |testcase| 
      |blank data_01|    
            
  Scenario Outline: Enter only Program Name
    Given Admin is on "Program Details" Popup window
   When Admin enters only<Program Name> in text box from "<testcase>" and clicks Save button
    Then Admin gets a message alert 'Description is required' for name
    
    Examples: 
      |testcase| 
      |EnteredNameOnly| 
    
  Scenario Outline: Enter only Program Description 
    Given Admin is on "Program Details" Popup window
    When Admin enters only<Program description> in text box from "<testcase>" and clicks Save button
    Then Admin gets a message alert 'Name is required' for description
    
  Examples: 
      |testcase| 
      |EnteredDescOnly| 
      
  Scenario Outline: Select Status only
    Given Admin is on "Program Details" Popup window
    When Admin selects only Status and clicks Save button "<testcase>"
    Then Admin gets a message alert 'Name and Description required' for status
   
    Examples:
      |testcase| 
      |EnteredstatusOnly| 
   
  # Scenario Outline: Validate invalid values on the text column
   # Given Admin is on "Program Details" Popup window
   # When Admin enters only numbers or special char in name and desc column from "<testcase>"
   # Then Admin gets a Error message alert 
    
   # Examples: 
    #  |testcase  | 
     # |Enternnumericvalue |     
      
   Scenario Outline: Validate Save button on Program Details form
    Given Admin is on "Program Details" Popup window
    When Enter all the required fields with valid values and click Save button from excel "<testcase>"
    Then Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table
  
  Examples: 
      |testcase| 
      |addProgram_01|     
 
 # Scenario: Validate Cancel/Close(X) icon on Program Details form
  #  Given Admin is on "Program Details" Popup window
   # When Admin clicks Close Icon on Program Details form for program details
   # Then Program Details popup window should be closed without saving 
      

  
 # Scenario: Validate Cancel button on Program Details form
 #   Given Admin is on "Program Details" Popup window
 #   When Admin clicks <Cancel>button 
  #  Then Admin can see the Program details popup disappears without creating any program
        
  
