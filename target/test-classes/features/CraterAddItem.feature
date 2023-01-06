@InventoryManagement
Feature: Crater Item Management

   @AddItem
  Scenario Outline: user is able to create an item or service
Given user is on the login page
And user enters valid "adminuser@primetechschool.com" and "Testing123"
And clicks on the login button
And user navigates to Items tab
When user clicks on the Add Item button
And user should be on item input page
When user provides item information name "<name>" and price "<price>" and unit "<unit>" and description "<description>"
And click Save Item button 


    Examples: 
      | name        | price   | unit    | description                 |
      | Tennis ball |   500   | USD     | Only to be used for practise|
      | Laptop      |   70000 | USD     | Gaming laptop               |
