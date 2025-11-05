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
import javafx.scene.control.skin.TreeTableRowSkin;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GradeCalculatorController implements Initializable {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private Stage stage;

    @FXML
    protected BorderPane sceneRoot;

    @FXML
    protected MenuBar menuBar;

    @FXML
    protected Menu fileMenu;

    @FXML
    protected MenuItem newItem;

    @FXML
    protected MenuItem openItem;

    @FXML
    protected MenuItem saveItem;

    @FXML
    protected MenuItem exitItem;

    @FXML
    protected SplitPane splitPane;

    @FXML
    protected VBox editorPane;

    @FXML
    protected VBox viewPane;

    @FXML
    protected TreeTableView<Object> courseTableView;

    private Course course;

    /* -----------------------------------------------Constructors--------------------------------------------------- */

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    protected void handleNewCourse() {

    }

    @FXML
    protected void handleOpenCourse() {
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
            this.course = courseFile.read();
            showCourse();
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
    protected void handleSaveCourse() {

    }

    @FXML
    protected void handleExit() { Platform.exit(); }

    private void showCourse() {
        TreeItem<Object> root = new TreeItem<>(this.course);
        root.setExpanded(true);

        TreeTableColumn<Object, String> courseColumn = new TreeTableColumn<>(course.getName());
        courseColumn.setPrefWidth(this.courseTableView.getWidth());
        courseColumn.setResizable(false);


        // Display the course information
        //TreeItem<String>

        this.courseTableView.getColumns().add(courseColumn);
    }

}
