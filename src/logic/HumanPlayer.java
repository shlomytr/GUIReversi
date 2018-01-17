package logic;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner scanner = new Scanner(System.in);

    /**
     * the constructor
     * @param  gameLogic gameLogic
     **/
    public HumanPlayer(GameLogic gameLogic) {
        super(gameLogic);
        this.canPlay = true;
        this.type = 1;
    }


    @Override
    void playOneTurn(boolean blacksTurn) {
        this.canPlay = true;
        int row, col;
        row = scanner.nextInt();
        col = scanner.nextInt();
        lastMove.setX(row - 1);
        lastMove.setY( col - 1);
        logic.move(blacksTurn, row -1, col - 1);
    }



}
