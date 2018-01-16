package reversi;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private VBox root;
    @FXML
    private Button start;
    @FXML
    private int[][] maze = {
            {0,1,0,1,0,0,0,1,0,0,0},
            {0,1,0,1,1,1,0,1,0,1,0},
//...
    };
/*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MazeBoard mazeBoard = new MazeBoard(maze);
        mazeBoard.setPrefWidth(400);
        mazeBoard.setPrefHeight(400);
        root.getChildren().add(0, mazeBoard);
        mazeBoard.draw();
        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double boardNewWidth = newValue.doubleValue() - 120;
            mazeBoard.setPrefWidth(boardNewWidth);
            mazeBoard.draw();
        });

        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            mazeBoard.setPrefHeight(newValue.doubleValue());
            mazeBoard.draw();
        });
    }
*/
}
