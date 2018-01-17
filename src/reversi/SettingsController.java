package reversi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController  implements Initializable {

    @FXML private ComboBox<Integer> boardSize;
    @FXML private ComboBox<String> firstColor;
    @FXML private ComboBox<String> secondColor;
    @FXML private Button cancel;
    @FXML private Button save;

    @FXML public void save() {
        int size = boardSize.getValue();
        boardSize.getValue().toString();
        String color1 = firstColor.getValue();
        String color2 = secondColor.getValue();
//        System.out.println(color1);

        //save the parameters to the file

        try {
            Stage primaryStage = (Stage) this.save.getScene().getWindow();
            VBox root = (VBox) FXMLLoader.load(getClass().getResource("ReversiMenu.fxml"));
            Scene scene = new Scene(root,600,400);
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Reversi Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML public void cancel() {
        try {
            Stage primaryStage = (Stage) this.cancel.getScene().getWindow();
            VBox root = (VBox) FXMLLoader.load(getClass().getResource("ReversiMenu.fxml"));
            Scene scene = new Scene(root,600,400);
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Reversi Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstColor.getItems().addAll("Black", "White", "Red", "Blue", "Yellow", "Pink", "Gray", "Green", "Brown");
        secondColor.getItems().addAll("Black", "White", "Red", "Blue", "Yellow", "Pink", "Gray", "Green", "Brown");
        boardSize.getItems().addAll(4, 6, 8, 10, 12, 14, 16, 18, 20);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("./src/settingsFile.txt")));
            String line;

            boardSize.setValue(Integer.parseInt(reader.readLine()));
            firstColor.setValue(reader.readLine());
            secondColor.setValue(reader.readLine());
        }catch (IOException e) {
                System . out . println (" Something went wrong while reading !");
            }
    }
}
