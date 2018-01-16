package reversi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

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
//        int size = boardSize.getValue();
        System.out.println("cancel");
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
