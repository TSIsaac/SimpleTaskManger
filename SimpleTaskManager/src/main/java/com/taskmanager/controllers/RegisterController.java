package com.taskmanager.controllers;

import com.taskmanager.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private PasswordField rePasswordTxt;

    @FXML
    private Button signupButton;

    @FXML
    private Label loginHereLbl;

    private static final String USERS_FILE = "users.txt";

    @FXML
    public void initialize() {
        loginHereLbl.setOnMouseClicked(event -> {
            try {
                App.changeScene("login.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void handleSignup() {
        String username = usernameTxt.getText().trim();
        String password = passwordTxt.getText().trim();
        String rePassword = rePasswordTxt.getText().trim();

        if (username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        if (!password.equals(rePassword)) {
            System.out.println("Passwords do not match.");
            return;
        }

        if (userExists(username)) {
            System.out.println("Username already exists. Choose a different one.");
            return;
        }

        if (saveUser(username, password)) {
            System.out.println("User registered successfully! Redirecting to login...");
            try {
                App.changeScene("login.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to register user. Try again.");
        }
    }

    private boolean userExists(String username) {
        File file = new File(USERS_FILE);
        if (!file.exists()) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean saveUser(String username, String password) {
        try (FileWriter writer = new FileWriter(USERS_FILE, true)) {
            writer.write(username + ":" + password + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
