package com.gradecalc.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

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

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public EditCourseController() {}

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void showNewCourseScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewCourseFXML.fxml"));
            Parent newCourseRoot = fxmlLoader.load();

            newCourseRoot.getStylesheets().add("/css/styles.css");

            this.sceneRoot.getScene().setRoot(newCourseRoot);

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
