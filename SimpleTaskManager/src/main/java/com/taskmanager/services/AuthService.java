package com.taskmanager.services;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private final Map<String, String> users = new HashMap<>();

    // Register a user
    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, password);
        return true;
    }

    // Login a user
    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
