package test.task_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import task_service.Task;

class TaskTest {

	// Testing the Task class constructor with valid attribute values
	@Test
	void testTaskClass() {
		
		Task task = new Task("1234567890", "It has 20 characters", 
				"This string should contain fifty characters total.");
		assertTrue(task.getTaskId().equals("1234567890"));
		assertTrue(task.getName().equals("It has 20 characters"));
		assertTrue(task.getDescription().equals("This string should contain fifty characters total."));
	}
	
	// Testing the invalid id exception with id too long
	@Test
	void testIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "It has 20 characters", 
					"This string should contain fifty characters total.");
		}); 
	}
	
	// Testing the invalid id exception with a null value
	@Test
	void testIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "It has 20 characters", 
					"This string should contain fifty characters total.");
		}); 
	}

	// Testing the invalid name exception with name too long
	@Test
	void testNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "It has 20 charactersX", 
					"This string should contain fifty characters total.");
		}); 
	}
	
	// Testing the invalid name exception with a null value
	@Test
	void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", null, 
					"This string should contain fifty characters total.");
		}); 
	}
	
	// Testing the invalid description exception with description too long
	@Test
	void testDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "It has 20 characters", 
					"This string should contain fifty characters total.X");
		}); 
	}
	
	// Testing the invalid description exception with a null value
	@Test
	void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "It has 20 characters", null);
		}); 
	}	
}
