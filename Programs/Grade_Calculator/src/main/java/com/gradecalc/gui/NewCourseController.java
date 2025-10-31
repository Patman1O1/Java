package com.gradecalc.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewCourseController {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    @FXML
    protected BorderPane sceneRoot;

    @FXML
    protected MenuBar menuBar;

    @FXML
    protected MenuItem editCourseItem;

    @FXML
    protected MenuItem exitItem;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public NewCourseController() {}

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void showEditCourseScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EditCourseFXML.fxml"));
            Parent editCourseRoot = fxmlLoader.load();

            editCourseRoot.getStylesheets().add("/css/styles.css");

            this.sceneRoot.getScene().setRoot(editCourseRoot);

            Stage stage = (Stage) editCourseRoot.getScene().getWindow();
            stage.sizeToScene();
            stage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitApp() { Platform.exit(); }

}
