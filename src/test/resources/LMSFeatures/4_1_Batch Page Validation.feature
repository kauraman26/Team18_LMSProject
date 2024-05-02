@tag
Feature: Batch Page Validation

  Scenario: Login with valid credentials
     Given user is logged on the LMS portal
  @BatchPage1
  Scenario: Validate landing in Batch page
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the URL

  @BatchPage2
  Scenario: Validate header in the Batch Page
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the header

  @BatchPage3
  Scenario: Validate pagination in the Batch Page
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the pagination controls under the data table

  @BatchPage4
  Scenario: Validate data table headers in the Batch Page
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete

  @BatchPage5
  Scenario: Validate Delete button in Batch Page
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Admin should be able to see the "Delete" icon button that is disabled

  @BatchPage6
  Scenario: Validate "+ A New batch" in Batch Page
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Admin should be able to see the "+ A New batch" button

  @BatchPage7
  Scenario: Validate data rows
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "Batch" from navigation bar
    Then Each row in the data table should have a checkbox and edit icon and delete icon enabled

  @BatchPage8
  Scenario: Validate pop up for adding batch
    Given Admin is on dashboard page after Login for Batch
    When Admin clicks "+ A New Batch" button
    Then A new pop up with Batch details appears
