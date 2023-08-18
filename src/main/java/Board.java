import java.util.*;
import java.util.stream.IntStream;

public class Board
{
    public Board(MinesweeperOptions options)
    {

        rows = options.getNumberOfRows();
        columns = options.getNumberOfColumns();
        mines = options.getNumberOfMines();

        generateBoard();
    }


    final int rows;
    final int columns;
    final int mines;


    private final List<List<Square>> squaresList = new LinkedList<>();
    private Square[][] squaresArray;

    public Square getSquareAtCoordinate(Coordinate coordinate)
    {
        return squaresArray[coordinate.row][coordinate.column];
    }

    public Iterator<List<Square>> getRowIterator(){
        return squaresList.iterator();
    }

    private void generateBoard() {

        addSquares();

        addNeighborsToSquares();

        addMines();
    }


    private void addSquares() {

        // 2D Array - for instant querying
        squaresArray = new Square[rows][columns];

        // LinkedLists - for fast square-by-square iteration
        for (int i = 0; i < rows; i++) {

            final List<Square> rowList = new LinkedList<>();
            squaresList.add(rowList);

            for (int j = 0; j < columns; j++) {

                final Coordinate coordinate = new Coordinate(i, j);
                final Square square = new Square(coordinate);

                squaresArray[i][j] = square;
                rowList.add(square);
            }
        }
    }

    private void addNeighborsToSquares() {

        final Iterator<List<Square>> rowIterator = getRowIterator();
        while(rowIterator.hasNext())
        {
            final Iterator<Square> row = rowIterator.next().iterator();

            while(row.hasNext())
            {
                addNeighbors(row.next());
            }
        }

    }

    private void addNeighbors(Square square)
    {
        final Coordinate coordinate = square.coordinate;
        final List<Coordinate> neighborCoordinates = new ArrayList<>()
        {
            {
                add(new Coordinate(coordinate.row - 1, coordinate.column + 1));
                add(new Coordinate(coordinate.row - 1, coordinate.column));
                add(new Coordinate(coordinate.row - 1, coordinate.column - 1));
                add(new Coordinate(coordinate.row, coordinate.column + 1));
                add(new Coordinate(coordinate.row, coordinate.column - 1));
                add(new Coordinate(coordinate.row + 1, coordinate.column + 1));
                add(new Coordinate(coordinate.row + 1, coordinate.column));
                add(new Coordinate(coordinate.row + 1, coordinate.column - 1));
            }
        };

        neighborCoordinates.removeIf(c -> !isValidCoordinate(c));

        neighborCoordinates.forEach(c ->
        {
            final Square neighbor = getSquareAtCoordinate(c);
            square.addNeighbor(neighbor);
        });
    }

    private boolean isValidCoordinate(Coordinate c) {
        final boolean isNonNegative = c.column >= 0 && c.row >=0;
        final boolean isInBounds = c.column < columns && c.row < rows;
        return isNonNegative && isInBounds;
    }

    private Coordinate indexToCoordinate(int i) {
        return new Coordinate(i / rows, i % columns);
    }

    private void addMines()
    {
        final Set<Integer> indexes = new HashSet<Integer>(IntStream.range(0, (rows * columns) - 1).boxed().toList());

/*        // Get a random subset of existing locations
        final List<String> locations = new ArrayList<String>(squaresArray.keySet());
        Collections.shuffle(locations);
        final Set<String> randomLocations = new HashSet<String>(locations.subList(0, mines - 1));

        // Add mine
        for(String location : randomLocations)
        {
            final Square square = getSquareAtCoordinate(location);
            square.setHasMine(true);
        }*/
    }


}
