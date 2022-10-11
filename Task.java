
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

public class Task {

	// Class variables
	private String taskId = "";
	private String Name = "";
	private String Description = "";
	
	// Full Constructor
	public Task(String task_id, String name, String description) {
		setTaskId(task_id);
		setName(name);
		setDescription(description);
	}
	
	/*********************
	 * Getters and Setters
	 *********************/
	
	public String getTaskId() {
		return taskId;
	}
	
	// Requirements: unique, <= 10 chars, cannot be null, cannot be updated 
	// Handling unique and not updatable requirements in addTask method
	public void setTaskId(String task_id) {
		if (task_id == null || task_id.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.taskId = task_id;
	}
	
	public String getName() {
		return Name;
	}
	
	// Requirements: <= 20 chars, cannot be null
	public void setName(String name) {
		if (name == null || name.length()>20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.Name = name;
	}
	
	public String getDescription() {
		return Description;
	}
	
	// Requirements: <= 50 chars, cannot be null
	public void setDescription(String description) {
		if (description == null || description.length()>50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.Description = description;
	}
}
