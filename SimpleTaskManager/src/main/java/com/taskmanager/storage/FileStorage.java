package com.taskmanager.storage;

import com.taskmanager.models.Task;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class FileStorage {

    private static final String STORAGE_DIRECTORY = "task_manager_data"; // Directory to store task files

    // Create a storage file for the user based on their username
    private File getUserFile(String username) {
        File dir = new File(STORAGE_DIRECTORY);
        if (!dir.exists()) {
            dir.mkdir();  // Create directory if not exists
        }

        return new File(dir, username + "_tasks.json");
    }

    // Save tasks to a file based on username
    public void saveTasks(String username, List<Task> tasks) throws IOException {
        File userFile = getUserFile(username);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(userFile, tasks);  // Serialize the tasks into a JSON file
    }

    // Load tasks from a file based on username
    public List<Task> loadTasks(String username) throws IOException {
        File userFile = getUserFile(username);
        ObjectMapper objectMapper = new ObjectMapper();
        if (userFile.exists()) {
            return objectMapper.readValue(userFile, objectMapper.getTypeFactory().constructCollectionType(List.class, Task.class));
        }
        return new ArrayList<>();  // Return empty list if no tasks file exists
    }

    // Clear tasks for a specific user
    public void clearTasks(String username) throws IOException {
        File userFile = getUserFile(username);
        if (userFile.exists()) {
            userFile.delete();  // Delete the user's task file
        }
    }
}

