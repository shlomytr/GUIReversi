package reversi;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import logic.*;

import java.io.IOException;

public class GridBoard extends GridPane {
    private static String black,white;
    private static HumanPlayer BPlayer,WPlayer;
    private static DeafultLogic logic;
    private static Board board;
    public GridBoard(Board board, DeafultLogic logic, HumanPlayer BPlayer, HumanPlayer WPlayer) {
        this.board = board;
        this.logic = logic;
        this. BPlayer=BPlayer;
        this.WPlayer = WPlayer;
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

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == FREE)
                    this.add(new Rectangle(cellWidth, cellHeight,
                            Color.WHITE), j, i);
                else
                    this.add(new Rectangle(cellWidth, cellHeight,
                            Color.BLACK), j, i);
            }
        }
    }
    }

}
