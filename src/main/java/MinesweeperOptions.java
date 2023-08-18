public class MinesweeperOptions {
    static int DEFAULT_ROW_COUNT = 5;
    static int DEFAULT_COLUMN_COUNT = 8;
    static int DEFAULT_MINE_COUNT = 10;

    public MinesweeperOptions(){
        this.numberOfRows = DEFAULT_ROW_COUNT;
        this.numberOfColumns = DEFAULT_COLUMN_COUNT;
        this.numberOfMines = DEFAULT_MINE_COUNT;
    }

    public MinesweeperOptions(Difficulty difficulty, BoardSize boardSize) {
        // TODO: Base on parameters
        this.numberOfRows = 5;
        this.numberOfColumns = 8;
        this.numberOfMines = 10;
    }

    public MinesweeperOptions(int numberOfRows, int numberOfColumns, int numberOfMines) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.numberOfMines = numberOfMines;
    }

    private int numberOfRows;
    private int numberOfColumns;
    private int numberOfMines;


    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }
}
