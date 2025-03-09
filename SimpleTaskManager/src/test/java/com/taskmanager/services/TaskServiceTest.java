package com.taskmanager.services;

import com.taskmanager.models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        Task task = new Task(1, "Test Task", "Description");
        taskService.addTask(task);

        List<Task> tasks = taskService.getAllTasks();
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }

    @Test
    void testGetTaskById() {
        Task task = new Task(1, "Find Me", "Task Description");
        taskService.addTask(task);

        Optional<Task> foundTask = taskService.getTaskById(1);
        assertTrue(foundTask.isPresent());
        assertEquals("Find Me", foundTask.get().getTitle());
    }

    @Test
    void testUpdateTask() {
        Task task = new Task(1, "Initial Task", "Initial Description");
        taskService.addTask(task);

        boolean updated = taskService.updateTask(1, "Updated Task", "Updated Description");
        assertTrue(updated);
        assertEquals("Updated Task", taskService.getTaskById(1).get().getTitle());
    }

    @Test
    void testDeleteTask() {
        Task task = new Task(1, "To be deleted", "Description");
        taskService.addTask(task);

        assertTrue(taskService.deleteTask(task));
        assertFalse(taskService.deleteTask(task)); // Already deleted
    }
}
