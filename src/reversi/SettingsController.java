package reversi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import static javax.script.ScriptEngine.FILENAME;

public class SettingsController implements Initializable {

    @FXML
    private ComboBox<Integer> boardSize;
    @FXML
    private ComboBox<String> firstColor;
    @FXML
    private ComboBox<String> secondColor;
    @FXML
    private ComboBox<Integer> firstPlayer;
    @FXML
    private Button cancel;
    @FXML
    private Button save;
    private static final String FILENAME = "settingsFile.txt";

    /**
     * save the changes in the settings when the user is clicking on save button
     * and returns to the first menu.
     * @name save
     **/
    @FXML
    public void save() {
        int size = boardSize.getValue();
        boardSize.getValue().toString();
        String color1 = firstColor.getValue();
        String color2 = secondColor.getValue();
        int turn = firstPlayer.getValue();

        if (color1 == color2) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error: Identical color");
            alert.setContentText("You chose the same color to both of the players.\nPlease change one of the player's color");
            alert.showAndWait();
        } else {
            BufferedWriter bf = null;
            FileWriter fw = null;
            try {
                fw = new FileWriter(FILENAME);
                bf = new BufferedWriter(fw);
                bf.write(Integer.toString(size));
                bf.newLine();
                bf.write(color1);
                bf.newLine();
                bf.write(color2);
                bf.newLine();
                bf.write(Integer.toString(turn));

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bf != null)
                        bf.close();
                    if (fw != null)
                        fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                Stage primaryStage = (Stage) this.save.getScene().getWindow();
                VBox root = (VBox) FXMLLoader.load(getClass().getResource("ReversiMenu.fxml"));
                Scene scene = new Scene(root, 600, 400);
                scene.getStylesheets().add(getClass().getResource("ReversiMenu.css").toExternalForm());
                primaryStage.setTitle("Reversi Game");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * discard all the changes in the settings when the user is clicking on save button
     * and returns to the first menu.
     *
     * @name cancel
     **/
    @FXML
    public void cancel() {
        try {
            Stage primaryStage = (Stage) this.cancel.getScene().getWindow();
            VBox root = (VBox) FXMLLoader.load(getClass().getResource("ReversiMenu.fxml"));
            Scene scene = new Scene(root, 600, 400);
            scene.getStylesheets().add(getClass().getResource("ReversiMenu.css").toExternalForm());
            primaryStage.setTitle("Reversi Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * initialize the settings menu. read the settings file and updates all hte fields accordingly
     * @name initialize
     **/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstColor.getItems().addAll("Black", "White", "Red", "Blue", "Yellow", "Pink", "Gray", "Green", "Brown");
        secondColor.getItems().addAll("Black", "White", "Red", "Blue", "Yellow", "Pink", "Gray", "Green", "Brown");
        boardSize.getItems().addAll(4, 6, 8, 10, 12, 14, 16, 18, 20);
        firstPlayer.getItems().addAll(1, 2);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));
            boardSize.setValue(Integer.parseInt(reader.readLine()));
            firstColor.setValue(reader.readLine());
            secondColor.setValue(reader.readLine());
            firstPlayer.setValue(Integer.parseInt(reader.readLine()));
        } catch (IOException e) {
            boardSize.setValue(8);
            firstColor.setValue("Black");
            secondColor.setValue("White");
            firstPlayer.setValue(1);
        }
    }
}
