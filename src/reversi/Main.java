package reversi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Reversi");
        Label lbl = new Label("Welcome to Reversi");
        lbl.setFont(new Font("Arial", 30));

        Button startBtn = new Button("Start");
        Button settingsBtn = new Button("settings");

        VBox root = new VBox();
        root.getChildren().add(lbl);
        root.getChildren().add(startBtn);
        root.getChildren().add(settingsBtn);


        primaryStage.setScene(new Scene(root, 600, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
