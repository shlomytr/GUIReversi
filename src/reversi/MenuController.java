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

    @FXML
    private Button start;

    @FXML
    private Button settings;

    @FXML
    private Button exit;

    /**
     * starts the game - moves tp the game when the start button is clicked
     *
     * @name gameStart
     **/
    @FXML
    private void gameStart() {
        Stage stage = (Stage) start.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReversiGame.fxml"));
        try {
            HBox root = (HBox) loader.load();
            loader.setController(new GameController());
            Scene gameScene = new Scene(root, 600, 400);
//            gameScene.getStylesheets().add(getClass().getResource("ReversiBoard.css").toExternalForm());
            stage.setScene(gameScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * moves to the settings menu - moves tp the settings when the settings button is clicked
     *
     * @name gameSettings
     **/
    @FXML
    private void gameSettings() {
        Stage stage = (Stage) this.settings.getScene().getWindow();
        try {
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("ReversiSettings.fxml"));
            Scene scene = new Scene(root, 600, 400);
            scene.getStylesheets().add(getClass().getResource("ReversiSettings.css").toExternalForm());
            stage.setTitle("Settings");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * exits the game - closing everything
     *
     * @name gameExit
     **/
    @FXML
    private void gameExit() {
        Stage stage = (Stage) this.exit.getScene().getWindow();
        stage.close();
    }

}
