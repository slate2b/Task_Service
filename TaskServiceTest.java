package test.task_service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task_service.Task;
import task_service.TaskService;

class TaskServiceTest {

	// Declare ArrayList for use in the following tests. Can be replaced with different data structure if needed in future versions.
	static private ArrayList<Task> taskList;
	
	@BeforeAll
	static void setupAll() {
		
		// Instantiate the data structure
		taskList = new ArrayList<Task>();
	}
	
	@BeforeEach
	void setupEach() {
		
		// Clear the list
		taskList.clear();
		
		// Add an object for testing purposes
		TaskService.addTask("1234567890", "It has 20 characters", 
				"This string should contain fifty characters total.", 
				taskList);
	}

	// Testing the addTask method with a unique id
	@Test
	void testAddTask() {
		
		// Calling addTask method
		TaskService.addTask("0987654321", "20 characters it has", 
				"Fifty characters total should this string contain.", 
				taskList);
		
		// Using index 1 since @BeforeEach created an object at index 0
		assertTrue(taskList.get(1).getTaskId().equals("0987654321"));
		assertTrue(taskList.get(1).getName().equals("20 characters it has"));
		assertTrue(taskList.get(1).getDescription().equals("Fifty characters total should this string contain."));
	}
	
	// Testing the duplicate id exception by calling addTask with same id as existing object
	@Test
	void testAddTaskDuplicate() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskService.addTask("1234567890", "It has 20 characters", 
					"This string should contain fifty characters total.", 
					taskList);
		}); 
	}
	
	// Testing the deleteTask method with the id of the existing object in list
	@Test
	void testDeleteTask() {
		
		// Calling deleteTask method
		TaskService.deleteTask("1234567890", taskList);
		
		// Checking to see if list is now empty
		assertTrue(taskList.isEmpty());
	}
	
	// Testing the task not found exception by calling deleteTask with id which doesn't match existing object
	@Test
	void testDeleteTaskNotFound() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskService.deleteTask("4563215897", taskList);
		}); 
	}
	
	// Testing the updateTask method with valid attribute values
	// NOTE: When updating a task, the taskId is not updatable.
	@Test
	void testUpdateTask() {
		
		//Calling updateTask method
		TaskService.updateTask("1234567890", "Something different.", "Something different that is fifty characters long.", taskList);
		
		assertTrue(taskList.get(0).getTaskId().equals("1234567890"));
		assertTrue(taskList.get(0).getName().equals("Something different."));
		assertTrue(taskList.get(0).getDescription().equals("Something different that is fifty characters long."));
	}
	
	// Testing the task not found exception by calling updateTask with id that doesn't match existing object
	@Test
	void testUpdateTaskNotFound() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskService.updateTask("51326987", "Something different.", "Something different that is fifty characters long.", taskList);
		});
	}	
}
