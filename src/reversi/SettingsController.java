package reversi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController  implements Initializable {

    @FXML private ComboBox<Integer> boardSize;
    @FXML private ComboBox<String> firstColor;
    @FXML private ComboBox<String> secondColor;
    @FXML private Button cancel;
    @FXML private Button save;

    @FXML public void save() {
//        int size = boardSize.getValue();
//        Color color1 = firstColor.getValue();
//        Color color2 = secondColor.getValue();
        System.out.println("save");
    }

    @FXML public void cancel() {
        try {
            Stage primaryStage = (Stage) this.cancel.getScene().getWindow();
            VBox root = (VBox) FXMLLoader.load(getClass().getResource("ReversiMenu.fxml"));
            Scene scene = new Scene(root,600,400);
//            scene.getStylesheets().add(getClass().getResource("application").toExternalForm());
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
        firstColor.setValue("Black");
        secondColor.setValue("White");
        boardSize.setValue(8);
    }
}
