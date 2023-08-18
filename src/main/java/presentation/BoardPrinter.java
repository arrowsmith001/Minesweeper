package presentation;

import square_location_translators.SquareLocationTranslator;
import model.Board;
import model.Square;

import java.util.Iterator;
import java.util.List;

// TODO: Sort out printer
public class BoardPrinter
{
    static int resolution = 1;
    public BoardPrinter(Board board, SquareLocationTranslator locator)
    {
        this.board = board;
        this.locator = locator;
    }

    final Board board;
    final SquareLocationTranslator locator;

    private AsciiTableStringSet ascii = new PlaceHolderAsciiTable();

    public void print()
    {
        System.out.print(ascii.topLeftCorner());

        printSpace();
        printSpace();
        for (int i = 0; i < board.columns; i++) {
            System.out.print(locator.columnLabel(i));
        }
        printNewLine();

        int rowNumber = 0;
        final Iterator<List<Square>> rowIterator = board.getRowIterator();
        while(rowIterator.hasNext())
        {
            System.out.print(locator.rowLabel(rowNumber++));
            printSpace();

            final Iterator<Square> squareIterator = rowIterator.next().iterator();
            while(squareIterator.hasNext())
            {
                drawSquare(squareIterator.next());
            }

            System.out.println();
        }

        System.out.print(ascii.bottomRightCorner());
    }

    private void drawSquare(Square square)
    {
        //System.out.print(ascii.wall());
        for (int i = 0; i < resolution; i++)
        {
            if(!square.isRevealed)
            {
                if(square.isFlagged)
                {
                    System.out.print("F");
                }
                else
                {
                    System.out.print("?");
                }
            }
            else if(square.hasMine)
            {
                System.out.print("X");
            }
            else System.out.print(square.getNeighborMineCount());
            //System.out.print(ascii.floor());
        }
    }

    void printSpace(){
        System.out.print(" ");
    }
    void printNewLine(){
        System.out.println();
    }
}

