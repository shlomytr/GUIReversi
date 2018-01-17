package reversi;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML private Button start;

    @FXML private Button settings;

    @FXML private void gameStart() {
        Stage stage = (Stage) start.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReversiGame.fxml"));
        try {
            HBox root = (HBox) loader.load();
            loader.setController(new GameController());
            Scene gameScene = new Scene(root, 600, 400);
//            gameScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(gameScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void gameSettings() {
        Stage stage = (Stage)this.settings.getScene().getWindow();
        try {
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("ReversiSettings.fxml"));
            Scene scene = new Scene(root, 600, 400);
            //todo find out what the comment do
//            scene.getStylesheets().add(getClass().getResource("settingsStyle.css").toExternalForm());
            stage.setTitle("Settings");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}