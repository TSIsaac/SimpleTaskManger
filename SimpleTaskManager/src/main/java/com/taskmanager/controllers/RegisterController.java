package com.taskmanager.controllers;

import com.taskmanager.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();
        String rePassword = rePasswordTxt.getText();

        if (username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        if (!password.equals(rePassword)) {
            System.out.println("Passwords do not match.");
            return;
        }

        System.out.println("User registered: " + username);
        //TODO Add user registration logic here
    }
}
