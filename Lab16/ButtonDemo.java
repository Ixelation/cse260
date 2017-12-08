import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class ButtonDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("Traffic Lights");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    BorderPane getPane(){
        VBox paneForButtons = new VBox(20);
        VBox paneForCircles = new VBox(20);
        RadioButton btRed = new RadioButton("Red");
        RadioButton btYellow = new RadioButton("Yellow");
        RadioButton btGreen = new RadioButton("Green");
        Circle ciRed = new Circle(20);
        ciRed.setStroke(Color.RED);
        ciRed.setFill(Color.BLACK);
        Circle ciYellow = new Circle(20);
        ciYellow.setStroke(Color.YELLOW);
        ciYellow.setFill(Color.BLACK);
        Circle ciGreen = new Circle(20);
        ciGreen.setStroke(Color.GREEN);
        ciGreen.setFill(Color.BLACK);
        paneForButtons.getChildren().addAll(btRed, btYellow, btGreen);
        paneForButtons.setAlignment(Pos.CENTER_LEFT);
        paneForCircles.getChildren().addAll(ciRed, ciYellow, ciGreen);
        paneForCircles.setAlignment(Pos.CENTER_RIGHT);
        //paneForButtons.setStyle("-fx-border-color: green");
        BorderPane pane = new BorderPane();
        pane.setLeft(paneForButtons);
        pane.setRight(paneForCircles);
        btRed.setOnAction(e -> 
            {
                ciRed.setFill(Color.RED);
                ciYellow.setFill(Color.BLACK);
                ciGreen.setFill(Color.BLACK);
            }
        );
        btYellow.setOnAction(e -> 
            {
                ciYellow.setFill(Color.YELLOW);
                ciGreen.setFill(Color.BLACK);
                ciRed.setFill(Color.BLACK);
            }
        );
        btGreen.setOnAction(e -> 
            {
                ciGreen.setFill(Color.GREEN);
                ciYellow.setFill(Color.BLACK);
                ciRed.setFill(Color.BLACK);
            }
        );
        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}