package com.taskmanager.controllers;

import com.taskmanager.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginController {

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Button loginButton;

    @FXML
    private Label signupHereLbl;

    private static final String USER_FILE = "users.txt"; // File to store user data
    private static String loggedInUser; // Store logged-in username

    @FXML
    public void initialize() {
        signupHereLbl.setOnMouseClicked(event -> {
            try {
                App.changeScene("register.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void handleLogin() {
        String username = usernameTxt.getText().trim();
        String password = passwordTxt.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter both fields.");
            return;
        }

        if (authenticateUser(username, password)) {
            System.out.println("Login successful: " + username);
            loggedInUser = username;

            // Redirect to main.fxml (Task Manager)
            try {
                App.changeScene("main.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private boolean authenticateUser(String username, String password) {
        try {
            return Files.lines(Paths.get(USER_FILE))
                    .anyMatch(line -> line.equals(username + ":" + password));
        } catch (IOException e) {
            return false;
        }
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }
}
