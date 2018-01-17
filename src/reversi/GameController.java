package reversi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private static String black,white;
    private static HumanPlayer BPlayer,WPlayer;
    private static DeafultLogic logic;
    private static Board board;
    private static final String FILENAME = "./src/settingsFile.txt";
    @FXML
    private Button exit;
    @FXML
    private Label currentPlayer;
    @FXML
    private Label player1L;
    @FXML
    private Label player2L;

    @FXML private void exitToMenu() {
        try {
            Stage primaryStage = (Stage) this.exit.getScene().getWindow();
            VBox root = (VBox) FXMLLoader.load(getClass().getResource("ReversiMenu.fxml"));
            Scene scene = new Scene(root, 600, 400);
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Reversi Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int boardSize;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));
            boardSize = (Integer.parseInt(reader.readLine()));
            black= reader.readLine();
            white= reader.readLine();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error: Error reading file");
            alert.setContentText("The default settings will be used.");
            boardSize = 8;
            black= "Black";
            white= "White";
            alert.showAndWait();
        }
        player1L.setText(black+ " Score: 2");
        player2L.setText(white+ " Score: 2");
        board = new Board(boardSize);
        logic = new DeafultLogic(board);
        BPlayer = new HumanPlayer(logic);
        WPlayer = new HumanPlayer(logic);

    }


}
