package com.taskmanager.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testTaskProperties() {
        Task task = new Task(1, "Task Title", "Task Description");

        assertEquals(1, task.getId());
        assertEquals("Task Title", task.getTitle());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    void testSetters() {
        Task task = new Task(1, "Initial Title", "Initial Description");

        task.setTitle("New Title");
        task.setDescription("New Description");

        assertEquals("New Title", task.getTitle());
        assertEquals("New Description", task.getDescription());
    }
}
