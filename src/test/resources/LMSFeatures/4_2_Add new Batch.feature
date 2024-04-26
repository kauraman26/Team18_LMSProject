
Feature: Add new Batch

 Background: 
   Given user is logged on LMS portal
   When  Admin clicks "Batch" from navigation bar and clicks "+ A New Batch" button
   Then  A new pop up with Batch details appears
   
  @tag1
  Scenario: Check if the fields exist in pop
    Given A new pop up with Batch details appears
    Then The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop down and Status as radio button
         


   @tag2
  Scenario: Check if description is optional field
    Given A new pop up with Batch details appears
    When Fill in all the fields except description with valid values and click save
      | Batch021 |
      | as |
      | 17 |   
    Then The newly added batch should be present in the data table in Manage Batch page

    Scenario: Check if the program details are added in data table
     Given A new pop up with Batch details appears
     When Fill in all the fields with valid values and click save
     | Batch022 |
      | SDET |
      | 20 | 
     Then The newly added batch should be present in the data table in Manage Batch page