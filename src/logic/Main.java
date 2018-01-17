package logic;

public class Main {

    public static void main (String[] args) {
        Board board = new Board(8);
        Printer printer = new ConsolePrinter();
        GameLogic logic = new DeafultLogic(board);
        Player black = new HumanPlayer(logic);
        Player white = new HumanPlayer(logic);
        Game game = new Game(board,black,white,logic,printer);
        game.playGame();
    }
}
