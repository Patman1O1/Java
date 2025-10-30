package com.gradecalc;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Map;

public class StartScene extends Scene {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final double WIDTH = 200.0, HEIGHT = 300.0;

    private final BorderPane root;

    private final Button newCourseButton, loadCourseButton;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public StartScene(Stage stage) {
        super(new BorderPane(), WIDTH, HEIGHT);
        stage.setScene(this);
        this.root = (BorderPane)this.getRoot();
        this.newCourseButton = new Button("New Course");
        this.loadCourseButton = new Button("Load Course");
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */

    /* -------------------------------------------------Getters------------------------------------------------------ */
    /* -------------------------------------------------Methods------------------------------------------------------ */


}
