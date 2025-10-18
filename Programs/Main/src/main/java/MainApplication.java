import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;

import javafx.util.Duration;


public class MainApplication extends Application {

    public static void main(String[] args) { MainApplication.launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage.setTitle("Main");
            this.createAnimation(stage);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createAnimation(Stage stage) {
        Rectangle rectangle = new Rectangle(100, 40, 100, 100);
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        rectangle.setFill(Color.VIOLET);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(5000), rectangle);
        rotateTransition.setByAngle(270);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
        SequentialTransition sequentialTransition = new SequentialTransition (
                new PauseTransition(Duration.millis(500)),
                rotateTransition
        );
        sequentialTransition.play();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(5000), rectangle);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.3);
        fadeTransition.setCycleCount(4);
        fadeTransition.setAutoReverse(true);

        fadeTransition.play();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(rectangle);

        Scene scene = new Scene(borderPane, 700,700);
        stage.setScene(scene);
        stage.show();
    }
}
