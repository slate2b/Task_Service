
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
// 
//  This Task Service project is part of a small collection of back-end services developed for a hypothetical 
//  Mobile App.  The Task Service is designed to allow a user to manage the various tasks associated with their business.  
//  It includes a Task class for Task objects and a TaskService class which provides the necessary 
//  back-end functionality for the service.  The Task class contains basic getters and setters along with 
//  exception-handling to meet specifications.  The TaskService class contains methods which  provide functionality
//  to add a task, delete a task, and update a task.  
//
//  This project also includes JUnit tests designed to maximize test coverage and value.  JUnit tests in the TaskTest
//  class and TaskServiceTest class are implemented with input values which clearly demonstrate whether or not each 
//  component meets the specification with as much code coverage as possible.  
//  Coverage percentages for this service are 100% for the Task class and 96.9% for the TaskService class. 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package task_service;

import java.util.ArrayList;

public class TaskService {

	public static int searchTask(String task_id, ArrayList<Task> list) {
		
		// int variable for the index of matching object
		int searchIndex = -1;
		
		// Loop through list and search based on id
		for (int i = 0; i < list.size(); i++) {
			if (task_id == list.get(i).getTaskId()) {
				searchIndex = i;
			}
		}
		
		return searchIndex;
	}

	public static void addTask(String task_id, String name, String description, ArrayList<Task> list) {
		
		// Search list based on id
		int lookupIndex = searchTask(task_id, list); // search returns -1 if id is not found
		
		// If id is unique
		if (lookupIndex == -1) {
			
			// Create new object
			Task task = new Task(task_id, name, description);	
			
			// Add the new object to the taskList
			list.add(task);
		}
		
		// If id is NOT unique
		else {
			throw new IllegalArgumentException("Duplicate ID");
		}
	}
	
public static void deleteTask(String task_id, ArrayList<Task> list) {
		
		// Search list based on id
		// The search method returns -1 if not found, otherwise returns the index of the object in the list
		int lookupIndex = searchTask(task_id, list); 
		
		// If id is found
		if (lookupIndex != -1) {
			
			// Delete object
			list.remove(lookupIndex);
		}
		
		else {
			throw new IllegalArgumentException("Task not found");
		}
	}
	
public static void updateTask(String task_id, String name, String description, ArrayList<Task> list) {
	
	// A Task variable to temporarily hold task data
	Task tempTask;
	
	// Search list based on id
	// The search method returns -1 if not found, otherwise returns the index of the object in the list
	int lookupIndex = searchTask(task_id, list); 
	
		// If id is found
		if (lookupIndex != -1) {
			
			// Assign the object we found to the temp variable
			tempTask = list.get(lookupIndex);
			
			// update temp variable based on the arguments passed through the updateTask method call
			// Note: the id stays the same
			tempTask.setName(name);
			tempTask.setDescription(description);
	
			// update the corresponding object in list
			list.set(lookupIndex, tempTask);
		}
	
		else {
			throw new IllegalArgumentException("Task not found");
		}
	}
}

// addTask
//		Ensure unique taskId
//			Search data structure by taskId
//			If found, throw exception
//			If NOT found, create new task and add to data structure

// deleteTask
//		Search data structure by taskId
//		If NOT found, throw exception
//		If found, remove from data structure

// updateTask
//		Search data structure by taskId
//		If NOT found, throw exception
//		If found, update name and description fields only
