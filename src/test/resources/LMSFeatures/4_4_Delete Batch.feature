
@tag
Feature: Delete Batch

  @DeleteBatch1
  Scenario: Validate row level delete icon
    Given The delete icon on row level in data table is enabled
    When Admin clicks the delete icon
    Then Alert appears with yes and No option
    
  @DeleteBatch2 
  Scenario: Validate accept alert
    When You click yes option
    Then Batch deleted alert pops and batch is no more available in data table 
    
  @DeleteBatch3
  Scenario: Validate reject alert
    Given Admin clicks the delete icon
    When you click No option
    Then Batch is still listed in data table 
  
  
