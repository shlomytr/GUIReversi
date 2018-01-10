import java.util.Scanner;

public class  ConsolePrinter implements Printer {
    @Override
    public void printNextTurn(boolean blacksTurn) {
        if (blacksTurn)
            System.out.println("The next move - Player x:\n");
        else
            System.out.println("The next move - Player o:\n");
    }

    @Override
    public void printNoMoves() {
        System.out.println("No possible moves, the turn goes to the next player. Press a key and then enter to continue");
        Scanner scanner = new Scanner(System.in);
        char k = scanner.next().charAt(0);
    }

    @Override
    public void printLastMove(boolean blacksTurn, int i, int j) {
        int tmp1, tmp2;
        tmp1= i+1;
        tmp2= j+1;
        if (!blacksTurn)
            System.out.println("The last move of player x was: (" + tmp1 + "," + tmp2 + ")");
        else
            System.out.println("The last move of player o was: (" + tmp1 + "," + tmp2 + ")");
    }

    @Override
    public void printBoard(Board b, boolean onlyPrintBoard) {
        if (!onlyPrintBoard)
            System.out.println("The current board:");
        int row = 1;
        String tmp="";
        for (int k=0;k<4*b.getBoardSize();k++)
            tmp =tmp.concat("-");
        System.out.print( " | ");
        for (int i = 1; i < b.getBoardSize() + 1; i++)
            System.out.print(i + " | ");
        System.out.print("\n" + tmp + "--" + "\n");
        for (int i = 0; i < b.getBoardSize(); i++, row++) {
            System.out.print(row + "| ");
            for (int j = 0; j < b.getBoardSize(); j++) {
                if(b.getCell(i, j) == Color.black)
                    System.out.print("x | ");
                else if(b.getCell(i, j) == Color.white)
                    System.out.print("o | ");
                else
                    System.out.print("  | ");
            }
            System.out.println("\n" + tmp + "--");
        }
        if (!onlyPrintBoard)
            System.out.println("The score is: Black = " + b.getBTiles() + "\tWhite = " + b.getWTiles());
    }

    @Override
    public void printsWhoWon(Board b) {
        System.out.println("The final board:\n");
        printBoard(b, true);
        System.out.println("The game is finished! The final score is: Black = " + b.getBTiles() + "\tWhite = "
                + b.getWTiles());
        System.out.print("The winner is ");
        if (b.getBTiles() > b.getWTiles())
            System.out.println("Black!");
        else if (b.getBTiles() < b.getWTiles())
            System.out.println("White!");
        else
            System.out.println("no one! The game ended as a draw!");
    }

    @Override
    public void printEnterNextTurn() {
        System.out.println("Please enter your next move: row,col");
    }

    @Override
    public void PrintInvalidMove() {
        System.out.println("Invalid move, please enter a legal move: row,col");
    }

    @Override
    public void printPosMoves(Board b) {
        int tmp1, tmp2;
        System.out.print("Your possible moves are: ");
        for (int i = 0; i < b.getBoardSize(); i++)
            for (int j = 0; j < b.getBoardSize(); j++)
                if (b.getPosCell(i, j)){
                    tmp1= i+1;
                    tmp2= j+1;
                    System.out.print("(" + tmp1 + ","+ tmp2 + ") ");
                }
        System.out.println();
    }
}
