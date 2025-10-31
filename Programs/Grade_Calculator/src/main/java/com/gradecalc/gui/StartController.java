package com.gradecalc.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.lang.System;

public class StartController {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    @FXML
    protected VBox root;

    @FXML
    protected Button newCourseButton;

    @FXML
    protected Button editCourseButton;

    @FXML
    protected Button exitButton;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public StartController() {}

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {}

    @FXML
    public void showNewCourseScene() throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewCourseFXML.fxml"));
            Parent newCourseRoot = fxmlLoader.load();

            newCourseRoot.getStylesheets().add("/css/styles.css");

            this.root.getScene().setRoot(newCourseRoot);

            Stage stage = (Stage) newCourseRoot.getScene().getWindow();
            stage.sizeToScene();
            stage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showEditCourseScene() throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewCourseFXML.fxml"));
            Parent newCourseRoot = fxmlLoader.load();

            newCourseRoot.getStylesheets().add("/css/styles.css");

            this.root.getScene().setRoot(newCourseRoot);

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
