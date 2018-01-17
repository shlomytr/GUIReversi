package reversi;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import logic.*;

import java.io.IOException;

public class GridBoard extends GridPane {
    private static String black,white;
    private static HumanPlayer BPlayer,WPlayer;
    private static DeafultLogic logic;
    private static Board board;
    public GridBoard(Board board, DeafultLogic logic, HumanPlayer BPlayer, HumanPlayer WPlayer,String black,String white) {
        this.board = board;
        this.logic = logic;
        this. BPlayer=BPlayer;
        this.WPlayer = WPlayer;
        this.black = black;
        this.white = white;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GridBoardFX.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.getChildren().clear();

        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();

        int cellHeight = height / board.getBoardSize();
        int cellWidth = width / board.getBoardSize();

        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if (board.getCell(i,j) ==Color.empty )
                    this.add(new Circle(20, javafx.scene.paint.Color.ORANGE), j, i);
                else
                    if (board.getCell(i,j) ==Color.black )
                        this.add(new Circle(20, javafx.scene.paint.Color.web(black)), j, i);
                else
                    if (board.getCell(i,j) ==Color.white )
                        this.add(new Circle(20, javafx.scene.paint.Color.web(white)), j, i);

            }
        }
    }


}
