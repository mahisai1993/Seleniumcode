#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions

@tag
Feature: Purchase from Ecommerce app
  I want to use this template for my feature file
  
Background:
Given Login into the Ecommerce Application


@Errorvalidation
  Scenario Outline: Positive Test for submitting the order
    Given landed in ecommerce page 
   	When  Login with username <username> and password <password>
    Then "Incorect email or password." message is displayed 
    Examples: 
    | username  				| 						password 	|
    | anshika@gmal.com |    Iamking@000 				|
    
    
    
    
   