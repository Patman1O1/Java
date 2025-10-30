import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class GradeCalculator extends Application {
    /* --------------------------------------------------Methods----------------------------------------------------- */
    @Override
    public void start(Stage stage) {

        stage.setTitle("Grade Calculator");
        stage.show();
    }


    public static void main(String[] args) { launch(args); }
}
