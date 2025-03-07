package com.taskmanager.services;

import com.taskmanager.models.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskService {

    // In-memory task storage (simulating a database)
    private List<Task> tasks = new ArrayList<>();

    // Create a new task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return tasks;
    }

    // Get task by ID
    public Optional<Task> getTaskById(int taskId) {
        return tasks.stream()
                    .filter(task -> task.getId() == taskId)
                    .findFirst();
    }

    // Update an existing task
    public boolean updateTask(int taskId, String title, String description, String dueDate) {
        Optional<Task> taskOpt = getTaskById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setTitle(title);
            task.setDescription(description);
            task.setDueDate(dueDate);
            return true;
        }
        return false;
    }

    // Delete a task by ID
    public boolean deleteTask(int taskId) {
        Optional<Task> taskOpt = getTaskById(taskId);
        if (taskOpt.isPresent()) {
            tasks.remove(taskOpt.get());
            return true;
        }
        return false;
    }
}
