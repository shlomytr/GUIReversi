public abstract class GameLogic {

    protected Board board;

    GameLogic(Board board) {
        this.board = board;
    }

    /**
     * and returns true, otherwise returns false
     * @param blacksTurn boolean indicates who's turn it is
     * @param type the type of the player
     * @param printer printer
     * @return : if there are possible moves, the function prints them, puts them in the posArray
     **/
    abstract boolean possibleMoves(boolean blacksTurn, int type, Printer printer);

    /**
     * the function makes the move that the user put in
     * @param blacksTurn boolean indicates who's turn it is
     * @param row row coordinates
     * @param col col coordinates
     **/
    void move(boolean blacksTurn, int row, int col) {
        boolean foundATileToSwitch = false;
        for (int k = -1; k < 2; k++)
            for (int l = -1; l < 2; l++)
                if (k != 0 || l != 0) {
                    if (changeBoard(blacksTurn, row, col, k, l, false) && !foundATileToSwitch) {
                        changeSingleTile(blacksTurn, row, col);
                        foundATileToSwitch = true;
                    }
                }
    }

    /**
     * @return : the function returns a string with the name of the class
     **/
    abstract String getType();

    /**
     * @return : the function returns whether we can put a tile in board[i][j]
     * @param i the index of the x coordinates cell that is required
     * @param j the index of the y coordinates cell that is required
     **/
    boolean getPosCell(int i, int j) {
        return board.getPosCell(i, j);
    }

    /**
     * @param blacksTurn turn
     * @param i row coordinates
     * @param j col coordinates
     * @param rowDif
     * @param colDif
     * @param foundACandidate
     * @return : the function uses recursion to find whether we can put a tile in the current index or not
     **/
    protected abstract boolean checkAdTile(boolean blacksTurn, int i, int j, int rowDif, int colDif, boolean foundACandidate);

    /**
     * the score accordingly
     * @name : changeBoard
     * @param blacksTurn turn
     * @param i
     * @param j
     * @param rowDif
     * @param colDif
     * @param foundACandidate
     * expression that is true when we find a candidate that is suitable
     * @return : the function uses recursion to change all the tiles that according to the rules and change
     **/
    protected abstract boolean changeBoard(boolean blacksTurn, int i, int j, int rowDif, int colDif, boolean foundACandidate);

    /**
     * changes the tile, adds to the score of player and doesn't decrease the score of the opponent
     * @param blacksTurn the turn
     * @param i row coordinates that is need to be changed
     * @param j col coordinates that is need to be changed
     **/

    protected void changeSingleTile(boolean blacksTurn, int i, int j) {
        if (blacksTurn) {
            board.addToBTiles(1);
            board.setCell(i, j, Color.black);
        } else {
            board.addToWTiles(1);
            board.setCell(i, j, Color.white);
        }
    }

    /**
     * changes the tile, adds to the score of player and decreases the score of the opponent
     * @param blacksTurn the turn and the index that is need to be changed
     * @param i row coordinates that is need to be changed
     * @param j col coordinates that is need to be changed
     **/

    protected void flipTile(boolean blacksTurn, int i, int j) {
        if (blacksTurn) {
            board.addToWTiles(-1);
            board.addToBTiles(1);
            board.setCell(i, j, Color.black);
        } else {
            board.addToBTiles(-1);
            board.addToWTiles(1);
            board.setCell(i, j, Color.white);
        }
    }
}
