package com.gradecalc.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EditCourseController {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    @FXML
    private BorderPane sceneRoot;

    @FXML
    protected MenuBar menuBar;

    @FXML
    protected MenuItem newCourseItem;

    @FXML
    protected MenuItem exitItem;

    @FXML
    protected Label fileLabel;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public EditCourseController() {}

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void handleChooseFile() {
        // Create the file picker
        FileChooser fileChooser = new FileChooser();

        // Set the file picker's initial directory to the user's home directory
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Restrict the file picker to only .json files
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON Files", "*.json"));

        // Show the dialog
        Stage stage = (Stage) this.sceneRoot.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        // Display the result
        if (selectedFile != null) {
            fileLabel.setText("Selected: " + selectedFile.getName());
            System.out.println("File path: " + selectedFile.getAbsolutePath());
        } else {
            fileLabel.setText("No file selected.");
        }
    }

    @FXML
    public void showNewCourseScene() {
        try {
            // Read FXML file and load the root
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewCourseFXML.fxml"));
            Parent newCourseRoot = fxmlLoader.load();

            // Apply CSS styles
            newCourseRoot.getStylesheets().add("/css/styles.css");

            // Set the root of the scene to the New Course Scene root
            this.sceneRoot.getScene().setRoot(newCourseRoot);

            // Resize the window
            Stage stage = (Stage) newCourseRoot.getScene().getWindow();
            stage.sizeToScene();
            stage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitApp() { Platform.exit(); }

}
