@DataStructure
Feature: User launch DSAlgo application and test Data Structure functionality after login

 Background: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enters valid username "username" and password "password" and clicks "Login" button
    Then The user is redirected to homePage

@TS_DS_01
  Scenario: User lands on Data Structures Introduction Page on clicking Get Started button below Data Structures
    When The user clicks Get Started button below the "Datastructures" option
    Then The user should land on "Data Structures-Introduction"
    
@TS_DS_02
  Scenario: User lands on Data Structures Introduction Page on clicking Get Started button below Data Structures
    When The user clicks Get Started button below the "Datastructures" and then clicks Time Complexity button
    Then The user is redirected to "Time Complexity" page
 
 
   