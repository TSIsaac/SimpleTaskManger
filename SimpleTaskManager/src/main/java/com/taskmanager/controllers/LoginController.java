package com.taskmanager.controllers;

import com.taskmanager.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Button loginButton;

    @FXML
    private Label signupHereLbl;

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
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter both fields.");
            return;
        }

        System.out.println("Logging in user: " + username);
        //TODO Add authentication logic here
    }
}
