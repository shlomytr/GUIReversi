public class Board {

    private int boardSize;
    private int bTiles, wTiles ;
    private Color arr[][] ;
    private boolean posArray[][];

    // constructor
    public Board(double x, double y) {

    }

    /**
     * the constructor
     * @param size the size of the board
     **/
    public Board(int size) {
        boardSize = size;
        wTiles=bTiles=2;
        arr = new Color [boardSize][boardSize];
        posArray = new boolean [boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            arr[i] = new Color[boardSize];
            posArray[i] = new boolean[boardSize];
        }

        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++) {
                arr[i][j] = Color.empty;
            }

        int mid = boardSize/2;
        arr[mid][mid] = arr[mid-1][mid-1] = Color.white;
        arr[mid-1][mid] = arr[mid][mid-1] = Color.black;
    }

    /**
     * @param i a number of tiles to add
     **/
    public void addToBTiles(int i) {
        bTiles += i;
    }

    /**
     * The amount to add to the number of the white tiles in the board
     * @param i the number to add
     **/

    public void addToWTiles(int i) {
        wTiles += i;
    }

    /**
     * @return the function returns the number of the black tiles in the board
     **/

    public int getBTiles() {
        return bTiles;
    }

    /**
     * @return : the function returns the number of the white tiles in the board
     **/
    public int getWTiles() {
        return wTiles;
    }

    /**
     * @return : the function returns true if the board is full, otherwise returns false
     **/

    public boolean isFull() {
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                if (arr[i][j] == Color.empty)
                    return false;
        return true;
    }

    /**
     * @param i the index of the row of the cell that is required
     * @param j the index of the column of the cell that is required
     * @return : the value of the cell in the board ('x' or 'o')
     **/
    public Color getCell(int i, int j) {
        return arr[i][j];
    }

    /**
     * @param i the index of the row of the cell that is required
     * @param j the index of the column of the cell that is required
     * @return : the function returns true if a tile could be placed in the cell
     **/
    public boolean getPosCell(int i, int j) {
        return posArray[i][j];
    }

    /**
     * @param i the index of the row of the cell and the value that we want to change
     * @param j the index of the column of the cell and the value that we want to change
     * @param value the type of the cell to set
     **/
    public void setCell(int i, int j, Color value) {
        arr[i][j] = value;
    }

    /**
     * @name : setPosCell
     * @parameters : the index of the cell and the information whether we can put a tile there ot not
     * @return : the function sets true if we can put a tile in the board or false otherwise
     **/
    public void setPosCell(int i, int j, boolean value) {
        posArray[i][j] = value;
    }

    /**
     * @name : getBoardSize
     * @parameters : no parameters
     * @return : the function returns the size of the board
     **/
    public int getBoardSize() {
        return boardSize;
    }

}
