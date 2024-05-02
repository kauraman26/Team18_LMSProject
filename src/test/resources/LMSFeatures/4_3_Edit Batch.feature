@tag
Feature: Edit Batch

  @EditBatch1
  Scenario: Validate row level edit icon
    Given The edit icon on row level in data table is enabled
    When Admin clicks the edit icon
    Then A new pop up with Batch details appears

  @EditBatch2
  Scenario Outline: Check if the fields are updated
    Given Admin clicks the edit icon for "<testcase>"
    When Update the fields for "<testcase>" and click save
    Then The updated batch details should appear on the data table

    Examples: 
      | testcase          |
      | UpdateValidValues |

  @EditBatch3
  Scenario Outline: Check if the update throws error with invalid values
    Given Admin clicks the edit icon
    When Update the fields "<testcase>" and click save
    Then Error message should appear

    Examples: 
      | testcase            |
      | UpdateInvalidValues |

  @EditBatch4
  Scenario Outline: Check if you get error message when mandatory fields are erased
    Given Admin clicks the edit icon
    When Erase data from mandatory field for "<testcase>"
    Then Error message should appear

    Examples: 
      | testcase       |
      | ClearMandatory |
  #@tag5
  #Scenario: Check if description field is optional in update
    #Given Admin clicks the edit icon
    #When Erase data from description field
    #Then The updated batch details should appear on the data table
