package reversi;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private static String black, white;
    private static HumanPlayer BPlayer, WPlayer;
    private static DeafultLogic logic;
    private static Board board;
    private static boolean firstsTurn;
    private static final String FILENAME = "./src/settingsFile.txt";
    private static final double PANELSIZE = 400;
    @FXML
    private Button exit;
    private GridBoard gridBoard;
    @FXML
    private Label currentPlayer;
    @FXML
    private HBox root;
    @FXML
    private Label player1L;
    @FXML
    private Label player2L;

    @FXML
    private void exitToMenu() {
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
            black = reader.readLine();
            white = reader.readLine();

        } catch (IOException e) {
            boardSize = 8;
            black = "Black";
            white = "White";
            sendAlert(0,"Error: Error reading file", "The default settings will be used.");
        }
        firstsTurn = true;
        currentPlayer.setText("Current Player: " + black);
        player1L.setText(black + " Score: 2");
        player2L.setText(white + " Score: 2");
        board = new Board(boardSize);
        logic = new DeafultLogic(board);
        BPlayer = new HumanPlayer(logic);
        WPlayer = new HumanPlayer(logic);
        logic.possibleMoves(firstsTurn, 2, null);
        gridBoard = new GridBoard(board, logic, BPlayer, WPlayer, black, white);
        gridBoard.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            Point p = getClickedPoint(x, y);
            tryToPlay(p);
        });
        gridBoard.setPrefWidth(PANELSIZE);
        gridBoard.setPrefHeight(PANELSIZE);
        gridBoard.draw();
        root.getChildren().add(0, gridBoard);
    }

    private static Point getClickedPoint(double x, double y) {
        Double sizeOfCell = ((double) (PANELSIZE)) / ((double) (board.getBoardSize()));
        double x1 = x / sizeOfCell;
        double y1 = y / sizeOfCell;
        return new Point((int) x1, (int) y1);
    }


    private void tryToPlay(Point p) {
        logic.possibleMoves(firstsTurn, 2, null);
        boolean isNextMoveExist = true;
        if (board.getPosCell(p.getX(), p.getY())) {
            logic.move(firstsTurn, p.getX(), p.getY());
            firstsTurn = !firstsTurn;
            isNextMoveExist = logic.possibleMoves(firstsTurn, 2, null);
            gridBoard.draw();
            player1L.setText(black + " Score: " + board.getBTiles());
            player2L.setText(white + " Score: " + board.getWTiles());
            if (firstsTurn)
                currentPlayer.setText("Current Player: " + black);
            else
                currentPlayer.setText("Current Player: " + white);
        } else if (!board.isFull())
            sendAlert(1 ,"Invalid Move", "please chose a valid move");
        if (board.isFull())
            gameOver();
        if (!isNextMoveExist && !board.isFull()) {
            sendAlert(1,"No Move", "There is no possible move\nThe turn goes to the other player");
            firstsTurn = !firstsTurn;
            isNextMoveExist = logic.possibleMoves(firstsTurn, 2, null);
            gridBoard.draw();
            player1L.setText(black + " Score: " + board.getBTiles());
            player2L.setText(white + " Score: " + board.getWTiles());
            if (firstsTurn)
                currentPlayer.setText("Current Player: " + black);
            else
                currentPlayer.setText("Current Player: " + white);
            if (!isNextMoveExist)
                gameOver();
        }

    }

    private void gameOver(){
        String winner;
        if (board.getBTiles() > board.getWTiles())
            winner=black+"!";
        else if (board.getBTiles() < board.getWTiles())
            winner=white+"!";
        else
            winner="no one! The game ended as a draw!";

        sendAlert(1,"The winner is "+ winner,"The game is finished!\nThe final score is: "
                +black+" = " + board.getBTiles() + "\t"+ white+" = " + board.getWTiles());

    }



    public void sendAlert(int type, String header, String contact) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(type == 1)
            alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(header);
        alert.setContentText(contact);
        alert.showAndWait();
    }


}
