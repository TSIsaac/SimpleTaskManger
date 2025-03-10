package com.taskmanager.controllers;

import com.taskmanager.App;
import com.taskmanager.models.Task;
import com.taskmanager.services.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

public class MainController {

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private TableColumn<Task, String> descriptionColumn;

    @FXML
    private TableColumn<Task, String> dueDateColumn;

    @FXML
    private Button addTaskButton;

    @FXML
    private Button editTaskButton;

    @FXML
    private Button deleteTaskButton;

    private ObservableList<Task> taskList = FXCollections.observableArrayList();

    private TaskService taskService = new TaskService();

    @FXML
    public void initialize() {
        // Initialize TableView columns
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
       

        // Load tasks into the table
        taskList.setAll(taskService.getAllTasks());
        taskTable.setItems(taskList);

        // Filter tasks as the user types in the search field
        searchField.setOnKeyReleased(this::handleSearch);

        // Handle add task button click
        addTaskButton.setOnAction(event -> openAddTaskDialog());

        // Handle edit task button click
        editTaskButton.setOnAction(event -> openEditTaskDialog());

        // Handle delete task button click
        deleteTaskButton.setOnAction(event -> deleteTask());
    }

    // Open dialog to add a new task
    private void openAddTaskDialog() {
        try {
            App.changeScene("add_task.fxml"); // Scene transition to add task
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Open dialog to edit an existing task
    private void openEditTaskDialog() {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            try {
                App.changeScene("edit_task.fxml"); // Scene transition to edit task
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showAlert("No Task Selected", "Please select a task to edit.");
        }
    }

    // Delete the selected task
    private void deleteTask() {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskService.deleteTask(selectedTask);
            taskList.setAll(taskService.getAllTasks());
        } else {
            showAlert("No Task Selected", "Please select a task to delete.");
        }
    }

    // Handle the search functionality
    private void handleSearch(KeyEvent keyEvent) {
        String searchText = searchField.getText().toLowerCase();
        ObservableList<Task> filteredTasks = FXCollections.observableArrayList();
        for (Task task : taskList) {
            if (task.getTitle().toLowerCase().contains(searchText) || 
                task.getDescription().toLowerCase().contains(searchText)) {
                filteredTasks.add(task);
            }
        }
        taskTable.setItems(filteredTasks);
    }

    // Show an alert message
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
