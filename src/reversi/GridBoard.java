package reversi;

import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import logic.*;

import java.io.IOException;
import java.util.TreeMap;

import static javafx.scene.paint.Color.TRANSPARENT;
import static javafx.scene.paint.Color.YELLOW;

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

    }

    public void draw() {
        this.getChildren().clear();
        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();

        int cellHeight = height / board.getBoardSize();
        int cellWidth = width / board.getBoardSize();
        int radius = (((cellHeight > cellWidth) ? cellWidth : cellHeight) - 10) /2;
        javafx.scene.paint.Color color;
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                color = TRANSPARENT;
                if(board.getPosCell(i,j))
                    color = javafx.scene.paint.Color.YELLOW;
                Rectangle rectangle = new Rectangle(cellWidth, cellHeight, color);
                rectangle.setStroke(javafx.scene.paint.Color.BLACK);
                this.add(rectangle, i, j);


                if (board.getCell(i, j) == Color.empty) {
                    Circle circle = new Circle(radius, TRANSPARENT);
                    this.add(circle, i, j);
                    this.setValignment(circle, VPos.CENTER);
                    this.setHalignment(circle, HPos.CENTER);
                } else if (board.getCell(i, j) == Color.black) {
                    Circle circle = new Circle(radius, javafx.scene.paint.Color.web(black));
                    this.add(circle, i, j);
                    this.setValignment(circle, VPos.CENTER);
                    this.setHalignment(circle, HPos.CENTER);
                } else if (board.getCell(i, j) == Color.white) {
                    Circle circle = new Circle(radius, javafx.scene.paint.Color.web(white));
                    this.add(circle, i, j);
                    this.setValignment(circle, VPos.CENTER);
                    this.setHalignment(circle, HPos.CENTER);
                }

            }
        }
    }


}
