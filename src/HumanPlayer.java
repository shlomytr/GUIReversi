import java.util.Scanner;

public class HumanPlayer extends Player {

    protected Printer printer;
    private Scanner scanner = new Scanner(System.in);

    /**
     * the constructor
     * @param  gameLogic gameLogic
     * @param  printer printer
     **/
    HumanPlayer(GameLogic gameLogic, Printer printer) {
        super(gameLogic);
        this.canPlay = true;
        this.type = 1;
        this.printer = printer;
    }


    @Override
    void playOneTurn(boolean blacksTurn) {
        this.canPlay = true;
        printer.printEnterNextTurn();
        int row, col;
        row = scanner.nextInt();
        col = scanner.nextInt();
// TODO: 09/01/18


        lastMove.setX(row - 1);
        lastMove.setY( col - 1);
        logic.move(blacksTurn, row -1, col - 1);
    }



}
