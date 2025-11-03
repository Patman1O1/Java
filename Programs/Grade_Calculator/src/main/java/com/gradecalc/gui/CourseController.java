package com.gradecalc.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.gradecalc.Course;
import com.gradecalc.io.CourseFile;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CourseController implements Initializable {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    @FXML
    protected BorderPane sceneRoot;

    @FXML
    protected VBox menuBarRoot;

    @FXML
    protected MenuBar menuBar;

    @FXML
    protected MenuItem newItem;

    @FXML
    protected MenuItem openItem;

    @FXML
    protected MenuItem exitItem;

    @FXML
    protected Label courseNameLabel;

    @FXML
    protected Label courseGradeLabel;

    private FXMLLoader fxmlLoader;

    private Stage stage;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public CourseController() {}

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void handleNewCourse() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleOpenCourse() {
        // Create the file picker
        FileChooser fileChooser = new FileChooser();

        // Set the file picker's initial directory to the user's home directory
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Restrict the file picker to only JSON files
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON Files", "*.json"));

        // Show the dialog and get the selected course file
        CourseFile courseFile = new CourseFile(fileChooser.showOpenDialog(this.stage).getPath());

        try {
            // Attempt to the read the course file and create a new Course object to store the information
            Course course = courseFile.read();

            this.courseNameLabel.setFont(Font.font("System", FontWeight.BOLD, 50));
            this.courseNameLabel.setText(course.getName());
            this.courseNameLabel.setAlignment(Pos.TOP_CENTER);

            this.menuBarRoot.getChildren().add(this.courseNameLabel);

            // Display the course information
            //TreeItem<String>

        } catch (IOException e) {
            // Prompt the user that the JSON file they selected is invalid
            Alert alert = new Alert(Alert.AlertType.ERROR, "The selected JSON file is invalid", ButtonType.OK);
            alert.showAndWait();

            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleExit() { Platform.exit(); }


}
