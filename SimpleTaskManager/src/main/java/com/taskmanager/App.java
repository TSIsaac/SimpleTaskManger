package com.taskmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Task Manager - Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/views/" + fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

