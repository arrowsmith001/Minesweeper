package model;

import exceptions.MineUncoveredException;
import model.Coordinate;

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
    public final int columns;
    final int mines;


    private List<List<Square>> squaresList;
    private Square[][] squaresArray;

    public Square getSquareAtCoordinate(Coordinate coordinate)
    {
        try
        {
            return squaresArray[coordinate.row][coordinate.column];
        }catch(ArrayIndexOutOfBoundsException e)
        {
            return null;
        }
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
        squaresList = new LinkedList<>();

        for (int i = 0; i < rows; i++) {

            final List<Square> rowList = new LinkedList<>();
            squaresList.add(rowList);

            for (int j = 0; j < columns; j++)
            {
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
            if(neighbor != null) square.addNeighbor(neighbor);
        });
    }

    private boolean isValidCoordinate(Coordinate c) {
        final boolean isNonNegative = c.column >= 0 && c.row >=0;
        final boolean isInBounds = c.column < columns && c.row < rows;
        return isNonNegative && isInBounds;
    }

    private Coordinate indexToCoordinate(int i) {
        return new Coordinate(i / columns, i % columns);
    }

    private void addMines()
    {
        // New array from 0 to end of grid
        final List<Integer> indexes = new ArrayList<>(IntStream.range(0, rows * columns).boxed().toList());

        // Get a random subset of these indices
        Collections.shuffle(indexes);
        final Set<Integer> randomIndices = new HashSet<Integer>(indexes.subList(0, mines - 1));

        System.out.println("rows: " + rows + ", cols: " + columns);

        // Add mines at those indices
        for(int index : randomIndices)
        {
            final Coordinate coordinate = indexToCoordinate(index);

            System.out.println(index);
            System.out.println(coordinate);


            final Square square = getSquareAtCoordinate(coordinate);
            square.setHasMine(true);

        }
    }


    public void selectSquare(Coordinate coordinate) throws MineUncoveredException {
        System.out.println("Selecting " + coordinate);
        final Square square = getSquareAtCoordinate(coordinate);
        square.select();
    }

    public void reset() {
        generateBoard();
    }
}
