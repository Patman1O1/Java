package com.gradecalc;

import com.gradecalc.gui.StartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class GradeCalculator extends Application {
    /* --------------------------------------------------Methods----------------------------------------------------- */
    @Override
    public void start(Stage stage) {
        try {
            stage.setTitle("Grade Calculator");

            Parent startSceneRoot = FXMLLoader.load(Objects.requireNonNull(
                    getClass().getResource("/fxml/StartFXML.fxml")));

            Scene startScene = new Scene(startSceneRoot);
            startScene.getStylesheets().add("/css/styles.css");

            stage.setScene(startScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) { launch(args); }
}
