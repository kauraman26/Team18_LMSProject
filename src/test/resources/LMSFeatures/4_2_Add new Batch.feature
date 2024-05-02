Feature: Add new Batch

  @AddBatch1
  Scenario Outline: Check if the fields exist in pop
    Given A new pop up with a Batch details appears
    Then The pop up should include all "<Fields>"

    Examples: 
      | Fields        |
      | Name          |
      | Description   |
      | Program Name  |
      | Status        |
      | No Of Classes |

  @AddBatch2
  Scenario Outline: Check if description is optional field
    Given A new pop up with Batch details appears
    When Fill in all the fields except description with valid values from excel "<SheetName>" and <RowNumber> and click save
    Then The newly added batch should be present in the data table in Manage Batch page

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         0 |

  @AddBatch3
  Scenario Outline: Check if the program details are added in data table
    Given A new pop up with Batch details appear
    When Fill in all the fields with valid values from excel "<SheetName>" and <RowNumber> and click save
    Then The newly added batch should be present in the data table in Manage Batch page

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         1 |

  @AddBatch4
  Scenario Outline: Check for error messages for invalid fields
    Given A new pop up with Batch details appear
    When Any of the fields have invalid values from excel "<SheetName>" and <RowNumber>
    Then Error message should appear

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         2 |

  @AddBatch5
  Scenario Outline: Check for error messages for mandatory fields
    Given A new pop up Batch details appear
    When Any of the mandatory fields are blank from excel "<SheetName>" and <RowNumber>
    Then Error message should appear

    Examples: 
      | SheetName | RowNumber |
      | Batch     |         3 |
