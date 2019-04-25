#Author: Swathiraj
#Keywords Summary :
#Feature: PHPTravels Demo Page
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@php_demo_page
Feature: PHPTravels Demo Page Navigation
  @php_admin_page
  Scenario Outline: Navigate to PHP Travels Admin Home Page
    Given the user is on the PHPTravels Demo Page
    Then I navigate on PHP Admin login page
    And I enter the emailid with <emailid> and password with <passwd>
    Examples: 
      | emailid  | passwd | status  |
      | admin@phptravels.com |     demoadmin | success |
