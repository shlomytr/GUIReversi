package reversi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            VBox root = (VBox)FXMLLoader.load(getClass().getResource("ReversiMenu.fxml"));
            Scene scene = new Scene(root,600,400);
//            scene.getStylesheets().add((getClass().getResource("application.css").toExternalForm()));
            primaryStage.setTitle("Reversi logic.Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
