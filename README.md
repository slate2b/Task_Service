# Task_Service
by slate2b
---
This Task Service project is part of a small collection of back-end services developed for a hypothetical Mobile App, utilizing JUnit tests and coverage analysis tools to reinforce quality assurance for the service.  The Task Service is designed to allow a business user to manage the various tasks associated with their business.  It includes a Task class for Task objects and a TaskService class which provides the necessary back-end functionality for the service.  The Task class contains basic getters and setters along with exception-handling to meet specifications.  The TaskService class contains methods which  provide functionality to add a task, delete a task, and update a task.

The JUnit tests for the project are designed to maximize test coverage and value.  JUnit tests in the TaskTest class and TaskServiceTest class are implemented with input values which clearly demonstrate whether or not each component meets the specification with as much code coverage as possible.  Coverage percentages for this service are 100% for the Task class and 96.9% for the TaskService class. 

![T_Vaughn TaskServiceTest](https://user-images.githubusercontent.com/88697660/194997164-c6a54e27-3777-4251-b404-e1435aef91ed.PNG)

The Task class is designed to meet the following requirements:

* taskId's must be unique
* taskId's must be <= 10 characters
* taskId's cannot be null
* taskId's cannot be modified
* name must be <= 20 characters
* name cannot be null
* description must be <= 50 characters
* description cannot be null

The TaskService class is designed to meet the following requirements:

* Allow user to add a task
* Allow user to delete a task
* Allow user to update a task

The Task Service is designed to throw exceptions for the following:

* Attempting to add a duplicate task
* Attempting to add a task with data which does not meet all Task class requirements
* Attempting to update a task which doesn't exist
* Attempting to update a task with data which does not meet all Task class requirements
* Attempting to delete a task which doesn't exist

The updateTask method is designed to update all attributes except for the taskId, thereby fulfilling the business reqirement that a taskId can not be modified.

NOTE: This service is implemented using a simple ArrayList data structure and a linear search for testing purposes, but the services could easily be adapted to implementations utilizing more complex data structures and more efficienct search algorithms.
