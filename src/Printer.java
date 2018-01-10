public interface Printer {

    /**
     * @name : printNextTurn
     * @parameters : no parameters
     * @return : the function prints a message declaring who has the next turn
     **/

    void printNextTurn(boolean blacksTurn);

    /**
     * @name : printNoMoves
     * @parameters : true if it is the black's player turn, false otherwise
     * @return : the function prints a message declaring that the player doesn't have possible moves
     **/

     void printNoMoves();

    /**
     * @name : printLastMove
     * @parameters : the turn and the index of the last move that was played
     * @return : the function prints a message declaring what was the last move that was played
     **/

     void printLastMove(boolean blacksTurn, int i, int j);

    /**
     * @name : printBoard
     * @parameters : the board that the game is played in, and a boolean that
     * is true if it is the last print or false otherwise
     * @return : the function prints the board
     **/

    void printBoard(Board b, boolean onlyPrintBoard);

    /**
     * @name : printsWhoWon
     * @parameters : the board that the game is played in
     * @return : the function prints the final board, score and who's won
     **/

    void printsWhoWon(Board b);

    /**
     * @name : printEnterNextTurn
     * @parameters : no parameters
     * @return : the function prints a message telling the user to enter a next turn
     **/

    void printEnterNextTurn();

    /**
     * @name : PrintInvalidMove
     * @parameters : no parameters
     * @return : the function prints a message telling the user that he entered an invalid move
     **/

     void PrintInvalidMove();

    /**
     * @name : printPosMoves
     * @parameters : the board that the game is played in
     * @return : the function prints the possible choices to pu a tile in
     **/

    void printPosMoves (Board b);

};

