
@tag
Feature: Delete multiple batches 

  @DeleteMultipleBatches1
  Scenario: Validate the delete icon below the header   
    Given None of the checkboxes in data table are selected
    Then  The delete icon under the "Manage Batch" header should be disabled
    
  @DeleteMultipleBatches2
  Scenario: Check for single row delete  
    Given One of the checkbox is selected
    When  Click delete icon below "Manage Batch" header
    Then  The respective row in the data table is deleted
    
   @DeleteMultipleBatches3
  Scenario: Check for multi row delete 
    Given Two or more checkboxes/row is selected
    When  Click delete icon below "Manage Batch" header
    Then  The respective row in the data table is deleted
  