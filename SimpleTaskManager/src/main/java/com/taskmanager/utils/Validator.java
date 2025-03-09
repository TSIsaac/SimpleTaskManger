package com.taskmanager.utils;

import java.util.regex.Pattern;

public class Validator {

    // Validate if the username is not empty and has a minimum length
    public static boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty() && username.length() >= 3;
    }

    // Validate if the password meets certain complexity requirements
    public static boolean isValidPassword(String password) {
        // Password should have at least one uppercase, one lowercase, one digit, and be at least 8 characters long
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";
        return password != null && Pattern.matches(regex, password);
    }

    // Validate if a task title is not empty and has a minimum length
    public static boolean isValidTaskTitle(String title) {
        return title != null && !title.trim().isEmpty() && title.length() >= 3;
    }

    // Validate if the task description is not empty
    public static boolean isValidTaskDescription(String description) {
        return description != null && !description.trim().isEmpty();
    }
}
