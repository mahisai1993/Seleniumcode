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


@Regression
  Scenario Outline: Positive Test for submitting the order
    Given Login with username <username> and password <password>
    When added product <productname> to cart
    And Check the product <productname> added in cart
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation page
    Examples: 
    | username  				| 						password 	|	productName				|
    | anshika@gmail.com |    Iamking@000 				| ZARA COAT 3				|
    
    
    
    
   