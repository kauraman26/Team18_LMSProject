@tag
Feature: Batch Page Validation
  Background:
  Given user is logged on the LMS portal

  @tag1
  Scenario: Validate landing in Batch page
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the URL
  
  @tag1
  Scenario: Validate header in the Batch Page
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the header
    
  Scenario: Validate pagination in the Batch Page 
    Given Admin is on dashboard page after Login for Batch
    When  Admin clicks "Batch" from navigation bar
    Then  Admin should see the pagination controls under the data table
  
  Scenario: Validate data table headers in the Batch Page
    Given Admin is on dashboard page after Login for Batch
    When  Admin clicks "Batch" from navigation bar
    Then  Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
      
  Scenario: Validate Delete button in Batch Page
    Given Admin is on dashboard page after Login for Batch
    When  Admin clicks "Batch" from navigation bar
    Then  Admin should be able to see the "Delete" icon button that is disabled
  
   Scenario: Validate "+ A New batch" in Batch Page
     Given Admin is on dashboard page after Login for Batch
     When  Admin clicks "Batch" from navigation bar
     Then  Admin should be able to see the "+ A New batch" button
     
   Scenario: Validate data rows
     Given Admin is on dashboard page after Login for Batch
     When  Admin clicks "Batch" from navigation bar
     Then  Each row in the data table should have a checkbox and edit icon and delete icon enabled

  Scenario: Validate pop up for adding batch
    Given Admin is on dashboard page after Login for Batch
    When  Admin clicks "+ A New Batch" button
    Then  A new pop up with Batch details appears
  
  
  
  